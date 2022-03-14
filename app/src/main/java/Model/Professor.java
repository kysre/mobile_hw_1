package Model;

public class Professor extends User {
    private String universityName;

    public Professor(String name, String family, String userName, String password
            , String universityName) {
        super(name, family, userName, password);
        this.universityName = universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
