package src;

import src.Course;
import src.Student;
import src.Professor;

public class Test {
    public static void main(String[] args) {
        // Question 1
        String studentName = "student";
        String studentId = "studentId";
        String courseName = "Info5100";

        Course testCourse = new Course(courseName);
        System.out.println("Course Name: " + testCourse.getName());

        for (int i = 0; i < Course.MAX_STUDENTS; i++) {
            Student student = new Student(studentName, studentId);
            studentName += i;
            studentId += i;
            student.setName(studentName);
            student.setId(studentId);
            if (!testCourse.isFull()) {
                testCourse.registerStudent(student);    
            }
            studentName = studentName.substring(0, studentName.length() - 1);
            studentId = studentId.substring(0, studentId.length() - 1);
        }
        Student[] registeredStudent = testCourse.getStudents();
        for (Student currentStudent: registeredStudent) {
            System.out.println(currentStudent.getId() + " " + currentStudent.getName());
        }

        System.out.println("Current number of student: " + testCourse.getNumberOfStudent());
        Student extra = new Student("extra", "extraStudentId");
        testCourse.registerStudent(extra);
        System.out.println("Current number of student: " + testCourse.getNumberOfStudent());

        // Question 2
        String test = "the sky is blue";
        String result = reverseString(test);
        System.out.println(result);

        String test2 = "     the     sky   is    blue   ";
        String result2 = reverseString(test2);
        System.out.println(result2);

        // Extra Credit
        Professor p = new Professor.Builder("First", "Last", "id")
                .setEmail("email@email.com")
                .setGender("Male")
                .setWebsite("professor.com")
                .build();
    }

    public static String reverseString(String s) {
        String[] parsedStrings = s.trim().split("\s+");
        String result = "";
        for (int i = parsedStrings.length - 1; i >= 0; i--) {
            result += parsedStrings[i].trim() + " ";
        }
        return result.trim();
    }
}
