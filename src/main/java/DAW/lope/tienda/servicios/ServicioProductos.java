package DAW.lope.tienda.servicios;

import java.util.List;

import DAW.lope.tienda.entidades.Producto;
import DAW.lope.tienda.entidades.ProductosCompras;

public interface ServicioProductos {
	
	public Producto crear(Producto producto);
	public void borrar(Object id);
	public List<Producto> findAll();
	public Producto findProductoById(int id);
	public List<Producto> findEight();
	public List<Producto> getProductoByName(String name);
	public ProductosCompras guardarProductoCompra(int id_Producto, ProductosCompras producto);
	
}
