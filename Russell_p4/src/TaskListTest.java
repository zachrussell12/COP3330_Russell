import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;


class TaskListTest {

    @Test
    void addingTaskItemsIncreasesSize(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-14", "This is task 1", false);
        list.taskList.add(newItem);
        assertEquals(1, list.taskList.size());
    }

    @Test
    void completingTaskItemChangesStatus(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-14", "This is task 1", false);
        list.taskList.add(newItem);
        newItem.setCompleted();
        assertTrue(newItem.isCompleted());
    }

    @Test
    void completingTaskItemFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-14", "This is task 1", false);
        TaskItem newItem2 = new TaskItem("Task 2", "2020-12-17", "This is task 2", false);
        list.taskList.add(newItem);
        list.taskList.add(newItem2);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.markCompleted(list.taskList, 2);});

    }

    @Test
    void editingTaskItemChangesValues(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-14", "This is task 1", false);
        list.taskList.add(newItem);
        TaskItem editItem = new TaskItem("Task 4", "2020-11-14", "This is task 4 to be comeplted later", false);
        list.taskList.set(0,editItem);

        assertEquals(editItem, list.taskList.get(0));

    }

    @Test
    void editingTaskItemDescriptionChangesValue(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Clean car", "2020-12-14", "i need to clean the car", false);
        list.taskList.add(newItem);
        TaskItem editItem = new TaskItem("get gas", "2020-11-25", "I need to get gas later", false);
        list.taskList.set(0,editItem);

        assertEquals("I need to get gas later", list.taskList.get(0).getDescription());
    }

    @Test
    void editingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Clean car", "2020-12-14", "i need to clean the car", false);
        list.taskList.add(newItem);
        assertThrows(IndexOutOfBoundsException.class, () -> { list.taskList.get(4).setDescription("woied");});

    }

    @Test
    void editingTaskItemDueDateChangesValue(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Get groceries", "2021-10-14", "i need cheese", false);
        list.taskList.add(newItem);
        TaskItem editItem = new TaskItem("get gas", "2020-12-30", "I need to get gas on the 30th", false);
        list.taskList.set(0,editItem);

        assertEquals("2020-12-30", list.taskList.get(0).getDueDate());
    }

    @Test
    void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Clean car", "2024-10-13", "i need to clean the car way in the future", false);
        list.taskList.add(newItem);
        assertThrows(IndexOutOfBoundsException.class, () -> { list.taskList.get(-1).setDueDate("wepk");});
    }

    @Test
    void editingTaskItemTitleChangesValue(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Paint house", "2021-09-14", "pick colors at sherwin, paint it", false);
        list.taskList.add(newItem);
        TaskItem editItem = new TaskItem("get gas", "2020-12-30", "why do i always need to get gas on the 30th", false);
        list.taskList.set(0,editItem);

        assertEquals("get gas", list.taskList.get(0).getName());
    }

    @Test
    void editingTaskItemTitleFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Clean car", "2024-10-13", "i need to clean the car way in the future", false);
        assertThrows(IndexOutOfBoundsException.class, () -> { list.taskList.get(7).setName("New");});
    }

    @Test
    void gettingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Clean car", "2024-10-13", "i need to clean the car way in the future", false);
        list.taskList.add(newItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.taskList.get(1).getDescription();});
    }

    @Test
    void gettingTaskItemDescriptionSucceedsWithValidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Clean car", "2024-10-13", "i need to clean the car way in the future", false);
        list.taskList.add(newItem);
        assertEquals("i need to clean the car way in the future", list.taskList.get(0).getDescription());
    }

    @Test
    void gettingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Clean car", "2024-10-13", "i need to clean the car way in the future", false);
        list.taskList.add(newItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.taskList.get(1).getDueDate();});
    }

    @Test
    void gettingTaskItemDueDateSucceedsWithValidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Clean car", "2024-10-13", "i need to clean the car way in the future", false);
        list.taskList.add(newItem);
        assertEquals("2024-10-13", list.taskList.get(0).getDueDate());
    }

    @Test
    void gettingTaskItemTitleFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Clean car", "2024-10-13", "i need to clean the car way in the future", false);
        list.taskList.add(newItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.taskList.get(1).getName();});
    }

    @Test
    void gettingTaskItemTitleSucceedsWithValidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Clean car", "2024-10-13", "i need to clean the car way in the future", false);
        list.taskList.add(newItem);
        assertEquals("Clean car", list.taskList.get(0).getName());
    }

    @Test
    void newTaskListIsEmpty(){
        TaskList list = new TaskList();
        assertEquals(0,list.taskList.size());
    }

    @Test
    void removingTaskItemsDecreasesSize(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Clean car", "2024-10-13", "i need to clean the car way in the future", false);
        list.taskList.add(newItem);
        TaskItem newItem2 = new TaskItem("Clean car", "2024-10-13", "i need to clean the car way in the future", false);
        list.taskList.add(newItem2);
        TaskItem newItem3 = new TaskItem("Clean car", "2024-10-13", "i need to clean the car way in the future", false);
        list.taskList.add(newItem3);
        TaskItem newItem4 = new TaskItem("Clean car", "2024-10-13", "i need to clean the car way in the future", false);
        list.taskList.add(newItem4);
        list.removeItem(list.taskList, 1);
        assertEquals(3, list.taskList.size());
    }

    @Test
    void removingTaskItemsFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Clean car", "2024-10-13", "i need to clean the car way in the future", false);
        list.taskList.add(newItem);
        TaskItem newItem2 = new TaskItem("Clean car", "2024-10-13", "i need to clean the car way in the future", false);
        list.taskList.add(newItem2);
        TaskItem newItem3 = new TaskItem("Clean car", "2024-10-13", "i need to clean the car way in the future", false);
        list.taskList.add(newItem3);
        TaskItem newItem4 = new TaskItem("Clean car", "2024-10-13", "i need to clean the car way in the future", false);
        list.taskList.add(newItem4);
        assertEquals(4, list.taskList.size());
    }

    @Test
    void savedTaskListCanBeLoaded(){
        TaskList loadedList = new TaskList();
        File listFile = new File("testList.txt");
        assertTrue(listFile.exists());
    }

    @Test
    void savedTaskListCannotBeLoaded(){
        TaskList loadedList = new TaskList();
        File listFile = new File("rfcefw");
        assertFalse(listFile.exists());
    }

    @Test
    void uncompletingTaskItemChangesStatus(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Clean car", "2024-10-13", "i need to clean the car way in the future", false);
        list.taskList.add(newItem);
        list.markCompleted(list.taskList, 0);
        list.unmarkCompleted(list.taskList, 0);
        assertFalse(list.taskList.get(0).isCompleted());
    }

    @Test
    void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Clean car", "2024-10-13", "i need to clean the car way in the future", false);
        list.taskList.add(newItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.taskList.get(9).unsetCompleted();});
    }

    @Test
    void getDescriptiongetsCorrectDescription(){
        TaskList list = new TaskList();
        TaskItem item = new TaskItem("Task 1", "2020-12-16", "This is task 1", false);
        list.taskList.add(item);
        assertEquals("This is task 1", list.taskList.get(0).getDescription());
    }

    @Test
    void getDueDategetsCorrectDueDate(){
        TaskList list = new TaskList();
        TaskItem item = new TaskItem("Task 1", "2020-12-16", "This is task 1", false);
        list.taskList.add(item);
        assertEquals("2020-12-16", list.taskList.get(0).getDueDate());
    }

    @Test
    void getNamegetsCorrectName(){
        TaskList list = new TaskList();
        TaskItem item = new TaskItem("Task 1", "2020-12-16", "This is task 1", false);
        list.taskList.add(item);
        assertEquals("Task 1", list.taskList.get(0).getName());
    }

    @Test
    void getStatusgetsCorrectStatus(){
        TaskList list = new TaskList();
        TaskItem item = new TaskItem("Task 1", "2020-12-16", "This is task 1", false);
        list.taskList.add(item);
        list.taskList.get(0).setCompleted();
        assertTrue(list.taskList.get(0).isCompleted());
    }

    @Test
    void taskItemtoStringPrintsProperly(){
        TaskList list = new TaskList();
        TaskItem item = new TaskItem("Task 1", "2020-12-16", "This is task 1", false);
        list.taskList.add(item);
        assertEquals("[2020-12-16] Task 1: This is task 1", list.taskList.get(0).toString());
    }

    @Test
    void taskItemtoStringFilePrintsProperly(){
        TaskList list = new TaskList();
        TaskItem item = new TaskItem("Task 1", "2020-12-16", "This is task 1", false);
        list.taskList.add(item);
        assertEquals("[2020-12-16]\nTask 1\nThis is task 1", list.taskList.get(0).toStringFile());
    }

    @Test
    void completedItemPrintsWithStars(){
        TaskList list = new TaskList();
        TaskItem item = new TaskItem("Task 1", "2020-12-16", "This is task 1", false);
        list.taskList.add(item);
        list.taskList.get(0).setCompleted();
        //In program if statement prints list with stars if completed exactly like this
        assertEquals("*** [2020-12-16] Task 1: This is task 1", "*** " + list.taskList.get(0).toString());
    }




}