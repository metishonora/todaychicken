package com.metishonora.todaychicken.domain;

import java.util.List;

public class Store {
    private Integer id;
    private String name;
    private List<Menu> menus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menu getMenu(Integer index) {
        return menus.get(index);
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }
}
