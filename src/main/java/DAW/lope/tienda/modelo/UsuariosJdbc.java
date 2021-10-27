package DAW.lope.tienda.modelo;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UsuariosJdbc implements UsuariosDao{

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Usuarios usuario) {
		// TODO Auto-generated method stub
		return 1;
		//"INSERT INTO Productos(tituloProducto, descripcionProducto, precio, descuento) VALUES(?,?,?,?)";
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
