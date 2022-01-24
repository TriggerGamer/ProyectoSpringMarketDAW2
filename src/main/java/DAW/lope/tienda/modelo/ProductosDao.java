package DAW.lope.tienda.modelo;

import java.util.List;

import DAW.lope.tienda.entidades.Producto;
import DAW.lope.tienda.entidades.ProductosCompras;

public interface ProductosDao  extends DaoGenerico<Producto> {
	public List<Producto> findAll();
	public List<Producto> findEight();
	public Producto findById(int id);
	public List <Producto> getProductoByName(String name);
}