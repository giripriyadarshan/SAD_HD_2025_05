package SOLID;

public class OCP_01 {
    interface DiscountType {
        double applyDiscount(double amount);
    }

    public static class RegularCustomerDiscount implements DiscountType {
        @Override
        public double applyDiscount(double amount) {
            return amount * 0.1;
        }
    }

    public static class PremiumCustomerDiscount implements DiscountType {
        @Override
        public double applyDiscount(double amount) {
            return amount * 0.2;
        }
    }

    public static class DiscountCalculator {
        public double calculateDiscount(DiscountType customerType, double amount) {
            if (customerType == null) {
                throw new IllegalArgumentException("Discount CustomerType cannot be null");
            }
            return customerType.applyDiscount(amount);
        }
    }

    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();

        DiscountType regularCustomerType = new RegularCustomerDiscount();
        double regularDiscount = calculator.calculateDiscount(regularCustomerType, 100.0);
        System.out.println("Regular Customer Discount: " + regularDiscount);

        DiscountType premiumCustomerType = new PremiumCustomerDiscount();
        double premiumDiscount = calculator.calculateDiscount(premiumCustomerType, 100.0);
        System.out.println("Premium Customer Discount: " + premiumDiscount);
    }
}