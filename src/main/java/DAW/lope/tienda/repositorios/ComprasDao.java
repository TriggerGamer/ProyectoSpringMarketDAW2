package DAW.lope.tienda.repositorios;

import java.util.List;

import DAW.lope.tienda.entidades.Compras;

public interface ComprasDao extends DaoGenerico<Compras> {
	
	
	public boolean deleteCompraById(int id);
	public List<Compras> comprasUsuario(int id);
	
}
