package Model;

import java.util.ArrayList;

public class Course {
    private static ArrayList<Course> courses;
    private String name;
    private Professor professor;
    private ArrayList<HomeWork> homeWorks;

    static {
        courses = new ArrayList<>();
    }

    public Course(String name, Professor professor) {
        this.name = name;
        this.professor = professor;
        courses.add(this);
    }

    public String getName() {
        return name;
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
