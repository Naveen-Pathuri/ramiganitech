package com.example.RamiganiTech.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Ramigani {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name=" id")
    private long id;  
    private long Sno; 

    private String firstName;
    private String email;
    private String organisation;
    
    
    
    private String phone;
    private String region;
    private String inquirytype;
    private String message;
    
    public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	private String locality;

   

	public long getSno() {
        return Sno;
    }

    public void setSno(long sno) {
        Sno = sno;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getInquirytype() {
        return inquirytype;
    }

    public void setInquirytype(String inquirytype) {
        this.inquirytype = inquirytype;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
  
}
