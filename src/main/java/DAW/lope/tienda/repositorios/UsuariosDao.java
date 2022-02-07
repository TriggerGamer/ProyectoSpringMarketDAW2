package DAW.lope.tienda.repositorios;

import java.util.List;

import DAW.lope.tienda.entidades.Usuario;

public interface UsuariosDao extends DaoGenerico<Usuario>{

	public List<Usuario> findAll();
	public Usuario findById(int id);
	public Usuario findByName(String nombreUsuario);
	
}
