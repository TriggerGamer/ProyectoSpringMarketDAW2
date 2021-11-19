package DAW.lope.tienda.modelo;

import java.util.List;

public interface ComprasDao {
	int save(Compra compra);

	int saveProductosCompra(int id_Compra, int id_Producto, int numeroUnidades);

	int deleteById(int id);

	int deleteProductosCompraById(int id);

	List<Compra> findAll(int id);

	Compra findIdCompra();
}
