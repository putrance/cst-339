create table users(
	username varchar(50) not null primary key,
	password varchar(500) not null,
	`email` varchar(45) DEFAULT NULL,
	`phoneNumber` varchar(45) DEFAULT NULL,
	`firstName` varchar(45) DEFAULT NULL,
	`lastName` varchar(45) DEFAULT NULL,
	enabled boolean not null
);

create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);