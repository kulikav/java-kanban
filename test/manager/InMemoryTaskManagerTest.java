package manager;

import model.Epic;
import model.Subtask;
import model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskManagerTest {
    InMemoryTaskManager manager;

    @BeforeEach
    void init() {
        manager = new InMemoryTaskManager(Managers.getDefaultHistoryManager());
    }

    @Test
    public void shouldAddTask() {
        Task task1 = new Task("Хлеб", "Купить хлеб в магазине");
        int idTask = task1.getId();
        manager.addTask(task1);
        Task task2 = manager.getTaskById(idTask);
        assertEquals(task1, task2,
                "Ошибка! Экземпляры класса Task должны быть равны друг другу");
    }

    @Test
    public void shouldAddSubtask() {
        Epic epic = new Epic("Хлеб", "Купить хлеб в магазине");
        int epicId = epic.getId();
        manager.addEpic(epic);
        Subtask subtask1 = new Subtask("Хлеб", "Купить хлеб в магазине", epicId);
        int idSubtask = subtask1.getId();
        manager.addSubtask(subtask1);
        Subtask subtask2 = manager.getSubtaskById(idSubtask);
        assertEquals(subtask1, subtask2,
                "Ошибка! Экземпляры класса Subtask должны быть равны друг другу");
    }

    @Test
    public void shouldAddEpic() {
        Epic epic1 = new Epic("Хлеб", "Купить хлеб в магазине");
        int idEpic = epic1.getId();
        manager.addEpic(epic1);
        Epic epic2 = manager.getEpicById(idEpic);
        assertEquals(epic1, epic2,
                "Ошибка! Экземпляры класса Epic должны быть равны друг другу");
    }

    @Test
    public void titleAndDescriptionShouldBeEquals() {
        Task task1 = new Task("Хлеб", "Купить хлеб в магазине");
        int idTask = task1.getId();
        String title1 = task1.getTitle();
        String description1 = task1.getDescription();
        manager.addTask(task1);
        Task task2 = manager.getTaskById(idTask);
        String title2 = task2.getTitle();
        String description2 = task2.getDescription();

        assertEquals(title1, title2,
                "Ошибка! Заголовки должны быть равны друг другу");
        assertEquals(description1, description2,
                "Ошибка! Описания должны быть равны друг другу");
    }


}