DROP DATABASE IF EXISTS adt4_ejemplo2;

CREATE DATABASE adt4_ejemplo2;

USE adt4_ejemplo2;

CREATE TABLE alumno(
	idAlumno		INT NOT NULL AUTO_INCREMENT,
	nombre 			VARCHAR(50),
	apellido 		VARCHAR(100),
	dni				VARCHAR(10),
	fechaNacimiento DATE,
	PRIMARY KEY(idAlumno)
);

CREATE TABLE curso(
	idCurso					INT NOT NULL AUTO_INCREMENT,
	nombre					VARCHAR(50),
	PRIMARY KEY(idCurso)
);

CREATE TABLE asignatura(
	idAsignatura			INT NOT NULL AUTO_INCREMENT,
	nombre 					VARCHAR(100),
	numeroHorasSemanales 	INT,
	idCurso					INT,
	PRIMARY KEY(idAsignatura),
	FOREIGN KEY (idCurso) REFERENCES curso(idCurso) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE alumno_asignatura(
	idAlumno		INT NOT NULL,
	idAsignatura	INT NOT NULL,
	PRIMARY KEY (idAlumno, idAsignatura),
	FOREIGN KEY (idAlumno) REFERENCES alumno(idAlumno) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (idAsignatura) REFERENCES asignatura(idAsignatura) ON DELETE CASCADE ON UPDATE CASCADE
);


INSERT INTO Curso(Nombre) VALUES ('1º DAM');
INSERT INTO Curso(Nombre) VALUES ('2º DAM');
INSERT INTO Curso(Nombre) VALUES ('1º ASIR');
INSERT INTO Curso(Nombre) VALUES ('2º ASIR');
INSERT INTO Curso(Nombre) VALUES ('1º DAW');
INSERT INTO Curso(Nombre) VALUES ('2º DAW');
COMMIT;

INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Planificación y administración de redes.',3,6);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Implantación de sistemas operativos.',3,7);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Fundamentos de hardware.',3,3);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Gestión de bases de datos.',3,5);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Lenguajes de marcas y sistemas de gestión de información.',3,3);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Formación y orientación laboral.',3,3);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Horario reservado para el módulo impartido en inglés.',3,3);
COMMIT;

INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Administración de sistemas operativos.',4,6);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Servicios de red e Internet.',4,6);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Implantación de aplicaciones web.',4,5);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Administración de sistemas gestores de bases de datos.',4,3);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Seguridad y alta disponibilidad.',4,5);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Empresa e iniciativa emprendedora.',4,3);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Proyecto de administración de sistemas informáticos en red.',4,40);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Horario reservado para el módulo impartido en inglés.',4,2);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Formación en Centros de Trabajo.',4,400);
COMMIT;

INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Lenguajes de marcas y sistemas de gestión de información.',5,3);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Sistemas informáticos.',5,5);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Bases de datos.',5,5);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Programación.',5,8);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Entornos de desarrollo.',5,3);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Formación y orientación laboral.',5,3);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Horario reservado para el módulo impartido en inglés.',5,3);
COMMIT;

INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Desarrollo web en entorno cliente.',6,7);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Desarrollo web en entorno servidor.',6,8);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Despliegue de aplicaciones web.',6,4);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Diseño de interfaces web.',6,6);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Proyecto de Desarrollo de aplicaciones web.',6,40);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Empresa e iniciativa emprendedora.',6,3);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Horario reservado para el módulo impartido en inglés.',6,2);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Formación en Centros de Trabajo.',6,400);
COMMIT;

INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Lenguajes de marcas y sistemas de gestión de información.',1,3);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Sistemas informáticos.',1,5);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Bases de Datos.',1,5);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Programación.',1,8);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Entornos de desarrollo.',1,3);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Formación y Orientación Laboral.',1,3);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Horario reservado para el módulo impartido en inglés.',1,3);
COMMIT;

INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Acceso a datos.',2,6);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Desarrollo de interfaces.',2,6);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Programación multimedia y dispositivos móviles.',2,5);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Programación de servicios y procesos.',2,3);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Sistemas de gestión empresarial.',2,5);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Empresa e iniciativa emprendedora.',2,3);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Proyecto de Desarrollo de aplicaciones multiplataforma.',2,40);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Horario reservado para el módulo impartido en inglés.',2,2);
INSERT INTO asignatura(Nombre,idCurso,numeroHorasSemanales) VALUES ('Formación en Centros de Trabajo.',2,400);
COMMIT;

INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Pedro','Inostroza','27100220A','1970-05-01');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Juan','Marchant','22100120B','1971-10-02');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Pamela','Aguirre','03100114C','1972-03-15');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Mónica','Villanueva','22002201D','1973-04-20');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Ignacio','Madariaga','23100222E','1970-05-25');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Camilo','Zuñiga','21112014F','1971-06-03');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Alejandro','Zurita','25072935G','1972-01-06');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Fernando','Condeza','10012012H','1973-02-09');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Andrés','Poblete','26201496I','1980-07-12');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Yilun','Hernández','29220123J','1981-08-15');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Andrés','Pasten','17000201K','1982-09-18');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Andrés','Mella','27100121L','1983-10-21');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Alejandro','Bustos','29002013M','1976-11-24');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Andrea','Muñoz','18102204N','1977-12-27');
INSERT INTO alumno(nombre,apellido,dni,fechanacimiento) VALUES ('Ignacio','Rojas','17475289O','1978-12-31');
COMMIT;

INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (1,1);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (1,2);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (1,3);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (1,4);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (2,1);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (2,2);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (2,3);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (3,9);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (3,10);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (3,11);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (4,18);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (4,19);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (4,20);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (4,21);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (5,19);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (5,20);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (5,21);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (6,18);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (6,19);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (6,20);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (6,21);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (7,25);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (7,26);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (7,27);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (7,28);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (8,25);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (8,27);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (9,27);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (9,28);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (10,29);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (10,30);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (10,31);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (11,29);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (11,30);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (12,34);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (12,35);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (12,36);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (12,37);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (13,40);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (13,41);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (13,42);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (13,43);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (14,40);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (14,41);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (14,42);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (14,43);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (15,44);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (15,45);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (15,46);
INSERT INTO Alumno_Asignatura(idAlumno, idAsignatura) VALUES (15,47);
COMMIT;

