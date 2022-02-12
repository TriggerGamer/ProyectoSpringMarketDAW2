package DAW.lope.tienda.servicios;

import org.springframework.security.core.userdetails.UserDetailsService;
import DAW.lope.tienda.entidades.Usuario;

public interface ServicioUsuarios extends UserDetailsService{
	
	public Usuario crear(Usuario usuario);
	public void borrar(int idUsuario);
	public Usuario findUsuarioById(int id);
	public Usuario login(String nombreUsuario);	
	
}
