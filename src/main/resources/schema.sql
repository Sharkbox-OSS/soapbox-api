CREATE TABLE box (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE,
    created_at DATETIME DEFAULT now()
);

CREATE TABLE thread (
    id SERIAL PRIMARY KEY,
    box_id SERIAL,
    title VARCHAR(255),
    thread_type ENUM('TEXT', 'IMAGE', 'LINK'),
    body VARCHAR(2000),
    created_at DATETIME DEFAULT now()
);
