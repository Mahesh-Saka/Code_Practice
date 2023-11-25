package DesignPattern;


// abstract interface
interface Shape {
    float getArea();
}

// Concreate Prodcut class
class Circle implements Shape {

    public float getArea() {
        return (float) (2 * 3.14 * 50);
    }
}


class Rectangle implements Shape {

    public float getArea() {
        return 10 * 20;
    }
}

// Factory Interface
interface ShapeFactory {
    Shape createShape(String type);
}

// Concrete Factory
class ConcreteShapeFactory implements ShapeFactory {

    public Shape createShape(String type) {
        switch (type.toLowerCase()) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            default:
                throw new IllegalArgumentException("Invalid shape type");
        }
    }
}


// client
public class FactoryPattern {
    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ConcreteShapeFactory();
        Shape mShape = shapeFactory.createShape("Circle");
        System.out.println(mShape.getArea());
    }
}




