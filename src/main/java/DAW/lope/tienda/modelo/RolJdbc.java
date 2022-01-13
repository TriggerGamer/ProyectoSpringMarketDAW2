package DAW.lope.tienda.modelo;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import DAW.lope.tienda.entidades.Rol;
import DAW.lope.tienda.entidades.Usuario;

@Repository
@Component("RolDao")
public class RolJdbc  extends DaoGenericoImpl<Rol> implements RolDao {

	@Override
	public long contarTodos(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Rol save(int id_Rol, Usuario usuario) {
		Rol rol = this.buscar(id_Rol);
		rol.addUsuario(usuario);
		this.em.merge(rol);
		this.em.refresh(rol);

		return rol;
	}

	@Override
	public List<Rol> buscarRol(int id) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	
//	@Override
//	public List<Rol> buscarRol(int id) {
//		// TODO Auto-generated method stub
//		return jdbcTemplate.query("SELECT Roles.id_Rol AS id, Roles.nombre_Rol AS nombre FROM Roles, UsuarioRol WHERE id_Usuario = " + id + " and Roles.id_Rol = UsuarioRol.id_Rol;", (rs, rowNum) -> new Rol(rs.getInt("id"), rs.getString("nombre")));
//	}
//
//	@Override
//	public int save(Rol rol) {
//		// TODO Auto-generated method stub
//		return jdbcTemplate.update("INSERT INTO UsuarioRol VALUES(?,?)", rol.getId_Rol(), rol.getId_Usuario());
//	}

}
