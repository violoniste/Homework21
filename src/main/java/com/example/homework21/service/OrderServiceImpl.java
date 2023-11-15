package com.example.homework21.service;

import com.example.homework21.exceptions.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@SessionScope
//@Scope(WebApplicationContext.SCOPE_SESSION)       // todo почему-то вызывает ошибку на старте!!!
public class OrderServiceImpl implements OrderService {

    private final HashMap<Integer, Integer> items = new HashMap<>();  // Ключ - id товара, значение - количество в корзине

    @Override
    public String add(String ids) {
        try {
            List<Integer> parsed = Arrays.stream(ids.split(",")).map(Integer::parseInt).collect(Collectors.toList());
            for (Integer id : parsed) {
                addItem(id);
            }
            return "OK!";
        }
        catch (Exception e) {
            throw new BadRequestException();
        }
    }

    private void addItem(int id) {
        int count = items.getOrDefault(id, 0) + 1;
        items.put(id, count);
    }

    @Override
    public HashMap<Integer, Integer> get() {
        return items;
    }
}
