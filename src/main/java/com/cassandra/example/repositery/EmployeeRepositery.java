package com.cassandra.example.repositery;

import org.springframework.data.cassandra.repository.CassandraRepository;

import org.springframework.stereotype.Repository;

import com.cassandra.example.model.Employee;

@Repository
public interface EmployeeRepositery extends CassandraRepository<Employee, Integer> {

}
