package Controller;

import java.sql.Array;
import java.util.ArrayList;

import Model.Course;
import Model.Professor;
import Model.Student;
import Model.User;

public class Controller {

    public static void addProfessor(String firstName, String lastName,
                                    String university, String username, String password) {
        new Professor(firstName, lastName, username, password, university);
    }

    public static void addStudent(String firstName, String lastName, String studentId,
                                  String username, String password) {
        new Student(firstName, lastName, username, password, Integer.parseInt(studentId));
    }

    public static boolean checkUsernameForRegister(String username) {
        return User.getUserByUsername(username) == null;
    }

    public static boolean loginErrorHandler(String username, String password) {
        User user = User.getUserByUsername(username);
        if (user != null) {
            if (user.checkPassword(password)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean checkForLogin(String username) {
        return Professor.getUserByUsername(username) == null;
    }

    public static ArrayList<String> getCourseNames(String username) {
        User user = User.getUserByUsername(username);
        ArrayList<String> courseNames = new ArrayList<>();
        for (Course course : user.getCourses()) {
            courseNames.add(course.getName());
        }
        return courseNames;
    }
}
