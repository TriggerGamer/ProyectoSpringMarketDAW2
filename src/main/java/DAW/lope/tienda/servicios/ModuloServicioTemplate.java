package DAW.lope.tienda.servicios;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAW.lope.tienda.modelo.Productos;
import DAW.lope.tienda.modelo.ProductosDao;
import DAW.lope.tienda.modelo.Usuario;
import DAW.lope.tienda.modelo.UsuariosDao;

@Transactional
@Service
public class ModuloServicioTemplate implements ModuloServicio {
	@Autowired
	ProductosDao productosdao;
	@Autowired
	UsuariosDao usuariodao;

	@Override
	public List<Productos> findEight(){
		return productosdao.findEight();
	}

	@Override
	public List<Productos> getProductoByName(String name) {
		// TODO Auto-generated method stub
		return productosdao.getProductoByName(name);
	}

	@Override
	public int saveProductos(Productos producto) {
		// TODO Auto-generated method stub
		return productosdao.save(producto);
	}

	@Override
	public int saveUsuarios(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuariodao.save(usuario);
	}

	@Override
	public int deleteProductoById(int id) {
		// TODO Auto-generated method stub
		return productosdao.deleteById(id);
	}

	@Override
	public List<Productos> findProductoById(int id) {
		// TODO Auto-generated method stub
		return productosdao.findById(id);
	}

	@Override
	public Usuario login(String nombre, String contrasenia) {
		// TODO Auto-generated method stub
		return usuariodao.login(nombre, contrasenia);
	}

	@Override
	public List<Usuario> findUsuarioById(int id) {
		// TODO Auto-generated method stub
		return usuariodao.findById(id);
	}
}