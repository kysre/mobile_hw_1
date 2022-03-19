package Model;

import java.util.ArrayList;

public class Course {
    private static ArrayList<Course> courses;
    private String name;
    private int id;
    private Professor professor;
    private ArrayList<HomeWork> homeWorks;

    static {
        courses = new ArrayList<>();
    }

    public Course(String name, Professor professor, int id) {
        this.name = name;
        this.professor = professor;
        this.id = id;
        courses.add(this);
    }

    public static Course getCourseByName(String name) {
        for (Course course : courses) {
            if (course.getName().equals(name)) {
                return course;
            }
        }

        return null;
    }

    public static Course getCourseById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Professor getProfessor() {
        return professor;
    }

    public ArrayList<HomeWork> getHomeWorks() {
        return homeWorks;
    }

    public void addHomeWork(HomeWork homeWork) {
        this.homeWorks.add(homeWork);
    }
}
