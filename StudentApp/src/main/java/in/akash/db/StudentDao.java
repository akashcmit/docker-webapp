package in.akash.db;

import java.util.ArrayList;
import java.util.List;

import in.akash.db.entity.Student;

public class StudentDao {

	private static Integer generatedId = 0;
	private static List<Student> studentList;

	private static Integer getId() {
		return ++generatedId;
	}

	public static void saveStudent(Student student) {
		student.setId(getId());
		if (studentList == null) {
			studentList = new ArrayList<Student>();
		}
		studentList.add(student);
		System.out.println("New Student Saved : " + student.toString());
	}

	public static List<Student> getAllStudents() {
		return studentList;
	}
}
