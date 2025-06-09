package SOLID;

public class LSP_02 {

    public static class Bird {
        public void eat() {
            System.out.println("The bird is eating...");
        }
    }

    public interface FlyingBird {
        void fly();
    }

    public static class Sparrow extends Bird implements FlyingBird {
        @Override
        public void fly() {
            System.out.println("The sparrow is flying...");
        }
    }

    public static class Penguin extends Bird {
        public void swim() {
            System.out.println("The penguin is swimming...");
        }
    }

    public static void makeBirdFly(FlyingBird bird) {
        bird.fly();
    }

    public static void feedBird(Bird bird) {
        bird.eat();
    }

    public static void main(String[] args) {
        Sparrow sparrow = new Sparrow();
        Penguin penguin = new Penguin();

        System.out.println("Feeding sparrow:");
        feedBird(sparrow);
        System.out.println("Making sparrow fly:");
        makeBirdFly(sparrow);

        System.out.println("\nFeeding penguin:");
        feedBird(penguin);

        System.out.println("Penguin specific action:");
        penguin.swim();
    }
}