package Controller;

import java.util.ArrayList;

import Model.Course;
import Model.Homework;
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
        return Professor.isThereProfessor(username);
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

    public static String getCourseProfessorName(String courseName) {
        Professor professor = Course.getCourseByName(courseName).getProfessor();
        return professor.getFirstname() + professor.getLastname();
    }

    public static String getCourseNameById(int courseId) {
        Course course = Course.getCourseById(courseId);
        if (course != null) {
            return course.getName();
        }
        return null;
    }

    public static boolean isCourseJoinedByOnlineUser(String courseName) {
        return onlineUser.isCourseJoined(Course.getCourseByName(courseName));
    }

    public static ArrayList<RecyclerViewAdapter.ListItem> getHomeworkListItems(String courseName) {
        ArrayList<Homework> homeworks = Course.getCourseByName(courseName).getHomeworks();
        ArrayList<RecyclerViewAdapter.ListItem> listItems = new ArrayList<>();
        for (Homework homework : homeworks) {
            listItems.add(new RecyclerViewAdapter.ListItem(homework.getName(), ""));
        }
        return listItems;
    }

    public static String getHomeworkQuestion(String courseName, String homeworkName) {
        Homework homework = Course.getCourseByName(courseName).getHomeworkByName(homeworkName);
        if (homework != null) {
            return homework.getQuestion();
        }
        return null;
    }

    public static String getPreviousAnswer(String courseName, String homeworkName) {
        Homework homework = Course.getCourseByName(courseName).getHomeworkByName(homeworkName);
        if (homework != null) {
            if (onlineUser instanceof Student) {
                return homework.getStudentAnswer((Student) onlineUser);
            }
        }
        return null;
    }

    public static boolean setAnswerForOnlineUser(String courseName, String homeworkName, String answer) {
        Homework homework = Course.getCourseByName(courseName).getHomeworkByName(homeworkName);
        if (onlineUser instanceof Student && homework != null) {
            Student student = (Student) onlineUser;
            Course.getCourseByName(courseName).getHomeworkByName(homeworkName)
                    .setStudentAnswer(student, answer);
            return true;
        }
        return false;
    }

    public static void createNewCourse(String courseName, Professor professor) {
        Course course = new Course(courseName, professor);
        professor.addCourse(course);
    }
}
