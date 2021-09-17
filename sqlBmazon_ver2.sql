--CREATE DATABASE Bmazon

USE master
GO
alter database [Bmazon] set single_user with rollback immediate
if exists (select * from sysdatabases where name='Bmazon') drop database Bmazon
GO

CREATE DATABASE Bmazon
GO

USE Bmazon
GO

CREATE TABLE [User] (
--private profile
	userID int NOT NULL identity(1,1) PRIMARY KEY,
	username nvarchar(255) NOT NULL,
	[password] nvarchar(255) NOT NULL,
	email nvarchar(255),
	phoneNumber nvarchar(255),
	sell bit,
	wallet money,
	--public profile
	fullname nvarchar(255),
	[address] nvarchar(255),
	profileImage nvarchar(255),
	gender bit,
	DOB date NOT NULL CHECK(DOB <= getDate()),
	bio nvarchar(255),
	Facebook nvarchar(255),
	Instagram nvarchar(255),
	Twitter nvarchar(255),
	Youtube nvarchar(255),
	--system profile
	activityPoint int CHECK(activityPoint>=0),
	systemRole int CHECK(systemRole>=0),
	[status] bit
)


CREATE TABLE [Category] (
	categoryID int NOT NULL identity(1,1) PRIMARY KEY,
	categoryName nvarchar(255) NOT NULL,
	[status] bit
)

--Toi di code dao <- Code Book <- Book
CREATE TABLE [Genre] (
	genreID int NOT NULL identity(1,1) PRIMARY KEY,
	genreName nvarchar(255) NOT NULL,
	categoryID int NOT NULL,
	[status] bit,
	FOREIGN KEY (categoryID) REFERENCES [Category]([categoryID])
)

-- co 1 bang Company
CREATE TABLE [Warehouse](
	wareHouseID int NOT NULL PRIMARY KEY,
	wareHouseAddress nvarchar(255),
	wareHouseCity nvarchar(255),
	[status] bit,
)
CREATE TABLE [Product] (
	productID int NOT NULL identity(1,1) PRIMARY KEY,
	productName nvarchar(255) NOT NULL,
	[description] nvarchar(max),
	rating int,
	releaseDate date NOT NULL CHECK(releaseDate <= getDate()),
	seller int,
	[status] bit,
	FOREIGN KEY (seller) REFERENCES [User](userID),
)
CREATE TABLE Comment (
	productID int,
	userID int,
	content nvarchar(255),
	FOREIGN KEY (productID) REFERENCES [Product] (productID),
	FOREIGN KEY (userID) REFERENCES [User](userID),
)
CREATE TABLE [ProductGenre] (
	productID int,
	genreID int,
	[status] bit,
	FOREIGN KEY (productID) REFERENCES [Product] (productID),
	FOREIGN KEY (genreID) REFERENCES [Genre] (genreID),
)

CREATE Table [ProductCategory] (
	productID int,
	categoryId int,
	[status] bit,
	FOREIGN KEY (productID) REFERENCES [Product] (productID),
	FOREIGN KEY (categoryID) REFERENCES [Category] (categoryID),
)

CREATE TABLE [ProductType] (
	productTypeId nvarchar(255) PRIMARY KEY,
	productID int NOT NULL,
	size nvarchar(255),
    color nvarchar(255),
    price money NOT NULL CHECK (price>=0),
	wareHouseID int NOT NULL,
	quantity int NOT NULL CHECK (quantity>=0),
	[status] bit,
	FOREIGN KEY (productID) REFERENCES [Product](productID),
	FOREIGN KEY (wareHouseID) REFERENCES [Warehouse](wareHouseID)
)

CREATE TABLE ShipCompany (
	companyID int identity(1,1) PRIMARY KEY,
	companyName nvarchar(255),
	unitCost money,
	commitDate int CHECK (commitDate>=0),
	[status] bit,
)

CREATE TABLE Gallery (
	galleryID int identity(1,1) PRIMARY KEY, 
	productID int NOT NULL,
	productTypeID nvarchar(255) NOT NULL,
	link nvarchar(255) NOT NULL,
	[status] bit,
	FOREIGN KEY (productID) REFERENCES [Product](productID),
	FOREIGN KEY (productTypeID) REFERENCES [ProductType](productTypeID)
)

CREATE TABLE [Order](
    orderID int identity(1,1) primary key,
    userID int not null,
    orderDate datetime NOT NULL CHECK(orderDate <= getDate()),
    requiredDate datetime not null CHECK(requiredDate <= getDate()),
    shippedDate datetime not null CHECK(shippedDate <= getDate()),
    shipName nvarchar(255),
    shipAddress nvarchar(255),
    shipCity nvarchar(255),
    shipPhone nvarchar(255),
    companyID int,
    shipMoney nvarchar(255),
    paymentMethod nvarchar(50),
    total money NOT NULL CHECK (total>=0),
	[status] bit,
    FOREIGN KEY (userID) references [User](userID),
    FOREIGN KEY (companyID) references [ShipCompany](companyID),
)

CREATE TABLE OrderDetail(
    orderID int not null,
    productTypeID nvarchar(255) not null,
    primary key(orderID, productTypeID),
    productName nvarchar(255) not null,
    price money NOT NULL CHECK (price>=0),
    quantity int not null CHECK (quantity>=0),
	[status] bit,
    FOREIGN KEY (orderID) references [Order](orderID),
    FOREIGN KEY (productTypeID) references [ProductType](productTypeID),
)
DBCC CHECKIDENT ('dbo.Product', RESEED, 1)

DBCC CHECKIDENT ('dbo.Genre', RESEED, 1)