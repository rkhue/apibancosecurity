DROP TABLE IF EXISTS transactions CASCADE;
DROP TABLE IF EXISTS accounts CASCADE;

-- ========================================
-- TABELA DE CONTAS (Accounts)
-- ========================================
CREATE TABLE accounts (
                          id SERIAL PRIMARY KEY,
                          document VARCHAR(20) UNIQUE NOT NULL,
                          name VARCHAR(100) NOT NULL,
                          balance NUMERIC(15,2) NOT NULL DEFAULT 0
);

-- ========================================
-- TABELA DE TRANSAÇÕES
-- ========================================
CREATE TABLE transactions (
                              id SERIAL PRIMARY KEY,
                              from_account_id INT NOT NULL REFERENCES accounts(id),
                              to_account_id INT NOT NULL REFERENCES accounts(id),
                              amount NUMERIC(15,2) NOT NULL,
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- ========================================
-- CONTAS (1:1 com usuário)
-- ========================================
INSERT INTO accounts (document, name, balance) VALUES
                                                   ('11111111111', 'Alice Farias', 1000.00),
                                                   ('22222222222', 'Bruno Sodré', 500.00),
                                                   ('33333333333', 'Carla Dias', 750.50),
                                                   ('44444444444', 'Daniel de Oliveira', 200.00),
                                                   ('55555555555', 'Eva Mota', 1200.00),
                                                   ('66666666666', 'Felipe Silva', 330.00),
                                                   ('77777777777', 'Gabriela Souza', 440.40),
                                                   ('88888888888', 'Hugo Mota', 1500.00),
                                                   ('99999999999', 'Isabela Sodré', 50.00),
                                                   ('00000000000', 'João Pereira', 900.00);

-- ========================================
-- TRANSAÇÕES
-- Exemplo: Alice envia para Bob, Bob envia para Carol...
-- ========================================
INSERT INTO transactions (from_account_id, to_account_id, amount) VALUES
                                                                      ((SELECT id FROM accounts WHERE document='11111111111'), (SELECT id FROM accounts WHERE document='22222222222'), 100.00),
                                                                      ((SELECT id FROM accounts WHERE document='22222222222'), (SELECT id FROM accounts WHERE document='33333333333'), 50.00),
                                                                      ((SELECT id FROM accounts WHERE document='33333333333'), (SELECT id FROM accounts WHERE document='44444444444'), 25.00),
                                                                      ((SELECT id FROM accounts WHERE document='44444444444'), (SELECT id FROM accounts WHERE document='55555555555'), 10.00),
                                                                      ((SELECT id FROM accounts WHERE document='55555555555'), (SELECT id FROM accounts WHERE document='66666666666'), 75.00),
                                                                      ((SELECT id FROM accounts WHERE document='66666666666'), (SELECT id FROM accounts WHERE document='77777777777'), 15.00),
                                                                      ((SELECT id FROM accounts WHERE document='77777777777'), (SELECT id FROM accounts WHERE document='88888888888'), 200.00),
                                                                      ((SELECT id FROM accounts WHERE document='88888888888'), (SELECT id FROM accounts WHERE document='99999999999'), 300.00),
                                                                      ((SELECT id FROM accounts WHERE document='99999999999'), (SELECT id FROM accounts WHERE document='00000000000'), 20.00),
                                                                      ((SELECT id FROM accounts WHERE document='00000000000'), (SELECT id FROM accounts WHERE document='11111111111'), 150.00);
