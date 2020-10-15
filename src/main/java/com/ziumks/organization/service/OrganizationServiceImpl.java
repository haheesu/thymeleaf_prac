package com.ziumks.organization.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziumks.organization.mapper.OrganizationMapper;
import com.ziumks.organization.model.Organization;

@Service
public class OrganizationServiceImpl implements OrganizationService{

	@Autowired
	private OrganizationMapper orgMapper;
	
	@Override
	public List<Organization> selectOrganizationList(HttpServletRequest request, Organization organization) throws Exception {
		// TODO Auto-generated method stub
		return orgMapper.selectOrganizationList();
	}
	
	@Override
	public int selectOrganizationListCnt(HttpServletRequest request, Organization organization) throws Exception {
		// TODO Auto-generated method stub
		return orgMapper.selectOrganizationListCnt();
	}
}
