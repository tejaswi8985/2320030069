package com.tejaswi;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class Gradebook {
	private Set<String> subjects;
    private Map<Student, Map<String, Integer>> studentGrades;

    public Gradebook() {
        this.subjects = new HashSet<>();
        this.studentGrades = new HashMap<>();
    }

    public void addSubject(String subject) {
        subjects.add(subject);
    }

    public void addStudent(Student student) {
        studentGrades.putIfAbsent(student, new HashMap<>());
    }

    public void assignGrade(Student student, String subject, int grade) {
        if (!subjects.contains(subject)) {
            System.out.println("Subject not found!");
            return;
        }
        studentGrades.get(student).put(subject, grade);
    }

   
    public Integer getGrade(Student student, String subject) {
        return studentGrades.get(student).get(subject);
    }

    public void printGrades(Student student) {
        Map<String, Integer> grades = studentGrades.get(student);
        if (grades != null) {
            System.out.println("Grades for " + student.getName() + ":");
            grades.forEach((subject, grade) -> System.out.println(subject + ": " + grade));
        } else {
            System.out.println("No grades found for this student.");
        }
    }

    public void printAllGrades() {
        for (Student student : studentGrades.keySet()) {
            printGrades(student);
        }
    }
}
