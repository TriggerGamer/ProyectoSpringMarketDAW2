package DAW.lope.tienda.modelo;

import java.util.List;
import java.util.Optional;

public interface UsuariosDao {
	int count();
	int save(Usuarios usuario);
	int update(Usuarios usuario);
	int deleteById(int id);
	List<Usuarios> findAll();
	List<Usuarios> findById(int id);
	String getNameById(int id);
	Optional<Usuarios> login(String nombre, String contrasenia);
}
