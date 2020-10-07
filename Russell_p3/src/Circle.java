public class Circle extends Shape2D{

    private final double radius;

    public Circle(double i) {
        this.radius = i;
    }

    public String getName(){
        return "circle";
    }
    
    public double getArea(){
        return 3.1416*Math.pow(this.radius, 2);
    }
}
