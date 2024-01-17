package ru.stock.sock.controller;



import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stock.sock.dto.SockDto;

import ru.stock.sock.service.SockService;

import javax.validation.Valid;



@RequestMapping("/api/socks")
@RestController
public class SockController {
    private final SockService sockService;


    public SockController(SockService sockService) {
        this.sockService = sockService;
    }

    @PostMapping("/income")
    public ResponseEntity<String> sockIncome(@RequestBody @Valid SockDto sockDto) {
        String result = sockService.sockIncome(sockDto);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/outcome")
    public ResponseEntity<String> sockOutcome(@RequestBody @Valid SockDto sockDto) {
        String result = sockService.sockOutcome(sockDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<String> quantity(@Parameter(description = "Введите цвет носков", example = "black")
                                         @RequestParam String color,
                                         @Parameter(description = "Введите количества хлопка в составе носков - moreThan, lessThan, equal", example = "moreThan")
                                         @RequestParam String operation,
                                         @Parameter(description = "Введите значение процента хлопка от 0 до 100", example = "30")
                                         @RequestParam Integer cottonPart) {
        String result = sockService.getQuantity(color, operation, cottonPart);
        return ResponseEntity.ok(result);
    }



}
