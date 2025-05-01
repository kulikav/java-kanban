import java.util.ArrayList;
import java.util.HashMap;

public class Epic extends Task {
    ArrayList<Integer> subtasksId;

    Epic(String title, String description) {
        super(title, description);
        subtasksId = new ArrayList<Integer>();

    }

    @Override
    public String toString() {
        return "Эпик{" +
                "[id = " + id + "]" +
                ", [название = " + title + "]" +
                ", [описание = " + description + "]" +
                ", [статус = " + status + "]" +
                ", [подзадачи = " + subtasksId + "]}";
    }

    void addSubtask(Integer id) {
        subtasksId.add(id);
    }

    void calculateStatus(HashMap<Integer, Subtask> subtasks) {
        int size = subtasksId.size();
        if (size == 0) {
            status = TaskStatus.NEW;
            return;
        }
        int counterDone = 0;
        for (Integer id : subtasksId) {
            Subtask subtask = subtasks.get(id);
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

    ArrayList getSubtasks() {
        return subtasksId;
    }

}
