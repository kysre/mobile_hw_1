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
        homeWorks = new ArrayList<>();
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
