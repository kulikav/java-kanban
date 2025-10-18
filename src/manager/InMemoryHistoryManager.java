package manager;

import model.Task;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {

    private static class Node {
        Task task;
        Node prev;
        Node next;

        public Node(Task task, Node prev, Node next) {
            this.task = task;
            this.prev = prev;
            this.next = next;
        }
    }

    private Map<Integer, Node> history = new HashMap<>(); //taskId
    private Node first = null;  //первый элемент в истории
    private Node last = null;  //последний элемент в истории

    private ArrayList<Task> getTasks() {
        ArrayList<Task> tasks = new ArrayList<Task>();

        return tasks;
    }

    private void linkLast(Task task) {
        Node node = new Node(task, null, null);
        if (last == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }

    }


    @Override
    public void add(Task task) {
        if (task == null) {
            return;
        }
        int taskId = task.getId();
        removeNode(taskId);
        linkLast(task);
        history.put(taskId, last);
    }

    private void removeNode(int id) {
        final Node node = history.remove(id);
        if (node == null) {
            return;
        }
        // first middle last
        if (node == first) {
            if (first == last) { // один элемент
                first = null;
                last = null;
            } else {
                first = node.next;
                first.prev = null;
            }
        } else if (node == last) {
            last = node.prev;
            last.next = null;
        } else { //middle
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

    }

    @Override
    public void remove(int id) {
        removeNode(id);

    }

    @Override
    public List<Task> getHistory() {
        ArrayList<Task> tasks = new ArrayList<>();
        Node node = first;
        if (node != null) {
            tasks.add(node.task);
        }
        while (node.next != null) {
            node = node.next;
            tasks.add(node.task);
        }
        return tasks;
    }
}