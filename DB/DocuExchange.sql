CREATE DATABASE IF NOT EXISTS DocuExchange;
USE DocuExchange;

CREATE TABLE User(
	Email_User VARCHAR(35) NOT NULL,
    Name VARCHAR(20) NOT NULL,
    Surname VARCHAR(20) NOT NULL,
    Password VARCHAR(20) NOT NULL,
    Sex CHAR(1) NOT NULL,
    Type INTEGER(1) NOT NULL,
    LimitDownload INTEGER(1),
    PRIMARY KEY(Email_User)
);

CREATE TABLE Note(
	ID_Note INTEGER(10) AUTO_INCREMENT,
	Course VARCHAR(40) NOT NULL,
    Professor VARCHAR(20) NOT NULL,
    Description VARCHAR(255) NOT NULL,
    FilePDF BLOB NOT NULL,
    Email_User VARCHAR(35) NOT NULL,
    Checked INTEGER(1) NOT NULL,
    PRIMARY KEY(ID_Note),
    FOREIGN KEY(Email_User) REFERENCES User(Email_User)
);

CREATE TABLE Review(
	ID_Review INT AUTO_INCREMENT,
    Comment VARCHAR(255),
    Stars INTEGER(10) NOT NULL,
    Email_User VARCHAR(35) NOT NULL,
    ID_Note INTEGER(10) NOT NULL,
    PRIMARY KEY(ID_Review),
    FOREIGN KEY(Email_User) REFERENCES User(Email_User),
    FOREIGN KEY(ID_Note) REFERENCES Note(ID_Note)
);


CREATE TABLE Professor(
	Nome_Professor VARCHAR(30) NOT NULL,
    PRIMARY KEY(Nome_Professor)
);

CREATE TABLE Course(
	Nome_Course VARCHAR(40) NOT NULL,
    Nome_Professor VARCHAR(30) NOT NULL,
    PRIMARY KEY(Nome_Course),
    FOREIGN KEY(Nome_Professor) REFERENCES Professor(Nome_Professor)
);
    
    
	
    


    
    