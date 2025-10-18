package manager;

import model.Epic;
import model.Subtask;
import model.Task;

import java.util.Collection;

public interface TaskManager {

    //model.Task
    Collection<Task> getTasks();

    void deleteAllTasks();

    Task getTaskById(int id);

    void addTask(Task task);

    void updateTask(Task task);

    void deleteTaskById(int id);

    //model.Subtask
    Collection<Subtask> getSubtasks();

    void deleteAllSubtasks();

    Subtask getSubtaskById(int id);

    void addSubtask(Subtask subtask);

    void updateSubtask(Subtask subtask);

    void deleteSubtaskById(int id);

    //model.Epic
    Collection<Epic> getEpics();

    void deleteAllEpics();

    Epic getEpicById(int id);

    void addEpic(Epic epic);

    void updateEpic(Epic epic);

    void deleteEpicById(int id);

}