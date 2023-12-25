-- ************************************************************************
-- *** Esquema de la base de datos relacional personas					***
-- ***																	***
-- *** Autor: Francisco Jesús Delgado Almirón							***
-- *** Ciclo Formativo: Desarrollo de Aplicaciones Multiplataforma		***
-- *** Módulo Formativo: Programación Multimedia y Dispositivos Móviles	***
-- *** Curso: 2º             											***
-- ************************************************************************

-- Creo la base de datos

CREATE DATABASE personas;
USE personas;

--- Creo la tabla persona
--- En esta tabla se guardarán los datos de las personas

CREATE TABLE IF NOT EXISTS persona (
	DNI VARCHAR(10) PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL,
	apellidos VARCHAR(100) NOT NULL,
	telefono int NOT NULL,
	email VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

--- Inserto datos en la tabla persona

INSERT INTO persona (DNI, nombre, apellidos, telefono, email) VALUES ('14786325P', 'Juan', 'López López', 666666666, 'juanlopez@gmail.com');
INSERT INTO persona (DNI, nombre, apellidos, telefono, email) VALUES ('24158749L', 'Pepe', 'Adamuz Núñez', 666956666, 'pepeadamuz@gmail.com');
INSERT INTO persona (DNI, nombre, apellidos, telefono, email) VALUES ('36214758I', 'Dolores', 'Pérez Aguilera', 684766666, 'doloresperez@gmail.com');
