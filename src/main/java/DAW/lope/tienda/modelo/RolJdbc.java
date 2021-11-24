package DAW.lope.tienda.modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import DAW.lope.tienda.entidades.Rol;

@Repository
public class RolJdbc implements RolDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Rol buscarRol(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(("SELECT * FROM Roles, UsuarioRol WHERE id_Usuario = ? and Roles.id_Rol = UsuarioRol.id_Rol;"), (rs, rowNum) -> new Rol(rs.getInt(""), rs.getString("")), id);
	}

}
