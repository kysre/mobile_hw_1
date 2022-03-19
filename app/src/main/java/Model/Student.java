package Model;

import androidx.annotation.NonNull;

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


    @Override
    public void setUsername(String username) {
        super.setUsername(username);
    }

    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean checkPassword(String password) {
        return super.checkPassword(password);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                '}';
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }


    @Override
    public void setLastname(String lastname) {
        super.setLastname(lastname);
    }

    @Override
    public void setFirstname(String firstname) {
        super.setFirstname(firstname);
    }


    @Override
    public void addCourse(Course course) {
        super.addCourse(course);
    }

    @Override
    public ArrayList<Course> getCourses() {
        return super.getCourses();
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static void setStudents(ArrayList<Student> students) {
        Student.students = students;
    }
}
