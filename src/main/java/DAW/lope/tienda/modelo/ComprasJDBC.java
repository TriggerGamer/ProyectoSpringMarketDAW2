package DAW.lope.tienda.modelo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ComprasJDBC implements ComprasDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int save(Compras compra) {
		return jdbcTemplate.update("INSERT INTO Compras(id_Usuario, fechaDeCompra) VALUES(?,NOW())",
				compra.getId_Usuario());
	}
	
	@Override
	public int saveProductosCompra(int id_Compra, int id_Producto, int  numeroUnidades) {
		return jdbcTemplate.update("INSERT INTO ProductosCompra VALUES(?,?,?)",
				id_Compra, id_Producto, numeroUnidades);
	}

	@Override
	public int deleteById(int id) {
		return jdbcTemplate.update("DELETE FROM Compras WHERE id_Compra = " + id);
	}

	@Override
	public List<Compras> findAll(int id) {
		return jdbcTemplate.query("SELECT * FROM Compras Where id_Usuario  = " + id + " ORDER BY id_Compra DESC", (rs,
				rowNum) -> new Compras(rs.getInt("id_Compra"), rs.getInt("id_Usuario"), rs.getString("fechaDeCompra")));
	}

	@Override
	public Compras findIdCompra() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
