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

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {


    }

    private static void displayBmiInfo(BodyMassIndex bmi) {
        System.out.printf("Body Mass Index is: %.2f. ", bmi.getBmi());
        bmi.bmiCat(bmi.getBmi());
    }


    public static boolean moreInput(){
        System.out.println("Would you like to enter more data? Enter Y or N: ");

        Scanner input = new Scanner(System.in);
        String choice = input.next();

        if(choice.equalsIgnoreCase("Y")){
            return true;
        }
        else if(choice.equalsIgnoreCase("N")){
            return false;
        }
        else{
            System.out.println("Invalid Option");
            return moreInput();
        }
    }

    public static double getUserHeight(){
        Integer number;
        Scanner heightInput = new Scanner(System.in);
        System.out.println("Please enter your height in inches: ");
        number = heightInput.nextInt();

        if(number < 0){

            System.out.println("Invalid height entered.");

            return getUserHeight();
        }

            return number;

    }

    public static double getUserWeight(){
        int number;
        System.out.println("Please enter your weight in inches: ");
        Scanner weightInput = new Scanner(System.in);

        number = weightInput.nextInt();

        if(number < 0){

            System.out.println("Invalid weight entered.");

            return getUserWeight();
        }

        return number;
    }
}
