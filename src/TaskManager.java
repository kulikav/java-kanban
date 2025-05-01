import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {
    private static int taskId = 0;

    public static int getNewId() {
        return taskId++;
    }

    HashMap<Integer, Task> tasks = new HashMap<>();
    HashMap<Integer, Subtask> subtasks = new HashMap<>();
    HashMap<Integer, Epic> epics = new HashMap<>();
//Task
    ArrayList getTasks() {
        ArrayList<Task> values = new ArrayList<>(tasks.values());
        return values;
    }

    void deleteAllTasks() {
        tasks.clear();
    }

    Task getTaskById(int id) {
        return tasks.get(id);
    }

    void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    void deleteTaskById(int id) {
        tasks.remove(id);
    }
//Subtask
    ArrayList getSubtasks() {
        ArrayList<Subtask> values = new ArrayList<>(subtasks.values());
        return values;
    }

    void deleteAllSubtasks() {
        subtasks.clear();
        for(Epic epic : epics.values()) {
            epic.status = Task.TaskStatus.NEW;
        }

    }

    Subtask getSubtaskById(int id) {
        return subtasks.get(id);
    }

    void addSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
        Epic epic = epics.get(subtask.getEpicId());
        epic.addSubtask(subtask.getId());
        epic.calculateStatus(subtasks);

    }

    void updateSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
        Epic epic = epics.get(subtask.getEpicId());
        epic.calculateStatus(subtasks);
    }

    void deleteSubtaskById(int id) {
        Subtask subtask = subtasks.get(id);
        Epic epic = epics.get(subtask.getEpicId());
        int index = epic.subtasksId.indexOf(id);
        epic.subtasksId.remove(index);
        subtasks.remove(id);
        epic.calculateStatus(subtasks);
    }
//Epic
ArrayList getEpics() {
    ArrayList<Epic> values = new ArrayList<>(epics.values());
    return values;
}

    void deleteAllEpics() {
        epics.clear();
        subtasks.clear();

    }

    Epic getEpicById(int id) {
        return epics.get(id);
    }

    void addEpic(Epic epic) {
        epics.put(epic.getId(), epic);
    }

    void updateEpic(Epic epic) {
        epics.put(epic.getId(), epic);
    }

    void deleteEpicById(int id) {
        Epic epic = getEpicById(id);
        for (Integer subtaskId : epic.subtasksId) {
            subtasks.remove(subtaskId);
        }
        epics.remove(id);
    }

}
