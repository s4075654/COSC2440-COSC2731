
import api.StudentAPI;
import controller.StudentController;

import java.util.Scanner;

public class StudentManagementApp {
    public static void main(String[] args) {
        StudentAPI controller = new StudentController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Get Student Details");
            System.out.println("3. Update Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Get All Students");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            scanner.nextLine(); 
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    controller.addStudent(id, name, age);
                }
                case 2 -> {
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    controller.getStudentDetails(id);
                }
                case 3 -> {
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    controller.updateStudent(id, name, age);
                }
                case 4 -> {
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    controller.removeStudent(id);
                }
                case 5 -> controller.getAllStudents();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
