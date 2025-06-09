package SOLID;

interface Shape {
    int getArea();
}

public class LSP_01 {
    public static class Rectangle implements Shape {
        protected final int width;
        protected final int height;

        public Rectangle(int width, int height) {
            if (width < 0 || height < 0) {
                throw new IllegalArgumentException("Dimensions must be non-negative.");
            }
            this.width = width;
            this.height = height;
        }

        @Override
        public int getArea() {
            return width * height;
        }
    }

    public static class Square implements Shape {
        private final int side;

        public Square(int side) {
            if (side < 0) {
                throw new IllegalArgumentException("Side must be non-negative.");
            }
            this.side = side;
        }

        @Override
        public int getArea() {
            return side * side;
        }
    }

    public static class ImmutableRectangleBase {
        protected final int width;
        protected final int height;

        public ImmutableRectangleBase(int width, int height) {
            this.width = width;
            this.height = height;
        }
        public int getArea() { return width * height; }
        public int getWidth() { return width; }
        public int getHeight() { return height; }
    }

    public static class ImmutableSquareDerived extends ImmutableRectangleBase {
        public ImmutableSquareDerived(int side) {
            super(side, side);
        }
    }


    public static void printArea(Shape shape) {
        System.out.println("Area: " + shape.getArea());
    }

    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5, 10);
        System.out.println("Rectangle (5x10) Area: " + rectangle.getArea());
        printArea(rectangle);

        Shape square = new Square(5);
        System.out.println("Square (side 5) Area: " + square.getArea());
        printArea(square);

        // Test with the alternative derived immutable square
        ImmutableRectangleBase rectBase = new ImmutableRectangleBase(5,10);
        System.out.println("ImmutableRectangleBase (5x10) Area: " + rectBase.getArea());

        ImmutableRectangleBase squareBase = new ImmutableSquareDerived(7);
        System.out.println("ImmutableSquareDerived (side 7) Area: " + squareBase.getArea());
        System.out.println("Width of squareBase: " + squareBase.getWidth());   // Output: 7
        System.out.println("Height of squareBase: " + squareBase.getHeight()); // Output: 7
    }
}