create table Users(
	users_id int identity(1,1) primary key,
	display_name varchar(50) not null,
	users_password varchar(50) not null,
	users_email text not null,
	limit_monthly int null,
	users_state int not null
)
go
create table Invoice(
	invoice_id int identity(1,1) primary key,
	invoice_type varchar(50) not null,
	invoice_money int not null,
	invoid_vat int not null,
	months int null,
	years int not null,
	users_id int,
	CONSTRAINT fk_users FOREIGN KEY (users_id) REFERENCES Users(users_id)
)
go
create table Admins(
	admin_id int identity(1,1) primary key,
	admin_password varchar(50) not null
)
go
