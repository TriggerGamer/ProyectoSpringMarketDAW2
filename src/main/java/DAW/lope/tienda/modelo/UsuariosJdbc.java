package DAW.lope.tienda.modelo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import DAW.lope.tienda.entidades.Usuario;

@Repository
public class UsuariosJdbc implements UsuariosDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Usuario usuario) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
				"INSERT INTO Usuarios(nombreUsuario, nombre, apellidos, contrasenia, email, fechaNacimiento, numeroTarjeta, titularTarjeta, codigoSeguridad, direccionFacturacion) VALUES(?,?,?,?,?,?,?,?,?,?)",
				usuario.getNombreUsuario() ,usuario.getNombre(), usuario.getApellidos(), usuario.getContrasenia(), usuario.getEmail(),
				usuario.getFechaNacimiento(), usuario.getNumeroTarjeta(), usuario.getTitularTarjeta(),
				usuario.getCodigoSeguridad(), usuario.getDireccionFacturacion());
	}

	@Override
	public int update(Usuario usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("DELETE FROM Producto WHERE id_Usuarios = " + id);
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM Usuarios",
				(rs, rowNum) -> new Usuario(rs.getInt("id_Usuarios"), rs.getString("nombreUsuario"), rs.getString("nombre"), rs.getString("apellidos"),
						rs.getString("contrasenia"), rs.getString("email"), rs.getString("fechaNacimiento"),
						rs.getInt("numeroTarjeta"), rs.getString("titularTarjet"), rs.getInt("codigoSeguridad"),
						rs.getString("direccionFacturacion)")));
	}

	@Override
	public Usuario findById(int id) {
		// TODO Auto-generated method stub
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM Usuarios WHERE id_Usuario = ?",
					(rs, rowNum) -> new Usuario(rs.getInt("id_Usuario"), rs.getString("nombreUsuario"),
							rs.getString("nombre"),
							rs.getString("apellidos"), rs.getString("contrasenia"), rs.getString("email"),
							rs.getString("fechaNacimiento"), rs.getLong("numeroTarjeta"),
							rs.getString("titularTarjeta"), rs.getInt("codigoSeguridad"),
							rs.getString("direccionFacturacion")),
					id);
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public Usuario findByName(String nombreUsuario) {
		
		try {
			return jdbcTemplate.queryForObject("SELECT * from Usuarios WHERE nombreUsuario LIKE ?",
					(rs, rowNum) -> new Usuario(rs.getInt("id_Usuario"), rs.getString("nombre"), rs.getString("contrasenia")), nombreUsuario);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

}
