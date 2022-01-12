package DAW.lope.tienda.modelo;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import DAW.lope.tienda.entidades.Compra;

@Repository
@Component("ComprasDao")
public class ComprasJDBC extends DaoGenericoImpl<Compra> implements ComprasDao {

	@Override
	public long contarTodos(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Compra compra) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int saveProductosCompra(int id_Compra, int id_Producto, int numeroUnidades) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCompraById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProductosCompraById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Compra> findAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//	@Override
//	public int save(Compra compra) {
//		return jdbcTemplate.update("INSERT INTO Compras(id_Usuario, fechaDeCompra) VALUES(?,NOW())",
//				compra.getUsuario());
//	}
//	
//	@Override
//	public int saveProductosCompra(int id_Compra, int id_Producto, int  numeroUnidades) {
//		return jdbcTemplate.update("INSERT INTO ProductosCompras VALUES(?,?,?)",
//				id_Compra, id_Producto, numeroUnidades);
//	}
//
//	@Override
//	public int deleteCompraById(int id) {
//		return jdbcTemplate.update("DELETE FROM Compras WHERE id_Compra = " + id);
//	}
//	
//	@Override
//	public int deleteProductosCompraById(int id) {
//		return jdbcTemplate.update("DELETE FROM ProductosCompras WHERE id_Compra = " + id);
//	}
//
//	@Override
//	public List<Compra> findAll(int id) {
//		return jdbcTemplate.query("SELECT * FROM Compras Where id_Usuario  = " + id + " ORDER BY id_Compra DESC", (rs,
//				rowNum) -> new Compra(rs.getInt("id_Compra"), rs.getInt("id_Usuario"), rs.getString("fechaDeCompra")));
//	}


}
