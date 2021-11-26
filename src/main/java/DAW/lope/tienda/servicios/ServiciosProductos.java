package DAW.lope.tienda.servicios;

import java.util.List;

import DAW.lope.tienda.entidades.Producto;

public interface ServiciosProductos {
	int saveProductos(Producto producto);
	
	int deleteProductoById(int id);

	Producto findProductoById(int id);

	List<Producto> findEight();

	List<Producto> getProductoByName(String name);
}
