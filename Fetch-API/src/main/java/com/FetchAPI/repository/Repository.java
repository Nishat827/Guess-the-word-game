package com.FetchAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FetchAPI.dao.Employee;

public interface Repository extends JpaRepository<Employee, Integer>{

}
