package ru.stock.sock.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.stock.sock.dto.SockDto;
import ru.stock.sock.entity.Sock;

@Mapper(componentModel = "spring")
public interface SockMapper {
    @Mapping(target = "color", expression = "java(sockDto.getColor().toLowerCase())")
    Sock sockDtoToSock(SockDto sockDto);

    SockDto sockToSockDto(Sock sock);

}
