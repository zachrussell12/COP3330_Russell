import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class MainApplication {
    public static void main(String[] args){
        while(true) {
            System.out.println("Select Your Application");
            System.out.println("-----------------------");
            System.out.println("\n1) task list\n2) contact list\n3) quit");
            System.out.println();
            Scanner input = new Scanner(System.in);
            System.out.print("> ");
            int value = 0;
            try {
                value = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice selected. Try again.");
                input.nextLine();
            }

            if(value == 1){
                TaskApp run = new TaskApp();
                run.appMenu();
            }
            else if(value == 2){
                ContactApp run = new ContactApp();
                //run.appMenu();
            }
            else if(value == 3){
                exit(0);
            }
        }
    }
}
