package Model;

public class Professor extends User {
    private String nameOfTheUniversity;

    public Professor(String name, String family, String userName, String password
            , String nameOfTheUniversity) {
        super(name, family, userName, password);
        this.nameOfTheUniversity = nameOfTheUniversity;
    }

    public String getNameOfTheUniversity() {
        return nameOfTheUniversity;
    }

    public void setNameOfTheUniversity(String nameOfTheUniversity) {
        this.nameOfTheUniversity = nameOfTheUniversity;
    }
}
