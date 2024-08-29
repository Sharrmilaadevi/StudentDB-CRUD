package com.mydemo.crudapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mydemo.crudapp.Model.Student;
import com.mydemo.crudapp.Response.StudentResponse;
import com.mydemo.crudapp.Service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	// Get the list of all students
	
	@GetMapping("/students")
	public ResponseEntity<List<StudentResponse>> getAllStudent(){
		List<StudentResponse> student_list= studentService.getAllStudent();
	
		return ResponseEntity.status(HttpStatus.OK).body(student_list);
		
	}
	
	
	// Get the STudent detail based on RollNo
	
	
	@GetMapping("/students/{id}")
	public ResponseEntity<StudentResponse> getStudentDetailByRollno(@PathVariable int id){
		StudentResponse student= studentService.getStudentdetailByRollNo(id);
	
		return ResponseEntity.status(HttpStatus.OK).body(student);
		
	} 
	
	//Add a new student record
	@PostMapping("/students/add")
	public ResponseEntity<String> createStudentRecord(@RequestBody Student student) {
		
		StudentResponse studentResponse= studentService.createStudentRecord(student);
		
		String message ="student record created with id: "+studentResponse.getRollno()+" for "+studentResponse.getName();
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
		
	}

	
	//update the stduentdetail based on Id
	@PutMapping("/students/update/{id}")
	public ResponseEntity<StudentResponse> updateStudentRecord(@PathVariable int id, @RequestBody Student student) {
		
		StudentResponse studentResponse=studentService.updateStudentRecord(id,student);
	
		return ResponseEntity.status(HttpStatus.OK).body(studentResponse);
	}
	
	@DeleteMapping("/students/delete/{id}")
	public ResponseEntity<StudentResponse> deleteStudentRecord(@PathVariable int id) {
		
		StudentResponse studentResponse=studentService.deleteStudentRecord(id);
	
		return ResponseEntity.status(HttpStatus.OK).body(studentResponse);
	}
	
	@GetMapping("/studentwithaddress/{id}")
	public ResponseEntity<StudentResponse> getStudentdetailByRollNoWithAddress(@PathVariable int id){
		
		StudentResponse studentResponse=studentService.getStudentdetailByRollNoWithAddress(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(studentResponse);
	}
}
