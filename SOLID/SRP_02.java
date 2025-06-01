package SOLID;

public class SRP_02 {

    public static class EmployeeData {
        private int employeeID;
        private String designation;
        private double salary;

        public EmployeeData(int employeeID, String designation) {
            this.employeeID = employeeID;
            this.designation = designation;
        }

        public int getEmployeeID() {
            return employeeID;
        }

        public String getDesignation() {
            return designation;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary){
            this.salary = salary;
        }
    }

    public static class SalaryUpdateMitCalculations {
        public void updateSalary(EmployeeData employee, double newSalary) {
            System.out.println("Updating salary for employee ID: " + employee.getEmployeeID() + " to " + newSalary);
            employee.setSalary(newSalary);
        }
    }

    public static class MailAsAService {
        public void sendMailToEmployee(EmployeeData employee, String message) {
            System.out.println("Sending email to employee ID: " + employee.getEmployeeID() + " with message: " + message);
        }
    }

    public static void main(String[] args) {
        EmployeeData employee = new EmployeeData(123, "CEO");

        String designation = employee.getDesignation();
        System.out.println("Employee Designation: " + designation);

        SalaryUpdateMitCalculations salaryService = new SalaryUpdateMitCalculations();
        salaryService.updateSalary(employee, 6000000.00);
        System.out.println("Employee Salary after update: " + employee.getSalary());

        MailAsAService notificationService = new MailAsAService();
        notificationService.sendMailToEmployee(employee, "Welcome aboard!");
    }
}