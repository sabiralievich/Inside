CREATE TABLE IF NOT EXISTS user (
name varchar(20) not null,
password varchar(8) not null,

);

INSERT INTO user (name, password)
VALUES ('test', '123');