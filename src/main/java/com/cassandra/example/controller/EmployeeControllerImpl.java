package com.cassandra.example.controller;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cassandra.example.model.Employee;
import com.cassandra.example.repositery.EmployeeRepositery;

@Component
public class EmployeeControllerImpl implements EmployeeController {

	@Autowired
	private EmployeeRepositery repo;

	@Override
	public Response createUser(Employee employee) {
		employee.setId(ThreadLocalRandom.current().nextInt(9999999));
		repo.save(employee);
		return Response.status(Status.OK).build();
	}

	@Override
	public Response findById(int id) {
		Optional<Employee> find = repo.findById(id);
		if (find.isPresent()) {
			Employee emp = find.get();
			return Response.status(Status.OK).entity(emp).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@Override
	public Response upadate(Employee employee, int id) {
		Optional<Employee> find = repo.findById(id);
		if (find.isPresent()) {
			Employee _emp = find.get();
			_emp.setFirstName(employee.getFirstName());
			_emp.setLastName(employee.getLastName());
			_emp.setEmailId(employee.getEmailId());
			_emp.setPhoneNumber(employee.getPhoneNumber());
			repo.save(_emp);
			return Response.status(Status.ACCEPTED).build();
		}

		return Response.status(Status.INTERNAL_SERVER_ERROR).build();
	}

	@Override
	public Response delete(int id) {
		Optional<Employee> find = repo.findById(id);
		if(find.isPresent()){
		repo.deleteById(id);
		return Response.status(Status.OK).build();
		}
		return Response.status(Status.BAD_REQUEST).build();
	}

}
