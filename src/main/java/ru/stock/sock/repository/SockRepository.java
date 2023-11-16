package ru.stock.sock.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.stock.sock.entity.Sock;


public interface SockRepository extends JpaRepository<Sock, Long> {

}
