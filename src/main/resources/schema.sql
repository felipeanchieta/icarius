-- DATABASE CREATION----------------------------------------------------------
START TRANSACTION;

CREATE DATABASE IF NOT EXISTS icarius; -- NOTE: DOESN'T WORK HERE. FIXED AT DB
-- PROPERTIES, LOCATED AT APP.PROP
USE icarius;

COMMIT;
-- ---------------------------------------------------------------------------

-- TABLES CREATION------------------------------------------------------------
START TRANSACTION;

CREATE TABLE IF NOT EXISTS users (
  CPF       VARCHAR(11) PRIMARY KEY,
  NAME      VARCHAR(255) NOT NULL,
  USERNAME  VARCHAR(30)  NOT NULL,
  PASSWORD  BINARY(32)   NOT NULL, -- WARNING: SHA-256 ALGORITHM
  BIRTHDATE DATE         NULL
);

CREATE TABLE IF NOT EXISTS books (
  ISBN     VARCHAR(13) PRIMARY KEY,
  TITLE    VARCHAR(255) NOT NULL,
  AUTHOR   VARCHAR(255) NOT NULL,
  PRESS    VARCHAR(100) NULL,
  LOCATION VARCHAR(100) NULL,
  YEAR     INT(4)       NULL
);

CREATE TABLE IF NOT EXISTS loans (
  ID          INTEGER     NOT NULL AUTO_INCREMENT,
  ISBN        VARCHAR(13) NOT NULL,
  CPF         VARCHAR(11) NOT NULL,
  LOAN_DATE   DATE        NOT NULL,
  RETURN_DATE DATE        NOT NULL,
  PRIMARY KEY (ID),
  FOREIGN KEY (ISBN) REFERENCES books (ISBN),
  FOREIGN KEY (CPF) REFERENCES users (CPF)
);

CREATE TABLE IF NOT EXISTS reservations (
  ID               INTEGER     NOT NULL AUTO_INCREMENT,
  ISBN             VARCHAR(13) NOT NULL,
  CPF              VARCHAR(11) NOT NULL,
  RESERVATION_DATE DATE        NOT NULL,
  PRIMARY KEY (ID),
  FOREIGN KEY (ISBN) REFERENCES books (ISBN),
  FOREIGN KEY (CPF) REFERENCES users (CPF)
);

COMMIT;
-- ---------------------------------------------------------------------------

-- ADMIN USER INSERTION-------------------------------------------------------
START TRANSACTION;

INSERT INTO users (CPF, NAME, USERNAME, PASSWORD, BIRTHDATE)
VALUES ('43111027805',
        'Felipe Anchieta Santos Costa',
        'felipe.anchieta',
        0x2bd2d3a31934d76198acc030caca4c31965474fe5fa48f35fef79d0fd74ee1b2,
        '1995-06-17')
ON DUPLICATE KEY UPDATE CPF = CPF;

COMMIT;
-- ---------------------------------------------------------------------------

-- BOOKS INSERTION-----------------------------------------------------------
START TRANSACTION;

INSERT INTO books (ISBN, TITLE, AUTHOR, PRESS, YEAR)
VALUES ('9788582850015',
        'Memórias Póstumas de Brás Cubas',
        'Machado de Assis',
        'Penguin',
        2014)
ON DUPLICATE KEY UPDATE ISBN = ISBN;

INSERT INTO books (ISBN, TITLE, AUTHOR, PRESS, YEAR)
VALUES ('9788577994175',
        'Til',
        'José de Alencar',
        'Bestbolso',
        2012)
ON DUPLICATE KEY UPDATE ISBN = ISBN;

COMMIT;
-- ---------------------------------------------------------------------------
