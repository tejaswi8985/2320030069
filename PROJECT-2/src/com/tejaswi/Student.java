package com.tejaswi;
import java.util.*;
public class Student {
	private String studentId;
    private String name;
    private Set<String> subjects;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.subjects = new HashSet<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public Set<String> getSubjects() {
        return subjects;
    }

    public void enrollSubject(String subject) {
        subjects.add(subject);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId.equals(student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
