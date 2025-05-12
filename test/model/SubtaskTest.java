package model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SubtaskTest {
    @Test
    public void subtasksWithEqualIdShouldBeEqual() {
        Subtask subtask1 = new Subtask("Хлеб", "Купить хлеб в магазине", 0);
        Subtask subtask2 = new Subtask("Батон", "Купить батон в магазине", 1);
        subtask1.setId(subtask2.getId());
        assertEquals(subtask1, subtask2,
                "Ошибка! Экземпляры класса Subtask должны быть равны друг другу, если равен их id;");
    }

}