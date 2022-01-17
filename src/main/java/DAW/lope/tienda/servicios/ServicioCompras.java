package DAW.lope.tienda.servicios;

import java.util.List;

import DAW.lope.tienda.entidades.Compras;
import DAW.lope.tienda.entidades.Usuario;

public interface ServicioCompras {
	
	public Compras crear(int id);
	public void borrar(Object id);	
	public int saveProductosCompra(int id_Compra, int id_Producto, int  numeroUnidades);	
	public int borrar(int id);	
	public Compras getCompras(int id);	
	public List<Compras> findComprasUsuario(int id);
	
}
