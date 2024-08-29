package com.mydemo.crudapp.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mydemo.crudapp.Model.Student;
import com.mydemo.crudapp.Response.AddressResponse;
import com.mydemo.crudapp.Response.StudentResponse;
import com.mydemo.crudapp.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
    StudentRepository studentrepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	RestTemplate resttemplate;
	
	public List<StudentResponse> getAllStudent(){
		
		
		List<Student> student_list = studentrepo.findAll();
		if (student_list != null) {
		  List<StudentResponse> student_responselist = student_list.stream()
		      .map(student -> modelmapper.map(student, StudentResponse.class))
		      .collect(Collectors.toList());
		  return student_responselist;
		} else {
		  // Handle empty list scenario (optional: return an empty list or a specific message)
		  return Collections.emptyList();
		}
		
	  
	} 
	
	public StudentResponse getStudentdetailByRollNo(int id){
		
		
		Student student = studentrepo.findById(id).get();
		if (student != null) {
		StudentResponse studentresponse = modelmapper.map(student, StudentResponse.class);
		return studentresponse;
		}
		else {
			 return null;
		}
	} 
	
	public StudentResponse createStudentRecord(Student student ){
		
		
		Student student1 = studentrepo.save(student);
		if (student1 != null) {
		StudentResponse studentresponse = modelmapper.map(student, StudentResponse.class);
		return studentresponse;
		}
		else {
			 return null;
		}
	} 
	
	public StudentResponse updateStudentRecord(int id, Student updatestudent ){
		
		Student existingStudent = studentrepo.findById(id).get();
		existingStudent.setBranch(updatestudent.getBranch());
		existingStudent.setName(updatestudent.getName());
		studentrepo.save(existingStudent);
		if (existingStudent != null) {
		StudentResponse studentresponse = modelmapper.map(existingStudent, StudentResponse.class);
		return studentresponse;
		}
		else {
			return null;
		}
		
	}
	
	public StudentResponse deleteStudentRecord(int id ){
		
		
		Student student1 = studentrepo.findById(id).get();
		studentrepo.delete(student1);
		if (student1 != null) {
		StudentResponse studentresponse = modelmapper.map(student1, StudentResponse.class);
		return studentresponse;
		}
		else {
			 return null;
		}
	} 
	
	
	public StudentResponse getStudentdetailByRollNoWithAddress(int id){
		
		AddressResponse addressResponse = resttemplate.getForObject("http://localhost:8086/address-app/api/address/{student_id}", AddressResponse.class, id);
		
		Student student = studentrepo.findById(id).get();

		StudentResponse studentresponse = modelmapper.map(student, StudentResponse.class);
		
		
		
		studentresponse.setAddressResponse(addressResponse);
		return studentresponse;
		
		
	} 
	
	

}
