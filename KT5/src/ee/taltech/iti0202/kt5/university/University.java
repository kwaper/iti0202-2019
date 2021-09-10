package ee.taltech.iti0202.kt5.university;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class University {

    private String name;
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Course> finishedCourses = new ArrayList<>();

    public University(String name) {
        this.name = name;
    }

    public boolean addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            return true;
        }
        return false;
    }

    public Optional<Course> createCourse(String name, int eap) {
        if (courses.size() > 0) {
            for (Course c : courses) {
                if (c.getName().equals(name) || eap < 1) {
                    return Optional.empty();
                }
            }
        }
        Course c = new Course(name, eap);
        courses.add(c);
        return Optional.of(c);
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getName() {
        return name;
    }

    public List<Course> getFinishedCourses() {
        return finishedCourses;
    }

    public List<Student> getStudentsOrderedByResults() {
        return students;
    }
}
