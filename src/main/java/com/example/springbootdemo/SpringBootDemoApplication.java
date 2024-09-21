package com.example.springbootdemo;

import com.example.springbootdemo.dao.StudentDAO;
import com.example.springbootdemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student1 = new Student("Ram", "Rama", "ram@gmail.com");
		Student student2 = new Student("Krushna", "Lala", "krushna@gmail.com");
		Student student3 = new Student("Mahadev", "Shiv", "mahadev@gmail.com");
		Student student4 = new Student("Durga", "Devi", "durga@gmail.com");

		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
		studentDAO.save(student4);

	}

}
