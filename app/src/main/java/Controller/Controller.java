package Controller;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import Model.Course;
import Model.Professor;
import Model.Student;
import Model.User;
import edu.sharif.hw_1.RecyclerViewAdapter;

public class Controller extends Activity {

    private static User onlineUser;

    public static ArrayList<User> addProfessor(String firstName, String lastName,
                                    String university, String username, String password) {
        Professor professor = new Professor(firstName, lastName, username, password, university);
        System.out.println("00000");
        Controller controller = new Controller();
        ArrayList<User> users = User.getUsers();
        return users;
      //  controller.saveProfessor(firstName, lastName, university, username, password);

    }

    public void saveProfessor(String firstName, String lastName,
                              String university, String username, String password) {
        System.out.println("1");
        //SharedPreferences sharedPreferences;
        System.out.println("2");
        //String filePath = "Users/Professors/";
        String filePath = "";
        FileOutputStream fileOutputStream;
        filePath = "";

        System.out.println("3");
        SharedPreferences sharedPreferences = getSharedPreferences(username, Context.MODE_PRIVATE);
        System.out.println("4");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        System.out.println("5");
        editor.putString("username", username);
        editor.putString("password", password);
        editor.putString("firstName", firstName);
        editor.putString("lastName", lastName);
        System.out.println("6");

        editor.commit();
    }

    public static ArrayList<User> addStudent(String firstName, String lastName, String studentId,
                                  String username, String password) {
        new Student(firstName, lastName, username, password, studentId);

        ArrayList<User> users = User.getUsers();
        return users;
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

        if (string == null || string.equals("")) {
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {

        }
        return false;




    }

    public static boolean joinCourse(int courseId) {

        if (onlineUser instanceof Student) {
            return ((Student) onlineUser).joinCourse(courseId);
        }
        return false;
    }


    public static void initializer() {
        SharedPreferences sp;
        SharedPreferences.Editor editor;

        sp = PreferenceManager.getDefaultSharedPreferences(null);
        editor = sp.edit();
    }



}
