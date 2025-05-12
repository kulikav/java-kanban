package manager;

import model.Epic;
import model.Subtask;
import model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collection;
import java.util.Map;

public class InMemoryTaskManager implements TaskManager {

    private static HistoryManager historyManager;

    InMemoryTaskManager(HistoryManager hManager) {
        historyManager = hManager;
    }


    private static int taskId = 0;

    private Map<Integer, Task> tasks = new HashMap<>();
    private Map<Integer, Subtask> subtasks = new HashMap<>();
    private Map<Integer, Epic> epics = new HashMap<>();


    public static int getNewId() {
        return taskId++;
    }


    //model.Task
    @Override
    public Collection<Task> getTasks() {
        Collection<Task> values = new ArrayList<>(tasks.values());
        return values;
    }

    @Override
    public void deleteAllTasks() {
        tasks.clear();
    }

    @Override
    public Task getTaskById(int id) {
        Task task = tasks.get(id);
        historyManager.add(task);
        return task;
    }

    @Override
    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public void deleteTaskById(int id) {
        tasks.remove(id);
    }

    //model.Subtask
    @Override
    public Collection<Subtask> getSubtasks() {
        Collection<Subtask> values = new ArrayList<>(subtasks.values());
        return values;
    }

    @Override
    public void deleteAllSubtasks() {
        subtasks.clear();
        for (Epic epic : epics.values()) {
            epic.setStatus(Task.TaskStatus.NEW);
        }

    }

    @Override
    public Subtask getSubtaskById(int id) {
        Subtask subtask = subtasks.get(id);
        historyManager.add(subtask);
        return subtask;
    }

    @Override
    public void addSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
        Epic epic = epics.get(subtask.getEpicId());
        epic.addSubtask(subtask);
        epic.calculateStatus();

    }

    @Override
    public void updateSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
        Epic epic = epics.get(subtask.getEpicId());
        epic.calculateStatus();
    }

    @Override
    public void deleteSubtaskById(int id) {
        Subtask subtask = subtasks.get(id);
        Epic epic = epics.get(subtask.getEpicId());
        epic.deleteSubtusk(subtask);
        subtasks.remove(id);
        epic.calculateStatus();
    }

    //model.Epic
    @Override
    public Collection<Epic> getEpics() {
        Collection<Epic> values = new ArrayList<>(epics.values());
        return values;
    }

    @Override
    public void deleteAllEpics() {
        epics.clear();
        subtasks.clear();

    }

    @Override
    public Epic getEpicById(int id) {
        Epic epic = epics.get(id);
        historyManager.add(epic);
        return epic;
    }

    @Override
    public void addEpic(Epic epic) {
        epics.put(epic.getId(), epic);
    }

    @Override
    public void updateEpic(Epic epic) {
        epics.put(epic.getId(), epic);
    }

    @Override
    public void deleteEpicById(int id) {
        Epic epic = getEpicById(id);
        for (Subtask epicSubtask : epic.getSubtasks()) {
            subtasks.remove(epicSubtask);
        }
        epics.remove(id);
    }

    //History
    public Collection<Task> getHistory() {
        return historyManager.getHistory();
    }

}
