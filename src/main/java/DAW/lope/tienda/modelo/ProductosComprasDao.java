package DAW.lope.tienda.modelo;

import DAW.lope.tienda.entidades.ProductosCompras;

public interface ProductosComprasDao extends DaoGenerico<ProductosCompras>  {

	public int saveProductosCompra(int id_Compra, int id_Producto, int numeroUnidades);
	public boolean deleteProductosCompraById(int id);
}
