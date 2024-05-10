package com.sms.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sms.bean.Student;
import com.sms.repo.studentRepo;

@CrossOrigin("http://localhost:3000")
@RestController
public class StudentController {

//	@Autowired
	studentRepo repo; 

	@PostMapping("/insertStudent")
	public String InsertStudent(@RequestBody Student student) {
		String msg = "";
		try {
			repo.save(student);
			msg = "Object Saved";
		} catch (Exception e) {
			
			msg = "Object Not Saved";
		}
		return msg;
	}

	@GetMapping("/getAllStudent")
	public List<Student> getAllStudent(){
		List<Student> List = (List<Student>) repo.findAll();
		return List;
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable("id") Integer id) {
		String msg = "";
		try {
			repo.deleteById(id);
			msg = "Student deleted";
		} catch (Exception e) {
			msg = "Student not found";
		}
		return msg;
	}
	
	@PutMapping("/updateStudent/{id}")
	public String updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
	    String msg = "";
	    try {
	        Optional<Student> optionalStudent = repo.findById(id);
	        if (optionalStudent.isPresent()) {
	            Student existingStudent = optionalStudent.get();
	            existingStudent.setName(student.getName());
	            existingStudent.setAge(student.getAge());
	            existingStudent.setDepartment(student.getDepartment());
	            repo.save(existingStudent);
	            msg = "Updated Object Saved";
	        } else {
	            msg = "Student with id " + id + " not found";
	        }
	    } catch (Exception e) {
	        msg = "Error updating object: " + e.getMessage();
	    }

	    return msg;
	}
	
	

	  @GetMapping("/getStudent/{id}")
	  public Student getStudentById(@PathVariable("id") Integer id) {
	    return repo.findById(id).orElseThrow(() -> new RuntimeException("No student found with ID: " + id));
	  }

	 
	}


