package DAW.lope.tienda.modelo;

import java.util.List;
import java.util.Optional;

public interface ProductosDao {
	int count();
	int save(Productos pts);
	int update(Productos pts);
	int deleteById(int id);
	List<Productos> findAll();
	Optional<Productos> findById(int id);
	String getNameById(int id);

}