package com.satoripop.cruddemo;

import com.satoripop.cruddemo.dao.StudentDAO;
import com.satoripop.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return args -> {
			//Creation :

			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);

			//Reading Data :
			//readStudent(studentDAO ,1);
			//readStudent(studentDAO , 2);

			//Querying :
			//displayAll(studentDAO);
			//queryStudentByLastName(studentDAO, "Boussadia");


			//Updating
			/*
			Student student = studentDAO.findById(2);
			student.setFirstName("Ahmed");
			updateStudent(studentDAO , student);
			*/

			//Deleting :
			/*deleteStudent(studentDAO,3);*/

			studentDAO.deleteAll();



		};
	}


	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating student . . .");
		Student student = new Student("Chaabane" , "Boussadia" , "chaababaneboussadia@gmai.com");


		//save it
		studentDAO.save(student);

		//Test it
		System.out.println("Created student Id = " + student.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating students . . .");
		Student student1 = new Student("Chaabane" , "Boussadia" , "chaababaneboussadia@gmail.com");
		Student student2 = new Student("John" , "Doe" , "johndoe@gmail.com");
		Student student3 = new Student("Mary" , "Smith" , "mary.smith34@outlook.com");

		System.out.println("Saving students . . .");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);


		//Testing :
		System.out.println("Created students Id = " + student1.getId());
		System.out.println("Created students Id = " + student2.getId());
		System.out.println("Created students Id = " + student3.getId());

	}


	public void readStudent(StudentDAO studentDAO,int id) {
		System.out.println("Reading student . . .");
		Student student = studentDAO.findById(id);
		if (student == null) {
			System.out.println("Student with id " + id + " not found.");
		}
		System.out.println(student);
	}

	void displayAll(StudentDAO studentDAO){
		List<Student> students = studentDAO.findAll();
		for (Student student : students){
			System.out.println(student);
		}
	}

	void queryStudentByLastName(StudentDAO studentDAO, String lastName) {
		List<Student> students = studentDAO.findByLastName(lastName);
		if (students.isEmpty()) {
			System.out.println("Student with last name " + lastName + " not found.");
		}
		else{
			for (Student student : students){
				System.out.println(student);
			}
		}
	}

	void updateStudent(StudentDAO studentDAO ,Student student) {
		System.out.println("Updating student . . .");
		studentDAO.update(student);


		System.out.println("Updated student Id = " + student.getId());
	}


	public void deleteStudent(StudentDAO studentDAO,int id) {
		System.out.println("Deleting student . . .");

		studentDAO.delete(id);
		System.out.println("Operation Finished ");

	}




}
