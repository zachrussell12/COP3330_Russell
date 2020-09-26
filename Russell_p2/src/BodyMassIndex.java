import static java.lang.Math.pow;

public class BodyMassIndex {

    private double bmi;

    public BodyMassIndex(double height, double weight) { getbmi(height,weight); }

    public double getbmi(double height, double weight) {

        bmi = (703*weight)/pow(height, 2);
         return getBmi();

    }

    public String bmiCat(double bmi){
        if(bmi <= 18.5){
            return "You are underweight.";
        }
        else if(bmi >= 18.5 && bmi <= 24.9){
            return "You are of normal weight.";
        }
        else if(bmi >= 25 && bmi <= 29.9){
            return "You are overweight.";
        }
        else{
            return "You are obese.";
        }
    }

    public double getBmi() {
        return bmi;
    }

}
