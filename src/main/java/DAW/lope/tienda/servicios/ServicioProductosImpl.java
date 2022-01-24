package DAW.lope.tienda.servicios;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAW.lope.tienda.entidades.Productos;
import DAW.lope.tienda.entidades.ProductosCompras;
import DAW.lope.tienda.modelo.ProductosDao;

@Transactional
@Service
public class ServicioProductosImpl implements ServicioProductos {

	@Autowired
	ProductosDao productosdao;

	@Override
	public List<Productos> findEight() {
		return productosdao.findEight();
	}

	@Override
	public List<Productos> getProductoByName(String name) {
		return productosdao.getProductoByName(name);
	}


	@Override
	public Productos findProductoById(int id) {

		return productosdao.findById(id);
	}

	@Override
	public List<Productos> findAll() {
		return productosdao.findAll();
	}

	@Override
	public Productos crear(Productos productos) {
		return productosdao.crear(productos);
	}

	@Override
	public void borrar(Object id) {		
		productosdao.borrar(id);		
	}

}
