package manager;

import model.Epic;
import model.Subtask;
import model.Task;

import java.util.ArrayList;

public interface TaskManager {

    //model.Task
    ArrayList<Task> getTasks();

    void deleteAllTasks();

    Task getTaskById(int id);

    void addTask(Task task);

    void updateTask(Task task);

    void deleteTaskById(int id);

    //model.Subtask
    ArrayList<Subtask> getSubtasks();

    void deleteAllSubtasks();

    Subtask getSubtaskById(int id);

    void addSubtask(Subtask subtask);

    void updateSubtask(Subtask subtask);

    void deleteSubtaskById(int id);

    //model.Epic
    ArrayList<Epic> getEpics();

    void deleteAllEpics();

    Epic getEpicById(int id);

    void addEpic(Epic epic);

    void updateEpic(Epic epic);

    void deleteEpicById(int id);

}