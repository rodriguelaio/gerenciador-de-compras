--SELECT ID, NOME, USERNAME, PASSWORD, ADMIN FROM USUARIO
INSERT INTO usuario (nome, username, password, admin) VALUES ('Usuario A', 'guelaio', '$2a$10$fk.4vzhbPrtWVvbgYyHbZ.QuV7h3tIGPz2DPlfpo4ff5e3YUg30yC', true);

--SELECT ID, NOME FROM MARCA
INSERT INTO marca(nome) VALUES ('Marca A');
INSERT INTO marca(nome) VALUES ('Marca B');
INSERT INTO marca(nome) VALUES ('Marca C');
INSERT INTO marca(nome) VALUES ('Marca D');
INSERT INTO marca(nome) VALUES ('Marca E');

--SELECT ID, NOME, ID_MARCA, CATEGORIA, UNIDADE_MEDIDA, PESO_VOLUME FROM PRODUTO
INSERT INTO produto (nome, id_marca, unidade_medida, categoria, peso_volume) VALUES ('Produto A', 1,'UNIDADE'	, 'LIMPEZA'	, 1);
INSERT INTO produto (nome, id_marca, unidade_medida, categoria, peso_volume) VALUES ('Produto B', 3,'LITRO'		, 'ALIMENTO', 100);
INSERT INTO produto (nome, id_marca, unidade_medida, categoria, peso_volume) VALUES ('Produto C', 2,'MILILITRO'	, 'BEBIDA'	, 350);
INSERT INTO produto (nome, id_marca, unidade_medida, categoria, peso_volume) VALUES ('Produto D', 2,'GRAMA'		, 'ALIMENTO', 20);
INSERT INTO produto (nome, id_marca, unidade_medida, categoria, peso_volume) VALUES ('Produto E', 3,'UNIDADE'	, 'LIMPEZA'	, 1);
INSERT INTO produto (nome, id_marca, unidade_medida, categoria, peso_volume) VALUES ('Produto F', 1,'GRAMA'		, 'ALIMENTO', 200);
INSERT INTO produto (nome, id_marca, unidade_medida, categoria, peso_volume) VALUES ('Produto G', 1,'UNIDADE'	, 'ALIMENTO', 1);
INSERT INTO produto (nome, id_marca, unidade_medida, categoria, peso_volume) VALUES ('Produto H', 3,'UNIDADE'	, 'REMEDIO'	, 1);
INSERT INTO produto (nome, id_marca, unidade_medida, categoria, peso_volume) VALUES ('Produto I', 4,'MILILITRO'	, 'LIMPEZA'	, 750);
INSERT INTO produto (nome, id_marca, unidade_medida, categoria, peso_volume) VALUES ('Produto J', 4,'QUILOGRAMA', 'ALIMENTO', 2);
INSERT INTO produto (nome, id_marca, unidade_medida, categoria, peso_volume) VALUES ('Produto K', 4,'UNIDADE'	, 'ALIMENTO', 1);
INSERT INTO produto (nome, id_marca, unidade_medida, categoria, peso_volume) VALUES ('Produto L', 2,'LITRO'		, 'ALIMENTO', 2);
INSERT INTO produto (nome, id_marca, unidade_medida, categoria, peso_volume) VALUES ('Produto M', 3,'QUILOGRAMA', 'REMEDIO'	, 1);
INSERT INTO produto (nome, id_marca, unidade_medida, categoria, peso_volume) VALUES ('Produto N', 1,'MILILITRO'	, 'BEBIDA'	, 473);
INSERT INTO produto (nome, id_marca, unidade_medida, categoria, peso_volume) VALUES ('Produto O', 2,'LITRO'		, 'LIMPEZA'	, 2.5);
INSERT INTO produto (nome, id_marca, unidade_medida, categoria, peso_volume) VALUES ('Produto P', 3,'GRAMA'		, 'ALIMENTO', 500);

--SELECT ID, DATA FROM COMPRA
INSERT INTO compra (data) VALUES ('2021-03-07');

--SELECT ID_COMPRA, ID_PRODUTO, QUANTIDADE, VALOR_UNITARIO_BRUTO,VALOR_DESCONTO, PERCENTUAL_DESCONTO, VALOR_UNITARIO_LIQUIDO, VALOR_TOTAL_BRUTO, VALOR_TOTAL_LIQUIDO FROM PRODUTO_COMPRA
INSERT INTO produto_compra (id_compra, id_produto, quantidade, valor_unitario_bruto, valor_desconto, percentual_desconto,
							valor_unitario_liquido, valor_total_bruto, valor_total_liquido)
							VALUES (1, 1, 10, 25, 1.5, 6, 23.5, 250, 235);
INSERT INTO produto_compra (id_compra, id_produto, quantidade, valor_unitario_bruto, valor_desconto, percentual_desconto,
							valor_unitario_liquido, valor_total_bruto, valor_total_liquido)
							VALUES (1, 4, 1, 25, 1.5, 6, 23.5, 25, 23.5);
INSERT INTO produto_compra (id_compra, id_produto, quantidade, valor_unitario_bruto, valor_desconto, percentual_desconto,
							valor_unitario_liquido, valor_total_bruto, valor_total_liquido)
							VALUES (1, 14, 12, 3.99, 0, 0, 3.99, 47.88, 47.88);