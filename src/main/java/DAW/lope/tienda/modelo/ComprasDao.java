package DAW.lope.tienda.modelo;

import java.util.List;

import DAW.lope.tienda.entidades.Compras;

public interface ComprasDao extends DaoGenerico<Compras> {
	
	int saveProductosCompra(int id_Compra, int id_Producto, int numeroUnidades);
	int deleteCompraById(int id);
	int deleteProductosCompraById(int id);
	List<Compras> comprasUsuario(int id);
	
}
