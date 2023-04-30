package Lab5_Polymorphism.P02Shapes;

public class Main {

    public static void main(String[] args) {

        Shape rectangle = new Rectangle(2.0,3.5);
        Shape circle = new Circle(5.5);

        printShape(rectangle);
        printShape(circle);

    }
    private static void printShape(Shape shape){
        System.out.println(shape.calculateArea());
        System.out.println(shape.calculatePerimeter());
    }
}
