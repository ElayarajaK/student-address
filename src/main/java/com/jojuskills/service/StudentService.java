package com.jojuskills.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jojuskills.entity.Student;
import com.jojuskills.exception.ResourceNotFoundException;
import com.jojuskills.model.StudentDTO;
import com.jojuskills.repository.AddressRepository;
import com.jojuskills.repository.StudentRepository;
import com.jojuskills.util.Converter;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@SuppressWarnings("unused")
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private Converter converter;
	
	
	public String createStudent(Student student) {
		String message=null;
		studentRepository.save(student);
		if(student!=null)
		{
			message="Student details saved successfully";
		}
		return message;
	}
	
	public StudentDTO updateStudent(int id, Student student) {
		Student existingStudent =studentRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Student", "ID", id));
		existingStudent.setStudentName(student.getStudentName());
		existingStudent.setPhone(student.getPhone());
		existingStudent.setEmail(student.getEmail());
		
		studentRepository.save(existingStudent);
		
		return converter.convertToStudentDTO(existingStudent);
	}
	
	public StudentDTO getStudentById(int id) {
		Student getS = studentRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Student", "ID", id));
		return converter.convertToStudentDTO(getS);
	}
	
	public List<StudentDTO> getAllStudents() {
		List<Student> students=studentRepository.findAll();
		
		List<StudentDTO> sDTO = new ArrayList<>();
		for(Student s: students)
		{
			sDTO.add(converter.convertToStudentDTO(s));
		}
		return sDTO;
	}
	
	public String deleteStudentById(int id) {
		String message = null;
		java.util.Optional<Student> student= studentRepository.findById(id);
		if(student.isPresent())
		{
			studentRepository.deleteById(id);
			message = "Student details deleted successfully";
		}
		else
		{
			message="Student details not found!!";
		}
		return message;
	}

	public StudentDTO assignAddressToStudent(int id, int addressId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StudentDTO> getStudentByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StudentDTO> getStudentByName(String studentName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteAllStudents() {
		// TODO Auto-generated method stub
		
	}

}
