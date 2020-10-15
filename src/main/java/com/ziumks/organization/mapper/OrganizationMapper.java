package com.ziumks.organization.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ziumks.organization.model.Organization;

@Mapper
public interface OrganizationMapper {

	int selectOrganizationListCnt() throws Exception;
	
	List<Organization> selectOrganizationList() throws Exception;
}
