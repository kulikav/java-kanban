package manager;

import model.Epic;
import model.Subtask;
import model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTaskManager implements TaskManager {

    private static HistoryManager historyManager = Managers.getDefaultHistory();

    private static int taskId = 0;

    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Subtask> subtasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();


    public static int getNewId() {
        return taskId++;
    }


    //model.Task
    @Override
    public ArrayList<Task> getTasks() {
        ArrayList<Task> values = new ArrayList<>(tasks.values());
        return values;
    }

    @Override
    public void deleteAllTasks() {
        for (Integer id : tasks.keySet()) {
            deleteTaskById(id);
        }
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
        historyManager.remove(id);
        tasks.remove(id);
    }

    //model.Subtask
    @Override
    public ArrayList<Subtask> getSubtasks() {
        ArrayList<Subtask> values = new ArrayList<>(subtasks.values());
        return values;
    }

    @Override
    public void deleteAllSubtasks() {
        for (Integer id : subtasks.keySet()) {
            deleteSubtaskById(id);
        }
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
        historyManager.remove(id);
        subtasks.remove(id);
        epic.calculateStatus();
    }

    //model.Epic
    @Override
    public ArrayList<Epic> getEpics() {
        ArrayList<Epic> values = new ArrayList<>(epics.values());
        return values;
    }

    @Override
    public void deleteAllEpics() {
        for (Integer id : epics.keySet()) {
            deleteEpicById(id);
        }
        deleteAllSubtasks();
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
        ArrayList<Integer> subtaskList = new ArrayList<>();
        for (Subtask epicSubtask : epic.getSubtasks()) {
            subtaskList.add(epicSubtask.getId());
        }
        for (Integer subtaskId : subtaskList) {
            deleteSubtaskById(subtaskId);
        }
        historyManager.remove(id);
        epics.remove(id);
    }

    //History
    public List<Task> getHistory() {
        return historyManager.getHistory();
    }

}
