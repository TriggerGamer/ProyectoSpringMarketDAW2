package DAW.lope.tienda.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAW.lope.tienda.modelo.Compra;
import DAW.lope.tienda.modelo.ComprasDao;
import DAW.lope.tienda.modelo.Producto;
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
	@Autowired
	ComprasDao comprasdao;

	@Override
	public List<Producto> findEight() {
		return productosdao.findEight();
	}

	@Override
	public List<Producto> getProductoByName(String name) {
		// TODO Auto-generated method stub
		return productosdao.getProductoByName(name);
	}

	@Override
	public int saveProductos(Producto producto) {
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
	public Producto findProductoById(int id) {
		// TODO Auto-generated method stub
		return productosdao.findById(id);
	}

	@Override
	public Usuario login(String nombre, String contrasenia) {
		// TODO Auto-generated method stub
		return usuariodao.login(nombre, contrasenia);
	}

	@Override
	public Usuario findUsuarioById(int id) {
		// TODO Auto-generated method stub
		return usuariodao.findById(id);
	}

	@Override
	public int saveCompras(int id_Usuario) {
		// TODO Auto-generated method stub
		Compra compra = new Compra();
		compra.setId_Usuario(id_Usuario);
		return comprasdao.save(compra);
	}

	@Override
	public int deleteCompra(int id) {
		// TODO Auto-generated method stub
		return comprasdao.deleteById(id);
	}

	@Override
	public Compra getCompras(int id) {
		Compra compra = new Compra();
		
		List<Compra> compras = comprasdao.findAll(id);
		
		compra = compras.get(0);
		
		return compra;
	}

	@Override
	public int saveProductosCompra(int id_Compra, int id_Producto, int numeroUnidades) {
		// TODO Auto-generated method stub
		return comprasdao.saveProductosCompra(id_Compra, id_Producto, numeroUnidades);
	}
	
}