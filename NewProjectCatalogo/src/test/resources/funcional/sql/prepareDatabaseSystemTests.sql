DELETE FROM ITEM WHERE 1=1;
DELETE FROM PRODUTO WHERE 1=1;
DELETE FROM SUBCATEGORIA WHERE 1=1;
DELETE FROM CATEGORIA WHERE 1=1;
DELETE FROM IMAGENS WHERE 1=1;
DELETE FROM DIMENSOES WHERE 1=1;

INSERT INTO DIMENSOES VALUES(1, 10, 30, 10);

INSERT INTO CATEGORIA VALUES(1, 'Categoria 1');
INSERT INTO CATEGORIA VALUES(2, 'Categoria 2');
INSERT INTO CATEGORIA VALUES(3, 'Categoria 3');
INSERT INTO CATEGORIA VALUES(4, 'Categoria 4');
INSERT INTO CATEGORIA VALUES(5, 'Categoria 5');
INSERT INTO CATEGORIA VALUES(6, 'Categoria 6');
INSERT INTO CATEGORIA VALUES(7, 'Categoria 7');
INSERT INTO CATEGORIA VALUES(8, 'Categoria 8');
INSERT INTO CATEGORIA VALUES(9, 'Categoria 9');
INSERT INTO CATEGORIA VALUES(10, 'Categoria 10');

INSERT INTO SUBCATEGORIA VALUES(1, 'Subcategoria 1', 1);
INSERT INTO SUBCATEGORIA VALUES(2, 'Subcategoria 2', 1);
INSERT INTO SUBCATEGORIA VALUES(3, 'Subcategoria 3', 1);
INSERT INTO SUBCATEGORIA VALUES(4, 'Subcategoria 4', 1);
INSERT INTO SUBCATEGORIA VALUES(5, 'Subcategoria 5', 2);
INSERT INTO SUBCATEGORIA VALUES(6, 'Subcategoria 6', 2);
INSERT INTO SUBCATEGORIA VALUES(7, 'Subcategoria 7', 3);
INSERT INTO SUBCATEGORIA VALUES(8, 'Subcategoria 8', 3);
INSERT INTO SUBCATEGORIA VALUES(9, 'Subcategoria 9', 3);
INSERT INTO SUBCATEGORIA VALUES(10, 'Subcategoria 10', 4);

INSERT INTO PRODUTO VALUES(1, 1, 'Nome da Marca', 'Descrição longa', 'Nome do modelo', 'Nome do produto', 'Descrição curta', 2, 5, 1, 1, 10);
INSERT INTO PRODUTO VALUES(2, 1, 'Nome da Marca', 'Descrição longa', 'Nome do modelo', 'Nome do produto', 'Descrição curta', 2, 5, 1, 1, 2);
INSERT INTO PRODUTO VALUES(3, 1, 'Nome da Marca', 'Descrição longa', 'Nome do modelo', 'Nome do produto', 'Descrição curta', 2, 5, 1, 1, 3);
INSERT INTO PRODUTO VALUES(4, 1, 'Nome da Marca', 'Descrição longa', 'Nome do modelo', 'Nome do produto', 'Descrição curta', 2, 5, 2, 1, 5);
INSERT INTO PRODUTO VALUES(5, 1, 'Nome da Marca', 'Descrição longa', 'Nome do modelo', 'Nome do produto', 'Descrição curta', 2, 5, 2, 1, 2);
INSERT INTO PRODUTO VALUES(6, 1, 'Nome da Marca', 'Descrição longa', 'Nome do modelo', 'Nome do produto', 'Descrição curta', 2, 5, 3, 1, 5);
INSERT INTO PRODUTO VALUES(7, 1, 'Nome da Marca', 'Descrição longa', 'Nome do modelo', 'Nome do produto', 'Descrição curta', 2, 5, 3, 1, 6);
INSERT INTO PRODUTO VALUES(8, 1, 'Nome da Marca', 'Descrição longa', 'Nome do modelo', 'Nome do produto', 'Descrição curta', 2, 5, 3, 1, 8);
INSERT INTO PRODUTO VALUES(9, 0, 'Nome da Marca', 'Descrição longa', 'Nome do modelo', 'Nome do produto', 'Descrição curta', 2, 5, 4, 1, 8);
INSERT INTO PRODUTO VALUES(10, 0, 'Nome da Marca', 'Descrição longa', 'Nome do modelo', 'Nome do produto', 'Descrição curta', 2, 5, 4, 1, 8);

INSERT INTO ITEM VALUES(1, 1, 'Nome opcional', 'Valor opcional', 199.90, 299.90, 12345, 15, 1);
INSERT INTO ITEM VALUES(2, 1, 'Nome opcional', 'Valor opcional', 199.90, 299.90, 12345, 15, 1);
INSERT INTO ITEM VALUES(3, 1, 'Nome opcional', 'Valor opcional', 199.90, 299.90, 12345, 15, 1);
INSERT INTO ITEM VALUES(4, 1, 'Nome opcional', 'Valor opcional', 199.90, 299.90, 12345, 15, 2);
INSERT INTO ITEM VALUES(5, 1, 'Nome opcional', 'Valor opcional', 199.90, 299.90, 12345, 15, 2);
INSERT INTO ITEM VALUES(6, 1, 'Nome opcional', 'Valor opcional', 199.90, 299.90, 12345, 15, 3);
INSERT INTO ITEM VALUES(7, 1, 'Nome opcional', 'Valor opcional', 199.90, 299.90, 12345, 15, 3);
INSERT INTO ITEM VALUES(8, 1, 'Nome opcional', 'Valor opcional', 199.90, 299.90, 12345, 15, 3);
INSERT INTO ITEM VALUES(9, 1, 'Nome opcional', 'Valor opcional', 199.90, 299.90, 12345, 15, 4);
INSERT INTO ITEM VALUES(10, 1, 'Nome opcional', 'Valor opcional', 199.90, 299.90, 12345, 15, 4);
INSERT INTO ITEM VALUES(11, 1, 'Nome opcional', 'Valor opcional', 199.90, 299.90, 12345, 15, 5);
INSERT INTO ITEM VALUES(12, 1, 'Nome opcional', 'Valor opcional', 199.90, 299.90, 12345, 15, 6);
INSERT INTO ITEM VALUES(13, 1, 'Nome opcional', 'Valor opcional', 199.90, 299.90, 12345, 15, 7);
INSERT INTO ITEM VALUES(14, 1, 'Nome opcional', 'Valor opcional', 199.90, 299.90, 12345, 15, 8);
INSERT INTO ITEM VALUES(15, 1, 'Nome opcional', 'Valor opcional', 199.90, 299.90, 12345, 15, 8);
INSERT INTO ITEM VALUES(16, 1, 'Nome opcional', 'Valor opcional', 199.90, 299.90, 12345, 15, 9);
INSERT INTO ITEM VALUES(17, 0, 'Nome opcional', 'Valor opcional', 199.90, 299.90, 12345, 15, 9);