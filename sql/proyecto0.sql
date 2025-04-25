create database proyecto0;
use proyecto0;
create table equipo (
idEquipo int auto_increment primary key,
Nombre varchar (50) not null,
anyo_creacion int (4)
);
create table prueba (
    idprueba int auto_increment primary key,
    idfase int not null,
    numequipos int not null,
    numjueces int not null,
    mejororador bit not null
);
create table puntuacion (
    idpuntuacion int auto_increment primary key,
    idequipo1 int not null,
    idequipo2 int not null,
    puntuacion1 int not null,
    puntuacion2 int not null,
    observacion1 varchar(255),
    observacion2 varchar(255),
    penalizacion1 varchar(255),
    penalizacion2 varchar(255),
    foreign key (idequipo1) references equipo(idequipo),
    foreign key (idequipo2) references equipo(idequipo)
);

INSERT INTO equipo (Nombre, anyo_creacion) VALUES ('Madrid', 1945);
INSERT INTO equipo (Nombre, anyo_creacion) VALUES ('Barcelona', 1933);
INSERT INTO equipo (Nombre, anyo_creacion) VALUES ('Betis', 1907);
INSERT INTO equipo (Nombre, anyo_creacion) VALUES ('Mallorca', 1978);
INSERT INTO equipo (Nombre, anyo_creacion) VALUES ('Las Palmas', 1898);
INSERT INTO equipo (Nombre, anyo_creacion) VALUES ('Girona', 1920);
INSERT INTO equipo (Nombre, anyo_creacion) VALUES ('Alavés', 1931);
INSERT INTO equipo (Nombre, anyo_creacion) VALUES ('Bilbao', 1955);
INSERT INTO equipo (Nombre, anyo_creacion) VALUES ('Valladolid', 1936);
INSERT INTO equipo (Nombre, anyo_creacion) VALUES ('Leganés', 1978);
INSERT INTO equipo (Nombre, anyo_creacion) VALUES ('Celta', 1888);
INSERT INTO equipo (Nombre, anyo_creacion) VALUES ('Villareal', 1938);
INSERT INTO equipo (Nombre, anyo_creacion) VALUES ('Valencia', 1895);
INSERT INTO equipo (Nombre, anyo_creacion) VALUES ('Real Sociedad', 1947);
INSERT INTO equipo (Nombre, anyo_creacion) VALUES ('Atlético de Madrid', 1874);
INSERT INTO equipo (Nombre, anyo_creacion) VALUES ('Getafe', 1987);

INSERT INTO prueba (idfase, numequipos, numjueces, mejororador) VALUES (1, 2, 3, 1);
INSERT INTO prueba (idfase, numequipos, numjueces, mejororador) VALUES (1, 2, 3, 1);
INSERT INTO prueba (idfase, numequipos, numjueces, mejororador) VALUES (2, 4, 2, 0);
INSERT INTO prueba (idfase, numequipos, numjueces, mejororador) VALUES (3, 3, 1, 1);
INSERT INTO prueba (idfase, numequipos, numjueces, mejororador) VALUES (4, 5, 2, 0);
INSERT INTO prueba (idfase, numequipos, numjueces, mejororador) VALUES (5, 2, 3, 1);

INSERT INTO puntuacion (idequipo1, idequipo2, puntuacion1, puntuacion2, observacion1, observacion2, penalizacion1, penalizacion2) VALUES (1, 2, 85, 78, 'Buen uso de argumentos', 'Falta de claridad', 'Ninguna', 'Advertencia por tiempo');
INSERT INTO puntuacion (idequipo1, idequipo2, puntuacion1, puntuacion2, observacion1, observacion2, penalizacion1, penalizacion2) VALUES (3, 4, 92, 88, 'Muy persuasivo', 'Ligeramente repetitivo', 'Ninguna', 'Ninguna');
INSERT INTO puntuacion (idequipo1, idequipo2, puntuacion1, puntuacion2, observacion1, observacion2, penalizacion1, penalizacion2) VALUES (5, 6, 76, 81, 'Argumentos sólidos', 'Buena presentación', 'Advertencia leve', 'Ninguna');
INSERT INTO puntuacion (idequipo1, idequipo2, puntuacion1, puntuacion2, observacion1, observacion2, penalizacion1, penalizacion2) VALUES (7, 8, 89, 90, 'Excelente cohesión', 'Gran expresividad', 'Ninguna', 'Ninguna');
INSERT INTO puntuacion (idequipo1, idequipo2, puntuacion1, puntuacion2, observacion1, observacion2, penalizacion1, penalizacion2) VALUES (9, 10, 70, 75, 'Necesita mejorar estructura', 'Uso adecuado de ejemplos', 'Advertencia por interrupciones', 'Ninguna');
INSERT INTO puntuacion (idequipo1, idequipo2, puntuacion1, puntuacion2, observacion1, observacion2, penalizacion1, penalizacion2) VALUES (11, 12, 95, 93, 'Oratoria destacada', 'Muy buenos datos', 'Ninguna', 'Ninguna');

alter table equipo ADD CONSTRAINT nombre_unico UNIQUE (Nombre);
alter table prueba ADD CONSTRAINT prueba_unica UNIQUE (idfase, idprueba);
alter table puntuacion ADD CONSTRAINT puntuacion_unico UNIQUE (idpuntuacion,idequipo1, idequipo2);

delete from equipo where idEquipo = 16;

select nombre from equipo;

update equipo set nombre = "Osasuna" where idEquipo = 11;