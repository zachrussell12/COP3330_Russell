public class Cube extends Shape3D {

    private final double side;

    public Cube(double i) {
        this.side = i;
    }

    public String getName(){
        return "cube";
    }

    public double getArea(){
        return 6*(this.side*this.side);
    }

    public double getVolume(){
        return this.side*this.side*this.side;
    }


}
