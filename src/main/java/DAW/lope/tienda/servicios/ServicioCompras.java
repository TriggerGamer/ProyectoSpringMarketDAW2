package DAW.lope.tienda.servicios;

import java.util.List;

import DAW.lope.tienda.entidades.Compras;
import DAW.lope.tienda.entidades.Usuario;

public interface ServicioCompras {
	

	int saveCompras(Usuario id_Usuario);
	
	int saveProductosCompra(int id_Compra, int id_Producto, int  numeroUnidades);

	
	int deleteCompra(int id);

	
	Compras getCompras(int id);

	
	List<Compras> findComprasUsuario(int id);
	
}
