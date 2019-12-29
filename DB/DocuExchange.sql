CREATE DATABASE IF NOT EXISTS DocuExchange;
USE DocuExchange;

CREATE TABLE Studente(
	Email_Studente VARCHAR(35) NOT NULL,
    Nome VARCHAR(20) NOT NULL,
    Cognome VARCHAR(20) NOT NULL,
    Password VARCHAR(20) NOT NULL,
    Sesso VARCHAR(1) NOT NULL,
    PRIMARY KEY(Email_Studente)
);

CREATE TABLE Appunti(
	ID_Appunto INTEGER(10) AUTO_INCREMENT,
	Corso VARCHAR(40) NOT NULL,
    Professore VARCHAR(20) NOT NULL,
    Descrizione VARCHAR(255) NOT NULL,
    FilePDF BLOB NOT NULL,
    Email_Studente VARCHAR(35) NOT NULL,
    PRIMARY KEY(ID_Appunto),
    FOREIGN KEY(Email_Studente) REFERENCES Studente(Email_Studente)
);

CREATE TABLE Recensione(
	ID_Rcensione INT AUTO_INCREMENT,
    Commento VARCHAR(255),
    Stelline INTEGER(10) NOT NULL,
    Email_Studente VARCHAR(35) NOT NULL,
    ID_Appunto INTEGER(10) NOT NULL,
    PRIMARY KEY(ID_Rcensione),
    FOREIGN KEY(Email_Studente) REFERENCES Studente(Email_Studente),
    FOREIGN KEY(ID_Appunto) REFERENCES Appunti(ID_Appunto)
);

CREATE TABLE Admin(
	Email_Admin VARCHAR(35) NOT NULL,
    Nome VARCHAR(20) NOT NULL,
    Cognome VARCHAR(20) NOT NULL,
    Password VARCHAR(20) NOT NULL,
    Sesso VARCHAR(1) NOT NULL,
    PRIMARY KEY(Email_Admin)
);

CREATE TABLE Richiesta(
	ID_Richiesta INTEGER(10) AUTO_INCREMENT,
    Corso VARCHAR(40) NOT NULL,
    Professore VARCHAR(20) NOT NULL,
    Descrizione VARCHAR(255) NOT NULL,
    FilePDF BLOB NOT NULL,
    Email_Admin VARCHAR(35),
    Email_Studente VARCHAR(35) NOT NULL,
    PRIMARY KEY(ID_Richiesta),
    FOREIGN KEY(Email_Admin) REFERENCES Admin(Email_Admin),
    FOREIGN KEY(Email_Studente) REFERENCES Studente(Email_Studente)
);

CREATE TABLE Professore(
	Nome_Professore VARCHAR(30) NOT NULL,
    PRIMARY KEY(Nome_Professore)
);

CREATE TABLE Corso(
	Nome_Corso VARCHAR(40) NOT NULL,
    Nome_Professore VARCHAR(30) NOT NULL,
    PRIMARY KEY(Nome_Corso),
    FOREIGN KEY(Nome_Professore) REFERENCES Professore(Nome_Professore)
);
    
    
	
    


    
    