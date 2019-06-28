package com.hcl.sql;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hcl.sql.entity.Employee;
import com.hcl.sql.entity.Passport;
import com.hcl.sql.entity.Student;
import com.hcl.sql.reposiotry.StudentRepository;

@SpringBootApplication
public class JpaWithHibernateApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentRepository studentRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(JpaWithHibernateApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		//studentRepository.saveStudentWithPassport();
		//studentRepository.saveStudentWithmarksOneToMany();
		//studentRepository.saveEmployeeWithAddressManyToMany();
		
		Student student = studentRepository.findById(15L);
		System.out.println("student Details--->"+student.getName()+student.getPassport());
		
		
		Passport passport = studentRepository.findByPassprtId(9L);
		System.out.println("student Details--->"+passport.getNumber());
		
		
		List<Student> studentName = studentRepository.FindByName("Ayush");
		System.out.println("student Name Details--->"+ "Length is ="+studentName.size() +"  " +studentName.get(0).getName()+studentName.get(0).getPassport());
		
		
		List<Student> studentGroupName = studentRepository.FindGroupByName();
		System.out.println("student Group Name Details--->"+ "Length is ="+studentGroupName.size() +"  " +studentName.get(1).getName()+studentName.get(1).getPassport());
		
		//studentRepository.deleteById(3L);
		
	
	}

}
