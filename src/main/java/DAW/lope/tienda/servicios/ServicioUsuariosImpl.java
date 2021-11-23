package DAW.lope.tienda.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAW.lope.tienda.Entidades.Usuario;
import DAW.lope.tienda.modelo.UsuariosDao;

@Transactional
@Service
public class ServicioUsuariosImpl implements ServiciosUsuarios {
	@Autowired
	UsuariosDao usuariodao;
	
	@Override
	public int saveUsuarios(Usuario usuario) {

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

}
