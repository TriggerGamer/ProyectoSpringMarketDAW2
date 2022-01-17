package DAW.lope.tienda.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAW.lope.tienda.entidades.Compras;
import DAW.lope.tienda.entidades.Usuario;
import DAW.lope.tienda.modelo.ComprasDao;
import DAW.lope.tienda.modelo.UsuariosDao;

@Transactional
@Service
public class ServicioComprasImpl implements ServicioCompras {
	
	@Autowired
	ComprasDao comprasdao;
	
	@Autowired
	UsuariosDao usuariodao;

	@Override
	public Compras crear(int id) {
		Compras compras = new Compras();
		Usuario usuario = usuariodao.findById(id);
		compras.setUsuario(usuario);
		return comprasdao.crear(compras);
	}

	@Override
	public int borrar(int id) {
		comprasdao.deleteProductosCompraById(id);
		return comprasdao.deleteCompraById(id);
	}
	
	@Override
	public Compras getCompras(int id) {
		
		Compras compras = new Compras();		
		List<Compras> compras1 = comprasdao.comprasUsuario(id);		
		compras1 = (List<Compras>) compras1.get(0);		
		return (Compras) compras1;
	}

	@Override
	public int saveProductosCompra(int id_Compra, int id_Producto, int numeroUnidades) {
		return comprasdao.saveProductosCompra(id_Compra, id_Producto, numeroUnidades);
	}

	@Override
	public List<Compras> findComprasUsuario(int id) {
		return comprasdao.comprasUsuario(id);
	}

	@Override
	public void borrar(Object id) {
		comprasdao.borrar(id);
	}
	
}