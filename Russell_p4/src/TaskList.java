import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TaskList {

    public final ArrayList<TaskItem> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public void menu(){

        String menuChoice = "";

        Scanner input = new Scanner(System.in);

        while(!menuChoice.contains("8")) {
            System.out.println("\nList Operation Menu");
            System.out.println("---------");

            System.out.println("\n1) view the list\n2) add an item\n3) edit an item\n4) remove an item\n5) mark an item as completed\n6) unmark an item as completed\n7) save the current list\n8) quit to the main menu");
            System.out.print("\n>");

            menuChoice = input.next();

            if(menuChoice.equalsIgnoreCase("1")){
                viewList(this.taskList);
            }
            else if(menuChoice.equalsIgnoreCase("2")){
                addItem(this.taskList);
            }
            else if(menuChoice.equalsIgnoreCase("3")){
                editItem(this.taskList);
            }
            else if(menuChoice.equalsIgnoreCase("4")){
                removeItem(this.taskList);
            }
            else if(menuChoice.equalsIgnoreCase("5")){
                markCompleted(this.taskList);
            }
            else if(menuChoice.equalsIgnoreCase("6")){
                unmarkCompleted(this.taskList);
            }
            else if(menuChoice.equalsIgnoreCase("7")){
                saveList(this.taskList);
            }
            else if(menuChoice.equalsIgnoreCase("8")){
                break;
            }
            else{
                System.out.println("Invalid Input. Try again.\n");
            }

        }
    }

    public void viewList(ArrayList<TaskItem> taskList){
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

    public void viewUncompletedList(ArrayList<TaskItem> taskList){
        int counter = 0;
        System.out.println("Uncompleted Tasks");
        System.out.println("-------------\n");
        for(int i = 0; i < taskList.size(); i++){
            if (!taskList.get(i).isCompleted()) {
                System.out.println(i + ") " + taskList.get(i));
                counter++;
            }
        }

        if(counter == 0){System.out.println("You currently have no uncompleted tasks");}
    }

    public void viewCompletedList(ArrayList<TaskItem> taskList){
        int counter = 0;
        System.out.println("Completed Tasks");
        System.out.println("-------------\n");

        for(int i = 0; i < taskList.size(); i++){
            if (taskList.get(i).isCompleted()) {
                System.out.println(i + ") *** " + taskList.get(i));
                counter++;
            }
        }

        if(counter == 0){System.out.println("You currently have no completed tasks");}
    }

    public void addItem(ArrayList<TaskItem> taskList){
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
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        //Date object not able to parse into format ****
        try {
            Date currentDate = format.parse(dueDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(!(dueDate.matches("....-..-.."))){
            System.out.println("Date is in improper format. Remember to include dashes and use proper YYYY-MM-DD formatting.");
        }

        System.out.println(format.format(dueDate));

        TaskItem newItem = new TaskItem(taskName, dueDate, description, false);
        taskList.add(newItem);
    }

    public void editItem(ArrayList<TaskItem> taskList){

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

        TaskItem editedItem = new TaskItem(taskName, dueDate, description, false);

        taskList.set(choice, editedItem);

    }

    public void removeItem(ArrayList<TaskItem> taskList){

        viewList(taskList);
        int choice;

        System.out.println("Which task will you remove?");
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();

        taskList.remove(choice);

    }

    public void markCompleted(ArrayList<TaskItem> taskList){

        int choice;
        int counter = 0;

        viewUncompletedList(taskList);

        for(int i = 0; i < taskList.size(); i++){
            if(!taskList.get(i).isCompleted()){
                counter++;
            }
        }

        if(counter == 0){
            return;
        }

        System.out.println("Which task will you mark as completed?");
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();

        taskList.get(choice).setCompleted();

    }

    public void unmarkCompleted(ArrayList<TaskItem> taskList){

        int choice;
        int counter = 0;

        viewCompletedList(taskList);

        for(int i = 0; i < taskList.size(); i++){
            if(taskList.get(i).isCompleted()){
                counter++;
            }
        }

        if(counter == 0){
            return;
        }

        System.out.println("Which task will you unmark as completed?");
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();

        taskList.get(choice).unsetCompleted();

    }

    public void saveList(ArrayList<TaskItem> taskList){

        String fileName;

        System.out.println("Enter the filename to save as including .txt extension: ");
        Scanner input = new Scanner(System.in);
        fileName = input.nextLine();

        File saveFile = new File(fileName);

        try {
            FileWriter taskWriter = new FileWriter(fileName);
            int listSize = taskList.size();
            taskWriter.write(listSize + "\n");
            for(int i = 0; i < taskList.size(); i++){
                if(taskList.get(i).isCompleted()){
                    taskWriter.write("true\n" + taskList.get(i).toStringFile() + "\n");
                }
                else {
                    taskWriter.write("false\n" + taskList.get(i).toStringFile() + "\n");
                }


            }

            taskWriter.close();
        } catch (IOException e) {
            System.out.println("File error occured. Could not save task list.");
        }

        System.out.println("task list has been saved");

    }

    public void loadList(File listFile){

        String taskName;
        String dueDate;
        String description;
        String isCompleted;
        boolean taskDone;
        int listSize = 0;

        try {
            Scanner fileReader = new Scanner(listFile);

            listSize = fileReader.nextInt();
            fileReader.nextLine();

            for(int i = 0; i < listSize; i++){

                isCompleted = fileReader.nextLine();
                dueDate = fileReader.nextLine();
                taskName = fileReader.nextLine();
                description = fileReader.nextLine();

                dueDate = dueDate.replace("[", "");
                dueDate = dueDate.replace("]", "");
                if(isCompleted.contains("true")){
                    taskDone = true;
                }
                else{
                    taskDone = false;
                }

                TaskItem newItem = new TaskItem(taskName, dueDate, description, taskDone);
                taskList.add(newItem);

            }

            menu();

        } catch (FileNotFoundException e) {
            System.out.println("Could not load file");
        }
    }

}
