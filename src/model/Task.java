package model;

import manager.TaskManager;

import java.util.Objects;

public class Task {
    protected final int id;
    protected String title;
    protected String description;
    protected TaskStatus status;


    public enum TaskStatus {
        NEW,
        IN_PROGRESS,
        DONE
    }

    public Task(String title, String description) {
        this.id = TaskManager.getNewId();
        this.title = title;
        this.description = description;
        this.status = TaskStatus.NEW;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return Objects.equals(id, task.id);
    }

    public Integer getId() {
        return id;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Задача{" +
                "[id = " + id + "]" +
                ", [название = " + title + "]" +
                ", [описание = " + description + "]" +
                ", [статус = " + status + "]}";
    }

}
