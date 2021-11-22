package DAW.lope.tienda.servicios;

import java.util.List;

import DAW.lope.tienda.Entidades.Compra;
import DAW.lope.tienda.Entidades.Producto;
import DAW.lope.tienda.Entidades.Usuario;

public interface ServiciosCompras {
	

	int saveCompras(int id_Usuario);
	
	int saveProductosCompra(int id_Compra, int id_Producto, int  numeroUnidades);

	
	int deleteCompra(int id);

	
	Compra getCompras(int id);

	
	List<Compra> findComprasUsuario(int id);
	
}
