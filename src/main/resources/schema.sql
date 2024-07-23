-- src/main/resources/schema.sql
CREATE TABLE IF NOT EXISTS user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- Add other necessary tables
CREATE TABLE IF NOT EXISTS hibernate_sequence (
    next_val BIGINT NOT NULL
);
