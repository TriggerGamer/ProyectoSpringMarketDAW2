package DAW.lope.tienda.servicios;

import DAW.lope.tienda.Entidades.Usuario;

public interface ServiciosUsuarios {
	
	int saveUsuarios(Usuario usuario);
	Usuario findUsuarioById(int id);
	Usuario login(String nombre, String contrasenia);
	
}
