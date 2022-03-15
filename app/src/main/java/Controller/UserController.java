package Controller;

import Model.Professor;

public class UserController {

    public static void addProfessor(String firstName, String lastName,
                                    String university, String username, String password) {
        new Professor(firstName,lastName,username,password,university);
    }

}
