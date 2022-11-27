INSERT INTO clc_marketplace.users(username, password, email, phoneNumber, firstName, lastName, enabled)
VALUES ('user','$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG','useremail@email.com','602-555-5555','User','Guy', true);

INSERT INTO clc_marketplace.users(username, password, email, phoneNumber, firstName, lastName, enabled)
VALUES ('admin','$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG','adminemail@email.com','602-555-5555','Admin','Adminguy', true);

INSERT INTO clc_marketplace.users(username, password, email, phoneNumber, firstName, lastName, enabled)
VALUES ('aaron','$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG','adminemail@email.com','602-555-5555','Aaron','Rawley', true);

INSERT INTO clc_marketplace.users(username, password, email, phoneNumber, firstName, lastName, enabled)
VALUES ('patrick','$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG','adminemail@email.com','602-555-5555','Patrick','Quagge', true);

INSERT INTO clc_marketplace.users(username, password, email, phoneNumber, firstName, lastName, enabled)
VALUES ('daniel','$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG','adminemail@email.com','602-555-5555','Daniel','Harder', true);

insert into authorities (username, authority)
  values ('admin', 'ROLE_ADMIN');
insert into authorities (username, authority)
  values ('admin', 'ROLE_USER');
  
insert into authorities (username, authority)
  values ('aaron', 'ROLE_ADMIN');
insert into authorities (username, authority)
  values ('aaron', 'ROLE_USER');
  
insert into authorities (username, authority)
  values ('daniel', 'ROLE_ADMIN');
insert into authorities (username, authority)
  values ('daniel', 'ROLE_USER');

insert into authorities (username, authority)
  values ('patrick', 'ROLE_ADMIN');
insert into authorities (username, authority)
  values ('patrick', 'ROLE_USER');

insert into authorities (username, authority)
  values ('user', 'ROLE_USER');