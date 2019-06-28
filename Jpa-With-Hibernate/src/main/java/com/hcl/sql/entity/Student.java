package com.hcl.sql.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({ @NamedQuery(name = "fetchByName",query = "SELECT e FROM Student e WHERE e.name =:name"),
				@NamedQuery(name = "GroupByName",query = "SELECT e FROM Student e  GROUP BY e.name")})

public class Student {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@OneToOne(cascade=CascadeType.ALL)
	private Passport passport;



	protected Student() {
	}

	public Student(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Student[%s]", name);
	}
}