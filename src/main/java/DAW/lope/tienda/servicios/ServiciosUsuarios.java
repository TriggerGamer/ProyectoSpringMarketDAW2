package DAW.lope.tienda.servicios;

import org.springframework.security.core.userdetails.UserDetailsService;

import DAW.lope.tienda.entidades.Usuario;

public interface ServiciosUsuarios extends UserDetailsService{
	
	int saveUsuarios(Usuario usuario);
	Usuario findUsuarioById(int id);
	Usuario login(String nombre, String contrasenia);
	
}
