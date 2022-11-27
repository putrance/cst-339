package com.gcu.entity;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public class UserEntity {
	@Column("firstName")
	private String firstName;
	@Column("lastName")
	private String lastName;
	@Column("email")
	private String email;
	@Column("phoneNumber")
	private String phoneNumber;
	@Column("username")
	private String username;
	@Column("password")
	private String password;
	public UserEntity(String firstName, String lastName, String email, String phoneNumber, String username,
			String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
	}
}
