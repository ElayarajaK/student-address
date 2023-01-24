package com.jojuskills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jojuskills.entity.Address;
import com.jojuskills.model.AddressDTO;
import com.jojuskills.service.AddressService;
import com.jojuskills.util.AddressConverter;

@RestController
@RequestMapping("/api")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private AddressConverter addressConverter;
	
	@PostMapping("/createAddress")
	public String createAddress(@RequestBody AddressDTO addressDTO)
	{
		final Address address= addressConverter.convertToAddressEntity(addressDTO);
		return addressService.createAddress(address);
	}

}
