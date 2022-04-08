create schema bd_hibernate2;
use bd_hibernate2;

create table mascotas(
id_mascota int(11) not null auto_increment,
nombre varchar(45)not null,
raza varchar(45)default null,
sexo varchar(45)default null,
primary key(id_mascota)
);

CREATE TABLE persona(
id_persona int(11) NOT NULL,
nombre_persona varchar(45) DEFAULT NULL,
profesion_persona varchar(45) DEFAULT NULL,
telefono_persona varchar(45) DEFAULT NULL,
tipo_persona int(2) NOT NULL,
nacimiento_id int(11) NOT NULL,
sexo varchar(10) NOT NULL,
PRIMARY KEY (id_persona)
);
CREATE TABLE nacimiento(
id_nacimiento int(11) NOT NULL AUTO_INCREMENT ,
ciudad_nacimiento varchar(45) DEFAULT NULL,
departamento_nacimiento varchar(45) DEFAULT NULL,
fecha_nacimiento date DEFAULT NULL,
pais_nacimiento varchar(45) DEFAULT NULL,
PRIMARY KEY (id_nacimiento)
);

CREATE TABLE bd_hibernate2 . productos (
id_producto int (11) not null auto_increment,
nombre_producto varchar (45) not null,
precio_producto double not null,
primary key(id_producto)
);

create table bd_hibernate2 . personas_productos(
persona_id int(11) not null,
producto_id int (11) not null,
key FK_producto (producto_id),
key FK_persona (persona_id),
constraint FK_producto foreign key(producto_id) references productos (id_producto),
constraint FK_persona foreign key(persona_id) references persona (id_persona)
);

ALTER TABLE persona
ADD INDEX fk_persona_nacimiento (nacimiento_id ASC);
;
ALTER TABLE persona
ADD CONSTRAINT fk_persona_nacimiento
FOREIGN KEY (nacimiento_id)REFERENCES nacimiento (id_nacimiento)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

alter table bd_hibernate2 . mascotas add column persona_id int (11) null after sexo;

ALTER TABLE bd_hibernate2.mascotas
ADD INDEX fk_mascotas_persona_idx (persona_id ASC);
;
ALTER TABLE bd_hibernate2.mascotas
ADD CONSTRAINT fk_mascotas_persona
FOREIGN KEY (persona_id)
REFERENCES bd_hibernate2.persona (id_persona)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
