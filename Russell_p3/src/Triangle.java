public class Triangle extends Shape2D {

    private final double sideOne;
    private final double sideTwo;

    public Triangle(double i, double j) {
        this.sideOne = i;
        this.sideTwo = j;
    }

    public String getName(){
        return "triangle";
    }

    public double getArea(){
        return 0.5*(this.sideOne*this.sideTwo);
    }
}
