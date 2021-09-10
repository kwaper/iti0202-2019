package ee.taltech.iti0202.kt5.university;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int eap = 0;
    private University university;
    private List<Course> courses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void setEap(int eap) {
        this.eap = eap;
    }

    public String getName() {
        return this.name;
    }

    public int getEap() {
        return eap;
    }

    public String toString() {
        return name + " (" + eap + ")";
    }
}
