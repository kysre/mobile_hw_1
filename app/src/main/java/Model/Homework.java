package Model;

import java.util.HashMap;

public class Homework {
    private String name;
    private String question;
    private Course homeworkCourse;
    private HashMap<Student, String> studentAnswers;
    private HashMap<Student, Float> studentMarks;

    public Homework(String name, String question, Course homeworkCourse) {
        this.name = name;
        this.question = question;
        this.homeworkCourse = homeworkCourse;
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
