package in.akash.dao;

import java.util.List;

import in.akash.db.entity.StudentEntity;
public interface StudentDao {
	public void saveStudent(StudentEntity student);
	public List<StudentEntity> getAllStudents();
}
