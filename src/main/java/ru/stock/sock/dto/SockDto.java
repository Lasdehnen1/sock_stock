package ru.stock.sock.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class SockDto {
    @NotBlank(message = "цвет обязателен для заполнения")
    private String color;

    @Min(value = 0, message = "минимальное значение содержания хлопка в процентах")
    @Max(value = 100, message = "максимальное значение содержания хлопка в процентах")
    private int cottonPart;

    @Min(value = 1, message = "минимальное количество носков")
    private int quantity;

    public SockDto(String color, int cottonPart, int quantity) {
        this.color = color;
        this.cottonPart = cottonPart;
        this.quantity = quantity;
    }

    public SockDto() {
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
        SockDto sockDto = (SockDto) o;
        return cottonPart == sockDto.cottonPart && quantity == sockDto.quantity && Objects.equals(color, sockDto.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, cottonPart, quantity);
    }

    @Override
    public String toString() {
        return "SockDto{" +
                "color='" + color + '\'' +
                ", cottonPart=" + cottonPart +
                ", quantity=" + quantity +
                '}';
    }
}
