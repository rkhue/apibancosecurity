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



-- ========================================
-- DEPOIS DE SUBIR A API RODAR ESSE INSERT
-- RELACIONAR USERS às ROLES
-- Alice = ADMIN, Bob = USER, Carol = MANAGER, etc
-- ========================================
INSERT INTO users_roles (user_id, role_id) VALUES
                                               (1, 1), -- alice é ADMIN
                                               (2, 2), -- bob é USER
                                               (3, 3), -- carol é MANAGER
                                               (4, 2),
                                               (4, 3),
                                               (5, 1),
                                               (5, 2),
                                               (5, 3),
                                               (6, 1),
                                               (6, 3),
                                               (7, 2),
                                               (8, 2),
                                               (9, 2),
                                               (10, 2);
