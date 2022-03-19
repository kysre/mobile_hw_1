package Model;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Professor extends User {
    private static ArrayList<Professor> allProfessor = new ArrayList<>();
    private String universityName;



    public Professor(String name, String family, String userName, String password
            , String universityName) {
        super(name, family, userName, password);
        this.universityName = universityName;
        allProfessor.add(this);
    }

    @Override
    public String getFirstname() {
        return super.getFirstname();
    }

    @Override
    public String getLastname() {
        return super.getLastname();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }


    @Override
    public String toString() {
        return "Professor{" +
                "universityName='" + universityName + '\'' +
                '}';
    }

    @Override
    public ArrayList<Course> getCourses() {
        return super.getCourses();
    }

    @Override
    public boolean checkPassword(String password) {
        return super.checkPassword(password);
    }


    public static ArrayList<Professor> getAllProfessor() {
        return allProfessor;
    }


    public static void setAllProfessor(ArrayList<Professor> allProfessor) {
        Professor.allProfessor = allProfessor;
    }


    @Override
    public void addCourse(Course course) {
        super.addCourse(course);
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
    public void setUsername(String username) {
        super.setUsername(username);
    }


    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}
