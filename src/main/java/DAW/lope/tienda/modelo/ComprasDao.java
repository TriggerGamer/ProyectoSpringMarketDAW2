package DAW.lope.tienda.modelo;

import java.util.List;

public interface ComprasDao {
	int save(Compras compra);

	int saveProductosCompra(int id_Compra, int id_Producto, int numeroUnidades);

	int deleteById(int id);

	List<Compras> findAll(int id);

	Compras findIdCompra();
}
