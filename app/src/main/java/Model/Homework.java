package Model;

import java.util.HashMap;

public class Homework {
    private String name;
    private String question;
    private HashMap<Student, String> studentAnswers;
    private HashMap<Student, Float> studentMarks;

    public Homework(String name, String question) {
        this.name = name;
        this.question = question;
        this.studentAnswers = new HashMap<>();
        this.studentMarks = new HashMap<>();
    }
}
