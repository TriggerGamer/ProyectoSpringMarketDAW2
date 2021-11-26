package DAW.lope.tienda.servicios;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import DAW.lope.tienda.entidades.Rol;
import DAW.lope.tienda.entidades.Usuario;

public interface ServicioUsuarios extends UserDetailsService{
	
	int saveUsuarios(Usuario usuario);
	Usuario findUsuarioById(int id);
	Usuario login(String nombreUsuario);
	List<Rol> getRoles(int id_Usuario);	
}
