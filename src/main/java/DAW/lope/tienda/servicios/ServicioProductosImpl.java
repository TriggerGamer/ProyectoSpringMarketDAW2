package DAW.lope.tienda.servicios;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAW.lope.tienda.entidades.Producto;
import DAW.lope.tienda.entidades.ProductosCompras;
import DAW.lope.tienda.modelo.ProductosDao;

@Transactional
@Service
public class ServicioProductosImpl implements ServicioProductos {

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
	public Producto findProductoById(int id) {

		return productosdao.findById(id);
	}

	@Override
	public List<Producto> findAll() {
		return productosdao.findAll();
	}

	@Override
	public Producto crear(Producto producto) {
		return productosdao.crear(producto);
	}

	@Override
	public void borrar(Object id) {		
		productosdao.borrar(id);		
	}

}
