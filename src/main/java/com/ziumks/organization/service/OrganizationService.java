package com.ziumks.organization.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ziumks.organization.model.Organization;

public interface OrganizationService {
	
	public int selectOrganizationListCnt(HttpServletRequest request, Organization organization) throws Exception;
	
	public List<Organization> selectOrganizationList(HttpServletRequest request, Organization organization) throws Exception;
}
