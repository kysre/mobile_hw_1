package Model;

import java.util.ArrayList;

public class Course {
    private static ArrayList<Course> courses;
    private String name;
    private int id;
    private Professor professor;
    private ArrayList<Homework> homeworks;

    static {
        courses = new ArrayList<>();
    }

    public Course(String name, Professor professor, int id) {
        this.name = name;
        this.professor = professor;
        this.id = id;
        courses.add(this);
        homeworks = new ArrayList<>();
    }

    public static Course getCourseByName(String name) {
        for (Course course : courses) {
            if (course.getName().equals(name)) {
                return course;
            }
        }

        return null;
    }

    public static Course getCourseById(int courseId) {
        for (Course course : courses) {
            if (course.getId() == courseId) {
                return course;
            }
        }
        return null;
    }

    public static ArrayList<Course> getAllCourses() {
        return courses;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;

    }

    public Professor getProfessor() {
        return professor;
    }

    public ArrayList<Homework> getHomeworks() {
        return homeworks;
    }

    public void homework(Homework homework) {
        this.homeworks.add(homework);
    }

    public static void setCourses(ArrayList<Course> courses) {

        Course.courses = courses;
    }

    public void setHomeWorks(ArrayList<Homework> homeworks) {
        this.homeworks = homeworks;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static ArrayList<Course> getCourses() {
        return courses;
    }
}

   

