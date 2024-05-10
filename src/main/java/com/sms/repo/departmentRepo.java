package com.sms.repo;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sms.bean.Department;

@Repository
public interface departmentRepo extends CrudRepository<Department, Integer> { 
	
}