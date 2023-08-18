package com.metishonora.todaychicken.repository;

import com.metishonora.todaychicken.domain.Menu;

import java.util.LinkedHashMap;
import java.util.Map;

public class MemoryMenuRepository {
    private static final Map<Long, Menu> store = new LinkedHashMap<>();
    private static Long sequence = 0L;

    public void clear() {
        store.clear();
        sequence = 0L;
    }
    public Long size() {
        return sequence;
    }

    public void save(Menu menu) {
        menu.setId(++sequence);
        store.put(sequence, menu);
    }

    public Menu get(Long id) {
        return store.get(id);
    }
}
