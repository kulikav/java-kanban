import manager.InMemoryTaskManager;
import manager.Managers;
import model.Epic;
import model.Subtask;
import model.Task;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Поехали!");

        InMemoryTaskManager taskManager = Managers.getDefault();


        taskManager.addTask(new Task("Хлеб", "Купить хлеб в магазине"));


        taskManager.addTask(new Task("Батон", "Купить батон в магазине"));


        Task task = taskManager.getTaskById(1);
        task.setStatus(Task.TaskStatus.IN_PROGRESS);
        taskManager.updateTask(task);


        taskManager.addEpic(new Epic("Дом", "Построить дом"));//id2
        taskManager.addEpic(new Epic("Дерево", "Вырастить дерево"));//id3


        taskManager.addSubtask(new Subtask("Фундамент", "Построить фундамент", 2));//id4
        taskManager.addSubtask(new Subtask("Стены", "Построить стены", 2));//id5
        taskManager.addSubtask(new Subtask("Посадка", "Посадить дерево", 3));//id6


        task = taskManager.getTaskById(0);
        task = taskManager.getEpicById(2);
        task = taskManager.getTaskById(1);
        task = taskManager.getSubtaskById(4);
        task = taskManager.getEpicById(3);
        task = taskManager.getSubtaskById(6);
        task = taskManager.getSubtaskById(5);


        taskManager.deleteEpicById(2);


        task = taskManager.getTaskById(0);
        task = taskManager.getEpicById(2);
        task = taskManager.getTaskById(1);
        task = taskManager.getSubtaskById(4);
        task = taskManager.getEpicById(3);
        task = taskManager.getSubtaskById(6);
        task = taskManager.getSubtaskById(5);
        task = taskManager.getEpicById(2);

        System.out.println("История");
        List<Task> historyList = taskManager.getHistory();
        for (Task taskHistory : historyList) {
            System.out.println(taskHistory);
        }
    }
}
