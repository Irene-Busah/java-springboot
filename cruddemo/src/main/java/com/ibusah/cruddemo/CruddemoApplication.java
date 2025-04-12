package com.ibusah.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ibusah.cruddemo.dao.StudentDAO;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@SuppressWarnings("unused")
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

			// readStudent(studentDAO);

			// retrieving all students objects
			// queryForStudents(studentDAO);

			// retrieving students with the specified last name
			// retrieveStudentByLastName(studentDAO);

			// update a student
			// updateStudent(studentDAO);

			// delete student
			deletestudent(studentDAO);
		};
	}

	// ======================================================

	// private void createStudent(StudentDAO studentDAO) {
	// System.out.print("Creating new student object...\n");

	// Student newStudent = new Student("Renee", "Marison", "rmarison@gmail.com");

	// System.out.print("Saving new student...\n");

	// studentDAO.save(newStudent);

	// System.out.println("Saved student:" + newStudent.getId());

	// }

	// ==========================RETRIEVE ALL STUDENTS===========================

	// private void queryForStudents(StudentDAO studentDAO) {
	// List<Student> theStudents = studentDAO.findAll();

	// for (Student tempStudent : theStudents) {
	// System.out.println(tempStudent);
	// }
	// }

	// ================================================================

	// private void readStudent(StudentDAO studentDAO) {

	// // first, we create new student
	// System.out.print("Creating new student object...\n");

	// Student newStudent = new Student("Emmanuel", "Korankye", "emma@gmail.com");

	// System.out.print("Saving new student...\n");

	// studentDAO.save(newStudent);

	// // then, we get the ID of the newly created student

	// int studentID = newStudent.getId();

	// System.out.println("Saved student:" + studentID);

	// // find the new student by ID
	// System.out.println("New Student with ID: " + studentDAO + " " +
	// studentDAO.findById(studentID));

	// }

	private void deletestudent(StudentDAO studentDAO) {
		int id = 1;
		// Student student = studentDAO.findById(id);

		studentDAO.delete(id);
	}

	// ==========================================================

	// private void updateStudent(StudentDAO studentDAO) {
	// // retrieve a student id
	// int studentId = 1;
	// System.out.println("Getting Student with ID: " + studentId);

	// Student student = studentDAO.findById(studentId);

	// // changing the first name
	// System.out.println("Updating the student ......");

	// student.setFirstName("Nancy");
	// studentDAO.update(student);

	// System.out.println("Updated Student: " + student);
	// }

	// ==============================================
	// private void retrieveStudentByLastName(StudentDAO studentDAO) {
	// List<Student> students = studentDAO.findByLastName("Busah");

	// for (Student tempStudent : students) {
	// System.out.println(tempStudent);
	// }
	// }

}
