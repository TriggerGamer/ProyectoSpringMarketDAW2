DROP DATABASE IF EXISTS Tienda;
CREATE DATABASE IF NOT EXISTS Tienda;
use Tienda;

create table Productos(
id_Producto int(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
tituloProducto VARCHAR(100),
descripcionProducto VARCHAR(300),
precio double(10,2),
descuento int(5)
);

create table Usuarios(
id_Usuario int(10) NOT NULL PRIMARY KEY auto_increment,
nombreUsuario VARCHAR(50) UNIQUE,
nombre VARCHAR(50),
apellidos varchar(100),
contrasenia VARCHAR(100),
email VARCHAR(100),
fechaNacimiento date,
numeroTarjeta BIGINT,
titularTarjeta VARCHAR (100),
codigoSeguridad INT(3),
direccionFacturacion VARCHAR (200)
);

create table Compras(
id_Compra int(10) NOT NULL auto_increment,
id_Usuario int(10) NOT NULL,
fechaDeCompra DATE NOT NULL,
PRIMARY KEY(id_Compra, id_Usuario),
FOREIGN KEY (id_Usuario) REFERENCES Usuarios(id_Usuario)
);

create table ProductosCompras(
compra_id_Compra int(10) NOT NULL,
producto_id_Producto int(10) NOT NUll,
numeroUnidades int(3) NOT NULL,
PRIMARY KEY(compra_id_Compra, producto_id_Producto),
foreign key (producto_id_Producto) REFERENCES Productos(id_Producto),
foreign key (compra_id_Compra) REFERENCES Compras(id_Compra) ON DELETE CASCADE
);

create table Roles(
id_Rol int(10) primary key auto_increment,
nombre_Rol varchar(50)
);

create table UsuarioRol(
id_Rol int(10),
id_Usuario int(10),
PRIMARY KEY (id_Usuario, id_Rol),
foreign key (id_Usuario) REFERENCES Usuarios(id_Usuario),
foreign key (id_Rol) REFERENCES Roles(id_Rol)
);

create table Imagen(
id_Imagen int(5) PRIMARY KEY NOT NULL AUTO_INCREMENT,
id_Producto int(10) NOT NULL,
Imagen LONGBLOB,
foreign key (id_Producto) REFERENCES Productos(id_Producto)
);

create table Preguntas(
id_Pregunta int(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
id_Producto int(10) NOT NULL,
id_Usuario int(10) NOT NULL,
pregunta VARCHAR(300) NOT NULL,
fecha_Pregunta DATE,
foreign key (id_Producto) REFERENCES Productos(id_Producto),
foreign key (id_Usuario) REFERENCES Usuarios(id_Usuario)
);

create table Respuestas(
id_Respuesta int(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
id_Pregunta int(10) NOT NULL,
id_Usuario int(10) NOT NULL,
respuesta VARCHAR(300) NOT NULL,
fecha_Respuesta DATE,
foreign key (id_Usuario) REFERENCES Usuarios(id_Usuario),
foreign key (id_Pregunta) REFERENCES Preguntas(id_Pregunta)
);

CREATE TABLE `SPRING_SESSION` (
`PRIMARY_ID` char(36) NOT NULL,
 `SESSION_ID` char(36) NOT NULL,
 `CREATION_TIME` bigint NOT NULL,
 `LAST_ACCESS_TIME` bigint NOT NULL,
 `MAX_INACTIVE_INTERVAL` int NOT NULL,
 `EXPIRY_TIME` bigint NOT NULL,
 `PRINCIPAL_NAME` varchar(100) DEFAULT NULL,
 PRIMARY KEY (`PRIMARY_ID`),
 UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
 KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
 KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
 
 CREATE TABLE `SPRING_SESSION_ATTRIBUTES` (
   `SESSION_PRIMARY_ID` char(36) NOT NULL,
   `ATTRIBUTE_NAME` varchar(200) NOT NULL,
   `ATTRIBUTE_BYTES` blob NOT NULL,
   PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`),
   CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `SPRING_SESSION` (`PRIMARY_ID`) ON DELETE CASCADE
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
