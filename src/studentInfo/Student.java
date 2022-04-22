package studentInfo;

import java.io.*;
import java.util.*;

public class Student implements StudentMethods {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String university;
    private boolean isWorking;

    public Student() {

    }

    public Student(Integer id, String name, String surname, Integer age, String university, boolean isWorking) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.university = university;
        this.isWorking = isWorking;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    @Override
    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a new id");
        id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter student name ");
        name = scanner.nextLine();
        System.out.println("Enter student surname ");
        surname = scanner.nextLine();
        System.out.println("Enter student age");
        age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter student university");
        university = scanner.nextLine();
        System.out.println("Enter if student is working or not");
        isWorking = scanner.nextBoolean();
        Student student = new Student(id, name, surname, age, university, isWorking);
        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(student);
        try {
            FileWriter myRegisteredStudents = new FileWriter("RegisteredStudents.txt", true);
            myRegisteredStudents.write(student.getId() + "\t"
                    + student.getName() + "\t"
                    + student.getSurname() + "\t"
                    + student.getAge() + "\t"
                    + student.getUniversity() + "\t"
                    + student.isWorking() +
                    "\n");
            myRegisteredStudents.close();
            System.out.println("Student is successfully added\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void editStudent() throws IOException {
        System.out.println("Enter student ID to edit from 1 to 10");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        File file = new File("RegisteredStudents.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String read;
        while ((read = bufferedReader.readLine()) != null) {
            System.out.println(read);
        }

    }

    @Override
    public void deleteStudent() {

    }

    @Override
    public void printStudent() throws IOException {
        File file = new File("RegisteredStudents.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String read;
        while ((read = bufferedReader.readLine()) != null) {
            System.out.println(read);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", university='" + university + '\'' +
                ", isWorking=" + isWorking +
                '}';
    }
}