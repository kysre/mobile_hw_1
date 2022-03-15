package Model;

import java.util.ArrayList;

public class Student extends User {
    private String studentId;
    private static ArrayList<Student> allStudents = new ArrayList<>();

    public Student(String name, String family, String userName, String password, String studentId) {
        super(name, family, userName, password);
        this.studentId = studentId;
        allStudents.add(this);
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
