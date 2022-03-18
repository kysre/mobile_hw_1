package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private static final HashMap<String, User> userHashmap = new HashMap<>();
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private final ArrayList<Course> courses;

    public User(String firstname, String lastname, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.courses = new ArrayList<>();
        userHashmap.put(username, this);
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkPassword(String password) {
        return password.equals(this.password);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public static User getUserByUsername(String username) {
        return userHashmap.get(username);
    }
}
