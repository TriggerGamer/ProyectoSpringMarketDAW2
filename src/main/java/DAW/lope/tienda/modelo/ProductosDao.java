package DAW.lope.tienda.modelo;

import java.util.List;


public interface ProductosDao {
	int count();
	int save(Productos producto);
	int update(Productos producto);
	int deleteById(int id);
	List<Productos> findAll();
	List<Productos> findEight();
	List<Productos> findById(int id);
	String getNameById(int id);
	List <Productos> getProductoByName(String name);
}