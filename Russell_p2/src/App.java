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
        double sum = 0;
        int counter = 0;
        double avg;
        for(BodyMassIndex bmi : bmiData){
            sum += bmi.getBmi();
            counter++;
        }

        avg = sum / counter;

        System.out.printf("Here is the sum of all the BMI's entered: %.2f", avg);

    }

    private static void displayBmiInfo(BodyMassIndex bmi) {
        System.out.printf("Body Mass Index is: %.2f. ", bmi.getBmi());
        String cat = bmi.bmiCat(bmi.getBmi());
        System.out.println(cat);
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
        double number;
        Scanner heightInput = new Scanner(System.in);
        System.out.println("Please enter your height in inches: ");
        number = heightInput.nextDouble();

        if(number < 0){

            System.out.println("Invalid height entered.");

            return getUserHeight();
        }

            return number;

    }

    public static double getUserWeight(){
        double number;
        System.out.println("Please enter your weight in pounds: ");
        Scanner weightInput = new Scanner(System.in);

        number = weightInput.nextDouble();

        if(number < 0){

            System.out.println("Invalid weight entered.");

            return getUserWeight();
        }

        return number;
    }
}
