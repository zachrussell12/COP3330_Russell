import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.exit;

public class TaskApp {

    private Scanner userInput = new Scanner(System.in);
    private TaskList list;

    public void appMenu (){
        String menuChoice = "";


        while(!menuChoice.contains("3")){

            System.out.println("Main Menu");
            System.out.println("---------");

            System.out.println("\n1) create a new list\n2) load an existing list\n3) quit\n");
            System.out.print(">");

            menuChoice = userInput.nextLine();

            if(menuChoice.contains("1")){
                makeList();
                listInteraction();
            }
            else if(menuChoice.contains("2")){
                loadFile();
            }
            else if(menuChoice.contains("3")){
                break;
            }
            else{
                System.out.println("Invalid choice made. Please try again\n");
            }
        }
    }

    public void listMenu(){
        System.out.println("\nList Operation Menu");
        System.out.println("---------");

        System.out.println("\n1) view the list\n2) add an item\n3) edit an item\n4) remove an item\n5) mark an item as completed\n6) unmark an item as completed\n7) save the current list\n8) quit to the main menu");
        System.out.print("\n>");
    }

    public void makeList(){list = new TaskList();}

    public void listInteraction(){
        int choice = 0;

        while(choice != 8){
            listMenu();
            choice = userInput.nextInt();
            userInput.nextLine();

            if(choice == 1){
                viewList();
            }
            else if(choice == 2){
                addItem();
            }
            else if(choice == 3){
                editItem();
            }
            else if(choice == 4){
                removeItem();
            }
            else if(choice == 5){
                markItemCompleted();
            }
            else if(choice == 6){
                unmarkItemCompleted();
            }
            else if(choice == 7){
                saveFile();
            }
            else if(choice == 8){
                break;
            }
            else {
                System.out.println("Invalid choice made. Please try again.\n");
            }
        }
    }

    public void viewList(){
        System.out.println(list.view());
    }

    public void viewIncompleteTasks(){
        System.out.println(list.viewIncompleteTasks());
    }

    public void viewCompleteTasks(){
        System.out.println(list.viewCompleteTasks());
    }

    public void addItem(){
        String taskName;
        String dueDate;
        String description;

        System.out.println("Task title");
        taskName = userInput.nextLine();


        System.out.println("Task description: ");
        description = userInput.nextLine();

        System.out.println("Task due date (YYYY-MM-DD): ");
        dueDate = userInput.nextLine();

        try {
            TaskItem addItem = new TaskItem(taskName, dueDate, description, false);
            list.add(addItem);
        }
        catch(NullPointerException err){}
    }

    public void editItem(){
        String taskName;
        String dueDate;
        String description;
        int choice = 0;

        if(list.size() == 0){
            System.out.println("Theres no tasks to edit");
            return;
        }

        viewList();
        System.out.println("Which task would you like to edit?");
        try {
            choice = userInput.nextInt();
            userInput.nextLine();
        }
        catch(InputMismatchException e){
            System.out.println("\nInvalid input. No task was edited.");
            userInput.nextLine();
            return;
        }


        System.out.println("Enter a new title for task " + choice + ": ");
        taskName = userInput.nextLine();

        System.out.println("Enter a new description for task " + choice + ": ");
        description = userInput.nextLine();

        System.out.println("Enter a new due date (YYYY-MM-DD) for task " + choice + ": ");
        dueDate = userInput.nextLine();

        try{
            list.set(new TaskItem(taskName, dueDate, description, false), choice);
        }
        catch(NullPointerException ex){
            System.out.println("Task name is too short");
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Task choice does not exist.\nNot task edited.");
        }
    }

    public void removeItem(){
        int choice;
        viewList();
        System.out.println("Which item would you like to remove?");
        try {
            choice = userInput.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("\nInvalid input. No task was removed.");
            userInput.nextLine();
            return;
        }

        try{
            list.remove(choice);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Task choice does not exist.\nNo task removed.");
        }
    }

    public void markItemCompleted(){
        int choice;
        int counter = 0;
        viewIncompleteTasks();

        for(int i = 0; i < list.size(); i++){
            if(!(list.get(i).isCompleted())){counter++;}
        }
        if(counter == 0){return;}
        System.out.println("Which task will you mark as completed?");
        try{
            choice = userInput.nextInt();
            userInput.nextLine();
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input. No task marked as completed.");
            return;
        }

        try{
            list.setCompleted(choice);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Task choice does not exist.");
        }
    }

    public void unmarkItemCompleted(){
        int choice;
        int counter = 0;

        viewCompleteTasks();

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).isCompleted()){counter++;}
        }
        if(counter == 0){return;}

        System.out.println("Which task will you unmark as completed?");
        try{
            choice = userInput.nextInt();
            userInput.nextLine();
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input. No task unmarked as completed");
            userInput.nextLine();
            return;
        }

        try{
            list.unsetCompleted(choice);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Task choice does not exist");
        }
    }

    public void saveFile(){

        String fileName;

        if(list.size() == 0){
            System.out.println("You have nothing in your list to save.\nTry adding something.\n");
            return;
        }

        System.out.println("Enter the filename to save as including the .txt extension: ");
        fileName = userInput.nextLine();

        list.saveFile(fileName);

    }

    public void loadFile(){

        TaskList loadedList = new TaskList();
        String fileName;
        System.out.println("Please enter the name of your file including the .txt extension: ");
        fileName = userInput.nextLine();
        try{
            loadedList.loadFile(fileName);
        }
        catch(NullPointerException e){
            System.out.println("Check your spelling, add .txt, and try again.");
            return;
        }
        list = loadedList;
        listInteraction();
    }

}