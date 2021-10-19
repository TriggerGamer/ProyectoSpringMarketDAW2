package DAW.lope.tienda.modelo;

import java.util.List;
import java.util.Optional;

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
	public int save(Productos pts) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("INSERT INTO Puntuaciones(nombreUsuario, Puntuacion, Personaje) VALUES(?,?,?)", pts.getNombreUsuario(), pts.getPuntuacion(), pts.getPersonaje());
	}

	@Override
	public int update(Productos pts) {
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
		return jdbcTemplate.query("SELECT * FROM Puntuaciones ORDER BY id_Usuario DESC LIMIT 5", (rs, rowNum) -> new Productos(rs.getInt("id_Usuario"), rs.getString("nombreUsuario"), rs.getInt("Puntuacion"), rs.getString("Personaje")));
	}

	@Override
	public Optional<Productos> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNameById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
