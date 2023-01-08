package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.entity.ProductEntity;
//Create Product row mapper to allow for querying of product rows via ID
public class ProductRowMapper implements RowMapper<ProductEntity> {

	@Override
	public ProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new ProductEntity(
				rs.getString("color"),
				rs.getString("size"),
				rs.getInt("stock"),
				rs.getInt("id")
				);
	}

}
