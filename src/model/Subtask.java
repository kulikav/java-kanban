package model;

public class Subtask extends Task {
    protected final int epicId;

    public Subtask(String title, String description, int epicId) {
        super(title, description);
        this.epicId = epicId;
    }

    public Integer getEpicId() {
        return epicId;
    }

    @Override
    public String toString() {
        return "Подзадача{" +
                "[id = " + id + "]" +
                ", [название = " + title + "]" +
                ", [описание = " + description + "]" +
                ", [статус = " + status + "]" +
                ", [эпикId = " + epicId + "]}";
    }
}

