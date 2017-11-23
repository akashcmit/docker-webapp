package in.akash.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import in.akash.db.entity.StudentEntity;

@Stateless
public class StudentDaoImpl implements StudentDao {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	public StudentDaoImpl() {
	}

	public void saveStudent(StudentEntity student) {
		em.persist(student);
		System.out.println("New Student Saved : " + student.toString());

	}

	public List<StudentEntity> getAllStudents() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<StudentEntity> cq = cb.createQuery(StudentEntity.class);
		Root<StudentEntity> from = cq.from(StudentEntity.class);
		CriteriaQuery<StudentEntity> all = cq.select(from);
		TypedQuery<StudentEntity> allQuery = em.createQuery(all);
		return allQuery.getResultList();
	}
}
