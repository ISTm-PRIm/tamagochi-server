-- liquibase formatted sql

-- changeset homjakova-tg-170320:2
CREATE TABLE SCHEDULER (
  id              VARCHAR(36) PRIMARY KEY,
  indicator VARCHAR(36),
  cron VARCHAR(36),
  decrement_value   INT,
  prioritet INT
);

CREATE TABLE UPDATE_DATE (
  id              VARCHAR(36) PRIMARY KEY,
  indicator VARCHAR(36),
  is_scheduling BOOLEAN,
  decrement_value   INT,
  insert_date TIMESTAMP
);
