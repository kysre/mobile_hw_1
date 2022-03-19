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


    public void setName(String name) {
        this.name = name;
    }

    public Course getHomeWorkCourse() {
        return homeWorkCourse;
    }


    public void setHomeWorkCourse(Course homeWorkCourse) {
        this.homeWorkCourse = homeWorkCourse;
    }



    @Override
    public String toString() {

        return "HomeWork{" +
                "name='" + name + '\'' +
                ", question='" + question + '\'' +
                ", homeWorkCourse=" + homeWorkCourse +
                ", studentAnswers=" + studentAnswers +
                ", studentMarks=" + studentMarks +
                '}';
    }


    public HashMap<Student, Float> getStudentMarks() {
        return studentMarks;
    }

    public HashMap<Student, String> getStudentAnswers() {
        return studentAnswers;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setStudentAnswers(HashMap<Student, String> studentAnswers) {
        this.studentAnswers = studentAnswers;
    }


    public void setStudentMarks(HashMap<Student, Float> studentMarks) {
        this.studentMarks = studentMarks;
    }


}
