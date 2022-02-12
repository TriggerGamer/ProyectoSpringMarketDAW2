package DAW.lope.tienda.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAW.lope.tienda.entidades.Productos;
import DAW.lope.tienda.repositorios.ProductosRepository;

@Transactional
@Service
public class ServicioProductosImpl implements ServicioProductos {

	@Autowired
	ProductosRepository productosRepository;

	@Override
	public List<Productos> findEight() {
		return productosRepository.findEight();
	}

	@Override
	public List<Productos> getProductoByName(String name) {
		return productosRepository.findBytituloProductoContaining(name);
	}


	@Override
	public Productos findProductoById(int id) {

		return productosRepository.getById(id);
	}

	@Override
	public List<Productos> findAll() {
		return productosRepository.findAll();
	}

	@Override
	public Productos crear(Productos productos) {
		return productosRepository.save(productos);
	}

	@Override
	public void borrar(int idProducto) {
		try {
			productosRepository.deleteById(idProducto);		
		}catch (Exception e) {
			
		}
		
	}

}
