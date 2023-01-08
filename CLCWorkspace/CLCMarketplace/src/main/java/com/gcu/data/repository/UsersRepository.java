package com.gcu.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.gcu.entity.UserEntity;
//User repository interface
public interface UsersRepository extends CrudRepository<UserEntity, Long> {
	
}
