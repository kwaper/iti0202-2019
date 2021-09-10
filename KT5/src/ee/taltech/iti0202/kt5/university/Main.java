package ee.taltech.iti0202.kt5.university;

public class Main {
    public static void main(String[] args) {
        University talTech = new University("TalTech");
        Student mari = new Student("Mari");
        Student mati = new Student("Mati");
        talTech.addStudent(mari);
        System.out.println(talTech.addStudent(mati));  // true
        System.out.println(talTech.addStudent(mati));  // false
        Course java = talTech.createCourse("Programmeerimise põhikursus", 6).get();
        System.out.println(java);  // TalTech: Programmeerimise põhikursus (6)
        System.out.println(talTech.createCourse("Programmeerimise põhikursus", 7));  // Optional.empty
        System.out.println(talTech.createCourse("Java", 0));  // Optional.empty
        System.out.println(talTech.createCourse("Java", 6));  // Optional[TalTech: Java (6)]

        System.out.println(java.addStudent(mari));  // true
        System.out.println(java.addStudent(mari));  // false
        System.out.println(java.finish()); // true
        System.out.println(java.finish()); // false

        System.out.println(mari);  // Mari (6)
        System.out.println(mari.getEap());  // 6

        System.out.println(talTech.getStudentsOrderedByResults()); // [Mari (6), Mati (0)]

        System.out.println(talTech.getCourses()); // [TalTech: Programmeerimise põhikursus (6), TalTech: Java (6)]
        System.out.println(talTech.getFinishedCourses());  // [TalTech: Programmeerimise põhikursus (6)]
    }
}
