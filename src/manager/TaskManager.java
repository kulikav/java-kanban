package manager;

import model.Epic;
import model.Subtask;
import model.Task;

import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {
    private static int taskId = 0;

    public static int getNewId() {
        return taskId++;
    }

    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Subtask> subtasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();

    //model.Task
    public ArrayList<Task> getTasks() {
        ArrayList<Task> values = new ArrayList<>(tasks.values());
        return values;
    }

    public void deleteAllTasks() {
        tasks.clear();
    }

    public Task getTaskById(int id) {
        return tasks.get(id);
    }

    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void deleteTaskById(int id) {
        tasks.remove(id);
    }

    //model.Subtask
    public ArrayList<Subtask> getSubtasks() {
        ArrayList<Subtask> values = new ArrayList<>(subtasks.values());
        return values;
    }

    public void deleteAllSubtasks() {
        subtasks.clear();
        for (Epic epic : epics.values()) {
            //epic.status = Task.TaskStatus.NEW;
            epic.setStatus(Task.TaskStatus.NEW);
        }

    }

    public Subtask getSubtaskById(int id) {
        return subtasks.get(id);
    }

    public void addSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
        Epic epic = epics.get(subtask.getEpicId());
        epic.addSubtask(subtask);
        epic.calculateStatus();

    }

    public void updateSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
        Epic epic = epics.get(subtask.getEpicId());
        epic.calculateStatus();
    }

    public void deleteSubtaskById(int id) {
        Subtask subtask = subtasks.get(id);
        Epic epic = epics.get(subtask.getEpicId());
        epic.deleteSubtusk(subtask);
        subtasks.remove(id);
        epic.calculateStatus();
    }

    //model.Epic
    public ArrayList<Epic> getEpics() {
        ArrayList<Epic> values = new ArrayList<>(epics.values());
        return values;
    }

    public void deleteAllEpics() {
        epics.clear();
        subtasks.clear();

    }

    public Epic getEpicById(int id) {
        return epics.get(id);
    }

    public void addEpic(Epic epic) {
        epics.put(epic.getId(), epic);
    }

    public void updateEpic(Epic epic) {
        epics.put(epic.getId(), epic);
    }

    public void deleteEpicById(int id) {
        Epic epic = getEpicById(id);
        for (Subtask epicSubtask : epic.getSubtasks()) {
            subtasks.remove(epicSubtask);
        }
        epics.remove(id);
    }

}
