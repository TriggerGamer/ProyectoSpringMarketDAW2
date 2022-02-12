package DAW.lope.tienda.servicios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAW.lope.tienda.entidades.Compras;

import DAW.lope.tienda.entidades.Usuario;
import DAW.lope.tienda.repositorios.CompraRepository;
import DAW.lope.tienda.repositorios.ProductosComprasRepository;
import DAW.lope.tienda.repositorios.ProductosRepository;
import DAW.lope.tienda.repositorios.UsuariosRepository;

@Transactional
@Service
public class ServicioComprasImpl implements ServicioCompras {
	
	@Autowired
	CompraRepository comprasRepository;
	
	@Autowired
	ProductosRepository productosRepository;
	
	@Autowired
	ProductosComprasRepository productosComprasRepository;
	
	@Autowired
	UsuariosRepository usuarioRepository;
	

	@Override
	public Compras crear(int id_usuario, Compras compras) {
		
		Usuario usuario = usuarioRepository.getById(id_usuario);
		
		if(compras.getFechaDePedido() == null || compras.getFechaDePedido() == "") {
			String f = LocalDateTime.now().toString();
			String nuevo[] = f.split("T");
			compras.setFechaDePedido(nuevo[0]);
		}		
		
		usuario.anadirCompra(compras);
		compras.addUsuario(usuario);
		
		return comprasRepository.save(compras);
	}

	
	@Override
	public Compras getComprasbyId(int id) {
		
		try {
			Compras compras = comprasRepository.getById(id);			
			return compras;
		}catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public List<Compras> findComprasUsuario(int idUsuario) {
		return comprasRepository.findComprasbyidUsuario(idUsuario);
	}

	@Override
	public void borrar(int id) {
		
		try {
			comprasRepository.deleteById(id);
		}catch (Exception e) {
			
		}
	}
	
}