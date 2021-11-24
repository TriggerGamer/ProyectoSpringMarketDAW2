package DAW.lope.tienda.servicios;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Usuario login(String nombre, String contrasenia) {

		return usuariodao.login(nombre, contrasenia);
	}

	@Override
	public Usuario findUsuarioById(int id){
		return usuariodao.findById(id);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
