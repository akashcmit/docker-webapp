package in.akash.dao;

import java.util.List;

import javax.ejb.Local;

import in.akash.db.entity.StudentEntity;
@Local
public interface StudentDao {
	public void saveStudent(StudentEntity student);
	public List<StudentEntity> getAllStudents();
}
