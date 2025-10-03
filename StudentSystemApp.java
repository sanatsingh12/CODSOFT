import java.util.*;
import java.io.*;

class Student implements Serializable {
    private String name;
    private int roll;
    private String grade;

    Student(String name, int roll, String grade) {
        this.name = name;
        this.roll = roll;
        this.grade = grade;
    }

    public int getRoll() {
        return roll;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String toString() {
        return "Roll No: " + roll + ", Name: " + name + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private List<Student> students;
    private final String filename = "students.dat";

    StudentManagementSystem() {
        students = loadData();
    }

    public void addStudent(Student s) {
        students.add(s);
        saveData();
        System.out.println("Student added successfully!");
    }

    public void removeStudent(int roll) {
        boolean removed = students.removeIf(s -> s.getRoll() == roll);
        if (removed) {
            saveData();
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public void searchStudent(int roll) {
        for (Student s : students) {
            if (s.getRoll() == roll) {
                System.out.println("Student found: " + s);
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    private void saveData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving data!");
        }
    }

    private List<Student> loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Student>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}

public class StudentSystemApp {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();
                    if (name.isEmpty() || grade.isEmpty()) {
                        System.out.println("Fields cannot be empty!");
                    } else {
                        sms.addStudent(new Student(name, roll, grade));
                    }
                    break;
                case 2:
                    System.out.print("Enter Roll Number to remove: ");
                    int r = sc.nextInt();
                    sms.removeStudent(r);
                    break;
                case 3:
                    System.out.print("Enter Roll Number to search: ");
                    int s = sc.nextInt();
                    sms.searchStudent(s);
                    break;
                case 4:
                    sms.displayAll();
                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
