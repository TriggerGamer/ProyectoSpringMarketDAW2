package DAW.lope.tienda.modelo;

import java.util.List;
import DAW.lope.tienda.entidades.Rol;

public interface RolDao {

	int save(Rol rol);
	List<Rol> buscarRol(int id);
}
