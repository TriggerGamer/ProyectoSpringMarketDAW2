use tienda;
show tables;

create table Productos(
id_Productos int(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
tituloProducto VARCHAR(30),
descripcionProducto VARCHAR(100),
precio double(10,2),
descuento int(7)
);
INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES("Lenovo IdeaCentre","Diseñado específicamente para catapultarte al mundo de los videojuegos y los deportes electrónicos, esta formidable torre desatará tus opciones de productividad y creatividad",757.07,7);
INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES("Silver AMD Ryzen 5","La nueva línea de Pcs de sobremesa para juegos creada tras un amplio trabajo de investigación para ofrecer el mayor rendimiento y optimización en el juego para nuestros cliente",1347.42,2);
INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES("MSI GF75 Thin","Te presentamos el portátil GF75 Thin de MSI, un portátil gaming con procesador Intel Core i7, 16GB de RAM, 512GB de SSD y gráfica Nvidia GeForce RTX 3060.",1227.34,0);
INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES("MSI GS75 Stealth","Prepárate para sentir todo el poder del juego con el potente ordenador portátil de MSI GS75 Stealth. Un portátil gaming dotado con un procesador Coffeelake i7, 32GB de RAM, 1TB SSD de almacenamiento, y todo bajo una potente gráfica NVIDIA GeForce® RTX 2060 GDDR6 6GB. ",1477.59,2);
INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES("PNY Quadro RTX 6000","NVIDIA® Quadro RTX? 6000, impulsada por la arquitectura NVIDIA Turing y la plataforma NVIDIA RTX, ofrece el avance más importante de las últimas dos décadas en gráficos por ordenador para los flujos de trabajo profesionales.",4519.14,0);
INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES("Asus Rog Swift PG32UQX","ROG Swift PG32UQX. EL PRIMER MINI MONITOR LED PARA JUEGOS DEL MUNDO. El ROG Swift PG32UQX es el primer monitor para juegos 4K 144 Hz NVIDIA® G-SYNC® Ultimate.",3369,2);
INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES("Razer BlackWidow V3 Pro","El primer y más icónico teclado mecánico para juegos del mundo hace su próxima evolución revolucionaria. Entra a un nuevo meta inalámbrico con el Razer BlackWidow V3 Pro.",329.99,5);
INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES("Sony PlayStation 5 Standard + Ratchet & Clank","PlayStation® 5: Jugar no tiene límites. Experimenta cargas superrápidas gracias a una unidad de estado sólido (SSD) de alta velocidad, una inmersión más profunda con retroalimentación háptica, gatillos adaptables y audio 3D.",579.99,10);

create table Usuarios(
id_Usuario int(10) NOT NULL PRIMARY KEY auto_increment,
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
create table Pedidos(
id_Pedido int(10) NOT NULL PRIMARY KEY auto_increment,
id_Usuario int(10) NOT NULL,
id_Productos int(10) NOT NULL,
numeroUnidades int(3) NOT NULL,
fechaDeCompra DATE NOT NULL,
FOREIGN KEY (id_Usuario) REFERENCES Usuarios(id_Usuario),
FOREIGN KEY (id_Productos) REFERENCES Productos(id_Productos)
);

INSERT INTO Usuarios VALUES(2,"luis","Martinez", 'luis',"luis@.com","1994-12-12","12345678","luis","123","garcia plata de osma");
INSERT INTO Usuarios VALUES(1,"Luis","Martinez", 'contrafulanito',"luis@.com","1994-12-12","12345678","luis","123","garcia plata de osma");

delete from Usuarios;
drop table Usuarios;
SELECT * FROM Productos;
delete from Productos;
drop table Productos;

