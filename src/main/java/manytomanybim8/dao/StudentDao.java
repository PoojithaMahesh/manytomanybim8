package manytomanybim8.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanybim8.dto.Course;
import manytomanybim8.dto.Student;

public class StudentDao {
public EntityManager getEntityManager() {
	return Persistence.createEntityManagerFactory("vinod").createEntityManager();
}

public void updateStudent(int id,Student student) {
	EntityManager entityManager=getEntityManager();
	Student dbStudent=entityManager.find(Student.class, id);
	if(dbStudent!=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		student.setId(id);
		student.setCourses(dbStudent.getCourses());
		
		entityManager.merge(student);
		entityTransaction.commit();
	}else {
		System.out.println("Sorry id is not present");
	}
}
public void findStudent(int id) {
	EntityManager entityManager=getEntityManager();
	Student dbStudent=entityManager.find(Student.class, id);
	if(dbStudent!=null) {
		System.out.println(dbStudent);
	}else {
		System.out.println("Sorry id is not present");
	}
}
public void deleteStudent(int id) {
	EntityManager entityManager=getEntityManager();
	Student dbStudent=entityManager.find(Student.class, id);
	if(dbStudent!=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		
		List<Course> courses=dbStudent.getCourses();
		for(Course course:courses) {
			List<Student> students=course.getStudents();
			students.remove(dbStudent);
			course.setStudents(students);
		}
		entityManager.remove(dbStudent);
		entityTransaction.commit();
	}else {
		System.out.println("Sorry id is not present");
	}
}
}
