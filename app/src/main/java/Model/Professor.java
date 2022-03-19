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

    @Override
    public String getFirstname() {
        return super.getFirstname();
    }

    @Override
    public String getLastname() {
        return super.getLastname();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
