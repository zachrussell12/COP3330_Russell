import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp {

    private Scanner userInput = new Scanner(System.in);
    private ContactList list;

    public void appMenu(){
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

        System.out.println("\n1) view the list\n2) add an item\n3) edit an item\n4) remove an item\n5) save the current list\n6) quit to the main menu");
        System.out.print("\n>");
    }

    public void makeList(){list = new ContactList();}

    public void listInteraction(){

        int choice = 0;

        while(choice != 6){
            listMenu();
            try{
                choice = userInput.nextInt();
                userInput.nextLine();
            }
            catch(InputMismatchException er){
                System.out.println("Invalid choice made. Please try again.\n");
            }

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
                saveFile();
            }
            else if(choice == 6){
                break;
            }
        }
    }

    public void viewList(){
        System.out.println(list.view());
    }

    public void addItem(){
        String firstName;
        String lastName;
        String emailAddress;
        String phoneNumber;

        System.out.println("First name: ");
        firstName = userInput.nextLine();

        System.out.println("Last name: ");
        lastName = userInput.nextLine();

        System.out.println("Phone Number XXX-XXX-XXXX: ");
        phoneNumber = userInput.nextLine();

        System.out.println("Email Address (example@host.extension): ");
        emailAddress = userInput.nextLine();

        try{
            ContactItem addItem = new ContactItem(firstName, lastName, phoneNumber, emailAddress);
            list.add(addItem);
        }
        catch(IllegalArgumentException err){}
    }

    public void editItem(){
        String firstName;
        String lastName;
        String phoneNumber;
        String emailAddress;
        int choice;

        if(list.size() == 0){
            System.out.println("Theres no contacts to edit");
            return;
        }

        viewList();
        System.out.println("Which contact would you like to edit?");

        try{
            choice = userInput.nextInt();
            userInput.nextLine();
        }
        catch(InputMismatchException e){
            System.out.println("\nInvalid input. No contact was edited.");
            userInput.nextLine();
            return;
        }

        System.out.println("Enter a new first name for contact " + choice + ": ");
        firstName = userInput.nextLine();

        System.out.println("Enter a new last name for contact " + choice + ": ");
        lastName = userInput.nextLine();

        System.out.println("Enter a new phone number for contact " + choice + ": ");
        phoneNumber = userInput.nextLine();

        System.out.println("Enter a new email address for contact " + choice + ": ");
        emailAddress = userInput.nextLine();

        try{
            ContactItem editItem = new ContactItem(firstName, lastName, phoneNumber, emailAddress);
            list.set(editItem, choice);
        }
        catch(IllegalArgumentException ex){}
        catch(IndexOutOfBoundsException e){
            System.out.println("Contact does not exist.\nNo contact edited.");
        }

    }

    public void removeItem(){

        int choice;

        viewList();
        if(list.size() == 0){
            System.out.println("\nNo items removed.");
            return;
        }
        System.out.println("Which contact would you like to remove?");

        try{
            choice = userInput.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("\nInvalid Input. No task was removed.");
            userInput.nextLine();
            return;
        }

        try{
            list.remove(choice);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Contact does not exist.\nNo contact removed.");
        }
    }

    public void saveFile(){

        String fileName;

        if(list.size() == 0){
            System.out.println("You have no contacts to save.\nTry adding something.\n");
        }

        System.out.println("Enter the filename to save as including the .txt extension: ");
        fileName = userInput.nextLine();

        list.saveFile(fileName);
    }

    public void loadFile(){

        ContactList loadedList = new ContactList();
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
