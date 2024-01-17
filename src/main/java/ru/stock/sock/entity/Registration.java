package ru.stock.sock.entity;

import javax.persistence.*;

import java.time.LocalDateTime;


@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime time;
    private int quantity;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "sock_id")
    private Sock sock;

    public Registration(Long id, LocalDateTime time, int quantity, Status status) {
        this.id = id;
        this.time = time;
        this.quantity = quantity;
        this.status = status;
    }

    public Registration() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Sock getSock() {
        return sock;
    }

    public void setSock(Sock sock) {
        this.sock = sock;
    }

}
