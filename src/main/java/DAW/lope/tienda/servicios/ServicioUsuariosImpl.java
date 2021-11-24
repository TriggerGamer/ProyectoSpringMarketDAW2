package DAW.lope.tienda.servicios;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAW.lope.tienda.entidades.Usuario;
import DAW.lope.tienda.modelo.UsuariosDao;

@Transactional
@Service
public class ServicioUsuariosImpl implements ServiciosUsuarios, UserDetailsService {
	@Autowired
	UsuariosDao usuariodao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Override
	public int saveUsuarios(Usuario usuario) {
		
		usuario.setContrasenia(bCryptPasswordEncoder.encode(usuario.getContrasenia()));
		return usuariodao.save(usuario);
	}
	

	@Override
	public Usuario login(String nombreUsuario, String contrasenia) {

		return usuariodao.findByName(nombreUsuario);
	}

	@Override
	public Usuario findUsuarioById(int id){
		return usuariodao.findById(id);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuariodao.findByName(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

		return new org.springframework.security.core.userdetails.User(usuario.getNombreUsuario(), usuario.getContrasenia(), grantedAuthorities);
	}

}
