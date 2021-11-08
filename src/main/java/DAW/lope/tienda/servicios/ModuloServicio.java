package DAW.lope.tienda.servicios;

import java.util.List;

import DAW.lope.tienda.modelo.Producto;
import DAW.lope.tienda.modelo.Usuario;

public interface ModuloServicio {
	int saveProductos(Producto producto);
	int saveUsuarios(Usuario usuario);
	int deleteProductoById(int id);
	List<Producto> findProductoById(int id);
	List<Usuario> findUsuarioById(int id);
	List<Producto> findEight();
	Usuario findByName(String nombre, String contrasenia);
	List <Producto> getProductoByName(String name);
	Usuario login(String nombre, String contrasenia);
}
