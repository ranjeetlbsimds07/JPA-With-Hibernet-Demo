package com.hcl.sql.reposiotry;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.sql.entity.Address;
import com.hcl.sql.entity.Employee;
import com.hcl.sql.entity.MarksDetails;
import com.hcl.sql.entity.Passport;
import com.hcl.sql.entity.Student;
import com.hcl.sql.entity.StudentDetail;

@Repository
@Transactional
public class StudentRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	/**
	 * OneToOne Mapping
	 */
	public void saveStudentWithPassport() {
		Passport passport = new Passport("Z123456");

		Student student = new Student("Ayush");

		student.setPassport(passport);
		em.persist(student);

		Student student1 = new Student("Ranjeet");
		student1.setPassport(passport);
		em.persist(student1);
	}

	/**
	 * OnToMany Mapping
	 */
	public void saveStudentWithmarksOneToMany() {

		StudentDetail studentObj = new StudentDetail("Ayush", "Saxena", "ayush@javacodegeeks.com", "0123456789");

		MarksDetails marksObj1 = new MarksDetails("English", "100", "90", "Pass");
		marksObj1.setStudent(studentObj);
		em.persist(marksObj1);

		MarksDetails marksObj2 = new MarksDetails("Maths", "100", "99", "Pass");
		marksObj2.setStudent(studentObj);
		em.persist(marksObj2);

		MarksDetails marksObj3 = new MarksDetails("Science", "100", "94", "Pass");
		marksObj3.setStudent(studentObj);
		em.persist(marksObj3);

	}

	/**
	 * ManyToMany Mapping
	 */
	public void saveEmployeeWithAddressManyToMany() {
		Employee employee1 = new Employee();
		employee1.setEmployeeName("Barry Bingel");
		employee1.setEmail("barry.cs2017@gmail.com");
		employee1.setSalary(50000.00);
		employee1.setDoj(new Date());

		Employee employee2 = new Employee();
		employee2.setEmployeeName("Sean Bingel");
		employee2.setEmail("sean.cs2017@gmail.com");
		employee2.setSalary(70000.00);
		employee2.setDoj(new Date());

		Address address1 = new Address();
		address1.setCity("Chennai");
		address1.setPincode(9087727L);
		address1.setState("Tamilnadu");
		address1.setStreet("Park Street");

		Address address2 = new Address();
		address2.setCity("Pune");
		address2.setPincode(9000027L);
		address2.setState("MH");
		address2.setStreet("XYZ Street");

		Address address3 = new Address();
		address3.setCity("Delhi");
		address3.setPincode(908877027L);
		address3.setState("DL");
		address3.setStreet("PQR Street");

		employee1.getAddressList().add(address1);
		employee1.getAddressList().add(address2);
		employee1.getAddressList().add(address3);

		address1.getEmpList().add(employee1);
		address2.getEmpList().add(employee1);
		address3.getEmpList().add(employee1);

		employee2.getAddressList().add(address2);
		employee2.getAddressList().add(address3);

		address2.getEmpList().add(employee2);
		address3.getEmpList().add(employee2);

		em.persist(employee1);
		em.persist(employee2);
		
	

	}

	/**
	 * Find user details from Passport tbl
	 * 
	 * @param id
	 * @return
	 */
	public Passport findByPassprtId(Long id) {
		return em.find(Passport.class, id);
	}

	/**
	 * Find user details from student tbl
	 * 
	 * @param id
	 * @return
	 */
	public Student findById(Long id) {
		return em.find(Student.class, id);
	}

	public List<Student> FindByName(String name) {
		TypedQuery<Student> namedQuery=em.createNamedQuery("fetchByName",Student.class);
	    namedQuery.setParameter("name",name);
	    return namedQuery.getResultList();
	    
	}
	
	public List<Student> FindGroupByName() {
		TypedQuery<Student> namedQuery=em.createNamedQuery("GroupByName",Student.class);
	    return namedQuery.getResultList();
	    
	}

	public int deleteById(Long id) {
		Query query = em.createQuery("DELETE FROM Student s WHERE s.id=:id");
		query.setParameter("id", id);
		int result = query.executeUpdate();
		return result;

	}

}
