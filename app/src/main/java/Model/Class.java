package Model;

import java.util.ArrayList;

public class Class {

    static ArrayList<Class> allClasses;

    private String className;
    private Professor classProfessor;
    private ArrayList<HomeWork> homeWorks;


    public Class(String className, Professor classProfessor) {
        this.className = className;
        this.classProfessor = classProfessor;
        homeWorks = new ArrayList<>();
    }
    static public Class getClassByName(String className) {
        for (Class allClass : allClasses) {
            if (allClass.getClassName().equals(className)) {
                return allClass;
            }
        }
        return null;
    }

    public String getClassName() {
        return className;
    }
}

