package DAW.lope.tienda.modelo;

import java.util.List;

public interface ComprasDao{
	int save(Carrito carrito);
	int deleteById(int id);
	List<Carrito> findAll(int id);
}
