package com.metishonora.todaychicken.service;

import com.metishonora.todaychicken.repository.MemoryMenuRepository;
import com.metishonora.todaychicken.domain.Menu;

import java.util.Random;

public class MenuService {
    MemoryMenuRepository memoryMenuRepository;
    public MenuService(MemoryMenuRepository memoryMenuRepository) {
        this.memoryMenuRepository = memoryMenuRepository;
    }

    public void addMenu(Menu menu) {
        memoryMenuRepository.save(menu);
    }

    public Menu getRandom() {
        long index = new Random().nextLong(1, memoryMenuRepository.size() + 1);
        return memoryMenuRepository.get(index);
    }
}
