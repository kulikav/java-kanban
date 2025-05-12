package manager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ManagersTest {
    @Test
    public void testManagerIsInitialized() {
        InMemoryTaskManager manager = Managers.getDefault();
        assertNotNull(manager);
        int id = manager.getNewId();
        assertNotNull(id);
        assertEquals(id+1, manager.getNewId());


    }
}