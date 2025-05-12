package manager;

import model.Task;

import java.util.Collection;


public interface HistoryManager {

    void add(Task task);

    Collection<Task> getHistory();
}
