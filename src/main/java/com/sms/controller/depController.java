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

import com.sms.bean.Department;
import com.sms.repo.departmentRepo;
@CrossOrigin("http://localhost:3000")
@RestController
public class depController {
    
	
//	@Autowired
	departmentRepo repo; 
	
	
	
	public depController(departmentRepo repo) {
	super();
	this.repo = repo;
}

	@PostMapping("/insertDepartment")
	public String insertDepartment(@RequestBody Department department) {
		String msg = "";
		try {
			repo.save(department); 
			msg="object saved";
		}
		catch(Exception e){
			msg = "Object not saved";
		}
		return msg;
		
	}
	
	 @GetMapping("/getAllDepartment")
	    public List<Department> getAllDepartment() {
	        return (List<Department>) repo.findAll();
	    }
	 
	 @DeleteMapping("/deleteDepartment/{id}")
		public String deleteDepartment(@PathVariable("id") Integer id) {
			String msg = "";
			try {
				repo.deleteById(id);
				msg = "Dep deleted";
			} catch (Exception e) {
				msg = "Dep not found";
			}
			return msg;
		}
		
		@PutMapping("/updateDepartment")
		public String updateDepartment(@RequestBody Department department) {
		    String msg = "";
		    try {
		    	repo.save(department);
		       msg =" Updated succussfully";
		        }
		    catch (Exception e) {
		        msg = "Error updating object" ;
		    }

		    return msg;
		}
		
		

		  @GetMapping("/getDepartment/{id}")
		  public Optional<Department> getDepartmentById(@PathVariable("id") Integer id) {
		    return repo.findById(id);
		  }
	 
	 
	 
}
