package com.ziumks.organization.repository;

import java.util.List;
import java.util.Optional;

import com.ziumks.organization.model.Organization;

public interface OrganizationRepository {
	
	int count();
	
	int save(Organization organization);
	
	int update(Organization organization);
	
	int deleteById(Long id);
	
	List<Organization> findAll();
	
	Optional<Organization> findById(Long id);
	
	String getNameById(Long id);

	List<Organization> findByName(String name);
}
