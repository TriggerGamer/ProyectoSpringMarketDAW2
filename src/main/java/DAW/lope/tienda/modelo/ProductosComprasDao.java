package DAW.lope.tienda.modelo;

import DAW.lope.tienda.entidades.ProductosCompras;

public interface ProductosComprasDao extends DaoGenerico<ProductosCompras>  {

	public boolean deleteProductosCompraById(int id);
}
