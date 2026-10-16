
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class StudentController {
    private ArrayList<Student> studentList;
    private Scanner scanner;
    public StudentController() {
        studentList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    public void addStudent() {
        System.out.print("Nhap ma sinh vien: ");
        String id = scanner.nextLine();
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                System.out.println("Ma sinh vien da ton tai!");
                return;
            }
        }

        System.out.print("Nhap ho ten: ");
        String fullName = scanner.nextLine();

        System.out.print("Nhap email: ");
        String email = scanner.nextLine();

        System.out.print("Nhap so dien thoai: ");
        String phone = scanner.nextLine();

        System.out.print("Nhap GPA (0.0 - 4.0): ");
        double gpa = scanner.nextDouble();

        if (gpa < 0 || gpa > 4.0) {
            System.out.println("GPA khong hop le!");
            return;
        }

        Student student = new Student(
            id, fullName, email, phone, gpa
        );

        studentList.add(student);
        System.out.println("Them sinh vien thanh cong!");
    }
    public void printStudentList() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sach sinh vien rong!");
            return;
        }

        System.out.printf(
            "%-12s %-25s %-30s %-15s %s%n",
            "ID", "Full Name", "Email", "Phone", "GPA"
        );

        System.out.println(
            "--------------------------------------------------------------------------------------"
        );

        for (Student s : studentList) {
            s.displayData();
        }
    }
    public void searchStudentByName() {
        System.out.print("Nhap ten sinh vien can tim: ");
        String keyword = scanner.nextLine();

        boolean found = false;

        for (Student s : studentList) {
            if (s.getFullName()
                 .toLowerCase()
                 .contains(keyword.toLowerCase())) {

                s.displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay sinh vien!");
        }
    }
    public void updateStudentGpa() {
        System.out.print("Nhap ID sinh vien can cap nhat GPA: ");
        String id = scanner.nextLine();

        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                System.out.print("Nhap GPA moi (0.0 - 4.0): ");
                double newGpa = scanner.nextDouble();

                if (newGpa < 0 || newGpa > 4.0) {
                    System.out.println("GPA khong hop le!");
                    return;
                }

                s.setGpa(newGpa);
                System.out.println("Cap nhat GPA thanh cong!");
                return;
            }
        }

        System.out.println("Khong tim thay sinh vien!");
    }
    public void deleteStudent() {
        System.out.print("Nhap ID sinh vien can xoa: ");
        String id = scanner.nextLine();

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId()
                    .equalsIgnoreCase(id)) {

                studentList.remove(i);
                System.out.println("Xoa sinh vien thanh cong!");
                return;
            }
        }

        System.out.println("Khong tim thay sinh vien!");
    }
    public void sortStudentsByGpaDescending() {
        Collections.sort(
            studentList,
            Comparator.comparingDouble(Student::getGpa).reversed()
        );

        System.out.println("Da sap xep GPA giam dan!");
        printStudentList();
    }
}