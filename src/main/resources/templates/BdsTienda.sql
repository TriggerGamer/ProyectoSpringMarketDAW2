use tienda;
show tables;

create table Productos(
id_Productos int(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
tituloProducto VARCHAR(30),
descripcionProducto VARCHAR(100),
precio double(10,2),
descuento int(7)
);

INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES("Ordenador Sobremesa",?,?,?);

select * from Productos;

delete  from Productos;

drop table Productos;