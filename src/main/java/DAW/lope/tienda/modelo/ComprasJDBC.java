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
	public int save(Compras compra) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
				"INSERT INTO Compras(id_Usuario, id_Producto, numeroUnidades, fechaDeCompra) VALUES(?,?,?,NOW())", compra.getId_Usuario(), compra.getId_Producto(), compra.getNumeroUnidades());
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("DELETE FROM Compras WHERE id_Compra = " + id);
	}

	@Override
	public List<Carrito> findAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
