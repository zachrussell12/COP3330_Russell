public class Pyramid extends Shape3D {

    private final double sideOne;
    private final double sideTwo;
    private final double sideThree;

    public Pyramid(double i, double j, double k) {
        this.sideOne = i;
        this.sideTwo = j;
        this.sideThree = k;
    }

    public String getName(){
        return "pyramid";
    }

    public double getArea(){
        double area;
        double sideOneHalf = this.sideOne/2;
        double sideTwoHalf = this.sideTwo/2;
        //0.5*Perimeter*Height + Area of Base
        area = (this.sideOne*this.sideTwo) + ((2*(0.5*Math.sqrt(Math.pow(this.sideThree,2)+Math.pow(sideTwoHalf,2))*this.sideOne)) + (2*(0.5*Math.sqrt(Math.pow(this.sideThree,2)+Math.pow(sideOneHalf,2))*this.sideTwo)));
        return area;
    }

    public double getVolume(){

        return ((this.sideOne*this.sideTwo)*this.sideThree)/3;
    }
}
