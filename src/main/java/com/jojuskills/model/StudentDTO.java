package com.jojuskills.model;

import com.jojuskills.entity.Address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {

	private int id;
	private String studentName;
	private long phone;
	private String email;
	
	private Address address;
}