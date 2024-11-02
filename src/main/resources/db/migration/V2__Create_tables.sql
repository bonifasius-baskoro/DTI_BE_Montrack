
CREATE TABLE montrack_be.users (
    id SERIAL PRIMARY KEY,
    password VARCHAR(255),
    name VARCHAR(100),
    email VARCHAR(150),
    pin INTEGER,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP
);

CREATE TABLE montrack_be.wallet (
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES montrack_be.users(id),
    amount BIGINT DEFAULT 0,
    isActive boolean DEFAULT true,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP
);

CREATE TABLE montrack_be.pocket (
    id SERIAL PRIMARY KEY,
    wallet_id INTEGER REFERENCES montrack_be.wallet(id),
    name VARCHAR(50),
    emoji_data VARCHAR(10),
    description VARCHAR(200),
    budget_amount BIGINT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP
);