package ru.stock.sock.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stock.sock.dto.SockDto;
import ru.stock.sock.entity.Registration;
import ru.stock.sock.entity.Sock;
import ru.stock.sock.entity.Status;
import ru.stock.sock.mapper.SockMapper;
import ru.stock.sock.repository.RegistrationRepository;
import ru.stock.sock.repository.SockRepository;

import java.time.LocalDateTime;


@Service
public class SockService {
    private final SockRepository sockRepository;
    private final SockMapper sockMapper;
    private final RegistrationRepository registrationRepository;

    public SockService(SockRepository sockRepository, SockMapper sockMapper, RegistrationRepository registrationRepository) {
        this.sockRepository = sockRepository;
        this.sockMapper = sockMapper;
        this.registrationRepository = registrationRepository;
    }

    public String sockIncome(SockDto sockDto) {
        Sock sock = sockRepository.findByColorAndCottonPart(sockDto.getColor(), sockDto.getCottonPart());
        Registration registration = createRegistration(sockDto);
        registration.setStatus(Status.INCOME);
        if (sock != null) {
            sock.setQuantity(sock.getQuantity() + sockDto.getQuantity());
            registration.setSock(sockRepository.save(sock));
            registrationRepository.save(registration);
        } else {
            registration.setSock(sockRepository.save(sockMapper.sockDtoToSock(sockDto)));
            registrationRepository.save(registration);
        }
        return "добавлено";
    }

    public String sockOutcome(SockDto sockDto) {
        Sock sock = sockRepository.findByColorAndCottonPart(sockDto.getColor(), sockDto.getCottonPart());
        Registration registration = createRegistration(sockDto);
        registration.setStatus(Status.OUTCOME);
        if (sock != null) {
            int quantity = sock.getQuantity() - sockDto.getQuantity();
            if (quantity < 0) {
                throw new RuntimeException("на складе нет такого количества носков");
            }
            sock.setQuantity(quantity);
            registration.setSock(sock);
            registrationRepository.save(registration);
        } else {
            throw new RuntimeException("таких носков нет");
        }
        return "списаны со склада";
    }

    public String getQuantity(String color, String operation, Integer cottonPart) {
        if (cottonPart < 0 || cottonPart > 100) {
            throw new RuntimeException("содержание хлопка от 0 до 100");
        }
        switch (operation) {
            case "moreThan": {
                Integer count = sockRepository.getCountSocksMore(color.toLowerCase(), cottonPart);
                return checkCountSocks(count);
            }
            case "lessThan": {
                Integer count = sockRepository.getCountSocksLess(color.toLowerCase(), cottonPart);
                return checkCountSocks(count);
            }
            case "equal": {
                Integer count = sockRepository.getCountSocksEquals(color.toLowerCase(), cottonPart);
                return checkCountSocks(count);
            }
            default:
                throw new RuntimeException("The parameter \"operation\" was sent incorrectly");
        }
    }


    private String checkCountSocks(Integer count) {
        if (count != null) {
            return "Количество носков на складе - " + count;
        } else {
            throw new RuntimeException("нет");
        }
    }


    private Registration createRegistration(SockDto sockDto) {
        Registration registration = new Registration();
        registration.setTime(LocalDateTime.now());
        registration.setQuantity(sockDto.getQuantity());
        return registration;
    }


}
