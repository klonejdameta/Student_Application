package project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentMain {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentInfo studentInfo = new StudentInfo();

    public static void main(String[] args) {
        // Create a program that implements a simple mobile phone with the following capabilities.
        // Able to store, modify, remove and query contact names.
        // You will want to create a separate class for Contacts (name and phone number).
        // Create a master class (MobilePhone) that holds the ArrayList of Contacts
        // The MobilePhone class has the functionality listed above.
        // Add a menu of options that are available.
        // Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
        // and search/find contact.
        // When adding or updating be sure to check if the contact already exists (use name)
        // Be sure not to expose the inner workings of the Arraylist to MobilePhone
        // e.g. no ints, no .get(i) etc
        // MobilePhone should do everything with Contact objects only.

        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;

                case 1:
                    studentInfo.printStudents();
                    break;

                case 2:
                    addNewStudent();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    removeStudent();
                    break;

                case 5:
                    queryStudent();
                    break;

                case 6:
                    printActions();
                    break;
            }

        }

    }

    private static void addNewStudent() {
        System.out.println("Enter student id");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();
        System.out.println("Enter student surname: ");
        String surname = scanner.nextLine();
        System.out.println("Enter student age");
        Integer age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter student university");
        String university = scanner.nextLine();
        System.out.println("Is student working?");
        Boolean isWorking = scanner.nextBoolean();
        Student newStudent = Student.createStudent(id, name, surname, age, university, isWorking);
        try {
            FileWriter myRegisteredStudents = new FileWriter("RegisteredStudents.txt", true);
            myRegisteredStudents.write(id + "\t"
                    + name + "\t"
                    + surname + "\t"
                    + age + "\t"
                    + university + "\t"
                    + isWorking +
                    "\n");
            myRegisteredStudents.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (studentInfo.addNewStudent(newStudent)) {
            System.out.println("New student added: id = " + id + ", name = " + name + ", surname = " + surname
                    + ", age = " + age
                    + ", university = " + university
                    + ", isWorking = " + isWorking);
        } else {
            System.out.println("Cannot add, student with id: " + id + " already on file");
        }
    }

    private static void updateStudent() {
        System.out.println("Enter existing student id: ");
        Integer id = scanner.nextInt();
        Student existingStudentRecord = studentInfo.queryStudent(id);
        if (existingStudentRecord == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.println("Enter new id");
        Integer newId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new student name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new student surname: ");
        String newSurname = scanner.nextLine();
        System.out.println("Enter new age");
        Integer newAge = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new university");
        String newUniversity = scanner.nextLine();
        System.out.println("Is student working?");
        Boolean newIsWorking = scanner.nextBoolean();
        Student newStudent = Student.createStudent(newId, newName, newSurname, newAge, newUniversity, newIsWorking);
        try {
            FileWriter myRegisteredStudents = new FileWriter("RegisteredStudents.txt", true);
            myRegisteredStudents.write(newStudent.getId() + "\t"
                    + newStudent.getName() + "\t"
                    + newStudent.getSurname() + "\t"
                    + newStudent.getAge() + "\t"
                    + newStudent.getUniversity() + "\t"
                    + newStudent.getWorking() +
                    "\n");
            myRegisteredStudents.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (studentInfo.updateStudent(existingStudentRecord, newStudent)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record.");
        }
    }

    private static void removeStudent() {
        System.out.println("Enter existing student id: ");
        Integer id = scanner.nextInt();
        Student existingStudentRecord = studentInfo.queryStudent(id);
        if (existingStudentRecord == null) {
            System.out.println("Student not found.");
            return;
        }

        if (studentInfo.removeStudent(existingStudentRecord)) {
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Error deleting student");
        }
    }

    private static void queryStudent() {
        System.out.println("Enter existing student id: ");
        Integer id = scanner.nextInt();
        Student existingStudentRecord = studentInfo.queryStudent(id);
        if (existingStudentRecord == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Id:" + existingStudentRecord.getId() + "Name: " + existingStudentRecord.getName() +
                "surname: " + existingStudentRecord.getSurname() +
                "age: " + existingStudentRecord.getAge() +
                "university: " + existingStudentRecord.getUniversity() +
                "is working: " + existingStudentRecord.getWorking());
    }

    private static void startPhone() {
        System.out.println("Starting app...");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to shutdown\n" +
                "1  - to print students\n" +
                "2  - to add a new student\n" +
                "3  - to update an existing student\n" +
                "4  - to remove an existing student\n" +
                "5  - query if an existing student exists\n" +
                "6  - to print a list of available actions.");
        System.out.println("Choose your action: ");
    }
}

