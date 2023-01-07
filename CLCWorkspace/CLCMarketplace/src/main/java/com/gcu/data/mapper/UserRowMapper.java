package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.entity.UserEntity;
//Class for row mapping users to be displayed correctly on live web site
public class UserRowMapper implements RowMapper<UserEntity> {

	@Override
	public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new UserEntity(rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"), rs.getString("phoneNumber"), rs.getString("userName"), rs.getString("password"));
	}

}
