package DAW.lope.tienda.modelo;

import java.util.List;

import DAW.lope.tienda.entidades.Compra;

public interface ComprasDao extends DaoGenerico<Compra> {
	
	int save(Compra compra);
	int saveProductosCompra(int id_Compra, int id_Producto, int numeroUnidades);
	int deleteCompraById(int id);
	int deleteProductosCompraById(int id);
	List<Compra> comprasUsuario(int id);
	
}
