package DAW.lope.tienda.modelo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ComprasJDBC implements ComprasDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(Carrito carrito) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
				"INSERT INTO Usuarios(id_Usuario, id_Producto, numeroUnidades, fechaDeCompra) VALUES(?,?,?,NOW())", carrito.getId_Usuario(), carrito.getId_Producto(), carrito.getNumeroUnidades());
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Carrito> findAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
