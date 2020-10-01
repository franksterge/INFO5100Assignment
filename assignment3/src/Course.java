package src;

import src.Student;

public class Course {
    private String name;
    private int numberOfStudent;
    private Student[] students;
    public static int MAX_STUDENTS = 10;

    public Course(String name) {
        this.name = name;
        this.numberOfStudent = 0;
        this.students = new Student[MAX_STUDENTS];
    }

    public Student[] getStudents() {
        return this.students;
    }

    public boolean isFull() {
        return numberOfStudent == MAX_STUDENTS;
    }

    public String getName() {
        return this.name;
    }

    public int getNumberOfStudent() {
        return this.numberOfStudent;
    }

    public void registerStudent(Student student) {
        if (numberOfStudent < MAX_STUDENTS) {
            students[numberOfStudent] = student;
            numberOfStudent++;
        } else {
            System.out.println("This class is already full.");
        }
    }
}
