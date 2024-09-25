package com.tejaswi;

public class Main {
	public static void main(String[] args) {
        Gradebook gradebook = new Gradebook();
        gradebook.addSubject("Math");
        gradebook.addSubject("Science");

        Student student1 = new Student("001", "Alice");
        Student student2 = new Student("002", "Bob");

        gradebook.addStudent(student1);
        gradebook.addStudent(student2);

        gradebook.assignGrade(student1, "Math", 90);
        gradebook.assignGrade(student1, "Science", 85);
        gradebook.assignGrade(student2, "Math", 95);

        gradebook.printGrades(student1); 
        gradebook.printGrades(student2); 

        gradebook.printAllGrades(); 
    }
}
