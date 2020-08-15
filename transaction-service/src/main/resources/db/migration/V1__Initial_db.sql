CREATE TABLE IF NOT EXISTS transaction_categories(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR (256) NOT NULL UNIQUE

);
CREATE TYPE transaction_type_enum AS ENUM('DAY', 'WEEK', 'MONTH');

CREATE TABLE IF NOT EXISTS transactions (
      id BIGSERIAL NOT NULL PRIMARY KEY,
      sum FLOAT NOT NULL,
      transaction_type transaction_type_enum,
      transaction_category_id INTEGER NOT NULL REFERENCES transaction_categories(id)

);