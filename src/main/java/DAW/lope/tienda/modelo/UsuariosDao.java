package DAW.lope.tienda.modelo;

import java.util.List;

import DAW.lope.tienda.Entidades.Usuario;

public interface UsuariosDao {
	int count();

	int save(Usuario usuario);

	int update(Usuario usuario);

	int deleteById(int id);

	List<Usuario> findAll();

	Usuario findById(int id);

	Usuario login(String nombre, String contrasenia);
}
