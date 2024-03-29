USE master
GO
alter database [Bmazon] set single_user with rollback immediate
if exists (select * from sysdatabases where name='Bmazon') drop database Bmazon
GO

CREATE DATABASE Bmazon
GO

USE Bmazon
GO

CREATE TABLE [Role] (
	roleID int PRIMARY KEY NOT NULL,
	roleName nvarchar(255),
	adminPermission bit,
	sellerPermission bit,
	customerPermission bit,
	[status] bit,
)

CREATE TABLE [User] (
--private profile
	userID int NOT NULL identity(1,1) PRIMARY KEY,
	username nvarchar(255) NOT NULL,
	[password] nvarchar(255) NOT NULL,
	email nvarchar(255),
	phoneNumber nvarchar(255),
	sell int,
	wallet money,
	--public profile
	fullname nvarchar(255),
	publicName nvarchar(255),
	[address] nvarchar(255),
	profileImage nvarchar(255),
	backgroundImage nvarchar(255),
	occupation nvarchar(255),
	gender bit,
	DOB date CHECK(DOB <= getDate()),
	bio nvarchar(255),
	Facebook nvarchar(255),
	Instagram nvarchar(255),
	Twitter nvarchar(255),
	Youtube nvarchar(255),
	--system profile
	activityPoint int CHECK(activityPoint>=0),
	systemRole int,
	[status] bit,
	FOREIGN KEY (systemRole) REFERENCES Role([roleID])
)

CREATE TABLE [Category] (
	categoryID int NOT NULL identity(1,1) PRIMARY KEY,
	categoryName nvarchar(255) NOT NULL,
	[status] bit
)

CREATE TABLE Seller (
	sellerID int not null identity(1, 1) PRIMARY KEY,
	userID int not null,
	sellerShopName nvarchar(255),
	sellerPhone nvarchar(255) not null,
	evidence nvarchar(255) not null,
	sellerMainProduct int,
	[description] nvarchar(255),
	sellerVerification int,
	backGroundImage nvarchar(255),
	avatar nvarchar(255),
	[status] bit,
	FOREIGN KEY ([userID]) REFERENCES [User]([userID]),
	FOREIGN KEY (sellerMainProduct) REFERENCES Category([categoryID])
)

--Toi di code dao <- Code Book <- Book
CREATE TABLE [Genre] (
	genreID int NOT NULL identity(1,1) PRIMARY KEY,
	genreName nvarchar(255) NOT NULL,
	categoryID int NOT NULL,
	images nvarchar(255),
	[status] bit,
	FOREIGN KEY (categoryID) REFERENCES [Category]([categoryID])
)

-- co 1 bang Company
CREATE TABLE [Warehouse](
	wareHouseID int NOT NULL identity(1,1) PRIMARY KEY,
	wareHouseAddress nvarchar(255) not null,
	[status] bit,
)

CREATE TABLE [Product] (
	productID int NOT NULL identity(1,1) PRIMARY KEY,
	productName nvarchar(255) NOT NULL,
	[description] nvarchar(max),
	rating real,
	releaseDate date NOT NULL CHECK(releaseDate <= getDate()),
	sellerID int NOT NULL,
	[status] bit,
	FOREIGN KEY (sellerID) REFERENCES [Seller](sellerID),
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
	companyID int not null identity(1,1) PRIMARY KEY,
	companyName nvarchar(255) not null,
	unitCost money,
	commitDate int CHECK (commitDate>=0),
	[status] bit,
)

CREATE TABLE Gallery (
	galleryID int NOT NULL IDENTITY(1,1) PRIMARY KEY , 
	productID int NOT NULL,
	productTypeID nvarchar(255) NOT NULL,
	link nvarchar(255) NOT NULL,
	[status] bit,
	FOREIGN KEY (productID) REFERENCES [Product](productID),
	FOREIGN KEY (productTypeID) REFERENCES [ProductType](productTypeId)
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
    shipMoney money,
    paymentMethod nvarchar(50),
    total money NOT NULL CHECK (total>=0),
	[state] int,
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

CREATE TABLE [Comment](
	commentID int not null identity(1,1) PRIMARY KEY,
	productID int not null,
	[userId] int not null,
	content nvarchar(max),
	rating real not null CHECK(rating >= 0 AND rating <= 5),
	[status] bit,
	FOREIGN KEY ([userId]) REFERENCES dbo.[User]([userId]),
	FOREIGN KEY ([productID]) REFERENCES [Product]([productID])

)

CREATE TABLE [Transaction] (
	transactionID int not null PRIMARY KEY identity(1,1),
	userID int not null,
	pin nvarchar(25),
	[money] money,
	[history] datetime,
	[state] int, 
	[status] bit,
	FOREIGN KEY (userID) REFERENCES [User](userID) 
)