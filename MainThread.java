import java.util.Scanner;

public class MainThread {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentController studentController = new StudentController();
        while(true){
            System.out.println("==================================================\r\n" +
                                "        HỆ THỐNG QUẢN LÝ SINH VIÊN\r\n" +
                                "==================================================");
            System.out.println("1. Thêm mới sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo tên");
            System.out.println("4. Cập nhật điểm GPA theo mã sinh viên");
            System.out.println("5. Xoá sinh viên theo mã sinh viên");
            System.out.println("6. Sắp xếp danh sách sinh viên theo GPA giảm dần");
            System.out.println("7. Thoát chương trình");
            System.out.println("==================================================");
            System.out.println("Vui lòng chọn chức năng (1-7):");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    studentController.addStudent();
                    break;
                case 2:
                    studentController.printStudentList();               
                    break;
                case 3:
                    studentController.searchStudentByName();
                    break;
                case 4:
                    studentController.updateStudentGpa();
                    break;
                case 5:
                    studentController.deleteStudent();
                    break;
                case 6:
                    studentController.sortStudentsByGpaDescending();
                case 7:
                    System.out.println("See you later!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon chon lai (1-7)");
                    break;
            }
            if(choice == 0){
                break;
            }
            System.out.println("Nhan Enter de tiep tuc!");
            scanner.nextLine();
        }
        scanner.close();
    }
}