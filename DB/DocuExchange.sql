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
    Professor VARCHAR(60) NOT NULL,
    Description VARCHAR(255) NOT NULL,
    FilePDF LONGBLOB NOT NULL,
    Email_User VARCHAR(35) NOT NULL,
    Checked INTEGER(1) NOT NULL,
    Autor VARCHAR(45) NOT NULL,
    PRIMARY KEY(ID_Note),
    FOREIGN KEY(Email_User) REFERENCES User(Email_User)
);

CREATE TABLE Review(
	ID_Review INT AUTO_INCREMENT,
    Comment VARCHAR(255),
    Stars INTEGER(10) NOT NULL,
    Email_User VARCHAR(35) NOT NULL,
	Autor VARCHAR(35) NOT NULL,
    ID_Note INTEGER(10) NOT NULL,
    PRIMARY KEY(ID_Review),
    FOREIGN KEY(Email_User) REFERENCES User(Email_User),
    FOREIGN KEY(ID_Note) REFERENCES Note(ID_Note)
);

INSERT INTO `docuexchange`.`user` (`Email_User`, `Name`, `Surname`, `Password`, `Sex`, `Type`, `LimitDownload`) 
	VALUES ('p.erra1@studenti.unisa.it', 'Paolo', 'Erra', 'prova123', 'M', '0', '3');
    
INSERT INTO `docuexchange`.`user` (`Email_User`, `Name`, `Surname`, `Password`, `Sex`, `Type`, `LimitDownload`) 
	VALUES ('m.derosa102@studenti.unisa.it', 'Michele', 'derosa', 'prova123', 'M', '0', '3');

INSERT INTO `docuexchange`.`user` (`Email_User`, `Name`, `Surname`, `Password`, `Sex`, `Type`, `LimitDownload`) 
	VALUES ('a.dmin1@studenti.unisa.it', 'Luca', 'Prisco', 'prova123', 'M', '1', '0');


INSERT INTO `docuexchange`.`note` (`ID_Note`, `Course`, `Professor`, `Description`, `FilePDF`, `Email_User`, `Checked`, `Autor`) VALUES ('39', 'Metodi Matematici per Informatica', 'De Felice Clelia', 'Questa è una descrizione', "", 'm.derosa102@studenti.unisa.it', '1', 'Michele de Rosa');
INSERT INTO `docuexchange`.`review` (`ID_Review`, `Comment`, `Stars`, `Email_User`, `Autor`, `ID_Note`) VALUES ('1', 'Questo è un commento', '4', 'm.derosa102@studenti.unisa.it', 'Michele de Rosa', '38');



    
    
	
    


    
    