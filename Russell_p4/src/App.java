import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.lang.System.exit;

public class App {
    public static void main (String[] args) throws FileNotFoundException{

        Scanner userInput = new Scanner(System.in);
        String menuChoice = "";


        while(!menuChoice.contains("3")){

            System.out.println("Main Menu");
            System.out.println("---------");

            System.out.println("\n1) create a new list\n2) load an existing list\n3) quit\n");
            System.out.print(">");

            menuChoice = userInput.next();

            if(menuChoice.contains("1")){
                System.out.println("new task list has been created");
                TaskList list = new TaskList();
                list.menu();
            }
            else if(menuChoice.contains("2")){
                System.out.println("Enter the file name to load (including the .txt extension): ");
                Scanner userInputFile = new Scanner(System.in);
                String fileName = userInputFile.nextLine();
                TaskList loadedList = new TaskList();
                File listFile = new File(fileName);
                loadedList.loadList(listFile);
            }
            else if(menuChoice.contains("3")){
                break;
            }
            else{
                System.out.println("Invalid choice made. Please try again\n");
            }


        }
    }
}
