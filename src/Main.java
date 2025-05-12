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

        //System.out.println(taskManager.getTasks());
        //taskManager.deleteAllTasks();
        //System.out.println(taskManager.getTasks());
        //System.out.println(taskManager.getTaskById(1));

        taskManager.addEpic(new Epic("Дом", "Построить дом"));//id2
        taskManager.addEpic(new Epic("Дерево", "Вырастить дерево"));//id3


        taskManager.addSubtask(new Subtask("Фундамент", "Построить фундамент", 2));//id4
        taskManager.addSubtask(new Subtask("Стены", "Построить стены", 2));//id5
        taskManager.addSubtask(new Subtask("Посадка", "Посадить дерево", 3));//id6


        //System.out.println(taskManager.getEpics());
        //System.out.println(taskManager.getSubtasks());

        Subtask subtask = taskManager.getSubtaskById(4);
        subtask.setStatus(Task.TaskStatus.IN_PROGRESS);
        taskManager.updateSubtask(subtask);

        subtask = taskManager.getSubtaskById(5);
        subtask.setStatus(Task.TaskStatus.DONE);
        taskManager.updateSubtask(subtask);

        subtask = taskManager.getSubtaskById(6);
        subtask.setStatus(Task.TaskStatus.DONE);
        taskManager.updateSubtask(subtask);


        System.out.println(taskManager.getEpics());
        //System.out.println(taskManager.getSubtasks());

        taskManager.deleteEpicById(3);
        taskManager.deleteSubtaskById(4);

        System.out.println(taskManager.getEpics());
        //System.out.println(taskManager.getSubtasks());

//        subtask = taskManager.getSubtaskById(5);
//        task = taskManager.getTaskById(1);
//        task = taskManager.getTaskById(2);
//        subtask = taskManager.getSubtaskById(5);
//        task = taskManager.getTaskById(1);
//        task = taskManager.getTaskById(2);
//        subtask = taskManager.getSubtaskById(5);

        System.out.println("История");
        List<Task> historyList = taskManager.getHistory();
        for(Task taskHistory : historyList) {
            System.out.println(taskHistory);
        }
    }
}
