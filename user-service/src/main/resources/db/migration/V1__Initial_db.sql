CREATE TABLE IF NOT EXISTS users (
id BIGSERIAL NOT NULL PRIMARY KEY,
username VARCHAR (256) NOT NULL,
username VARCHAR (256) NOT NULL UNIQUE,
)

CREATE TABLE IF NOT EXISTS user_transaction_id_list (
     user_id INTEGER NOT NULL REFERENCES users(id),
    transaction_id_list  INTEGER NOT NULL 
)