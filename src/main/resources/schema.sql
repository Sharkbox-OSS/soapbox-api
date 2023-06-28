CREATE TABLE box (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE,
    created_at DATETIME DEFAULT now()
);

