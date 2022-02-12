package DAW.lope.tienda.servicios;

import java.util.HashSet;
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
import DAW.lope.tienda.repositorios.RolRepository;
import DAW.lope.tienda.repositorios.UsuariosRepository;

@Transactional
@Service
public class ServicioUsuariosImpl implements ServicioUsuarios, UserDetailsService {
	
	@Autowired
	UsuariosRepository usuarioRepository;
	
	@Autowired
	RolRepository rolRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;	

	@Override
	public Usuario login(String nombreUsuario) {
		return usuarioRepository.findByUsername(nombreUsuario);
	}

	@Override
	public Usuario findUsuarioById(int id){
		return usuarioRepository.getById(id);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.findByUsername(username);
		
		Set<Rol> roles = usuario.getRoles();
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		
		for(Rol rol : roles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(rol.getNombreRol()));
		}
		return new org.springframework.security.core.userdetails.User(usuario.getNombreUsuario(), usuario.getContrasenia(), grantedAuthorities);
	}
	
	@Override
	public Usuario crear(Usuario usuario) {		
		usuario.setContrasenia(bCryptPasswordEncoder.encode(usuario.getContrasenia()));
		Rol rol = rolRepository.getById(2);
		usuario.anadirRol(rol);
		return usuarioRepository.save(usuario);
	}

	@Override
	public void borrar(int idUsuario) {
		try {
			usuarioRepository.deleteById(idUsuario);
		} catch (Exception e) {
		}
	}

}
