-- account 생성 쿼리
CREATE TABLE IF NOT EXISTS account (
id SERIAL PRIMARY KEY,
username VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL
);

-- client 생성 쿼리
CREATE TABLE IF NOT EXISTS client (
id SERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL
);

-- deal 생성 쿼리
CREATE TABLE IF NOT EXISTS deal (
id SERIAL PRIMARY KEY,
client_id BIGINT REFERENCES client(id),
cnt INTEGER NOT NULL,
account_id BIGINT REFERENCES account(id),
deal_date DATE NOT NULL,
created_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
modified_date TIMESTAMP WITHOUT TIME ZONE,
CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES client(id),
CONSTRAINT fk_account FOREIGN KEY (account_id) REFERENCES account(id)
);

-- deal_item 생성 쿼리
CREATE TABLE IF NOT EXISTS deal_item (
id SERIAL PRIMARY KEY,
fish_id BIGINT REFERENCES fish(id),
deal_id BIGINT REFERENCES deal(id),
weight INTEGER NOT NULL,
quantity INTEGER NOT NULL,
unit VARCHAR(32) NOT NULL,
unitPrice INTEGER NOT NULL,
note VARCHAR(255),
CONSTRAINT fk_fish FOREIGN KEY (fish_id) REFERENCES fish(id),
CONSTRAINT fk_deal FOREIGN KEY (deal_id) REFERENCES deal(id)
);

-- fish 생성 쿼리
CREATE TABLE IF NOT EXISTS fish (
id SERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
code VARCHAR(255) NOT NULL
);