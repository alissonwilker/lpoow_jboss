-- ## SQL para uso em base de dados PostgreSQL ##

-- exclui a tabela 'users' se existir
DROP TABLE IF EXISTS users;

-- cria a tabela 'users' para autenticação e autorização
CREATE TABLE users (id SERIAL NOT NULL PRIMARY KEY, username VARCHAR(20) NOT NULL UNIQUE, 
                    password VARCHAR(32) NOT NULL, role VARCHAR(15) NOT NULL);

-- insere o usuário 'admin' com senha 'admin' e perfil 'ADMINISTRATOR' na tabela 'users'. A senha está encriptada como hash MD5. 
INSERT INTO users (username, password, role) VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3', 'ADMINISTRATOR');

-- insere o usuário 'user' com senha 'user' e perfil 'USER' na tabela 'users'. A senha está encriptada como hash MD5. 
INSERT INTO users (username, password, role) VALUES ('user', 'ee11cbb19052e40b07aac0ca060c23ee', 'USER');
