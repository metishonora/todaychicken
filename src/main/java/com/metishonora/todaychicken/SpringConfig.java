package com.metishonora.todaychicken;

import com.metishonora.todaychicken.repository.MemoryMenuRepository;
import com.metishonora.todaychicken.service.MenuService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemoryMenuRepository memoryMenuRepository() {
        return new MemoryMenuRepository();
    }

    @Bean
    public MenuService menuService() {
        return new MenuService(memoryMenuRepository());
    }

}
