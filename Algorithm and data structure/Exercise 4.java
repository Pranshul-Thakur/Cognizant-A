import java.util.Scanner;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int id, String name, String position, double salary) {
        this.employeeId = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return employeeId + " | " + name + " | " + position + " | $" + salary;
    }
}

public class EmployeeManagementSystem {

    static final int MAX = 100;
    static Employee[] employees = new Employee[MAX];
    static int count = 0;

    public static void addEmployee(Employee emp) {
        if (count < MAX) {
            employees[count++] = emp;
        } else {
            System.out.println("Employee list is full.");
        }
    }

    public static Employee searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }

    public static void displayEmployees() {
        if (count == 0) {
            System.out.println("No employees found.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void deleteEmployee(int id) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < count - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[--count] = null;
            System.out.println("Employee deleted.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public static void main(String[] args) {
        addEmployee(new Employee(101, "Alice", "Manager", 70000));
        addEmployee(new Employee(102, "Bob", "Engineer", 50000));
        addEmployee(new Employee(103, "Charlie", "HR", 40000));

        System.out.println("All Employees:");
        displayEmployees();

        System.out.println("\nSearching for employee with ID 102:");
        Employee found = searchEmployee(102);
        System.out.println(found != null ? found : "Not found");

        System.out.println("\nDeleting employee with ID 102:");
        deleteEmployee(102);
        displayEmployees();
    }
}

/*
Step 1: Array Representation in Memory
- Arrays are stored in contiguous memory.
- Index-based access is O(1), which makes retrieval fast.

Step 4: Time Complexity Analysis
Add:      O(1)
Search:   O(n)
Traverse: O(n)
Delete:   O(n)

Limitations of Arrays:
- Fixed size
- Costly insert/delete due to shifting
- Better to use ArrayList or LinkedList for flexible size
*/
