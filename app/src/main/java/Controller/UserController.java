package Controller;

import Model.Professor;
import Model.Student;

public class UserController {

    public static void addProfessor(String firstName, String lastName,
                                    String university, String username, String password) {
        new Professor(firstName,lastName,username,password,university);
    }

    public static void addStudent(String firstName,String lastName,String studentId,
                                  String username , String password){
        new Student(firstName,lastName,username,password,studentId);
    }

}
