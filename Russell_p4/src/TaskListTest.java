import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

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
        assertEquals(newItem.isCompleted(), true);
    }

    @Test
    void completingTaskItemFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-14", "This is task 1", false);
        TaskItem newItem2 = new TaskItem("Task 2", "2020-12-17", "This is task 2", false);
        list.taskList.add(newItem);
        list.taskList.add(newItem2);

        list.markCompleted(list.taskList);

        String input1 = "0";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(input1.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);

        assertEquals(list.taskList.get(0).isCompleted(), true);
        //assertThrows;

    }

    /*@Test
    void editingTaskItemChangesValues(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2020-12-14", "This is task 1", false);
        list.taskList.add(newItem);
        list.editItem(list.taskList);
        TaskItem editItem = new TaskItem("Task 4", "2020-11-14", "This is task 4 to be comeplted later", false);
        assertNotEquals(editItem,newItem);

    }*/

    /*@Test
    void editingTaskItemDescriptionChangesValue(){

    }

    @Test
    void editingTaskItemDescriptionFailsWithInvalidIndex(){

    }

    @Test
    void editingTaskItemDueDateChangesValue(){

    }

    @Test
    void editingTaskItemDueDateFailsWithInvalidIndex(){

    }

    @Test
    void editingTaskItemTitleChangesValue(){

    }

    @Test
    void editingTaskItemTitleFailsWithInvalidIndex(){

    }

    @Test
    void gettingTaskItemDescriptionFailsWithInvalidIndex(){

    }

    @Test
    void gettingTaskItemDescriptionSucceedsWithValidIndex(){

    }

    @Test
    void gettingTaskItemDueDateFailsWithInvalidIndex(){

    }

    @Test
    void gettingTaskItemDueDateSucceedsWithValidIndex(){

    }

    @Test
    void gettingTaskItemTitleFailsWithInvalidIndex(){

    }

    @Test
    void gettingTaskItemTitleSucceedsWithValidIndex(){

    }*/

    @Test
    void newTaskListIsEmpty(){
        TaskList list = new TaskList();
        assertEquals(0,list.taskList.size());
    }

    /*@Test
    void removingTaskItemsDecreasesSize(){

    }

    @Test
    void removingTaskItemsFailsWithInvalidIndex(){

    }

    @Test
    void savedTaskListCanBeLoaded(){

    }

    @Test
    void uncompletingTaskItemChangesStatus(){

    }

    @Test
    void uncompletingTaskItemFailsWithInvalidIndex(){

    }*/


}