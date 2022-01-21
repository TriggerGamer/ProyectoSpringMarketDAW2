package DAW.lope.tienda.modelo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import DAW.lope.tienda.entidades.ProductosCompras;

@Repository
@Component("ProductosComprasDao")
public class ProductosComprasJdbc extends DaoGenericoImpl<ProductosCompras> implements ProductosComprasDao {

	@Override
	public int saveProductosCompra(int id_Compra, int id_Producto, int numeroUnidades) {
		ProductosCompras productoscompras = new ProductosCompras();
		productoscompras.setNumeroUnidades(numeroUnidades);
		crear(productoscompras);
		return 0;
	}

	@Override
	public boolean deleteProductosCompraById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
