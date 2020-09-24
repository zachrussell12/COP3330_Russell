import static java.lang.Math.pow;

public class BodyMassIndex {

    private double bmi;

    public BodyMassIndex(double height, double weight) {

        getbmi(height,weight);

    }


    public void getbmi(double height, double weight) {

        bmi = (703*weight)/pow(height, 2);
        getBmi();

    }

    public void bmiCat(double bmi){
        if(bmi <= 18.5){
            System.out.println("You are underweight.");
        }
        else if(bmi >= 18.5 && bmi <= 24.9){
            System.out.println("You are of normal weight.");
        }
        else if(bmi >= 25 && bmi <= 29.9){
            System.out.println("You are overweight.");
        }
        else{
            System.out.println("You are obese.");
        }
    }


    public double getBmi() {
        return bmi;
    }

}
