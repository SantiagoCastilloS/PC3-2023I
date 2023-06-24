CREATE DATABASE programas;
-- 1) SCRIPT
CREATE TABLE programa (
	id_programa NUMERIC (4) PRIMARY KEY,
	nombre_programa VARCHAR (30),	
	descripcion_programa VARCHAR (50),
	hora_inicio CHAR (5),
	hora_fin CHAR (5)
);

CREATE TABLE oyente (
	id_oyente NUMERIC (4) PRIMARY KEY,
	username VARCHAR (30),	
	contraseña VARCHAR (50),
	mail VARCHAR (50),
	fecha_registro CHAR (10)
);

CREATE TABLE categoria (
	id_categoria NUMERIC (4) PRIMARY KEY,
	nombre_categoria VARCHAR (30),	
	descripcion_categoria VARCHAR (100)
);

CREATE TABLE suscripcion (
	id_suscripcion NUMERIC (4) PRIMARY KEY,
	descripcion_suscripcion VARCHAR (50),
	costo_suscripcion NUMERIC (10,2),
	tipo_medio CHAR (1),
	id_programa NUMERIC (4),
	FOREIGN KEY (id_programa) REFERENCES programa (id_programa)
);

CREATE TABLE conductor (
	id_conductor NUMERIC (4) PRIMARY KEY,
	nombre_conductor VARCHAR (30),
	codigo_conductor CHAR (8),
	id_programa NUMERIC (4),
	FOREIGN KEY (id_programa) REFERENCES programa (id_programa)
);

CREATE TABLE oyente_suscripcion (
	id_oyente_suscripcion NUMERIC (4) PRIMARY KEY,
	id_suscripcion NUMERIC (4),
	id_oyente NUMERIC (4),
	FOREIGN KEY (id_suscripcion) REFERENCES suscripcion (id_suscripcion),
	FOREIGN KEY (id_oyente) REFERENCES oyente (id_oyente)
);

CREATE TABLE nota (
	id_nota NUMERIC(4) PRIMARY KEY,
	titulo_nota VARCHAR (30),
	contenido VARCHAR (100),
	resumen VARCHAR (500),
	flag_activo NUMERIC (1),
	id_programa NUMERIC (4),
	id_categoria NUMERIC (4),
	FOREIGN KEY (id_programa) REFERENCES programa (id_programa),
	FOREIGN KEY (id_categoria) REFERENCES categoria (id_categoria)
);
CREATE TABLE comentario (
	id_comentario NUMERIC(4) PRIMARY KEY,
	texto VARCHAR (300),
	valoracion NUMERIC (1),
	flag_activo NUMERIC (1),
	id_oyente NUMERIC (4),
	id_nota NUMERIC(4),
	FOREIGN KEY (id_oyente) REFERENCES oyente (id_oyente),
	FOREIGN KEY (id_nota) REFERENCES nota (id_nota)
);

-- 2) REGISTROS
-- CATEGORIA
INSERT INTO categoria VALUES (1,'Noticias','Seccion de noticias');
INSERT INTO categoria VALUES (2,'Musica','Canales Musicales');
INSERT INTO categoria VALUES (3,'Deportes','Canales Deportivos');
INSERT INTO categoria VALUES (4,'Entretenimiento','Programas variados de entretenimiento');
-- PROGRAMA
INSERT INTO programa VALUES (1,'Futbol en America','Programa dominical resumen de la fecha','22:00','24:00');
INSERT INTO programa VALUES (2,'Octavo Mandamiento','Programa de noticias','20:00','22:00');
INSERT INTO programa VALUES (3,'El show de carloncho','Programa de entretenimiento matutino','06:00','10:00');
INSERT INTO programa VALUES (4,'Hora y treinta','Programa de noticias','19:00','20:30');
INSERT INTO programa VALUES (5,'Yo soy','Concurso de imitacion musical peruano','18:00','20:00');
-- OYENTE
INSERT INTO oyente VALUES (1,'Elblanquiazul','Pass123','elblanquiazul@gmail.com','14-06-2023');
INSERT INTO oyente VALUES (2,'Elcrema','Pass124','elcrema@gmail.com','12-03-2023');
INSERT INTO oyente VALUES (3,'TrolNoticioso','Pass125','trolNoticioso@gmail.com','12-04-2023');
INSERT INTO oyente VALUES (4,'melomano','Pass126','melomano@gmail.com','12-01-2021');
INSERT INTO oyente VALUES (5,'musiclover','Pass127','musiclover@gmail.com','12-01-2022');
INSERT INTO oyente VALUES (6,'elinformante','Pass128','elinformante@gmail.com','12-02-2021');
-- CONDUCTOR
INSERT INTO conductor VALUES (1,'Erick Osores','FUTA0001',1);
INSERT INTO conductor VALUES (2,'Gonzales Nuñez','FUTA0002',1);
INSERT INTO conductor VALUES (3,'Jaime Chicha','OCTM0001',2);
INSERT INTO conductor VALUES (4,'Carlos Bandera','ESDC0001',3);
INSERT INTO conductor VALUES (5,'Renzo Winder','ESDC0002',3);
INSERT INTO conductor VALUES (6,'Mariana Espinoza','ESDC0003',3);
INSERT INTO conductor VALUES (7,'Mario Ghibellini','HY300001',4);
INSERT INTO conductor VALUES (8,'Adolfo Aguilar','EGSH0001',5);
INSERT INTO conductor VALUES (9,'Christian Rivero','EGSH0002',5);
INSERT INTO conductor VALUES (10,'Jesus Alzamora','EGSH0003',5);
-- SUSCRIPCION
INSERT INTO suscripcion VALUES (1,'Suscripcion streaming de futbol en america',3.0,'A',1);
INSERT INTO suscripcion VALUES (2,'Suscripcion por tv de futbol en america',0.5,'T',1);
INSERT INTO suscripcion VALUES (3,'Suscripcion por tv de octavo mandamiento',3.0,'T',2);
INSERT INTO suscripcion VALUES (4,'Suscripcion por radio de El show de carloncho',0.5,'R',3);
INSERT INTO suscripcion VALUES (5,'Suscripcion por tv de Hora y treinta',0.5,'T',4);
INSERT INTO suscripcion VALUES (6,'Suscripcion por tv de Yo soy',0.7,'T',5);
INSERT INTO suscripcion VALUES (7,'Suscripcion streaming de Yo soy',2.5,'A',5);
-- OYENTE
INSERT INTO oyente_suscripcion VALUES (1,1,1);
INSERT INTO oyente_suscripcion VALUES (2,2,1);
INSERT INTO oyente_suscripcion VALUES (3,2,2);
INSERT INTO oyente_suscripcion VALUES (4,3,3);
INSERT INTO oyente_suscripcion VALUES (5,3,6);
INSERT INTO oyente_suscripcion VALUES (6,4,4);
INSERT INTO oyente_suscripcion VALUES (7,5,6);
-- NOTA
INSERT INTO nota VALUES (1,'Editorial','Dada la conyuntura politica, el congreso esta agravando la situacion','arreglos en el congreso',1,2,1);
INSERT INTO nota VALUES (2,'Resumen Peru Corea','Peru gana y gusta','Peru gano a Corea 1 a 0',1,1,3);
INSERT INTO nota VALUES (3,'Nueva caida de la U','La U pierde nuevamente de local','En un partido deslucido, la U volvio a perder de local',1,1,3);
-- COMENTARIO
INSERT INTO comentario VALUES (1,'Mucho resumen del futbol local',3,1,1,3);
INSERT INTO comentario VALUES (2,'Mucho frio en el gallinero',2,1,2,3);
INSERT INTO comentario VALUES (3,'Jaime es muy tibio',2,1,1,1);




























