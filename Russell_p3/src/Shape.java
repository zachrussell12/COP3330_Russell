public abstract class Shape {

    public abstract String getName();
}

class Square extends Shape {
    public Square(int i) {
        super();
    }

    @Override
    public String getName() {
        return "square";
    }
}

class Triangle extends Shape {
    public Triangle(int i, int j) {
        super();
    }

    @Override
    public String getName() {
        return "triangle";
    }
}

class Circle extends Shape {
    public Circle(int i) {
        super();
    }

    @Override
    public String getName() {
        return "circle";
    }
}

class Cube extends Shape {
    public Cube(int i) {
        super();
    }

    @Override
    public String getName() {
        return "cube";
    }
}

class Pyramid extends Shape {
    public Pyramid(int i, int j, int k) {
        super();
    }

    @Override
    public String getName() {
        return "pyramid";
    }
}

class Sphere extends Shape {
    public Sphere(int i) {
        super();
    }

    @Override
    public String getName() {
        return "sphere";
    }
}