package studentInfo;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface StudentMethods {

    void addStudent();
    void editStudent() throws IOException;
    void deleteStudent();
    void printStudent() throws IOException;
}
