package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Student extends User {
    private static ArrayList<Student> students = new ArrayList<>();
    private int studentId;


    public Student(String name, String family, String userName, String password, int studentId) {
        super(name, family, userName, password);
        this.studentId = studentId;
        students.add(this);
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
