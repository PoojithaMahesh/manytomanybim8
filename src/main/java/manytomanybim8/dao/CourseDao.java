package manytomanybim8.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanybim8.dto.Course;
import manytomanybim8.dto.Student;

public class CourseDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}

	public void updateCourse(int id,Course course) {
		EntityManager entityManager=getEntityManager();
		Course dbCourse=entityManager.find(Course.class, id);
		if(dbCourse!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			course.setId(id);
			course.setStudents(dbCourse.getStudents());
			
			entityManager.merge(course);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	
	public void findCourse(int id) {
		EntityManager entityManager=getEntityManager();
		Course dbCourse=entityManager.find(Course.class, id);
		if(dbCourse!=null) {
			System.out.println(dbCourse);
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	public void deleteCourse(int id) {
		EntityManager entityManager=getEntityManager();
		Course dbCourse=entityManager.find(Course.class, id);
		if(dbCourse!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			
		List<Student> students=dbCourse.getStudents();
		for(Student  student:students) {
			List<Course> courses=student.getCourses();
			courses.remove(dbCourse);
			student.setCourses(courses);
		}
			entityManager.remove(dbCourse);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	
	
	
	
}
