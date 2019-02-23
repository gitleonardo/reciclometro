CREATE TABLE IF NOT EXISTS Produto (
	id INT AUTO_INCREMENT, 
	tipo VARCHAR(60), 
	formulacao VARCHAR(60), 
	descricao VARCHAR(255), 
	peso DOUBLE, 
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Usuario (
	id INT AUTO_INCREMENT,
	username VARCHAR(60),
	senha VARCHAR(60),
	PRIMARY KEY (id)
);

INSERT INTO USUARIO(username,senha) VALUES ('admin','1234');