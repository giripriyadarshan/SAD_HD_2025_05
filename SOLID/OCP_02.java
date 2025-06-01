package SOLID;



public class OCP_02 {

    public abstract static class Shape {
        public abstract double calculateArea();
    }

    public static class Square extends Shape {
        private double side;

        public Square(double side) {
            this.side = side;
        }

        @Override
        public double calculateArea() {
            System.out.println("Calculating area of a square.");
            return side * side;
        }
    }

    public static class Circle extends Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            System.out.println("Calculating area of a circle.");
            return Math.PI * radius * radius;
        }
    }
    public static class AreaCalculator {
        public double getArea(Shape shape) {
            return shape.calculateArea();
        }
    }

    public static void main(String[] args) {
        AreaCalculator calculator = new AreaCalculator();

        Shape square = new Square(5.0);
        System.out.println("Area of square: " + calculator.getArea(square));

        Shape circle = new Circle(3.0);
        System.out.println("Area of circle: " + calculator.getArea(circle));

    }
}