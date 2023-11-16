package ru.stock.sock.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stock.sock.entity.Sock;
import ru.stock.sock.service.SockService;

import java.util.Collection;


@RequestMapping("/api/socks/")
@RestController
public class SockController {
    private final SockService sockService;

    public SockController(SockService sockService) {
        this.sockService = sockService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Sock> getStudentInfo(@PathVariable Long id) {
        Sock sock = sockService.getStudentById(id);
        if (sock == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sock);
    }

    @PostMapping("/income")
    public Sock addStudent(@RequestBody Sock sock) {
        return sockService.addStudent(sock);
    }

    @PutMapping
    public ResponseEntity<Sock> editStudent(@RequestBody Sock sock) {
        Sock foundSock = sockService.editStudent(sock);
        if (foundSock == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundSock);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        sockService.removeStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public Collection<Sock> getAll() {
        return sockService.getAll();
    }

}
