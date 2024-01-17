package ru.stock.sock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stock.sock.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}
