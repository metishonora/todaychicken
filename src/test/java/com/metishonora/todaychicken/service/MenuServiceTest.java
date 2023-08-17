package com.metishonora.todaychicken.service;

import com.metishonora.todaychicken.domain.Menu;
import com.metishonora.todaychicken.repository.MemoryMenuRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuServiceTest {

    MemoryMenuRepository memoryMenuRepository;
    MenuService menuService;

    @BeforeEach
    public void beforeEach() {
        memoryMenuRepository = new MemoryMenuRepository();
        menuService = new MenuService(memoryMenuRepository);
    }

    @AfterEach
    public void afterEach() {
        memoryMenuRepository.clear();
    }

    @Test
    public void 무작위추천() {
        // given
        Menu menu1 = new Menu("마법클", "시즈닝", 20000, "BHC");
        Menu menu2 = new Menu("황금올리브", "후라이드", 22000, "BBQ");
        Menu menu3 = new Menu("블랙라벨치킨", "후라이드", 23000, "KFC");

        // when
        menuService.addMenu(menu1);
        menuService.addMenu(menu2);
        menuService.addMenu(menu3);

        // then
        int[] seen = {0, 0, 0, 0};
        for (int i = 0; i < 100; i++) {
            Menu menu = menuService.getRandom();
            seen[Math.toIntExact(menu.getId())]++;
        }
        System.out.println(Arrays.toString(seen));
        assertThat(seen[1]).isGreaterThanOrEqualTo(20);
        assertThat(seen[2]).isGreaterThanOrEqualTo(20);
        assertThat(seen[3]).isGreaterThanOrEqualTo(20);
    }
}
