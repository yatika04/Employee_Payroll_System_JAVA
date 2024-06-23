import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem {
    private List<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        PayrollSystem payrollSystem = new PayrollSystem();

        FullTimeEmployee emp1 = new FullTimeEmployee("Riya Sharma ", 101, 10000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee("Geeta Jodar", 102, 30, 200.0);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        
        System.out.println("Enter You Choice:");
        System.out.println("\n 1 for Initial Employee Details"); 
        System.out.println("\n 2 for Removing Employee");
        System.out.println("\n 3 for Remaining Employee Details");
        int ch = obj.nextInt();
        
        switch(ch){
        case 1:
            System.out.println("\n Initial Employee Details:");
            payrollSystem.displayEmployees();
            break;

        case 2:
            System.out.println("\nRemoving Employee...");
            payrollSystem.removeEmployee(101);
            break;

        case 3:
            System.out.println("\nRemaining Employee Details:");
            payrollSystem.displayEmployees();
            break;
            
        default:
        System.out.println("Enter Valid Input");
        }
    }
}