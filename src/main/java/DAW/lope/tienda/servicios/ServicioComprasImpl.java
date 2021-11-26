package DAW.lope.tienda.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAW.lope.tienda.entidades.Compra;
import DAW.lope.tienda.modelo.ComprasDao;


@Transactional
@Service
public class ServicioComprasImpl implements ServicioCompras {
	
	@Autowired
	ComprasDao comprasdao;

	@Override
	public int saveCompras(int id_Usuario) {
		Compra compra = new Compra();
		compra.setId_Usuario(id_Usuario);
		return comprasdao.save(compra);
	}

	@Override
	public int deleteCompra(int id) {
		comprasdao.deleteProductosCompraById(id);
		return comprasdao.deleteCompraById(id);
	}
	
	@Override
	public Compra getCompras(int id) {
		Compra compra = new Compra();
		
		List<Compra> compras = comprasdao.findAll(id);
		
		compra = compras.get(0);
		
		return compra;
	}

	@Override
	public int saveProductosCompra(int id_Compra, int id_Producto, int numeroUnidades) {
		return comprasdao.saveProductosCompra(id_Compra, id_Producto, numeroUnidades);
	}

	@Override
	public List<Compra> findComprasUsuario(int id) {
		return comprasdao.findAll(id);
	}
	
}