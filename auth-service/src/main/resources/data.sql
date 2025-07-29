INSERT INTO users (name, username, email, password, is_active, last_login, role)
VALUES
    ('Admin One',  'admin', 'admin@example.com', '$2a$10$7W8e5Tk4a.uQk5b.qZoeLO9Llb/2L8W/3h1V5s8MTb7Hv7AFR1m2G', TRUE, NOW(), 'ADMIN'),
    ('User One',   'user1', 'user1@example.com', '$2a$10$7W8e5Tk4a.uQk5b.qZoeLO9Llb/2L8W/3h1V5s8MTb7Hv7AFR1m2G', TRUE, NULL,  'USER'),
    ('User Two',   'user2', 'user2@example.com', '$2a$10$7W8e5Tk4a.uQk5b.qZoeLO9Llb/2L8W/3h1V5s8MTb7Hv7AFR1m2G', TRUE, NULL,  'USER');
