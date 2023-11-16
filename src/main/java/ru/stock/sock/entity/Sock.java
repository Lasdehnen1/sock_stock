package ru.stock.sock.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Sock {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String color;
    private int cottonPart;
    private int quantity;

    public Sock(Long id, String color, int cottonPart, int quantity) {
        this.id = id;
        this.color = color;
        this.cottonPart = cottonPart;
        this.quantity = quantity;
    }

    public Sock() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCottonPart() {
        return cottonPart;
    }

    public void setCottonPart(int cottonPart) {
        this.cottonPart = cottonPart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sock sock = (Sock) o;
        return getCottonPart() == sock.getCottonPart() && getQuantity() == sock.getQuantity() && Objects.equals(getId(), sock.getId()) && Objects.equals(getColor(), sock.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getColor(), getCottonPart(), getQuantity());
    }

    @Override
    public String toString() {
        return "Sock{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", cottonPart=" + cottonPart +
                ", quantity=" + quantity +
                '}';
    }
}
