package com.gcu.data;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.repository.UsersRepository;
import com.gcu.entity.ProductEntity;
import com.gcu.entity.UserEntity;
//User data access service class
@Service
public class UserDataAccess implements UserDataAccessInterface<UserEntity> {
	//Variables
	@Autowired
	private UsersRepository userRepository;
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	//constructor
	public UserDataAccess(UsersRepository userRepository, DataSource dataSource, JdbcTemplate jdbcTemplateObject) {
		this.userRepository = userRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	//find all users method
	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	//find users by user ID
	@Override
	public Optional<ProductEntity> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	//create new user method
	@Override
	public boolean create(UserEntity user) {
		String sql = "INSERT INTO USERS(username, password, email, phoneNumber, firstName, lastName) VALUES(?, ?, ?, ?, ?, ?)";
		String sql_authorities_user = "INSERT INTO authorities(username, authority) VALUES(?, ?)";
		try {
			jdbcTemplateObject.update(sql,
					user.getUsername(),
					user.getPassword(),
					user.getEmail(),
					user.getPhoneNumber(),
					user.getFirstName(),
					user.getLastName());

			//this.userRepository.save(new UserEntity("test","test","test","test","test","test"));
			
			jdbcTemplateObject.update(sql_authorities_user,
					user.getUsername(),
					user.getAuthority());
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//update users
	@Override
	public boolean update(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}
	//delete users
	@Override
	public boolean delete(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
