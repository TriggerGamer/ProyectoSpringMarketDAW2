package DAW.lope.tienda.modelo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import DAW.lope.tienda.entidades.Rol;

@Repository
public class RolJdbc implements RolDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Rol> buscarRol(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM Roles, UsuarioRol WHERE id_Usuario = " + id + " and Roles.id_Rol = UsuarioRol.id_Rol;", (rs, rowNum) -> new Rol(rs.getInt("id_Rol"), rs.getString("nombre_Rol")));
	}

	@Override
	public int save(Rol rol) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("INSERT INTO UsuarioRol VALUES(?,?)", rol.getId_Rol(), rol.getId_Usuario());
	}

}
