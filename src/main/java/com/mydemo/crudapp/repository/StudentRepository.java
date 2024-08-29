package com.mydemo.crudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mydemo.crudapp.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	

}
