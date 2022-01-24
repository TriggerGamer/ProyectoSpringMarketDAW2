package DAW.lope.tienda.servicios;

import java.util.List;

import DAW.lope.tienda.entidades.Productos;

public interface ServicioProductos {
	
	public Productos crear(Productos productos);
	public void borrar(Object id);
	public List<Productos> findAll();
	public Productos findProductoById(int id);
	public List<Productos> findEight();
	public List<Productos> getProductoByName(String name);
	
}
