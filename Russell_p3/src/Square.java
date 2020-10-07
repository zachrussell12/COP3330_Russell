public class Square extends Shape2D {

    private final double side;

    public Square(double i) {
        this.side = i;
    }

    public String getName(){
        return "square";
    }

    public double getArea(){
        return this.side*this.side;
    }
}


