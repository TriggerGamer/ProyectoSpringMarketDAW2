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

select * from Productos;

delete  from Productos;

drop table Productos;