package DAW.lope.tienda.servicios;

import java.util.List;

import DAW.lope.tienda.modelo.Productos;
import DAW.lope.tienda.modelo.Usuarios;

public interface ModuloServicio {
	int saveProductos(Productos producto);
	int saveUsuarios(Usuarios usuario);
	int deleteProductoById(int id);
	List<Productos> findProductoById(int id);
	List<Usuarios> findUsuarioById(int id);
	List<Productos> findEight();
	List <Productos> getProductoByName(String name);
	List<Usuarios> login(String nombre, String contrasenia);
}
