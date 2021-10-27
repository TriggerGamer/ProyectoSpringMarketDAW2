package DAW.lope.tienda.modelo;

import java.util.List;

public interface UsuariosDao {
	int count();
	int save(Usuarios usuario);
	int update(Usuarios usuario);
	int deleteById(int id);
	List<Productos> findAll();
	List<Productos> findEight();
	List<Productos> findById(int id);
	String getNameById(int id);
	List <Productos> getProductoByName(String name);
}
