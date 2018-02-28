create table Users(
	users_id int identity(1,1) primary key,
	display_name varchar(50) not null,
	users_password varchar(50) not null,
	users_email text not null,
	limit_invoid int null,
	users_state int not null
)
go
create table Invoid(
	invoid_id int identity(1,1) primary key,
	invoid_type varchar(50) not null,
	invoid_money int not null,
	invoid_vat int not null,
	months int null,
	years int not null,
	users_id int FOREIGN KEY REFERENCES Users(users_id)
)
go
create table Admins(
	admin_id int identity(1,1) primary key,
	admin_password varchar(50) not null
)
go
