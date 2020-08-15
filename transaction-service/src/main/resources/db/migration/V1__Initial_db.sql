CREATE TABLE IF NOT EXISTS transaction_categories(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR (256) NOT NULL UNIQUE

)

CREATE TABLE IF NOT EXISTS transactions (
      id BIGSERIAL NOT NULL PRIMARY KEY,
      sum DOUBLE NOT NULL,
      transactionType ENUM('DAY', 'WEEK', 'MONTH') NOT NULL,
      transaction_category_id INTEGER NOT NULL REFERENCES transaction_categories(transaction_category_id)

)