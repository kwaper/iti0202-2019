package ee.taltech.iti0202.kt5.university;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private List<Student> students = new ArrayList<>();
    private String name;
    private int eap;

    Course(String name , int eap){
        this.name = name;
        this.eap = eap;
    }

    public boolean addStudent(Student student){
        return true;
    }

    public List<Student> getStudents(){
        return students;
    }



    public boolean finish() {
        return true;
    }

    public boolean isFinished(){
        return false;
    }

    public String toString(){
        return "";
    }

    public int getEap() {
        return eap;
    }

    public String getName() {
        return name;
    }
}
