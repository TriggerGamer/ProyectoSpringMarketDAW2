package DAW.lope.tienda.servicios;

import java.util.List;

import DAW.lope.tienda.modelo.Compra;
import DAW.lope.tienda.modelo.Producto;
import DAW.lope.tienda.modelo.Usuario;

public interface ModuloServicio {
	int saveProductos(Producto producto);

	int saveUsuarios(Usuario usuario);

	int saveCompras(int id_Usuario);
	
	int saveProductosCompra(int id_Compra, int id_Producto, int  numeroUnidades);

	int deleteProductoById(int id);
	
	int deleteCompra(int id);

	Producto findProductoById(int id);

	Usuario findUsuarioById(int id);

	List<Producto> findEight();

	List<Producto> getProductoByName(String name);

	Compra getCompras(int id);

	Usuario login(String nombre, String contrasenia);
	
	List<Compra> findComprasUsuario(int id);
	
	
}
