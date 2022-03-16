INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES('Lenovo IdeaCentre','Diseñado específicamente para catapultarte al mundo de los videojuegos y los deportes electrónicos, esta formidable torre desatará tus opciones de productividad y creatividad',757.07,7);
INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES('Silver AMD Ryzen 5','La nueva línea de Pcs de sobremesa para juegos creada tras un amplio trabajo de investigación para ofrecer el mayor rendimiento y optimización en el juego para nuestros cliente',1347.42,2);
INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES('MSI GF75 Thin','Te presentamos el portátil GF75 Thin de MSI, un portátil gaming con procesador Intel Core i7, 16GB de RAM, 512GB de SSD y gráfica Nvidia GeForce RTX 3060.',1227.34,0);
INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES('MSI GS75 Stealth','Prepárate para sentir todo el poder del juego con el potente ordenador portátil de MSI GS75 Stealth. Un portátil gaming dotado con un procesador Coffeelake i7, 32GB de RAM, 1TB SSD de almacenamiento, y todo bajo una potente gráfica NVIDIA GeForce® RTX 2060 GDDR6 6GB.',1477.59,2);
INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES('PNY Quadro RTX 6000','NVIDIA® Quadro RTX? 6000, impulsada por la arquitectura NVIDIA Turing y la plataforma NVIDIA RTX, ofrece el avance más importante de las últimas dos décadas en gráficos por ordenador para los flujos de trabajo profesionales.',4519.14,0);
INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES('Asus Rog Swift PG32UQX','ROG Swift PG32UQX. EL PRIMER MINI MONITOR LED PARA JUEGOS DEL MUNDO. El ROG Swift PG32UQX es el primer monitor para juegos 4K 144 Hz NVIDIA® G-SYNC® Ultimate.',3369,2);
INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES('Razer BlackWidow V3 Pro','El primer y más icónico teclado mecánico para juegos del mundo hace su próxima evolución revolucionaria. Entra a un nuevo meta inalámbrico con el Razer BlackWidow V3 Pro.',329.99,5);
INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES('Sony PlayStation 5 Standard + Ratchet & Clank','PlayStation® 5: Jugar no tiene límites. Experimenta cargas superrápidas gracias a una unidad de estado sólido (SSD) de alta velocidad, una inmersión más profunda con retroalimentación háptica, gatillos adaptables y audio 3D.',579.99,10);

INSERT INTO Usuarios(nombreUsuario, nombre, apellidos, contrasenia, email, fechaNacimiento, numeroTarjeta, titularTarjeta, codigoSeguridad, direccionFacturacion) VALUES('erick', 'Erick', 'Jaquez', '$2a$10$QZNeYmpAQxPhaoHI5boMVunUHScXf4Miqsj/ybhjqXmAZvkbxv0Xu', 'ff@bruh.es', '2002-05-29', 515454153, 'Erick', 214, 'Algun sitio');
INSERT INTO Usuarios(nombreUsuario, nombre, apellidos, contrasenia, email, fechaNacimiento, numeroTarjeta, titularTarjeta, codigoSeguridad, direccionFacturacion) VALUES('luis', 'Luis', 'Martinez', '$2a$10$GGKnxwVNXW5Nv4gOfEK04O3GetwwQ474sdC5E03TroYaCfIx1ItaS', 'ereasgfawdf@ff.com', '1994-06-15', 12342456454, 'Luis', 452, 'Lugar lugar'); 
INSERT INTO Usuarios(nombreUsuario, nombre, apellidos, contrasenia, email, fechaNacimiento, numeroTarjeta, titularTarjeta, codigoSeguridad, direccionFacturacion) VALUES('registrado', 'registrado', 'registrado', '$2a$10$BNUWqPLsxWTY/J.o9CtDLu06N9iPcBDw1EJs6.hbWVG6eTCw552Ki', 'registrado@registrado.com', '2022-02-05', '123', 'registrado', '213', 'registrado');
INSERT INTO Usuarios(nombreUsuario, nombre, apellidos, contrasenia, email, fechaNacimiento, numeroTarjeta, titularTarjeta, codigoSeguridad, direccionFacturacion) VALUES('registrado2', 'registrado2', 'registrado2', '$2a$10$BNUWqPLsxWTY/J.o9CtDLu06N9iPcBDw1EJs6.hbWVG6eTCw552Ki', 'registrado2@bruh.es', '2002-05-29', 515454153, 'registrado2', 214, 'registrado2 sitio');

INSERT INTO Roles (nombre_rol) VALUES ('Admin');
INSERT INTO Roles (nombre_rol) VALUES ('Registrado');
INSERT INTO Roles (nombre_rol) VALUES ('Publico');

INSERT INTO UsuarioRol VALUES(1, 1);
INSERT INTO UsuarioRol VALUES(1, 2); 
INSERT INTO UsuarioRol VALUES(2, 1);
INSERT INTO UsuarioRol VALUES(2, 2); 
INSERT INTO UsuarioRol VALUES(2, 3); 
INSERT INTO UsuarioRol VALUES(2, 4); 