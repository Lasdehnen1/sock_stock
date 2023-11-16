package ru.stock.sock.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.stock.sock.entity.Sock;
import ru.stock.sock.repository.SockRepository;


import java.util.Collection;


@Service
public class SockService {
    private final SockRepository sockRepository;

    public SockService(SockRepository sockRepository) {
        this.sockRepository = sockRepository;
    }

    private final Logger logger = LoggerFactory.getLogger(SockService.class);

    private final Object object = new Object();

    public Sock addStudent(Sock sock) {
        logger.info("Was invoked method for creating sock");
        return sockRepository.save(sock);

    }

    public Sock getStudentById(Long id) {
        logger.info("Was invoked method for getting sock by id: {}", id);
        return sockRepository.findById(id).get();
    }

    public Sock editStudent(Sock sock) {
        logger.info("Was invoked method for editing sock");
        return sockRepository.save(sock);
    }

    public void removeStudent(Long id) {
        logger.info("Was invoked method for deleting sock: {}", id);
        sockRepository.deleteById(id);
    }

    public Collection<Sock> getAll() {
        logger.info("Was invoked method for finding all socks");
        return sockRepository.findAll();
    }

}
