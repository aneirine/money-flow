CREATE TABLE IF NOT EXISTS jars
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name        VARCHAR(256) NOT NULL,
    startDate   BIGINT       NOT NULL,
    endDate     BIGINT       NOT NULL,
    status      VARCHAR(50)  NOT NULL,
    currentSum  BIGINT       NOT NULL,
    goalSum     BIGINT       NOT NULL,
    description VARCHAR(50)  NOT NULL

);