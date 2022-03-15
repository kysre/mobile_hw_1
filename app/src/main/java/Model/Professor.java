package Model;

import java.util.ArrayList;

public class Professor extends User {
    private static ArrayList<Professor> allProfessor = new ArrayList<>();
    private String universityName;

    public Professor(String name, String family, String userName, String password
            , String universityName) {
        super(name, family, userName, password);
        this.universityName = universityName;
        allProfessor.add(this);
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
