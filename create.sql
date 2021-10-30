CREATE TABLE `Role` (
	roleID int UNSIGNED PRIMARY KEY NOT NULL,
	roleName varchar(255),
	adminPermission bit,
	sellerPermission bit,
	customerPermission bit,
	status bit
);

CREATE TABLE `User` (
	userID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	username varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	email varchar(255),
	phoneNumber varchar(255),
	sell int,
	wallet double,	
	fullname varchar(255),
	publicName varchar(255),
	address varchar(255),
	profileImage varchar(255),
	backgroundImage varchar(255),
	occupation varchar(255),
	gender bit,
	DOB date ,
	bio varchar(255),
	Facebook varchar(255),
	Instagram varchar(255),
	Twitter varchar(255),
	Youtube varchar(255),	
	activityPoint int,
	systemRole int,
	status bit
);

CREATE TABLE Category (
	categoryID int NOT NULL PRIMARY KEY AUTO_INCREMENT ,
	categoryName varchar(255) NOT NULL,
	status bit
);
CREATE TABLE Genre (
	genreID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	genreName varchar(255) NOT NULL,
	categoryID int NOT NULL,
	images varchar(255),
	`status` bit,
    FOREIGN KEY (categoryID) REFERENCES Category(categoryID)
    
);


-- Toi di code dao <- Code Book <- Book

CREATE TABLE Seller (
	sellerID int not null PRIMARY KEY AUTO_INCREMENT,
	userID int not null,
	sellerShopName nvarchar(255),
	sellerPhone nvarchar(255) not null,
	evidence nvarchar(255) not null,
	sellerMainProduct int,
	description nvarchar(255),
	sellerVerification int,
	backGroundImage nvarchar(255),
	avatar nvarchar(255),
	status bit,
	FOREIGN KEY (userID) REFERENCES `User`(userID),
	FOREIGN KEY (sellerMainProduct) REFERENCES Category(categoryID)
);

-- co 1 bang Company
CREATE TABLE Warehouse(
	wareHouseID int NOT NULL  PRIMARY KEY AUTO_INCREMENT,
	wareHouseAddress varchar(255) not null,
	status bit
);

CREATE TABLE Product (
	productID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	productName varchar(255) NOT NULL,
	description varchar(500),
	rating real,
	releaseDate date NOT NULL ,
	sellerID int NOT NULL,
	status bit,
	FOREIGN KEY (sellerID) REFERENCES Seller(sellerID)
);


CREATE TABLE ProductGenre (
	productID int,
	genreID int,
	status bit,
	FOREIGN KEY (productID) REFERENCES Product (productID),
	FOREIGN KEY (genreID) REFERENCES Genre (genreID)
);

CREATE Table ProductCategory (
	productID int,
	categoryId int,
	status bit,	
	FOREIGN KEY (productID) REFERENCES Product (productID),
	FOREIGN KEY (categoryID) REFERENCES Category (categoryID)
);

CREATE TABLE ProductType (
	productTypeId varchar(255) PRIMARY KEY,
	productID int NOT NULL,
	size varchar(255),
    color varchar(255),
    price decimal NOT NULL,
	wareHouseID int NOT NULL,
	quantity int NOT NULL ,
	status bit,
	FOREIGN KEY (productID) REFERENCES Product(productID),
	FOREIGN KEY (wareHouseID) REFERENCES Warehouse(wareHouseID)
);

CREATE TABLE ShipCompany (
	companyID int not null  PRIMARY KEY AUTO_INCREMENT,
	companyName varchar(255) not null,
	unitCost decimal,
	commitDate int ,
	status bit
);

CREATE TABLE Gallery (
	galleryID int NOT NULL PRIMARY KEY AUTO_INCREMENT , 
	productID int NOT NULL,
	productTypeID varchar(255) NOT NULL,
	link varchar(255) NOT NULL,
	status bit,
	FOREIGN KEY (productID) REFERENCES Product(productID),
	FOREIGN KEY (productTypeID) REFERENCES ProductType(productTypeId)
);

CREATE TABLE `Order` (
    orderID int  primary key AUTO_INCREMENT,
    userID int not null,
    orderDate datetime NOT NULL ,
    requiredDate datetime not null,
    shippedDate datetime not null ,
    shipName varchar(255),
    shipAddress varchar(255),
    shipCity varchar(255),
    shipPhone varchar(255),
    companyID int,
    shipMoney decimal,
    paymentMethod varchar(50),
    total decimal NOT NULL ,
	state int,
	status bit,
    FOREIGN KEY (userID) references `User`(userID),
    FOREIGN KEY (companyID) references ShipCompany(companyID)
);

CREATE TABLE OrderDetail(
    orderID int not null,
    productTypeID varchar(255) not null,
    primary key(orderID, productTypeID),
    productName varchar(255) not null,
    price decimal NOT NULL,
    quantity int not null,
	status bit,
    FOREIGN KEY (orderID) references `Order`(orderID),
    FOREIGN KEY (productTypeID) references ProductType(productTypeID)
);

CREATE TABLE Comment(
	commentID int not null PRIMARY KEY AUTO_INCREMENT,
	productID int not null,
	userId int not null,
	content varchar(255),
	rating real not null ,
	status bit,
	FOREIGN KEY (userId) REFERENCES `User`(userId),
	FOREIGN KEY (productID) REFERENCES Product(productID)
);