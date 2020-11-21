import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {

    @Test
    void constructorFailsWithInvalidDueDate(){
        assertThrows(NullPointerException.class, () -> new TaskItem("Task 1", "2020-123-12", "This is task 1", false));
    }
    @Test
    void constructorFailsWithInvalidTitle(){
        assertThrows(NullPointerException.class, () -> new TaskItem("", "2020-12-12", "This is task 1", false));
    }

    @Test
    void constructorSucceedsWithValidDueDate(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-12", "This is task 1", false);
        list.add(newItem);
        assertEquals("2020-12-12", list.get(0).getDueDate());
    }
    @Test
    void constructorSucceedsWithValidTitle(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-12", "This is task 1", false);
        list.add(newItem);
        assertEquals("Task 1", list.get(0).getName());
    }
    @Test
    void editingDescriptionSucceedsWithExpectedValue(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-12", "This is task 1", false);
        list.add(newItem);
        TaskItem editedItem = new TaskItem("Task 2", "2020-12-14", "This is task 2", false);
        list.set(editedItem, 0);
        assertEquals(editedItem.toString(), list.get(0).toString());
    }
    @Test
    void editingDueDateFailsWithInvalidDateFormat(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-12", "This is task 1", false);
        list.add(newItem);
        assertThrows(NullPointerException.class, () -> list.set(new TaskItem("Task 1", "2020-123-12", "This is task 1", false), 0));
    }
    @Test
    void editingDueDateFailsWithInvalidYYYMMDD(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-12", "This is task 1", false);
        list.add(newItem);
        assertThrows(NullPointerException.class, () -> list.set(new TaskItem("Task 1", "2020-14-12", "This is task 1", false), 0));
    }
    @Test
    void editingDueDateSucceedsWithExpectedValue(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-12", "This is task 1", false);
        list.add(newItem);
        TaskItem editItem = new TaskItem("Task 2", "2020-12-17", "This is task 2", false);
        list.set(editItem,0);
        assertEquals("2020-12-17", list.get(0).getDueDate());
    }
    @Test
    void editingTitleFailsWithEmptyString(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-12", "This is task 1", false);
        list.add(newItem);
        assertThrows(NullPointerException.class, () -> list.set(new TaskItem("", "2020-12-12", "This is task 1", false), 0));
    }
    @Test
    void editingTitleSucceedsWithExpectedValue() {
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-12", "This is task 1", false);
        list.add(newItem);
        TaskItem editedItem = new TaskItem("Task 2", "2020-12-14", "This is task 1", false);
        list.set(editedItem, 0);
        assertEquals("Task 2", list.get(0).getName());
    }
}

