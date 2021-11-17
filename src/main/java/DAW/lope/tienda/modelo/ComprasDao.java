package DAW.lope.tienda.modelo;

import java.util.List;

public interface ComprasDao{
	int save(Compras compra);
	int deleteById(int id);
	List<Compras> findAll(int id);
}
