use tienda;
show tables;

create table Productos(
id_Productos int(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
tituloProducto VARCHAR(30),
descripcionProducto VARCHAR(100),
precio double(10,2),
descuento int(7)
);

INSERT INTO Productos(tituloProductProductoso, descripcionProducto, precio, descuento) VALUES("Ordenador Sobremesa", "Ordenador con i5, 16GB de RAM, Gráfica 1080ti con 2GB de RAM integrados, buena ventilacion y carcasa Krom set 12-33", 500.99, 10);
INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES("Lenovo IdeaCentre","Diseñado específicamente para catapultarte al mundo de los videojuegos y los deportes electrónicos, esta formidable torre desatará tus opciones de productividad y creatividad",757.07,7);
INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES("Silver AMD Ryzen 5","La nueva línea de Pcs de sobremesa para juegos creada tras un amplio trabajo de investigación para ofrecer el mayor rendimiento y optimización en el juego para nuestros cliente",1347.42,2);
INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES("MSI GF75 Thin","Te presentamos el portátil GF75 Thin de MSI, un portátil gaming con procesador Intel Core i7, 16GB de RAM, 512GB de SSD y gráfica Nvidia GeForce RTX 3060.",1227.34,0);
INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES("MSI GS75 Stealth","Prepárate para sentir todo el poder del juego con el potente ordenador portátil de MSI GS75 Stealth. Un portátil gaming dotado con un procesador Coffeelake i7, 32GB de RAM, 1TB SSD de almacenamiento, y todo bajo una potente gráfica NVIDIA GeForce® RTX 2060 GDDR6 6GB. ",1477.59,2);

select * from Productos;

delete  from Productos;

drop table Productos;