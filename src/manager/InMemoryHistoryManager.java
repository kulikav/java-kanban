package manager;

import model.Task;

import java.util.LinkedList;
import java.util.Collection;


public class InMemoryHistoryManager implements HistoryManager {
    private Collection<Task> history = new LinkedList<>();
    private static final int MAX_HISTORY = 10;

    @Override
    public void add(Task task) {
        if (history.size() >= MAX_HISTORY) {
            history.remove(0); // Удаляем самый старый элемент
        }
        history.add(task); // Добавляем новую задачу в конец списка
    }

    @Override
    public Collection<Task> getHistory() {
        return history;
    }
}