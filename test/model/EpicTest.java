package model;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class EpicTest {

    @Test
    public void epicsWithEqualIdShouldBeEqual() {
        Epic epic1 = new Epic("Хлеб", "Купить хлеб в магазине");
        Epic epic2 = new Epic("Батон", "Купить батон в магазине");
        epic1.setId(epic2.getId());
        assertEquals(epic1, epic2,
                "Ошибка! Экземпляры класса Epic должны быть равны друг другу, если равен их id;");
    }


}