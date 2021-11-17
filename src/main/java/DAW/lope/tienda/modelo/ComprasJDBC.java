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
		return jdbcTemplate.update(
				"INSERT INTO Compras(id_Usuario, id_Producto, numeroUnidades, fechaDeCompra) VALUES(?,?,?,NOW())", compra.getId_Usuario(), compra.getId_Producto(), compra.getNumeroUnidades());
	}

	@Override
	public int deleteById(int id) {
		return jdbcTemplate.update("DELETE FROM Compras WHERE id_Compra = " + id);
	}

	@Override
	public List<Compras> findAll(int id) {
		return jdbcTemplate.query("SELECT * FROM Compras Where id_Usuario  = " + id, (rs, rowNum) -> new Compras(rs.getInt("id_Compra"), rs.getInt("id_Usuario"), rs.getInt("id_Producto"), rs.getInt("numeroUnidades"), rs.getString("fechaDeCompra")));
	}

}
