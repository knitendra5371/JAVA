create table IF NOT EXISTS users
(
   id int AUTO_INCREMENT  PRIMARY KEY ,
   first_name VARCHAR(255) NOT NULL,
   last_name VARCHAR(255) NOT NULL,
   email_id VARCHAR(255) NOT NULL
);