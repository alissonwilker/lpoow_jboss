-- scripts de criação da base para postgresql
CREATE TABLE users (id SERIAL NOT NULL PRIMARY KEY, username VARCHAR(20) NOT NULL UNIQUE, 
                    password VARCHAR(32) NOT NULL, role VARCHAR(15) NOT NULL);
-- senha alisson
INSERT INTO users (username, password, role) VALUES ('alisson', '48ca192d5394397a37e28e5b913dcdb5', 'ADMINISTRATOR');

