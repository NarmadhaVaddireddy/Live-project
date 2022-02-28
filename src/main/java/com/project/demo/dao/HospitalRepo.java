package com.project.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.project.demo.entity.Hospital;

public interface HospitalRepo extends CrudRepository<Hospital, Integer>{

}
