package SOLID;

public class ISP_01 {

    public interface Printable {
        void printDocument();
    }

    public interface Scannable {
        void scanDocument();
    }

    public interface Faxable {
        void faxDocument();
    }

    public interface MultiFunctionPrinter extends Printable, Scannable, Faxable {}

    public static class SimplePrinter implements Printable {
        @Override
        public void printDocument() {
            System.out.println("Sending document to the printer ...");
        }
    }

    public static class AdvancedPrinter implements MultiFunctionPrinter {
        @Override
        public void printDocument() {
            System.out.println("AdvancedPrinter: Sending document to the printer ...");
        }

        @Override
        public void scanDocument() {
            System.out.println("AdvancedPrinter: Scanning document ...");
        }

        @Override
        public void faxDocument() {
            System.out.println("AdvancedPrinter: Faxing document ...");
        }
    }


    public static void main(String[] args) {
        Printable simplePrinter = new SimplePrinter();
        simplePrinter.printDocument();

        MultiFunctionPrinter advancedPrinter = new AdvancedPrinter();
        advancedPrinter.printDocument();
        advancedPrinter.scanDocument();
        advancedPrinter.faxDocument();

        Scannable scanner = new AdvancedPrinter();
        scanner.scanDocument();
    }
}