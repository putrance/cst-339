package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.repository.ProductsRepository;
import com.gcu.data.repository.UsersRepository;
import com.gcu.entity.ProductEntity;
import com.gcu.entity.UserEntity;

@Service
public class ProductDataAccess implements UserDataAccessInterface<ProductEntity> {
	@Autowired
	private ProductsRepository ProductsRepository;
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	
	public ProductDataAccess(ProductsRepository ProductsRepository, DataSource dataSource, JdbcTemplate jdbcTemplateObject) {
		this.ProductsRepository = ProductsRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<ProductEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(ProductEntity product) {
		String sql = "INSERT INTO products(color, size, stock) VALUES(?, ?, ?)";
		try {
			jdbcTemplateObject.update(sql,
					product.getColor(),
					product.getSize(),
					product.getStock());
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(ProductEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ProductEntity t) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
