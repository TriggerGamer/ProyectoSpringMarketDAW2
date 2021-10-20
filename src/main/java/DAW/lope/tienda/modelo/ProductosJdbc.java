package DAW.lope.tienda.modelo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductosJdbc implements ProductosDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Productos producto) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("INSERT INTO Productos(tituloProductos, descripcionProducto, precio) VALUES(?,?,?)", producto.getTituloProducto(), producto.getDescripcionProducto(), producto.getPrecio());
	}

	@Override
	public int update(Productos pts) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("DELETE FROM Productos WHERE id_Producto = " + id);
	}

	@Override
	public List<Productos> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM Productos ORDER BY id_Usuario", (rs, rowNum) -> new Productos(rs.getInt("id_Producto"), rs.getString("tituloProducto"), rs.getString("descripcionProducto"), rs.getDouble("precio"), rs.getInt("descuento")));
	}

	@Override
	public Optional<Productos> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNameById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
