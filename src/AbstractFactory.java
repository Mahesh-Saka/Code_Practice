

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
// Abstract factory
interface ShapeMaker {
    Shape getRect();
}


// Concreate Factory
class CircleFactory implements ShapeMaker {

    public Shape getRect() {
        return new Circle();
    }

}

class RectangleFactory implements ShapeMaker {
    public Shape getRect() {
        return new Rectangle();
    }
}
// client
public class AbstractFactory {
    public static void main(String[] args) {
        ShapeMaker mShapeMaker;

        String shape = "circle";
        if(shape.equalsIgnoreCase("Cicle")){
            mShapeMaker = new CircleFactory();
        }else {
            mShapeMaker = new RectangleFactory();
        }

        System.out.println(mShapeMaker.getRect().getArea());
    }
}


