package DAW.lope.tienda.modelo;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import DAW.lope.tienda.entidades.Producto;
import DAW.lope.tienda.entidades.Usuario;

@Repository
@Component("ProductosDao")
public class ProductosJdbc extends DaoGenericoImpl<Producto> implements ProductosDao {

	@Override
	public List<Producto> findAll() {

		Query query = this.em.createQuery("FROM Producto");
		
		List<Producto> producto = query.getResultList();

		if (producto != null) {
			return producto;
		}
		return null;
	}

	@Override
	public List<Producto> findEight() {
		Query query = this.em.createQuery("FROM Producto ORDER BY id_Producto ASC LIMIT 8");

		List<Producto> producto = query.getResultList();

		if (producto != null) {
			return producto;
		}
		return null;
	}

	@Override
	public Producto findById(int id) {
		Query query = this.em.createQuery("FROM Producto u where u.id_Producto = :id");
		query.setParameter("id", id);
		Producto producto = (Producto) query.getSingleResult();

		if (producto != null) {
			return producto;
		}
		return null;
	}

	@Override
	public List<Producto> getProductoByName(String name) {
		Query query = this.em.createQuery("FROM Producto u where u.tituloProducto = :nombre");
		query.setParameter("nombre", name);
		List<Producto> producto = query.getResultList();

		if (producto != null) {
			return producto;
		}
		return null;
	}

//	@Override
//	public int save(Producto producto) {
//		// TODO Auto-generated method stub
//		return jdbcTemplate.update("INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES(?,?,?,?)", producto.getTituloProducto(), producto.getDescripcionProducto(), producto.getPrecio(), producto.getDescuento());
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
//	public List<Producto> getProductoByName(String name) {
//		// TODO Auto-generated method stub
//		return jdbcTemplate.query("SELECT * FROM Productos WHERE tituloProducto LIKE '%" + name + "%' ", (rs, rowNum) -> new Producto(rs.getInt("id_Producto"), rs.getString("tituloProducto"), rs.getString("descripcionProducto"), rs.getDouble("precio"), rs.getInt("descuento")));
//	}

}
