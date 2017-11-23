package in.akash.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import in.akash.db.entity.StudentEntity;

public class StudentDaoImpl implements StudentDao {
	
	//@PersistenceUnit(unitName = "primary") = to be used when JTA managed by container
	private EntityManagerFactory entityManagerFactory;

	public StudentDaoImpl() {
		entityManagerFactory = Persistence.createEntityManagerFactory("primary");
	}

	public void saveStudent(StudentEntity student) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();
		em.close();
		System.out.println("New Student Saved : " + student.toString());
		
	}

	public List<StudentEntity> getAllStudents() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<StudentEntity> cq = cb.createQuery(StudentEntity.class);
		Root<StudentEntity> from = cq.from(StudentEntity.class);
		CriteriaQuery<StudentEntity> all = cq.select(from);
		TypedQuery<StudentEntity> allQuery = em.createQuery(all);
		return allQuery.getResultList();
	}
}
