package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.entity.ProductEntity;

// Row mapper for the product entity
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
