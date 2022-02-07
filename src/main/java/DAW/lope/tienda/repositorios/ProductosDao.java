package DAW.lope.tienda.repositorios;

import java.util.List;

import DAW.lope.tienda.entidades.Productos;
import DAW.lope.tienda.entidades.ProductosCompras;

public interface ProductosDao  extends DaoGenerico<Productos> {
	public List<Productos> findAll();
	public List<Productos> findEight();
	public Productos findById(int id);
	public List <Productos> getProductoByName(String name);
}