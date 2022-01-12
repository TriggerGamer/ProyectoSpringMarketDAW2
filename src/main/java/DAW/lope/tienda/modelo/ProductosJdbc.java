package DAW.lope.tienda.modelo;

import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import DAW.lope.tienda.entidades.Producto;

@Repository
@Component("ProductosDao")
public class ProductosJdbc extends DaoGenericoImpl<Producto> {

	@Override
	public long contarTodos(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//	@Override
//	public int count() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int save(Producto producto) {
//		// TODO Auto-generated method stub
//		return jdbcTemplate.update("INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES(?,?,?,?)", producto.getTituloProducto(), producto.getDescripcionProducto(), producto.getPrecio(), producto.getDescuento());
//	}
//
//	@Override
//	public int update(Producto pts) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int deleteById(int id) {
//		// TODO Auto-generated method stub
//		return jdbcTemplate.update("DELETE FROM Productos WHERE id_Producto = " + id);
//	}
//
//	@Override
//	public List<Producto> findAll() {
//		// TODO Auto-generated method stub
//		return jdbcTemplate.query("SELECT * FROM Productos", (rs, rowNum) -> new Producto(rs.getInt("id_Producto"), rs.getString("tituloProducto"), rs.getString("descripcionProducto"), rs.getDouble("precio"), rs.getInt("descuento")));
//	}
//	
//	@Override
//	public List<Producto> findEight() {
//		// TODO Auto-generated method stub
//		return jdbcTemplate.query("SELECT * FROM Productos ORDER BY id_Producto ASC LIMIT 8", (rs, rowNum) -> new Producto(rs.getInt("id_Producto"), rs.getString("tituloProducto"), rs.getString("descripcionProducto"), rs.getDouble("precio"), rs.getInt("descuento")));
//	}
//
//	@Override
//	public Producto findById(int id) {
//		return jdbcTemplate.queryForObject("SELECT * FROM Productos WHERE id_Producto = ?", (rs, rowNum) -> new Producto(rs.getInt("id_Producto"), rs.getString("tituloProducto"), rs.getString("descripcionProducto"), rs.getDouble("precio"), rs.getInt("descuento")),id);
//	}
//
//	@Override
//	public String getNameById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Producto> getProductoByName(String name) {
//		// TODO Auto-generated method stub
//		return jdbcTemplate.query("SELECT * FROM Productos WHERE tituloProducto LIKE '%" + name + "%' ", (rs, rowNum) -> new Producto(rs.getInt("id_Producto"), rs.getString("tituloProducto"), rs.getString("descripcionProducto"), rs.getDouble("precio"), rs.getInt("descuento")));
//	}

}
