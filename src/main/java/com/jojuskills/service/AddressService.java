package com.jojuskills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jojuskills.entity.Address;
import com.jojuskills.repository.AddressRepository;
import com.jojuskills.util.AddressConverter;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	AddressConverter addressConverter;
	
	public String createAddress(Address address) {
		String message=null;
		addressRepository.save(address);
		if(address!=null)
		{
			message="New address saved successfully!!";
		}
		else
		{
			message="Address was not saved!!";
		}
		return message;
	}
	
}
