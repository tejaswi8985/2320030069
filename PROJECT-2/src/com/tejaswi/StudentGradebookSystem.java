package com.tejaswi;

public class StudentGradebookSystem {
	public static void main(String[] args) {
        Gradebook gradebook = new Gradebook();

        
        Student student1 = new Student("S001", "Alice");
        Student student2 = new Student("S002", "Bob");

       
        student1.enrollSubject("Math");
        student1.enrollSubject("Science");
        student2.enrollSubject("Math");

        
        gradebook.addStudent(student1);
        gradebook.addStudent(student2);

        
        gradebook.assignGrade(student1, "Math", 85);
        gradebook.assignGrade(student1, "Science", 90);
        gradebook.assignGrade(student2, "Math", 88);

        
        gradebook.displayGrades(student1);
        gradebook.displayGrades(student2);

        
        System.out.println("Average grade for " + student1.getName() + ": " + gradebook.calculateAverageGrade(student1));
    }
}
