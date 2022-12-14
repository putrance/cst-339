package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.entity.ProductEntity;
import com.gcu.entity.UserEntity;
//Class for row mapping products to display correctly on web site
public class ProductsRowMapper implements RowMapper<ProductEntity> {

	@Override
	public ProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new ProductEntity(rs.getString("color"), rs.getString("size"), rs.getInt("stock"), rs.getInt("id"));
	}

}
