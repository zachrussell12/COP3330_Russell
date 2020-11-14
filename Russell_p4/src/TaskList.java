import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
                int choice;
                viewList(this.taskList);
                System.out.println("Which task will you edit?");
                Scanner taskChoice = new Scanner(System.in);
                if(!taskChoice.hasNextInt()){
                    System.out.println("Invalid input made.\nNo task marked as completed.");
                    return;
                }else {
                    choice = taskChoice.nextInt();
                    editItem(this.taskList, choice);
                }
            }
            else if(menuChoice.equalsIgnoreCase("4")){
                viewList(taskList);
                int choice;
                System.out.println("Which task will you remove?");
                Scanner taskChoice2 = new Scanner(System.in);
                if(!taskChoice2.hasNextInt()){
                    System.out.println("Invalid input made.\nNo task removed.");

                }else {
                    choice = taskChoice2.nextInt();
                    removeItem(this.taskList, choice);
                }
            }
            else if(menuChoice.equalsIgnoreCase("5")){
                int counter = viewUncompletedList(this.taskList);
                int choice;
                if(counter == 0){System.out.println("No task marked as completed.");}
                else {
                    System.out.println("Which task will you mark as completed?");
                    Scanner completeChoice = new Scanner(System.in);
                    if (!completeChoice.hasNextInt()) {
                        System.out.println("Invalid input made.\nNo task marked as completed.");
                        return;
                    } else {
                        choice = completeChoice.nextInt();
                        markCompleted(this.taskList, choice);
                    }
                }
            }
            else if(menuChoice.equalsIgnoreCase("6")){
                int choice;
                int counter = viewCompletedList(this.taskList);
                if(counter == 0){System.out.println("No task unmarked as completed.");}
                else {
                    System.out.println("Which task will you unmark as completed?");
                    Scanner unCompleteChoice = new Scanner(System.in);
                    if (!unCompleteChoice.hasNextInt()) {
                        System.out.println("Invalid input made.\nNo task unmarked as completed.");
                        return;
                    }
                    else {
                        choice = unCompleteChoice.nextInt();
                        unmarkCompleted(this.taskList, choice);
                    }
                }
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

    public int viewUncompletedList(ArrayList<TaskItem> taskList){
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

        return counter;
    }

    public int viewCompletedList(ArrayList<TaskItem> taskList){
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

        return counter;
    }

    public void addItem(ArrayList<TaskItem> taskList) {
        String taskName;
        String dueDate;
        String description;

        System.out.println("Task title: ");
        Scanner nameInput = new Scanner(System.in);
        taskName = nameInput.nextLine();

        if (!(taskName.length() >= 1)) {
            System.out.println("WARNING: Task Title must be at least 1 character long. Task not created.");
            return;
        }

        System.out.println("Task description: ");
        Scanner descriptionInput = new Scanner(System.in);
        description = descriptionInput.nextLine();


        System.out.println("Task due date (YYYY-MM-DD): ");
        Scanner dueDateInput = new Scanner(System.in);
        dueDate = dueDateInput.nextLine();

        if (!(dueDate.matches("....-..-.."))) {
            System.out.println("Date is in improper format.\nRemember to include dashes and use proper YYYY-MM-DD formatting.\nTask not created.");
            return;
        }

        Date currentDate = new Date();
        Date inputDate = null;
        try {
            inputDate = new SimpleDateFormat("yyyy-MM-dd").parse(dueDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(currentDate.after(inputDate)){
            System.out.println("Date is in the past. Task not created.");
            return;
        }
        if(dueDate.charAt(6) == '3' || dueDate.charAt(6) == '4' || dueDate.charAt(6) == '5' || dueDate.charAt(6) == '6' || dueDate.charAt(6) == '7' || dueDate.charAt(6) == '8' || dueDate.charAt(6) == '9'){
            System.out.println("Date is not valid. Task not created.");
            return;
        }


        TaskItem newItem = new TaskItem(taskName, dueDate, description, false);
        taskList.add(newItem);
    }

    public void editItem(ArrayList<TaskItem> taskList, int choice){

        String taskName;
        String dueDate;
        String description;

        try{
            taskList.get(choice);
        }catch (IndexOutOfBoundsException ex) {
            System.out.println("Invalid selection.\nTask number does not exist.\nEdit not completed\n");
            throw ex;
        }
        finally{
            if(choice > taskList.size() || choice < 0){
                return;
            }

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

            if (!(dueDate.matches("....-..-.."))) {
                System.out.println("Date is in improper format.\nRemember to include dashes and use proper YYYY-MM-DD formatting.\nTask not edited.");
                return;
            }

            Date currentDate = new Date();
            Date inputDate = null;
            try {
                inputDate = new SimpleDateFormat("yyyy-MM-dd").parse(dueDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if(currentDate.after(inputDate)){
                System.out.println("Date is in the past. Task not edited.");
                return;
            }

            TaskItem editedItem = new TaskItem(taskName, dueDate, description, false);

            taskList.set(choice, editedItem);
        }

    }

    public void removeItem(ArrayList<TaskItem> taskList, int choice) throws IndexOutOfBoundsException{

        try{
            taskList.get(choice);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Invalid selection.\nTask number does not exist.\nTask not removed.\n");
            throw ex;
        }
        finally{
            if(choice > taskList.size() || choice < 0){
                return;
            }
            taskList.remove(choice);
        }



    }

    public void markCompleted(ArrayList<TaskItem> taskList, int choice){
        try{
            taskList.get(choice);
        }
        catch (IndexOutOfBoundsException ex){
            System.out.println("Invalid selection.\nTask number does not exist.\nNo task marked as completed.\n");
            throw ex;
        }
        finally{
            if(choice > taskList.size() || choice < 0){
                return;
            }
            taskList.get(choice).setCompleted();
        }
    }

    public void unmarkCompleted(ArrayList<TaskItem> taskList, int choice){

        try{
            taskList.get(choice);
        }
        catch (IndexOutOfBoundsException ex){
            System.out.println("Invalid selection.\n Task number does not exist.\nTask not unmarked as completed.\n");
            throw ex;
        }
        finally{
            if(choice > taskList.size() || choice < 0){
                return;
            }
            taskList.get(choice).unsetCompleted();
        }

    }

    public void saveList(ArrayList<TaskItem> taskList){

        String fileName;

        if(taskList.size() == 0){
            System.out.println("You have nothing in your list to save.\nTry adding something.\n");
            return;
        }

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

                if(taskName.length() == 0){
                    System.out.println("\nInvalid task name detected in file. Stopping file load.\n");
                    return;
                }

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

        }catch (FileNotFoundException e) {
            System.out.println("Could not load file.\nCheck capitalization and make sure you added .txt");
            try {
                throw e;
            } catch (FileNotFoundException fileNotFoundException) {
                return;
            }
        }
    }

}
