package com.example.homework21.controller;

import com.example.homework21.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping(path = "/add")
    public String add(@RequestParam("id") String ids) {
        return service.add(ids);
    }

    @GetMapping(path = "/get")
    public HashMap<Integer, Integer> get() {
        return service.get();
    }
}
