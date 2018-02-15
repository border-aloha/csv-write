package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<CurryUser> findAll() {
		String sql = "SELECT * FROM CURRY_USER";
		RowMapper<CurryUser> rowMapper = new RowMapper<CurryUser>() {
			@Override
			public CurryUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				CurryUser entity = new CurryUser();
				entity.setId(rs.getLong("ID"));
				entity.setName(rs.getString("NAME"));
				entity.setCurry(rs.getString("CURRY"));
				return entity;
			}
		};
		RowMapperResultSetExtractor<CurryUser> rse = new RowMapperResultSetExtractor<>(rowMapper);
		List<CurryUser> list = (List<CurryUser>) jdbcTemplate.query(sql, rse);
		return list;
	}

}
