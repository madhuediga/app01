package com.cassandra.example.controller;


import javax.ws.rs.Consumes;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;

import com.cassandra.example.model.Employee;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Controller
@Path("/api")
public interface EmployeeController {

	
	
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/users")
	@ApiResponses(value = {		//Swagger Annotation
			@ApiResponse(code = 200, message = "Resource found"),
		    @ApiResponse(code = 404, message = "Resource not found")
		})
	public Response createUser(Employee employee) ;
	
	@GET
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/users/{id}")
	@ApiResponses(value = {		//Swagger Annotation
			@ApiResponse(code = 200, message = "Resource found"),
		    @ApiResponse(code = 404, message = "Resource not found")
		})
	public Response findById(@PathParam(value = "id") int id) ;
	
	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/update/{id}")
	@ApiResponses(value = {		//Swagger Annotation
			@ApiResponse(code = 200, message = "Resource found"),
		    @ApiResponse(code = 404, message = "Resource not found")
		})
	public Response upadate(Employee employee,@PathParam(value = "id")int id);
	
	@DELETE
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/delete/{id}")
	@ApiResponses(value = {		//Swagger Annotation
			@ApiResponse(code = 200, message = "Resource found"),
		    @ApiResponse(code = 404, message = "Resource not found")
		})
	public Response delete(@PathParam(value = "id")int id);
}
