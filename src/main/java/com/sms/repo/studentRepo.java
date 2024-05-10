package com.sms.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sms.bean.Student;

@Repository
public interface studentRepo extends CrudRepository<Student, Integer>  {

}