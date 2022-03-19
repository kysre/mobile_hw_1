package Model;

import java.util.ArrayList;

public class Course {
    private static ArrayList<Course> courses;
    private String name;
    private int id;
    private Professor professor;
    private ArrayList<Homework> homework;

    static {
        courses = new ArrayList<>();
    }

    public Course(String name, Professor professor, int id) {
        this.name = name;
        this.professor = professor;
        this.id = id;
        courses.add(this);
        homework = new ArrayList<>();
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
        return homework;
    }

    public void homework(Homework homework) {
        this.homework.add(homework);
    }

    public static void setCourses(ArrayList<Course> courses) {

        Course.courses = courses;
    }

    public void setHomeWorks(ArrayList<HomeWork> homeWorks) {

        this.homeWorks = homeWorks;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static ArrayList<Course> getCourses() {

        return courses;
    }


    @Override
    public String toString() {

        return "Course{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", professor=" + professor +
                ", homeWorks=" + homeWorks +
                '}';
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setProfessor(Professor professor) {
        this.professor = professor;
    }


}
