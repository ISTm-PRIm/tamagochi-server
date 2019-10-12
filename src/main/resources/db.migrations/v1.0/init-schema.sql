-- liquibase formatted sql

-- changeset homjakova-tg-170320:1
CREATE TABLE PET (
  id              VARCHAR(36) PRIMARY KEY,
  name VARCHAR(36),
  is_alive         BOOLEAN,
  create_date      TIMESTAMP,
  fool_indicator   INT,
  health_indicator INT,
  clean_indicator  INT,
  sleep_indicator  INT
);

CREATE TABLE USERS (
  id              VARCHAR(36) PRIMARY KEY,
  email           VARCHAR(100),
  create_date      TIMESTAMP,
  pet             VARCHAR(36) NULL,
  CONSTRAINT FK_PET_USER
  FOREIGN KEY (PET) REFERENCES PET (id)
);
