package DAW.lope.tienda.modelo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuariosJdbc implements UsuariosDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Usuarios usuario) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("INSERT INTO Usuarios(nombre, apellidos, contrasenia, email, fechaNacimiento, numeroTarjeta, titularTarjeta, codigoSeguridad, direccionFacturacion) VALUES(?,?,?,?,?,?,?,?,?)", usuario.getNombre(), usuario.getApellidos(), usuario.getContrasenia(), usuario.getEmail(), usuario.getFechaNacimiento(), usuario.getNumeroTarjeta(), usuario.getTitularTarjeta(), usuario.getCodigoSeguridad(), usuario.getDireccionFacturacion());
	}

	@Override
	public int update(Usuarios usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("DELETE FROM Productos WHERE id_Usuarios = " + id);
	}

	@Override
	public List<Usuarios> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM Usuarios", (rs, rowNum) -> new Usuarios(rs.getInt("id_Usuarios"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("contrasenia"), rs.getString("email"), rs.getString("fechaNacimiento"), rs.getInt("numeroTarjeta"), rs.getString("titularTarjet"), rs.getInt("codigoSeguridad"), rs.getString("direccionFacturacion)")));
	}

	@Override
	public List<Usuarios> findById(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM Usuarios WHERE id_Usuario = " + id, (rs, rowNum) -> new Usuarios(rs.getInt("id_Usuario"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("contrasenia"), rs.getString("email"), rs.getString("fechaNacimiento"), rs.getLong("numeroTarjeta"), rs.getString("titularTarjeta"), rs.getInt("codigoSeguridad"), rs.getString("direccionFacturacion")));
	}

	@Override
	public String getNameById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuarios> login(String nombre, String contrasenia) {
		// TODO Auto-generated method stub
		List<Usuarios> user = jdbcTemplate.query("SELECT * from Usuarios WHERE nombre = '" + nombre + "'" , (rs, rowNum) -> new Usuarios(rs.getString("nombre"), rs.getString("contrasenia")));
		
		if(user.equals(null)) {
			return null;
		}
		else if(user.size() == 1) {
		    return user;
		}
		else {
			return user;
		}
	}

}
