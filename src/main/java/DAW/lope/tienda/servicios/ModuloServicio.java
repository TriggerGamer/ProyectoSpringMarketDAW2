package DAW.lope.tienda.servicios;

import java.util.List;

import DAW.lope.tienda.modelo.Productos;
import DAW.lope.tienda.modelo.Usuario;

public interface ModuloServicio {
	int saveProductos(Productos producto);
	int saveUsuarios(Usuario usuario);
	int deleteProductoById(int id);
	List<Productos> findProductoById(int id);
	List<Usuario> findUsuarioById(int id);
	List<Productos> findEight();
	List <Productos> getProductoByName(String name);
	Usuario login(String nombre, String contrasenia);
}
