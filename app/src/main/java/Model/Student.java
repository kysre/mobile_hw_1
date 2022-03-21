package Model;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import com.gilecode.yagson.YaGson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Student extends User{
    private static ArrayList<Student> students = new ArrayList<>();
    private String studentId;


    public Student(String name, String family, String userName, String password, String studentId) {
        super(name, family, userName, password);
        this.studentId = studentId;
        students.add(this);

//        String filePath = "";
//        filePath += userName;
//        filePath += ".json";
//
//        YaGson yaGson = new YaGson();
//        String data = yaGson.toJson(this);
//
//
//        Context context = null;
//        try {
//            FileOutputStream F = context.openFileOutput(userName,0);
//            F.write(data.getBytes());
//            F.close();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("bayad save shode bashe");


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

    public boolean joinCourse(int courseId) {
        Course courseToJoin = Course.getCourseById(courseId);
        if (courseToJoin == null) {
            return false;
        }
        for (Course course : getCourses()) {
            if (course.getId() == courseId) {
                return false;
            }
        }
        this.addCourse(courseToJoin);
        return true;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                '}';
    }


    @Override
    public void addCourse(Course course) {
        super.addCourse(course);
        course.addStudent(this);
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



    @Override
    public void setFirstname(String firstname) {
        super.setFirstname(firstname);
    }


    @Override
    public void setLastname(String lastname) {
        super.setLastname(lastname);
    }


    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }


    @Override
    public boolean checkPassword(String password) {
        return super.checkPassword(password);
    }


    @Override
    public void setUsername(String username) {
        super.setUsername(username);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getUsername().equals(student.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

}
