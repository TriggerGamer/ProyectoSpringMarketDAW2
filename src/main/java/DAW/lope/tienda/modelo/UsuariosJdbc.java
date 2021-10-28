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
		return 0;
	}

	@Override
	public List<Productos> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Productos> findEight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Productos> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNameById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Productos> getProductoByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
