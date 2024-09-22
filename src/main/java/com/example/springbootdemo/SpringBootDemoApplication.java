package com.example.springbootdemo;

import com.example.springbootdemo.dao.StudentDAO;
import com.example.springbootdemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;



@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//			createStudent(studentDAO);

//            readStudent(studentDAO);

//            queryForStudents(studentDAO);

            queryForStudentsByLastName(studentDAO);

        };
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        Student student1 = new Student("Ram", "Rama", "ram@gmail.com");
        studentDAO.save(student1);

        Student student3 = new Student("Sita 2", "Devi 2", "sita1@gmail.com");
        studentDAO.save(student3);

        Student student2 = new Student("Ram 2", "Rama 2", "ram2@gmail.com");
        studentDAO.save(student2);

        Student student4 = new Student("Sita 2", "Devi 2", "sita2@gmail.com");
        studentDAO.save(student4);

        List<Student> theStudents = studentDAO.findByLastName("Rama 2");
        for (Student student : theStudents) {
            System.out.println("queryForStudentsByLatName : " + student);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        Student student1 = new Student("Ram", "Rama", "ram@gmail.com");
        studentDAO.save(student1);

        Student student2 = new Student("Ram 2", "Rama 2", "ram2@gmail.com");
        studentDAO.save(student2);

        List<Student> theStudents = studentDAO.findAll();
        for(Student theStudent: theStudents) {
            System.out.println("queryForStudents : " + theStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        Student student1 = new Student("Ram", "Rama", "ram@gmail.com");
        studentDAO.save(student1);
        Student student2 = new Student("Ram 2", "Rama 2", "ram2@gmail.com");
        studentDAO.save(student2);

        int theID = student2.getId();
        System.out.println("getStudent theID: " + theID);
        Student getStudent = studentDAO.findById(theID);
        System.out.println("getStudent : " + getStudent);
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
