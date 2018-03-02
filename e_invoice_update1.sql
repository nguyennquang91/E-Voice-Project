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
	invoice_vat int not null,
	months_invoice int null,
	years_invoice int not null,
	users_id int,
	CONSTRAINT fk_users FOREIGN KEY (users_id) REFERENCES Users(users_id)
)
go
create table Admins(
	admin_id int identity(1,1) primary key,
	admin_password varchar(50) not null
)
go
INSERT INTO Users(users_id, display_name, users_password, users_email, limit_monthly, users_state)
   VALUES (1, 'Thanh tri', 'xyz', 'tri@gmail.com', 5000000, 1);
INSERT INTO Users(users_id, display_name, users_password, users_email, limit_monthly, users_state)
   VALUES (2, 'Thanh tuan', 'abc', 'tuan@gmail.com', 1000000, 1);
INSERT INTO Users(users_id, display_name, users_password, users_email, limit_monthly, users_state)
   VALUES (3, 'Thanh hau', 'def', 'hau@gmail.com', 3000000, 1);
go
INSERT INTO Invoice(invoice_money, invoice_type, invoice_vat, months_invoice, years_invoice, users_id)
   VALUES (1500000, 'Tien nha', '0', 12, 2016, 1);
go
INSERT INTO Invoice(invoice_money, invoice_type, invoice_vat, months_invoice, years_invoice, users_id)
   VALUES (100000, 'Tien nuoc', '0', 12, 2016, 1);
go
INSERT INTO Invoice(invoice_money, invoice_type, invoice_vat, months_invoice, years_invoice, users_id)
   VALUES (200000, 'Tien internet', '0', 12, 2016, 1);
go
INSERT INTO Invoice(invoice_money, invoice_type, invoice_vat, months_invoice, years_invoice, users_id)
   VALUES (2000000, 'Tien nha', '0', 2, 2016, 2);
go
INSERT INTO Invoice(invoice_money, invoice_type, invoice_vat, months_invoice, years_invoice, users_id)
   VALUES (163000, 'Tien dien', '0', 2, 2016, 2);
go
INSERT INTO Invoice(invoice_money, invoice_type, invoice_vat, months_invoice, years_invoice, users_id)
   VALUES (50000, 'Tien nuoc', '0', 2, 2016, 2);
go
INSERT INTO Invoice(invoice_money, invoice_type, invoice_vat, months_invoice, years_invoice, users_id)
   VALUES (200000, 'Tien internet', '0', 4, 2016, 3);
go
INSERT INTO Invoice(invoice_money, invoice_type, invoice_vat, months_invoice, years_invoice, users_id)
   VALUES (150000, 'Tien dien', '0', 4, 2016, 3);
go
INSERT INTO Invoice(invoice_money, invoice_type, invoice_vat, months_invoice, years_invoice, users_id)
   VALUES (50000, 'Tien nuoc', '0', 4, 2016, 3);
go
