public class Main {

    public static void main(String[] args) {

        System.out.println("Поехали!");

        TaskManager taskManager = new TaskManager();

        taskManager.addTask(new Task("Хлеб", "Купить хлеб в магазине"));
        taskManager.addTask(new Task("Батон", "Купить батон в магазине"));
        Task task = taskManager.getTaskById(1);
        task.status = Task.TaskStatus.IN_PROGRESS;
        taskManager.updateTask(task);

        System.out.println(taskManager.getTasks());
        //taskManager.deleteAllTasks();
        //System.out.println(taskManager.getTasks());
        //System.out.println(taskManager.getTaskById(1));

        taskManager.addEpic(new Epic("Дом", "Построить дом"));//id2
        taskManager.addEpic(new Epic("Дерево", "Выростить дерево"));//id3


        taskManager.addSubtask(new Subtask("Фундамент", "Построить фундамент", 2));//id4
        taskManager.addSubtask(new Subtask("Стены", "Построить стены", 2));//id5
        taskManager.addSubtask(new Subtask("Посадка", "Посадить дерево", 3));//id6


       // System.out.println(taskManager.getEpics());
       // System.out.println(taskManager.getSubtasks());

        Subtask subtask = taskManager.getSubtaskById(4);
        subtask.status = Task.TaskStatus.DONE;
        taskManager.updateSubtask(subtask);

        subtask = taskManager.getSubtaskById(5);
        subtask.status = Task.TaskStatus.IN_PROGRESS;
        taskManager.updateSubtask(subtask);

        subtask = taskManager.getSubtaskById(6);
        subtask.status = Task.TaskStatus.DONE;
        taskManager.updateSubtask(subtask);



        System.out.println(taskManager.getEpics());
        System.out.println(taskManager.getSubtasks());

        taskManager.deleteEpicById(3);
        taskManager.deleteSubtaskById(5);

        System.out.println(taskManager.getEpics());
        System.out.println(taskManager.getSubtasks());





    }
}
