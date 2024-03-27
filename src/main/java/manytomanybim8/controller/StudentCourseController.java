package manytomanybim8.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanybim8.dto.Course;
import manytomanybim8.dto.Student;

public class StudentCourseController {
public static void main(String[] args) {
	Student student1=new Student();
	student1.setId(1);
	student1.setName("Kazi");
	student1.setAddress("Pune");
	
	Student student2=new Student();
	student2.setId(2);
	student2.setName("Sindhu");
	student2.setAddress("Pune");
	
	Student student3=new Student();
	student3.setId(3);
	student3.setName("prem");
	student3.setAddress("Pune");
	
	
	Course course1=new Course();
	course1.setId(1);
	course1.setName("Java");
	course1.setFees(5000);
	
	Course course2=new Course();
	course2.setId(2);
	course2.setName("Advancejava");
	course2.setFees(5000);
	
	Course course3=new Course();
	course3.setId(3);
	course3.setName("Sql");
	course3.setFees(5000);
	
	
	
	List<Course> coursesofkazi=new ArrayList<Course>();
	coursesofkazi.add(course1);
	coursesofkazi.add(course2);
	coursesofkazi.add(course3);
	
	
	student1.setCourses(coursesofkazi);
	student2.setCourses(coursesofkazi);
	student3.setCourses(coursesofkazi);
	
	
	List<Student> students=new ArrayList<Student>();
	students.add(student1);
	students.add(student2);
	students.add(student3);
	
	course1.setStudents(students);
	course2.setStudents(students);
	course3.setStudents(students);
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(course1);
	entityManager.persist(course2);
	entityManager.persist(course3);
	entityManager.persist(student1);
	entityManager.persist(student2);
	entityManager.persist(student3);
	entityTransaction.commit();
	
	
	
	
	
	
	
	
	
	
	
}
}
