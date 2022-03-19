package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Student extends User {
    private static ArrayList<Student> students = new ArrayList<>();
    private String studentId;


    public Student(String name, String family, String userName, String password, String studentId) {
        super(name, family, userName, password);
        this.studentId = studentId;
        students.add(this);
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getLastname() {
        return super.getLastname();
    }

    @Override
    public String getFirstname() {
        return super.getFirstname();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
