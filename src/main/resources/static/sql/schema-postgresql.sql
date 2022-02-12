DROP TABLE IF EXISTS ProductosCompras;
DROP TABLE IF EXISTS UsuarioRol;
DROP TABLE IF EXISTS Imagen;
DROP TABLE IF EXISTS Respuestas;
DROP TABLE IF EXISTS Preguntas;
DROP TABLE IF EXISTS Compras;
DROP TABLE IF EXISTS Productos;
DROP TABLE IF EXISTS Roles;
DROP TABLE IF EXISTS Usuarios;

DROP TABLE IF EXISTS SPRING_SESSION_ATTRIBUTES;
DROP TABLE IF EXISTS SPRING_SESSION;

CREATE TABLE Productos 
(
id_Producto serial PRIMARY KEY NOT NULL,
tituloProducto VARCHAR ( 100 ),
descripcionProducto VARCHAR ( 300 ),
precio decimal ( 10, 2 ),
descuento INT
);

CREATE TABLE Usuarios 
(
id_Usuario serial PRIMARY KEY NOT NULL,
nombreUsuario VARCHAR ( 50 ) UNIQUE NOT NULL,
nombre VARCHAR ( 50 ),
apellidos VARCHAR ( 100 ),
contrasenia VARCHAR ( 100 ),
email VARCHAR ( 100 ),
fechaNacimiento DATE,
numeroTarjeta bigint,
titularTarjeta VARCHAR ( 100 ),
codigoSeguridad INT,
direccionFacturacion VARCHAR ( 200 )
);

CREATE TABLE Compras 
(
id_Compra serial UNIQUE NOT NULL,
id_Usuario INT NOT NULL,
fechaDeCompra DATE NOT NULL,
PRIMARY KEY(id_Compra, id_Usuario),
FOREIGN KEY (id_Usuario) REFERENCES Usuarios(id_Usuario)
);

CREATE TABLE ProductosCompras 
(
id_Compra INT NOT NULL,
id_Producto INT NOT Null,
numeroUnidades INT NOT NULL,
PRIMARY KEY(id_Compra, id_Producto),
foreign key (id_Producto) REFERENCES Productos(id_Producto),
foreign key (id_Compra) REFERENCES Compras(id_Compra) ON DELETE CASCADE
);

CREATE TABLE Roles 
(
id_Rol serial primary key,
nombre_Rol varchar ( 50 )
);

CREATE TABLE UsuarioRol 
(
id_Rol INT NOT NULL,
id_Usuario INT NOT NULL,
PRIMARY KEY (id_Rol, id_Usuario),
foreign key (id_Usuario) REFERENCES Usuarios(id_Usuario),
foreign key (id_Rol) REFERENCES Roles(id_Rol)
);

CREATE TABLE Imagen
(
id_Imagen serial PRIMARY KEY NOT NULL,
id_Producto INT NOT NULL,
Imagen BYTEA,
foreign key (id_Producto) REFERENCES Productos(id_Producto)
);

CREATE TABLE Preguntas
(
id_Pregunta Serial PRIMARY KEY NOT NULL,
id_Producto INT NOT NULL,
id_Usuario INT NOT NULL,
pregunta VARCHAR ( 300 ) NOT NULL,
fecha_Pregunta DATE NOT NULL,
foreign key (id_Producto) REFERENCES Productos(id_Producto),
foreign key (id_Usuario) REFERENCES Usuarios(id_Usuario)
);

CREATE TABLE Respuesta
(
id_Respuesta Serial PRIMARY KEY NOT NULL,
id_Pregunta INT NOT NULL,
id_Usuario INT NOT NULL,
respuesta VARCHAR ( 300 ) NOT NULL,
fecha_Respuesta DATE NOT NULL,
foreign key (id_Usuario) REFERENCES Usuarios(id_Usuario),
foreign key (id_Pregunta) REFERENCES Preguntas(id_Pregunta)
);

CREATE TABLE SPRING_SESSION (
	PRIMARY_ID CHAR(36) NOT NULL,
	SESSION_ID CHAR(36) NOT NULL,
	CREATION_TIME BIGINT NOT NULL,
	LAST_ACCESS_TIME BIGINT NOT NULL,
	MAX_INACTIVE_INTERVAL INT NOT NULL,
	EXPIRY_TIME BIGINT NOT NULL,
	PRINCIPAL_NAME VARCHAR(100),
	CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (PRIMARY_ID)
);

CREATE UNIQUE INDEX SPRING_SESSION_IX1 ON SPRING_SESSION (SESSION_ID);
CREATE INDEX SPRING_SESSION_IX2 ON SPRING_SESSION (EXPIRY_TIME);
CREATE INDEX SPRING_SESSION_IX3 ON SPRING_SESSION (PRINCIPAL_NAME);

CREATE TABLE SPRING_SESSION_ATTRIBUTES (
	SESSION_PRIMARY_ID CHAR(36) NOT NULL,
	ATTRIBUTE_NAME VARCHAR(200) NOT NULL,
	ATTRIBUTE_BYTES BYTEA NOT NULL,
	CONSTRAINT SPRING_SESSION_ATTRIBUTES_PK PRIMARY KEY (SESSION_PRIMARY_ID, ATTRIBUTE_NAME),
	CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_PRIMARY_ID) REFERENCES SPRING_SESSION(PRIMARY_ID) ON DELETE CASCADE
);