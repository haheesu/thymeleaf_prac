package com.ziumks.organization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ziumks.organization.mapper.OrganizationMapper;

@SpringBootApplication
public class OrganizationServiceApplication {
	
//	private final OrganizationMapper organizationMapper;
//	
//	public OrganizationServiceApplication(OrganizationMapper organizationMapper) {
//		this.organizationMapper = organizationMapper;
//	}

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
