package DAW.lope.tienda.servicios;

import java.util.List;

import DAW.lope.tienda.modelo.Compras;
import DAW.lope.tienda.modelo.Producto;
import DAW.lope.tienda.modelo.Usuario;

public interface ModuloServicio {
	int saveProductos(Producto producto);
	int saveUsuarios(Usuario usuario);
	int saveCompras(Compras compra);
	int deleteProductoById(int id);
	int deleteCompra(int id);
	Producto findProductoById(int id);
	List<Usuario> findUsuarioById(int id);
	List<Producto> findEight();
	List <Producto> getProductoByName(String name);
	List<Compras> getCompras(int id);
	Usuario findByName(String nombre, String contrasenia);
	Usuario login(String nombre, String contrasenia);
}
