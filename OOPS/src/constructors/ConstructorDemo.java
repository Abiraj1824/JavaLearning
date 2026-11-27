
package constructors;

class Employee {

    String name;
    int age;
    double salary;

    // Default constructor
    Employee() {
        name = "Unknown";
        age = 0;
        salary = 0.0;
    }

    // Parameterized constructor
    Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Constructor overloading
    Employee(String name, int age) {
        this.name = name;
        this.age = age;
        this.salary = 25000;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println();
    }
}

public class ConstructorDemo {

    public static void main(String[] args) {

        Employee employee1 = new Employee();

        Employee employee2 =
                new Employee("Abiraj", 23, 35000);

        Employee employee3 =
                new Employee("Rahul", 24);

        employee1.displayDetails();
        employee2.displayDetails();
        employee3.displayDetails();
    }
}
