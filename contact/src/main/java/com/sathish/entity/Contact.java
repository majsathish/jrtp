package com.sathish.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="CONTACT_DETAILS")
public class Contact {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CONTACT_ID")
	@Id
	private Integer conId;

	@Column(name="CONTACT_NAME")
	private String name;
	
	@Column(name="CONTACT_EMAIL")	
	private String email;
	
	@Column(name="CONTACT_NUMBER")	
	private Integer conNumber;
	
	
}
