CREATE TABLE IF NOT EXISTS jars
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name        VARCHAR(256) NOT NULL,
    start_date   BIGINT       NOT NULL,
    end_date     BIGINT       NOT NULL,
    status      VARCHAR(50)  NOT NULL,
    current_sum  BIGINT       NOT NULL,
    goal_sum     BIGINT       NOT NULL,
    description VARCHAR(50)  NOT NULL

);