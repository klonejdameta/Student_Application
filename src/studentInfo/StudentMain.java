package studentInfo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) throws IOException {
        Student student = new Student();
        StudentMenu studentMenu = new StudentMenu();
        Scanner scanner = new Scanner(System.in);
        studentMenu.printMenu();
        boolean quit = false;
        while (!quit) {
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    student.addStudent();
                    studentMenu.printMenu();
                    break;
                case 2:
                    student.editStudent();
                    studentMenu.printMenu();
                    break;
                case 3:
                    student.deleteStudent();
                    studentMenu.printMenu();
                    break;
                case 4:
                    student.printStudent();
                    studentMenu.printMenu();
                    break;
                case 5:
                    studentMenu.printMenu();
                    break;
                case 0:
                    System.exit(0);
                    quit = true;
                    break;
            }
        }

    }
}