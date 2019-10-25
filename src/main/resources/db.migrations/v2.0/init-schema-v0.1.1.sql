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
  id              BIGINT PRIMARY KEY,
  email           VARCHAR(100),
  name            VARCHAR(255),
  image_url       VARCHAR(255),
  password        VARCHAR(255),
  provider        VARCHAR(255),
  provider_id     VARCHAR(255),
  is_online       BOOLEAN,
  email_verified  BOOLEAN,
  create_date      TIMESTAMP,
  pet             VARCHAR(36) NULL,
  CONSTRAINT FK_PET_USER
  FOREIGN KEY (PET) REFERENCES PET (id)
);
