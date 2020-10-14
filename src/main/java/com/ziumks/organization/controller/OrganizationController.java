package com.ziumks.organization.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ziumks.organization.mapper.OrganizationMapper;
import com.ziumks.organization.model.Organization;

@RequestMapping("/orgs")
@RestController
public class OrganizationController {
	
	private OrganizationMapper organizationMapper;
	
	public OrganizationController(OrganizationMapper organizationMapper) {
		this.organizationMapper = organizationMapper;
	}
	
	@GetMapping("{id}")
	Organization getOrganization(@PathVariable Long id) {
		return organizationMapper.findById(id);
	}

	
//	@PostMapping("/")
//	public int insertOrganization(@RequestParam(value = "id")Long id, @RequestParam(value = "name")String name) throws Exception{
//		return organizationMapper.insert(id, name);
//	}
}
