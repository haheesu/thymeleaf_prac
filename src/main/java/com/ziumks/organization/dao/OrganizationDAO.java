package com.ziumks.organization.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.ziumks.organization.model.Organization;

@Component
public class OrganizationDAO {
	
	private final SqlSession sqlSession;

	  public OrganizationDAO(SqlSession sqlSession) {
	    this.sqlSession = sqlSession;
	  }

	  public Organization selectOrganizationById(long id) {
	    return this.sqlSession.selectOne("selectOrganizationById", id);
	  }
}
