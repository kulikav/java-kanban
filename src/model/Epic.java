package model;

import java.util.ArrayList;

public class Epic extends Task {
    protected ArrayList<Subtask> epicSubtasks;

    public Epic(String title, String description) {
        super(title, description);
        epicSubtasks = new ArrayList<Subtask>();
    }

    @Override
    public String toString() {
        return "Эпик{" +
                "[id = " + id + "]" +
                ", [название = " + title + "]" +
                ", [описание = " + description + "]" +
                ", [статус = " + status + "]" +
                ", [подзадачи = " + epicSubtasks + "]}";
    }

    public void addSubtask(Subtask subtask) {
        epicSubtasks.add(subtask);
    }

    public void deleteSubtusk(Subtask subtask) {
        epicSubtasks.remove(subtask);
    }

    public void calculateStatus() {
        int size = epicSubtasks.size();
        if (size == 0) {
            status = TaskStatus.NEW;
            return;
        }
        int counterDone = 0;
        for (Subtask subtask : epicSubtasks) {
            TaskStatus subtaskStatus = subtask.getStatus();
            if (subtaskStatus == TaskStatus.IN_PROGRESS) {
                status = TaskStatus.IN_PROGRESS;
                return;
            }
            if (subtaskStatus == TaskStatus.DONE) {
                counterDone++;
            }
        }
        if (counterDone == size) {
            status = TaskStatus.DONE;
            return;
        } else {
            status = TaskStatus.NEW;
            return;
        }
    }

    public ArrayList<Subtask> getSubtasks() {
        return epicSubtasks;
    }

}
