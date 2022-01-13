package DAW.lope.tienda.modelo;

import java.util.List;

import DAW.lope.tienda.entidades.Usuario;

public interface UsuariosDao extends DaoGenerico<Usuario>{

	public Usuario save(Usuario usuario);

	int update(Usuario usuario);

	int deleteById(int id);

	public List<Usuario> findAll();

	Usuario findById(int id);

	Usuario findByName(String nombreUsuario);
}
