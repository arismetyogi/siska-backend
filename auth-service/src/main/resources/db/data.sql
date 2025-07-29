INSERT INTO users (name, username, email, password, is_active, last_login, role, created_at)
VALUES
    ('Admin One',  'admin', 'admin@example.com', '$2a$12$qGoDWkqsOGRmHG.VyG/zGOVIF3nLUhqy4BXw/wpKkLjikXStdmAWq', TRUE, NOW(), 'ADMIN', NOW()),
    ('User One',   'user1', 'user1@example.com', '$2a$12$qGoDWkqsOGRmHG.VyG/zGOVIF3nLUhqy4BXw/wpKkLjikXStdmAWq', TRUE, NULL,  'USER', NOW()),
    ('User Two',   'user2', 'user2@example.com', '$2a$12$qGoDWkqsOGRmHG.VyG/zGOVIF3nLUhqy4BXw/wpKkLjikXStdmAWq', TRUE, NULL,  'USER', NOW());

-- default password: "password"
