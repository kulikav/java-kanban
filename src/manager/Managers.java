package manager;

public class Managers {

    public static InMemoryTaskManager getDefault() {
        return new InMemoryTaskManager(getDefaultHistoryManager());
    }

    public static HistoryManager getDefaultHistoryManager() {
        return new InMemoryHistoryManager();
    }


}
