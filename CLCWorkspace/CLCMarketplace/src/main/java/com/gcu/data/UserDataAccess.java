package com.gcu.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.repository.UsersRepository;
import com.gcu.entity.UserEntity;

@Service
public class UserDataAccess implements UserDataAccessInterface<UserEntity> {
	@Autowired
	private UsersRepository userRepository;
		
	public UserDataAccess(UsersRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

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
		try {
			this.userRepository.save(user);
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
