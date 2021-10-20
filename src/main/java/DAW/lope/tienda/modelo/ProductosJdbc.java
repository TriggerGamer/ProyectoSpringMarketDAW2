package DAW.lope.tienda.modelo;

import java.util.List;

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
		return jdbcTemplate.update("INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES(?,?,?,?)", producto.getTituloProducto(), producto.getDescripcionProducto(), producto.getPrecio(), producto.getDescuento());
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
		return jdbcTemplate.query("SELECT * FROM Productos ", (rs, rowNum) -> new Productos(rs.getInt("id_Productos"), rs.getString("tituloProducto"), rs.getString("descripcionProducto"), rs.getDouble("precio"), rs.getInt("descuento")));
	}

	@Override
	public List<Productos> findById(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM Productos WHERE id_Productos = " + id, (rs, rowNum) -> new Productos(rs.getInt("id_Productos"), rs.getString("tituloProducto"), rs.getString("descripcionProducto"), rs.getDouble("precio"), rs.getInt("descuento")));
	}

	@Override
	public String getNameById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Productos> getNamByName(String name) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM Productos WHERE tituloProducto = " + name, (rs, rowNum) -> new Productos(rs.getInt("id_Productos"), rs.getString("tituloProducto"), rs.getString("descripcionProducto"), rs.getDouble("precio"), rs.getInt("descuento")));
	}

}
