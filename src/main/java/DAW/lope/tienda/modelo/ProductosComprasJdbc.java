package DAW.lope.tienda.modelo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import DAW.lope.tienda.entidades.Compras;
import DAW.lope.tienda.entidades.Producto;
import DAW.lope.tienda.entidades.ProductosCompras;

@Repository
@Component("ProductosComprasDao")
public class ProductosComprasJdbc extends DaoGenericoImpl<ProductosCompras> implements ProductosComprasDao {

	@Override
	public int saveProductosCompra(Compras compra, Producto producto, int numeroUnidades) {
		ProductosCompras productoscompras = new ProductosCompras();
		productoscompras.setNumeroUnidades(numeroUnidades);
		productoscompras.addCompra(compra);
		productoscompras.addProductos(producto);
		
		crear(productoscompras);

		return 0;
	}

	@Override
	public boolean deleteProductosCompraById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
