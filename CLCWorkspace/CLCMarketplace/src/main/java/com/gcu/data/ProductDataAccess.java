package com.gcu.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.repository.ProductsRepository;
import com.gcu.entity.ProductEntity;
import com.gcu.model.ProductRowMapper;

@Service
public class ProductDataAccess implements UserDataAccessInterface<ProductEntity> {
	@Autowired
	private ProductsRepository productsRepository;
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	
	public ProductDataAccess(ProductsRepository ProductsRepository, DataSource dataSource, JdbcTemplate jdbcTemplateObject) {
		this.productsRepository = ProductsRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<ProductEntity> findAll() {
		List<ProductEntity> products = new ArrayList<ProductEntity>();
		
		try {
			Iterable<ProductEntity> productIterable = productsRepository.findAll();
			
			products = new ArrayList<ProductEntity>();
			productIterable.forEach(products::add);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public Optional<ProductEntity> findById(int id) {
	   String sql = """
	           SELECT id, color, size, stock
	           FROM products
	           WHERE id = ?;
	           """;
	   return jdbcTemplateObject.query(sql,new ProductRowMapper(),id)
	           .stream()
	           .findFirst();
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
	public boolean delete(ProductEntity product) {
		String sql = "DELETE FROM products WHERE id = ?";
		try {
			jdbcTemplateObject.update(sql,
					product.getId());
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
