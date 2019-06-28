package com.hcl.sql.entity;


import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "studentDetail")
public class StudentDetail {
	@Id
    @GeneratedValue
    @Column(name = "student_id")
    private long id;
 
    @Column(name = "first_name")
    private String firstName;
 
    @Column(name = "last_name")
    private String lastName;
 
    @Column(name = "email")
    private String email;
 
    @Column(name = "phone")
    private String phone;
 
    @OneToMany(mappedBy = "studentDetail", cascade = CascadeType.ALL)
    private List<MarksDetails> marksDetails;
    
    public StudentDetail() { }
 
    public StudentDetail(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public List<MarksDetails> getMarksDetails() {
		return marksDetails;
	}

	public void setMarksDetails(List<MarksDetails> marksDetails) {
		this.marksDetails = marksDetails;
	}

	public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPhone() {
        return phone;
    }
 
    public void setPhone(String phone) {
        this.phone = phone;
    }
 
   
}
