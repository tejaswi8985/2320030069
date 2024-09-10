package student.com;

public class EnrollmentService {
	 public void enroll(Student student, Course course) {
	        student.enrollCourse(course);
	        course.enrollStudent(student);
	    }
}
