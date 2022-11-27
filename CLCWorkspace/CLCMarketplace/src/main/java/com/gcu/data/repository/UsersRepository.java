package com.gcu.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.gcu.entity.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {

}
