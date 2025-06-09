package SOLID;

public class DIP_02 {
    public interface Notification {
        void doNotify();
    }

    public static class EmailNotification implements Notification {
        @Override
        public void doNotify() {
            System.out.println("Sending notification via email!");
        }
    }

    public static class Employee {
        private final Notification notificationService;

        public Employee(Notification notificationService) {
            this.notificationService = notificationService;
        }

        public void notifyEmployee() {
            notificationService.doNotify();
        }
    }

    public static void main(String[] args) {
        Notification emailNotification = new EmailNotification();
        Employee employee1 = new Employee(emailNotification);
        employee1.notifyEmployee();
    }
}