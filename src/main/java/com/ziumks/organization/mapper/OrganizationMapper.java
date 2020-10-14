package com.ziumks.organization.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ziumks.organization.model.Organization;

@Mapper
public interface OrganizationMapper {
	@Select("select id, name from test_mysql where id = #{id}")
	Organization findById(@Param("id") Long id);
	
//	@Insert("insert into test_mysql (id, name) values (#{id}, #{name})")
//	int insert(@Param("id") Long id, @Param("name") String name);
}
