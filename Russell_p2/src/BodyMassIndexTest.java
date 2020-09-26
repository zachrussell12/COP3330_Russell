import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {

    private final double height = 0;
    private final double weight = 0;

    @Test
    void testBMICategory1() {
        BodyMassIndex bmi = new BodyMassIndex(height, weight);
        assertEquals("You are underweight.", bmi.bmiCat(17.5));
    }

    @Test
    void testBMICategory2() {
        BodyMassIndex bmi = new BodyMassIndex(height, weight);
        assertEquals("You are of normal weight.", bmi.bmiCat(20));
    }

    @Test
    void testBMICategory3() {
        BodyMassIndex bmi = new BodyMassIndex(height, weight);
        assertEquals("You are overweight.", bmi.bmiCat(26));
    }

    @Test
    void testBMICategory4() {
        BodyMassIndex bmi = new BodyMassIndex(height, weight);
        assertEquals("You are obese.", bmi.bmiCat(35));
    }

    @Test
    void testgetBmi() {
        BodyMassIndex bmi = new BodyMassIndex(height, weight);
        assertEquals(19.663387345679013, bmi.getbmi(72,145));
        //^^Should return whole value for accuracy, then only print to 2 decimal places in the App class
    }



}