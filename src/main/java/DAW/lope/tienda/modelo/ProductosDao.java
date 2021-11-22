package DAW.lope.tienda.modelo;

import java.util.List;

import DAW.lope.tienda.Entidades.Producto;


public interface ProductosDao {
	int count();
	int save(Producto producto);
	int update(Producto producto);
	int deleteById(int id);
	List<Producto> findAll();
	List<Producto> findEight();
	Producto findById(int id);
	String getNameById(int id);
	List <Producto> getProductoByName(String name);
}