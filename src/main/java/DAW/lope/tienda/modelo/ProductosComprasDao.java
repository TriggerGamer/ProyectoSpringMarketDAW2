package DAW.lope.tienda.modelo;

import DAW.lope.tienda.entidades.Compras;
import DAW.lope.tienda.entidades.Producto;
import DAW.lope.tienda.entidades.ProductosCompras;

public interface ProductosComprasDao extends DaoGenerico<ProductosCompras>  {

	public int saveProductosCompra(Compras compra, Producto producto, int numeroUnidades);
	public boolean deleteProductosCompraById(int id);
}
