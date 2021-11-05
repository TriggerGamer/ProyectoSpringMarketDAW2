package DAW.lope.tienda.modelo;

import java.util.List;

public interface UsuariosDao {
	int count();
	int save(Usuario usuario);
	int update(Usuario usuario);
	int deleteById(int id);
	List<Usuario> findAll();
	List<Usuario> findById(int id);
	String getNameById(int id);
	Usuario login(String nombre, String contrasenia);
}
