package Model;

import java.util.HashMap;

public class HomeWork {
    private String name;
    private String question;
    private Course homeWorkCourse;
    private HashMap<Student, String> studentAnswers;
    private HashMap<Student, Float> studentMarks;

    public HomeWork(String name, String question, Course homeWorkCourse) {
        this.name = name;
        this.question = question;
        this.homeWorkCourse = homeWorkCourse;
        this.studentAnswers = new HashMap<>();
        this.studentMarks = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getQuestion() {
        return question;
    }

    public Float getStudentMark(Student student) {
        return studentMarks.get(student);
    }

    public String getStudentAnswer(Student student){
        return studentAnswers.get(student);
    }
}
