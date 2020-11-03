import java.util.Scanner;
import static java.lang.System.exit;

public class App {
    public static void main (String[] args){

        Scanner userInput = new Scanner(System.in);
        int menuChoice = 0;


        while(menuChoice != 3){

            System.out.println("Main Menu");
            System.out.println("---------");

            System.out.println("\n1) create a new list\n2) load an existing list\n3) quit\n");
            System.out.print(">");

            menuChoice = userInput.nextInt();

            if(menuChoice == 1){
                System.out.println("new task list has been created");
                TaskList list = new TaskList();
                list.menu();
            }
            else if(menuChoice == 2){
                System.out.println("Enter the file name to load (including the .txt extension): ");
                Scanner userInputFile = new Scanner(System.in);
                String fileName = userInputFile.nextLine();
                TaskList loadedList = new TaskList();
            }
            else if(menuChoice == 3){
                break;
            }
            else{
                exit(0);
            }


        }
    }
}
