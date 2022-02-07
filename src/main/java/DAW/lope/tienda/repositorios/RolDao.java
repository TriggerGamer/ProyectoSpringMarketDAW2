package DAW.lope.tienda.repositorios;

import java.util.List;

import DAW.lope.tienda.entidades.Rol;
import DAW.lope.tienda.entidades.Usuario;

public interface RolDao extends DaoGenerico<Rol> {
	
	public Rol save(int id_Rol, Usuario usuario);
	public Rol findById(int id);	
}
