package br.dev.joaquim.studentApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.dev.joaquim.studentApp.entities.Student;
import br.dev.joaquim.studentApp.repositoy.StudentRepository;

@SpringBootApplication
public class StudentAppApplication implements CommandLineRunner {
	@Autowired
	private StudentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(StudentAppApplication.class, args);
	}

	@Override
    public void run(String... args) {
		Student s = new Student("Joaquim", 124);
		System.out.println("Olá mundo");
		
		repository.save(s);
		List<Student> students = repository.findByNomeStartingWith("Joaquim");

		for(Student student: students) {
			System.out.println(student);
		}
	}

}
