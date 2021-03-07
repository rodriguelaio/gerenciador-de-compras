--SELECT ID, NOME, CATEGORIA, UNIDADE_MEDIDA, PESO_VOLUME FROM PRODUTO
INSERT INTO produto (nome, unidade_medida, categoria, peso_volume) values ('Produto A', 'UNIDADE'	, 'LIMPEZA'	, 1);
INSERT INTO produto (nome, unidade_medida, categoria, peso_volume) values ('Produto B', 'LITRO'		, 'ALIMENTO', 100);
INSERT INTO produto (nome, unidade_medida, categoria, peso_volume) values ('Produto C', 'MILILITRO'	, 'BEBIDA'	, 350);
INSERT INTO produto (nome, unidade_medida, categoria, peso_volume) values ('Produto D', 'GRAMA'		, 'ALIMENTO', 20);
INSERT INTO produto (nome, unidade_medida, categoria, peso_volume) values ('Produto E', 'UNIDADE'	, 'LIMPEZA'	, 1);
INSERT INTO produto (nome, unidade_medida, categoria, peso_volume) values ('Produto F', 'GRAMA'		, 'ALIMENTO', 200);
INSERT INTO produto (nome, unidade_medida, categoria, peso_volume) values ('Produto G', 'UNIDADE'	, 'ALIMENTO', 1);
INSERT INTO produto (nome, unidade_medida, categoria, peso_volume) values ('Produto H', 'UNIDADE'	, 'REMEDIO'	, 1);
INSERT INTO produto (nome, unidade_medida, categoria, peso_volume) values ('Produto I', 'MILILITRO'	, 'LIMPEZA'	, 750);
INSERT INTO produto (nome, unidade_medida, categoria, peso_volume) values ('Produto J', 'QUILOGRAMA', 'ALIMENTO', 2);
INSERT INTO produto (nome, unidade_medida, categoria, peso_volume) values ('Produto K', 'UNIDADE'	, 'ALIMENTO', 1);
INSERT INTO produto (nome, unidade_medida, categoria, peso_volume) values ('Produto L', 'LITRO'		, 'ALIMENTO', 2);
INSERT INTO produto (nome, unidade_medida, categoria, peso_volume) values ('Produto M', 'QUILOGRAMA', 'REMEDIO'	, 1);
INSERT INTO produto (nome, unidade_medida, categoria, peso_volume) values ('Produto N', 'MILILITRO'	, 'BEBIDA'	, 473);
INSERT INTO produto (nome, unidade_medida, categoria, peso_volume) values ('Produto O', 'LITRO'		, 'LIMPEZA'	, 2.5);
INSERT INTO produto (nome, unidade_medida, categoria, peso_volume) values ('Produto P', 'GRAMA'		, 'ALIMENTO', 500);

--SELECT ID, NOME, USERNAME, PASSWORD, ADMIN FROM USUARIO
INSERT INTO usuario (nome, username, password, admin) values ('Usuario A', 'guelaio', '$2a$10$fk.4vzhbPrtWVvbgYyHbZ.QuV7h3tIGPz2DPlfpo4ff5e3YUg30yC', true);