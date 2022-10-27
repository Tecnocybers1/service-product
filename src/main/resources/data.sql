CREATE TABLE TBL_CATEGORIES (
  id BIGINT AUTO_INCREMENT NOT NULL,
   name VARCHAR(255) NULL,
   CONSTRAINT pk_tbl_category PRIMARY KEY (id)
);

CREATE TABLE TBL_PRODUCTS (
  id BIGINT AUTO_INCREMENT NOT NULL,
   name VARCHAR(255) NULL,
   descripcion VARCHAR(255) NULL,
   stock DOUBLE NULL,
   precio DOUBLE NULL,
   status VARCHAR(255) NULL,
   create_at datetime NULL,
   category_id BIGINT NULL,
   CONSTRAINT pk_tbl_products PRIMARY KEY (id)
);

ALTER TABLE TBL_PRODUCTS ADD CONSTRAINT FK_TBL_PRODUCTS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES TBL_CATEGORIES (id);

INSERT INTO TBL_CATEGORIES (id,name) VALUES (1,'Utensilios_de_oficina');
INSERT INTO TBL_CATEGORIES (id,name) VALUES (2,'Colchones');
INSERT INTO TBL_CATEGORIES (id,name) VALUES (3,'Laboratorio');

INSERT INTO TBL_PRODUCTS (id, name, descripcion, stock, precio, status, create_at, category_id)
VALUES (1, '500 hojas', 'Paquete de  tamaño carta de 60 gramos',50,60.00, 'CREATE','2022-10-21', 1 );

INSERT INTO TBL_PRODUCTS (id, name, descripcion, stock, precio, status, create_at, category_id)
VALUES (2, '500 hojas', 'Paquete de  tamaño oficio de 60 gramos',50,62.00,'CREATE','2022-10-21', 1 );

INSERT INTO TBL_PRODUCTS (id, name, descripcion, stock, precio, status, create_at, category_id)
VALUES (3, 'Colchon de camilla', 'tamaño imperial impermiable',100,750.00,'CREATE', '2022-10-22', 2 );

INSERT INTO TBL_PRODUCTS (id, name, descripcion, stock, precio, status, create_at, category_id)
VALUES (4, 'Frasco de muestra', 'Paquete de  12 frascos',300,2.25,'CREATE','2022-10-19', 3 );

