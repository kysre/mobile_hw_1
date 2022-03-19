package Controller;

import java.util.ArrayList;

import Model.Course;
import Model.Professor;
import Model.Student;
import Model.User;
import edu.sharif.hw_1.RecyclerViewAdapter;

public class Controller {

    private static User onlineUser;

    public static void addProfessor(String firstName, String lastName,
                                    String university, String username, String password) {
        new Professor(firstName, lastName, username, password, university);
    }

    public static void addStudent(String firstName, String lastName, String studentId,
                                  String username, String password) {
        new Student(firstName, lastName, username, password, studentId);
    }

    public static boolean checkUsernameForRegister(String username) {
        return User.getUserByUsername(username) == null;
    }

    public static boolean loginErrorHandler(String username, String password) {
        User user = User.getUserByUsername(username);
        if (user != null) {
            if (user.checkPassword(password)) {
                onlineUser = user;
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

    public static ArrayList<RecyclerViewAdapter.ListItem> getCourseListItems() {
        ArrayList<RecyclerViewAdapter.ListItem> courseList = new ArrayList<>();
        for (Course course : onlineUser.getCourses()) {
            courseList.add(new RecyclerViewAdapter.ListItem
                    (course.getName(), String.valueOf(course.getId())));
        }
        return courseList;
    }

    public static ArrayList<RecyclerViewAdapter.ListItem> getNotJoinedCourseListItems() {
        ArrayList<RecyclerViewAdapter.ListItem> courseList = new ArrayList<>();
        ArrayList<Course> allCourses = Course.getAllCourses();
        for (Course course : allCourses) {
            if (!onlineUser.isCourseJoined(course)) {
                courseList.add(new RecyclerViewAdapter.ListItem
                        (course.getName(), String.valueOf(course.getId())));
            }
        }
        return courseList;
    }

    public static boolean isNumeric(String string) {
        int intValue;

        System.out.println(String.format("Parsing string: \"%s\"", string));

        if (string == null || string.equals("")) {
            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }

    public static boolean joinCourse(int courseId) {
        if (onlineUser instanceof Student) {
            return ((Student) onlineUser).joinCourse(courseId);
        }
        return false;
    }
}
