package SOLID;

public class LSP_01 {

    // Common interface for shapes
    public interface Shape {
        int getArea();
    }

    // Immutable Rectangle
    public static class Rectangle implements Shape {
        protected final int width; // Made final
        protected final int height; // Made final

        public Rectangle(int width, int height) {
            if (width < 0 || height < 0) {
                throw new IllegalArgumentException("Dimensions must be non-negative.");
            }
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public int getArea() {
            return width * height;
        }
    }

    // Immutable Square, can still "be a" Shape, but not necessarily a mutable Rectangle.
    // For this solution, Square also implements Shape directly.
    // If inheritance from Rectangle is strictly desired for immutable shapes,
    // Rectangle's constructor would be used by Square.
    public static class Square implements Shape {
        private final int side; // Made final

        public Square(int side) {
            if (side < 0) {
                throw new IllegalArgumentException("Side must be non-negative.");
            }
            this.side = side;
        }

        public int getSide() {
            return side;
        }

        @Override
        public int getArea() {
            return side * side;
        }
    }

    // If Square MUST inherit from Rectangle and both are immutable:
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
        // No need to override setters as there are none.
        // getWidth and getHeight are inherited and work correctly for a square.
    }


    public static void printArea(Shape shape) { // Now takes the interface
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
        // We can use squareBase where ImmutableRectangleBase is expected.
        // For example:
        // someFunctionThatExpectsImmutableRectangleBase(squareBase);
        // Since there are no setters to violate expectations, LSP holds.
        System.out.println("Width of squareBase: " + squareBase.getWidth());   // Output: 7
        System.out.println("Height of squareBase: " + squareBase.getHeight()); // Output: 7
    }
}