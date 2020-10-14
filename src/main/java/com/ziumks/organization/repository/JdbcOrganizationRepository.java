package com.ziumks.organization.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ziumks.organization.model.Organization;

@Repository
public class JdbcOrganizationRepository implements OrganizationRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return jdbcTemplate
				.queryForObject("select id(*) from test_mysql", Integer.class);
	}
	
	@Override
	public int save(Organization organization) {
		return jdbcTemplate.update(
				"insert into test_mysql (id, name) values(?,?)",
				organization.getId(), organization.getName());
	}
	
	@Override
	public int update(Organization organization) {
		return jdbcTemplate.update(
				"update test_mysql set name = ? where id = ?",
				organization.getName(), organization.getId());
	}
	
	@Override
	public int deleteById(Long id) {
		return jdbcTemplate.update(
				"delete test_mysql where id = ?",
				id);
	}
	
	@Override
	public List<Organization> findAll(){
		return jdbcTemplate.query(
				"select * from test_mysql",
				(rs, rowNum) -> 
						new Organization(
								rs.getLong("id"),
								rs.getString("name")
						)
				);
	}
	
	// jdbcTemplate.queryForObject, populates a single object
	@Override
	public Optional<Organization> findById(Long id){
		return jdbcTemplate.queryForObject(
				"select * from test_mysql where id = ?",
				new Object[] {id},
				(rs, rowNum) ->
					Optional.of(new Organization(
							rs.getLong("id"),
							rs.getString("name")
					))
		);
	}
	
	@Override
    public List<Organization> findByName(String name) {
        return jdbcTemplate.query(
                "select * from books where name like ?",
                new Object[] {"%" + name + "%"},
                (rs, rowNum) ->
                        new Organization(
                                rs.getLong("id"),
                                rs.getString("name")
                        )
        );
    }

    @Override
    public String getNameById(Long id) {
        return jdbcTemplate.queryForObject(
                "select name from test_mysql where id = ?",
                new Object[]{id},
                String.class
        );
    }
}
