package manager;

import model.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private List<Task> history = new ArrayList<>();
    private static final int MAX_HISTORY = 10;

    @Override
    public void add(Task task) {
        if (history.size() >= MAX_HISTORY) {
            history.remove(0); // Удаляем самый старый элемент
        }
        history.add(task); // Добавляем новую задачу в конец списка
    }

    @Override
    public List<Task> getHistory() {
        return history;
    }
}