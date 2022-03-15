package Controller;

import Model.Professor;
import Model.Student;
import Model.User;

public class UserController {

    public static void addProfessor(String firstName, String lastName,
                                    String university, String username, String password) {
        new Professor(firstName, lastName, username, password, university);
    }

    public static void addStudent(String firstName, String lastName, String studentId,
                                  String username, String password) {
        new Student(firstName, lastName, username, password, studentId);
    }

    public static boolean checkUsernameForRegister(String username) {
        return User.getUsernameToUser().get(username) != null;
    }

    public static boolean loginErrorHandler(String username, String password) {
        if (User.getUsernameToUser().get(username) != null) {
            if (User.getUsernameToUser().get(username).getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
