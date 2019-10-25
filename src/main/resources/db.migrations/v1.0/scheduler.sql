-- liquibase formatted sql

-- changeset homjakova-tg-170320:2
CREATE TABLE SCHEDULER (
  id BIGSERIAL PRIMARY KEY,
  indicator VARCHAR(36),
  cron VARCHAR(36),
  decrement_value   INT,
  priority INT
);
CREATE INDEX SCHEDULER_index ON SCHEDULER (id);

CREATE TABLE UPDATE_HISTORY (
  id BIGSERIAL PRIMARY KEY,
  indicator VARCHAR(36),
  is_scheduling BOOLEAN,
  decrement_value   INT,
  insert_date TIMESTAMP
);
CREATE INDEX UPDATE_HISTORY_ID_index ON UPDATE_HISTORY (id);