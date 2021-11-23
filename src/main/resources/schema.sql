CREATE TABLE IF NOT EXISTS user (
name varchar(20) not null,
password varchar(8) not null,
)
DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS message (
id identity,
name varchar(20) not null,
text varchar(255) not null,

)
DEFAULT CHARSET=utf8;


