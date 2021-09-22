package com.cassandra.example.config;

import org.glassfish.jersey.server.ResourceConfig;

import org.springframework.context.annotation.Configuration;

import com.cassandra.example.controller.EmployeeControllerImpl;

@Configuration
public class JerseyConfiguration extends ResourceConfig {

	public JerseyConfiguration() {
		register(EmployeeControllerImpl.class);

	}

}
