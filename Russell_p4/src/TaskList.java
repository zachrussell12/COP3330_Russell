import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {

    private ArrayList<TaskItem> taskList = new ArrayList<>();

    public TaskList() {
        ArrayList<TaskItem> list = new ArrayList<>();
        this.taskList = list;
    }

    public void menu(){

        int menuChoice = 0;

        Scanner input = new Scanner(System.in);

        while(menuChoice != 8) {
            System.out.println("\nList Operation Menu");
            System.out.println("---------");

            System.out.println("\n1) view the list\n2) add an item\n3) edit an item\n4) remove an item\n5) mark an item as completed\n6) unmark an item as completed\n7) save the current list\n8) quit to the main menu");
            System.out.print("\n>");

            menuChoice = input.nextInt();

            if(menuChoice == 1){
                viewList(this.taskList);
            }
            else if(menuChoice == 2){
                addItem(this.taskList);
            }
            else if(menuChoice == 3){
                editItem(this.taskList);
            }
            else if(menuChoice == 4){
                removeItem(this.taskList);
            }
            else if(menuChoice == 5){
                markCompleted(this.taskList);
            }
            else if(menuChoice == 6){
                unmarkCompleted(this.taskList);
            }
            else if(menuChoice == 7){
                
            }

        }
    }

    public static void viewList(ArrayList<TaskItem> taskList){
        System.out.println("Current Tasks");
        System.out.println("-------------\n");
        if(taskList.size() == 0){
            System.out.println("The list is currently empty");
        }
        for(int i = 0; i < taskList.size(); i++){
            if(taskList.get(i).isCompleted()){
                System.out.println(i + ") *** " + taskList.get(i).toString());
            }
            else {
                System.out.println(i + ") " + taskList.get(i).toString());
            }
        }
    }

    public static void addItem(ArrayList<TaskItem> taskList){
        String taskName;
        String dueDate;
        String description;

        System.out.println("Task title: ");
        Scanner nameInput = new Scanner(System.in);
        taskName = nameInput.nextLine();

        if(!(taskName.length() >= 1)){
            System.out.println("WARNING: Task Title must be at least 1 character long. Task not created.");
            return;
        }

        System.out.println("Task description: ");
        Scanner descriptionInput = new Scanner (System.in);
        description = descriptionInput.nextLine();

        System.out.println("Task due date (YYYY-MM-DD): ");
        Scanner dueDateInput = new Scanner(System.in);
        dueDate = dueDateInput.nextLine();

        TaskItem newItem = new TaskItem(taskName, dueDate, description);
        taskList.add(newItem);
    }

    public static void editItem(ArrayList<TaskItem> taskList){

        int choice;
        String taskName;
        String dueDate;
        String description;

        viewList(taskList);


        System.out.println("Which task will you edit?");
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();

        System.out.println("Enter a new title for task " + choice + " :" );
        Scanner nameInput = new Scanner(System.in);
        taskName = nameInput.nextLine();

        if(!(taskName.length() >= 1)){
            System.out.println("WARNING: Task Title must be at least 1 character long. Task not edited.");
            return;
        }

        System.out.println("Enter a new description for task " + choice + " :");
        Scanner descriptionInput = new Scanner (System.in);
        description = descriptionInput.nextLine();

        System.out.println("Enter a new task due date (YYYY-MM-DD) for task " + choice + " :");
        Scanner dueDateInput = new Scanner(System.in);
        dueDate = dueDateInput.nextLine();

        TaskItem editedItem = new TaskItem(taskName, dueDate, description);

        taskList.set(choice, editedItem);

    }

    public static void removeItem(ArrayList<TaskItem> taskList){

        viewList(taskList);
        int choice;

        System.out.println("Which task will you remove?");
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();

        taskList.remove(choice);

    }

    public static void markCompleted(ArrayList<TaskItem> taskList){

        int choice;

        System.out.println("Uncompleted Tasks");
        System.out.println("-------------");

        for(int i = 0; i < taskList.size(); i++){
            if (!taskList.get(i).isCompleted()) {
                System.out.println(i + ") " + taskList.get(i));
            }
        }

        System.out.println("Which task will you mark as completed?");
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();

        taskList.get(choice).setCompleted();

    }

    public static void unmarkCompleted(ArrayList<TaskItem> taskList){

        int choice;

        System.out.println("Completed Tasks");
        System.out.println("-------------");

        for(int i = 0; i < taskList.size(); i++){
            if (taskList.get(i).isCompleted()) {
                System.out.println(i + ") *** " + taskList.get(i));
            }
        }

        System.out.println("Which task will you unmark as completed?");
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();

        taskList.get(choice).unsetCompleted();

    }

}
