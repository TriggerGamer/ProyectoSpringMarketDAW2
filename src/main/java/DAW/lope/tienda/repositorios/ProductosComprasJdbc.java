package DAW.lope.tienda.repositorios;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import DAW.lope.tienda.entidades.ProductosCompras;

@Repository
@Component("ProductosComprasDao")
public class ProductosComprasJdbc extends DaoGenericoImpl<ProductosCompras> implements ProductosComprasDao {

	@Override
	public boolean deleteProductosCompraById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
