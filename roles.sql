-- ========================================
-- TABELA DE Usuários
-- ========================================
CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(50) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       enabled BOOLEAN DEFAULT TRUE
);

-- ========================================
-- TABELA DE ROLES (Papeis)
-- ========================================
CREATE TABLE roles (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(50) UNIQUE NOT NULL
);


-- ========================================
-- Usuários
-- Senhas aqui sÃ£o texto puro (em prática devem ser BCrypt)
-- ========================================
INSERT INTO users (username, password) VALUES
                                           ('alice', '12345'),
                                           ('bruno', '12345'),
                                           ('carla', '12345'),
                                           ('daniel', '12345'),
                                           ('eva', '12345'),
                                           ('felipe', '12345'),
                                           ('gabi', '12345'),
                                           ('hugo', '12345'),
                                           ('isa', '12345'),
                                           ('joao', '12345');

-- ========================================
-- POPULAR ROLES
-- ========================================
INSERT INTO roles (name) VALUES
                             ('ADMIN'),
                             ('USER'),
                             ('MANAGER');
