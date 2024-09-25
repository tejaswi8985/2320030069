package com.tejaswi;
import java.util.HashMap;

import java.util.Map;

public class Gradebook {
	 private Map<Student, Map<String, Integer>> grades;

	    public Gradebook() {
	        grades = new HashMap<>();
	    }

	    public void addStudent(Student student) {
	        grades.putIfAbsent(student, new HashMap<>());
	    }

	    public void assignGrade(Student student, String subject, int grade) {
	        if (!grades.containsKey(student)) {
	            System.out.println("Student not found in the gradebook!");
	            return;
	        }

	        Map<String, Integer> studentGrades = grades.get(student);
	        if (student.getSubjects().contains(subject)) {
	            studentGrades.put(subject, grade);
	        } else {
	            System.out.println("Student is not enrolled in the subject: " + subject);
	        }
	    }

	    public void displayGrades(Student student) {
	        if (grades.containsKey(student)) {
	            System.out.println("Grades for " + student.getName() + ":");
	            Map<String, Integer> studentGrades = grades.get(student);
	            for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
	                System.out.println("Subject: " + entry.getKey() + ", Grade: " + entry.getValue());
	            }
	        } else {
	            System.out.println("Student not found!");
	        }
	    }

	    public double calculateAverageGrade(Student student) {
	        if (grades.containsKey(student)) {
	            Map<String, Integer> studentGrades = grades.get(student);
	            int total = 0;
	            for (int grade : studentGrades.values()) {
	                total += grade;
	            }
	            return studentGrades.size() > 0 ? (double) total / studentGrades.size() : 0.0;
	        } else {
	            System.out.println("Student not found!");
	            return 0.0;
	        }
	    }
}
