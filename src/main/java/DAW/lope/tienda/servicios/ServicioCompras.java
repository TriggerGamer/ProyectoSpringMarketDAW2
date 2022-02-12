package DAW.lope.tienda.servicios;

import java.util.List;

import DAW.lope.tienda.entidades.Compras;

public interface ServicioCompras {
	
	public Compras crear(int id, Compras compras);		
	public void borrar(int id);	
	public Compras getComprasbyId(int idCompra);	
	public List<Compras> findComprasUsuario(int idUsuario);
	
}
