import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {
    @Test
    void addingItemsIncreasesSize(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-12", "This is task 1", false);
        list.add(newItem);
        assertEquals(1, list.size());
    }
    @Test
    void completingTaskItemChangesStatus(){
        TaskItem newItem = new TaskItem("Task 1", "2020-12-12", "This is task 1", false);
        newItem.setCompleted();
        assertTrue(newItem.isCompleted());
    }
    @Test
    void completingTaskItemFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-12", "This is task 1", false);
        list.add(newItem);
        assertThrows(IndexOutOfBoundsException.class, () -> list.setCompleted(3));
    }
    @Test
    void editingItemDescriptionFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-12", "This is task 1", false);
        list.add(newItem);
        TaskItem editItem = new TaskItem("Task 2", "2020-12-14", "This is task 2", false);
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(editItem, 4));
    }
    @Test
    void editingItemDescriptionSucceedsWithExpectedValue(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-12", "This is task 1", false);
        list.add(newItem);
        TaskItem editItem = new TaskItem("Task 2", "2020-12-14", "This is task 2", false);
        list.set(editItem, 0);
        assertEquals(editItem.getDescription(), list.get(0).getDescription());
    }
    @Test
    void editingItemDueDateSucceedsWithExpectedValue(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-12", "This is task 1", false);
        list.add(newItem);
        TaskItem editItem = new TaskItem("Task 2", "2020-12-14", "This is task 2", false);
        list.set(editItem, 0);
        assertEquals(editItem.getDueDate(), list.get(0).getDueDate());
    }
    @Test
    void editingItemTitleFailsWithEmptyString(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-12", "This is task 1", false);
        list.add(newItem);
        new TaskItem("Task 2", "2020-12-14", "This is task 2", false);
        assertThrows(NullPointerException.class, () -> list.set(new TaskItem("", "2020-12-14", "This is task 2", false), 0));
    }
    @Test
    void editingItemTitleFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-12", "This is task 1", false);
        list.add(newItem);
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(new TaskItem("Task 2", "2020-12-14", "This is task 2", false), 4));
    }
    @Test
    void editingItemTitleSucceedsWithExpectedValue(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-12", "This is task 1", false);
        list.add(newItem);
        TaskItem editItem = new TaskItem("Task 2", "2020-12-14", "This is task 2", false);
        list.set(editItem, 0);
        assertEquals(editItem.getName(), list.get(0).getName());
    }
    @Test
    void editingTaskItemDueDateFailsWithInvalidDateFormat(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-12", "This is task 1", false);
        list.add(newItem);
        assertThrows(NullPointerException.class, () -> list.set(new TaskItem("Task 2", "2020-1214", "This is task 2", false), 0));
    }
    @Test
    void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-12", "This is task 1", false);
        list.add(newItem);
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(new TaskItem("Task 2", "2020-12-14", "This is task 2", false), 5));
    }
    @Test
    void editingTaskItemDueDateFailsWithInvalidYYYMMDD(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-12", "This is task 1", false);
        list.add(newItem);
        assertThrows(NullPointerException.class, () -> list.set(new TaskItem("Task 2", "2020-17-14", "This is task 2", false), 0));
    }
    @Test
    void gettingItemDescriptionFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(4).getDescription());
    }
    @Test
    void gettingItemDescriptionSucceedsWithValidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-14", "This is task 1", false);
        list.add(newItem);
        assertEquals( "This is task 1",list.get(0).getDescription());
    }
    @Test
    void gettingItemDueDateFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(4).getDueDate());
    }
    @Test
    void gettingItemDueDateSucceedsWithValidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-14", "This is task 1", false);
        list.add(newItem);
        assertEquals( "2020-12-14",list.get(0).getDueDate());
    }
    @Test
    void gettingItemTitleFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(4).getName());
    }
    @Test
    void gettingItemTitleSucceedsWithValidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-14", "This is task 1", false);
        list.add(newItem);
        assertEquals( "Task 1",list.get(0).getName());
    }
    @Test
    void newListIsEmpty(){
        TaskList list = new TaskList();
        assertEquals(0, list.size());
    }
    @Test
    void removingItemsDecreasesSize(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-14", "This is task 1", false);
        list.add(newItem);
        TaskItem newItem2 = new TaskItem("Task 1", "2020-12-14", "This is task 1", false);
        list.add(newItem2);
        list.remove(1);
        assertEquals( 1,list.size());
    }
    @Test
    void removingItemsFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-14", "This is task 1", false);
        list.add(newItem);
        TaskItem newItem2 = new TaskItem("Task 1", "2020-12-14", "This is task 1", false);
        list.add(newItem2);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
    }
    @Test
    void savedTaskListCanBeLoaded(){
        TaskList list = new TaskList();
        list.loadFile("testList2.txt");
        assertEquals("0) [2020-12-16] Task 1: This is task 1\n" + "1) *** [2020-12-31] Task 2: This is task 2\n" + "2) [2021-01-14] Task 3: This is task 3" + "\n",list.view());
    }
    @Test
    void uncompletingTaskItemChangesStatus(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-14", "This is task 1", false);
        list.add(newItem);
        list.setCompleted(0);
        list.unsetCompleted(0);
        assertFalse(list.get(0).isCompleted());
    }
    @Test
    void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-14", "This is task 1", false);
        list.add(newItem);
        list.setCompleted(0);
        assertThrows(IndexOutOfBoundsException.class, () -> list.unsetCompleted(4));
    }
}
