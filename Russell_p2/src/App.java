import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    public static boolean moreInput(){
        System.out.println("Would you like to enter more data? Enter Y or N: ");

        Scanner input = new Scanner(System.in);
        String choice = input.next();

        if(choice == "Y"){
            return true;
        }
        else if(choice == "N"){
            return false;
        }
        else{
            System.out.println("Invalid Option...Exiting");
            return false;
        }
    }

    public static double getUserHeight(){
        System.out.println("Please enter your height in inches: ");
        Scanner heightInput = new Scanner(System.in);
        double height = Integer.parseInt(heightInput.next());

        return height;
    }

    public static double getUserWeight(){
        System.out.println("Please enter your weight in inches: ");
        Scanner weightInput = new Scanner(System.in);
        double height = Integer.parseInt(weightInput.next());

        return height;
    }
}
