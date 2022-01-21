package DAW.lope.tienda.servicios;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import DAW.lope.tienda.entidades.Rol;
import DAW.lope.tienda.entidades.Usuario;

public interface ServicioUsuarios extends UserDetailsService{
	
	public Usuario crear(Usuario usuario);
	public void borrar(Object id);
	public Usuario findUsuarioById(int id);
	public Usuario login(String nombreUsuario);	
	
}
