import static java.lang.Math.pow;

public class BodyMassIndex {
    public BodyMassIndex(double height, double weight) {
        double bmi = (703*weight)/pow(height, 2);
    }

}
