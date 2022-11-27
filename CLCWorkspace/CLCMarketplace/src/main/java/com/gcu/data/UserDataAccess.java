package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.repository.UsersRepository;
import com.gcu.entity.UserEntity;

@Service
public class UserDataAccess implements UserDataAccessInterface<UserEntity> {
	@Autowired
	private UsersRepository userRepository;
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	
	public UserDataAccess(UsersRepository userRepository, DataSource dataSource, JdbcTemplate jdbcTemplateObject) {
		this.userRepository = userRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	/*
	public UserDataAccess(UsersRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	*/

	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(UserEntity user) {
		String sql = "INSERT INTO USERS(username, password, email, phoneNumber, firstName, lastName) VALUES(?, ?, ?, ?, ?, ?)";
		try {
			jdbcTemplateObject.update(sql,
					user.getUsername(),
					user.getPassword(),
					user.getEmail(),
					user.getPhoneNumber(),
					user.getFirstName(),
					user.getLastName());
			//this.userRepository.save(new UserEntity("test","test","test","test","test","test"));
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
