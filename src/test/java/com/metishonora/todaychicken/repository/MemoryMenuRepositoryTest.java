package com.metishonora.todaychicken.repository;

import com.metishonora.todaychicken.domain.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemoryMenuRepositoryTest {

    MemoryMenuRepository memoryMenuRepository;

    @BeforeEach
    public void beforeEach() {
        memoryMenuRepository = new MemoryMenuRepository();
    }

    @AfterEach
    public void afterEach() {
        memoryMenuRepository.clear();
        assertThat(memoryMenuRepository.size()).isEqualTo(0);
    }

    @Test
    public void 메뉴등록하기() {
        // given
        Menu menu = new Menu("마법클", "시즈닝", 20000, "BHC");
        menu.setScore(90);

        Menu menu2 = new Menu("황금올리브", "후라이드", 22000, "BBQ");
        menu2.setScore(95);

        // when
        memoryMenuRepository.save(menu);
        memoryMenuRepository.save(menu2);

        // then
        Menu result = memoryMenuRepository.get(1L);
        assertThat(result.getId()).isEqualTo(1);
        assertThat(result.getName()).isEqualTo("마법클");
        assertThat(result.getCategory()).isEqualTo("시즈닝");
        assertThat(result.getPrice()).isEqualTo(20000);
        assertThat(result.getStore()).isEqualTo("BHC");
        assertThat(result.getScore()).isEqualTo(90);

        Menu result2 = memoryMenuRepository.get(2L);
        assertThat(result2.getId()).isEqualTo(2);
        assertThat(result2.getName()).isEqualTo("황금올리브");
    }
}