package DAW.lope.tienda.servicios;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAW.lope.tienda.entidades.Compras;

import DAW.lope.tienda.entidades.Usuario;
import DAW.lope.tienda.repositorios.ComprasDao;
import DAW.lope.tienda.repositorios.ProductosComprasDao;
import DAW.lope.tienda.repositorios.ProductosDao;
import DAW.lope.tienda.repositorios.UsuariosDao;

@Transactional
@Service
public class ServicioComprasImpl implements ServicioCompras {
	
	@Autowired
	ComprasDao comprasdao;
	
	@Autowired
	ProductosDao productosdao;
	
	@Autowired
	ProductosComprasDao productoscomprasdao;
	
	@Autowired
	UsuariosDao usuariodao;

	@Override
	public Compras crear(int id_usuario, Compras compras) {
		
		Usuario usuario = usuariodao.findById(id_usuario);
		compras.setFechaDePedido(LocalDateTime.now());
		//usuario.anadirCompra(compras);
		compras.addUsuario(usuario);
		return comprasdao.crear(compras);
	}

	@Override
	public boolean borrar(int id) {
		//comprasdao.deleteProductosCompraById(id);
		return comprasdao.deleteCompraById(id);
	}
	
	@Override
	public Compras getComprasbyId(int id) {
		
		Compras compras = new Compras();		
		List<Compras> compras1 = comprasdao.comprasUsuario(id);		
		compras = compras1.get(0);		
		return compras;
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