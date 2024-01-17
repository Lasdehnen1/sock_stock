package ru.stock.sock.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.stock.sock.entity.Sock;


public interface SockRepository extends JpaRepository<Sock, Long> {
    Sock findByColorAndCottonPart(String color, int cottonPart);

    @Query(value = "SELECT SUM(quantity) FROM sock WHERE color = :color AND cotton_part > :cottonPart", nativeQuery = true)
    Integer getCountSocksMore(@Param("color") String color, @Param("cottonPart") int cottonPart);

    @Query(value = "SELECT SUM(quantity) FROM sock WHERE color = :color AND cotton_part < :cottonPart", nativeQuery = true)
    Integer getCountSocksLess(@Param("color") String color, @Param("cottonPart") int cottonPart);

    @Query(value = "SELECT SUM(quantity) FROM sock WHERE color = :color AND cotton_part = :cottonPart", nativeQuery = true)
    Integer getCountSocksEquals(@Param("color") String color, @Param("cottonPart") int cottonPart);

}
