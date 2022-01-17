package DAW.lope.tienda.servicios;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import DAW.lope.tienda.entidades.Rol;
import DAW.lope.tienda.entidades.Usuario;
import DAW.lope.tienda.modelo.RolDao;
import DAW.lope.tienda.modelo.UsuariosDao;

@Transactional
@Service
public class ServicioUsuariosImpl implements ServicioUsuarios, UserDetailsService {
	
	@Autowired
	UsuariosDao usuariodao;
	
	@Autowired
	RolDao roldao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;	

	@Override
	public Usuario login(String nombreUsuario) {
		return usuariodao.findByName(nombreUsuario);
	}

	@Override
	public Usuario findUsuarioById(int id){
		return usuariodao.findById(id);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuariodao.findByName(username);
		
		List<Rol> roles = getRoles(usuario.getId_Usuario());
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		
		for(Rol rol : roles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(rol.getNombreRol()));
		}
		return new org.springframework.security.core.userdetails.User(usuario.getNombreUsuario(), usuario.getContrasenia(), grantedAuthorities);
	}


	@Override
	public List<Rol> getRoles(int id_Usuario) {
		return roldao.buscarRol(id_Usuario);
	}

	@Override
	public Usuario crear(Usuario usuario) {		
		usuario.setContrasenia(bCryptPasswordEncoder.encode(usuario.getContrasenia()));
		Rol rol = roldao.findById(2);
		usuario.anadirRol(rol);
		return usuariodao.crear(usuario);
	}

	@Override
	public void borrar(Object id) {
		usuariodao.borrar(id);
	}

}
