package com.ziumks.organization.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ziumks.organization.model.Organization;
@Repository
public class NamedParameterJdbcOrganizationRepository extends JdbcOrganizationRepository{
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public int update(Organization organization) {
		return namedParameterJdbcTemplate.update(
				"update test_mysql set name = :name where id = :id",
				new BeanPropertySqlParameterSource(organization));
	}
	
	@Override
	public int save(Organization organization) {
		return namedParameterJdbcTemplate.update(
				"insert into test_mysql (id, name) values (:id, :name)",
				new BeanPropertySqlParameterSource(organization));
	}
	
	@Override
	public int deleteById(Long id) {
		return namedParameterJdbcTemplate.update(
				"delete from test_mysql where id = :id",
				new MapSqlParameterSource()
			      .addValue("id", id));
	}
	
	@Override
	public Optional<Organization> findById(Long id){
		return namedParameterJdbcTemplate.queryForObject(
				"select * from test_mysql where id = :id", 
				new MapSqlParameterSource("id", id), 
				(rs, rowNum) -> 
					Optional.of(new Organization(
								rs.getLong("id"),
								rs.getString("name")
					))
		);
	}
	
	@Override
    public List<Organization> findByName(String name) {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("name", "%" + name + "%");

        return namedParameterJdbcTemplate.query(
                "select * from test_mysql where name like :name",
                mapSqlParameterSource,
                (rs, rowNum) ->
                        new Organization(
                                rs.getLong("id"),
                                rs.getString("name")
                        )
        );
	}
	
}
