create table if not exists users (
  id int primary key AUTO_INCREMENT,
  name VARCHAR(100),
  email VARCHAR(100)
);

create table if not exists publishers (
  id int primary key AUTO_INCREMENT,
  name VARCHAR(100),
  address VARCHAR(200)
);
