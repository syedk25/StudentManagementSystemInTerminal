import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager
{
    private static final ArrayList<Student> students = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Student\n2. View Students\n3. Update Student\n4. Delete Student\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private static void addStudent()
    {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents()
    {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
        } else {
            students.forEach(System.out::println);
        }
    }

    private static void updateStudent()
    {
        System.out.print("Enter ID of student to update: ");
        int id = scanner.nextInt();
        for (Student student : students) {
            if (student.getId() == id) {
                scanner.nextLine(); // Consume newline
                System.out.print("Enter new name: ");
                student.setName(scanner.nextLine());
                System.out.print("Enter new marks: ");
                student.setMarks(scanner.nextDouble());
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void deleteStudent() {
        System.out.print("Enter ID of student to delete: ");
        int id = scanner.nextInt();
        students.removeIf(student -> student.getId() == id);
        System.out.println("Student deleted if ID was found.");
    }
}
