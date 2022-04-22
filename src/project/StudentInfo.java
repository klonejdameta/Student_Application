package project;

import java.util.ArrayList;

public class StudentInfo {
    private ArrayList<Student> myStudents;

    public StudentInfo() {
        this.myStudents = new ArrayList<Student>();
    }

    public boolean addNewStudent(Student student) {
        if (findStudent(student.getId()) >= 0) {
            System.out.println("Student is already on file");
            return false;
        }

        myStudents.add(student);
        return true;

    }

    public boolean updateStudent(Student oldStudent, Student newStudent) {
        Integer foundPosition = findStudent(oldStudent);
        if (foundPosition < 0) {
            System.out.println(oldStudent.getId() + ", was not found.");
            return false;
        } else if (findStudent(newStudent.getId()) != -1) {
            System.out.println("Student with name " + newStudent.getId() +
                    " already exists.  Update was not successful.");
            return false;
        }

        this.myStudents.set(foundPosition, newStudent);
        System.out.println(oldStudent.getName() + ", was replaced with " + newStudent.getName());
        return true;
    }

    public boolean removeStudent(Student student) {
        int foundPosition = findStudent(student);
        if (foundPosition < 0) {
            System.out.println(student.getName() + ", was not found.");
            return false;
        }
        this.myStudents.remove(foundPosition);
        System.out.println(student.getName() + ", was deleted.");
        return true;
    }

    private int findStudent(Student student) {
        return this.myStudents.indexOf(student);
    }

    private int findStudent(Integer studentId) {
        for (int i = 0; i < this.myStudents.size(); i++) {
            Student student = this.myStudents.get(i);
            if (student.getId().equals(studentId)) {
                return i;
            }
        }
        return -1;
    }

    public String queryStudent(Student student) {
        if (findStudent(student) >= 0) {
            return student.getName();
        }
        return null;
    }

    public Student queryStudent(Integer id) {
        int position = findStudent(id);
        if (position >= 0) {
            return this.myStudents.get(position);
        }

        return null;
    }

    public void printStudents() {
        System.out.println("Student List");
        for (int i = 0; i < this.myStudents.size(); i++) {
            System.out.println(myStudents.get(i).getId() + " " +
                    this.myStudents.get(i).getName() + " " +
                    this.myStudents.get(i).getSurname() + " " +
                    this.myStudents.get(i).getAge() + " " +
                    this.myStudents.get(i).getUniversity() + " " +
                    this.myStudents.get(i).getWorking()
            );
        }

    }
}