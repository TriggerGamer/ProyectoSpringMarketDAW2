package DAW.lope.tienda.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import DAW.lope.tienda.Entidades.Producto;
import DAW.lope.tienda.modelo.ProductosDao;

public class ServicioProductosImpl implements ServiciosProductos {
	@Autowired
	ProductosDao productosdao;

	@Override
	public List<Producto> findEight() {
		return productosdao.findEight();
	}

	@Override
	public List<Producto> getProductoByName(String name) {
		return productosdao.getProductoByName(name);
	}

	@Override
	public int saveProductos(Producto producto) {
		return productosdao.save(producto);
	}
	
	@Override
	public int deleteProductoById(int id) {

		return productosdao.deleteById(id);
	}

	@Override
	public Producto findProductoById(int id) {

		return productosdao.findById(id);
	}

}
