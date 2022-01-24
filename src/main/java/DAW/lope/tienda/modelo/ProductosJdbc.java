package DAW.lope.tienda.modelo;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import DAW.lope.tienda.entidades.Productos;
import DAW.lope.tienda.entidades.ProductosCompras;

@Repository
@Component("ProductosDao")
public class ProductosJdbc extends DaoGenericoImpl<Productos> implements ProductosDao {

	@Override
	public List<Productos> findAll() {

		Query query = this.em.createQuery("FROM Productos");
		
		List<Productos> productos = query.getResultList();

		if (productos != null) {
			return productos;
		}
		return null;
	}

	@Override
	public List<Productos> findEight() {
		Query query = this.em.createQuery("FROM Productos ORDER BY id_Producto ASC").setMaxResults(8);

		List<Productos> productos = query.getResultList();

		if (productos != null) {
			return productos;
		}
		return null;
	}

	@Override
	public Productos findById(int id) {
		Query query = this.em.createQuery("FROM Productos where id_Producto =:id");
		query.setParameter("id", id);
		Productos productos = (Productos) query.getSingleResult();

		if (productos != null) {
			return productos;
		}
		return null;
	}

	@Override
	public List<Productos> getProductoByName(String name) {
		Query query = this.em.createQuery("FROM Productos where tituloProducto LIKE :name");
		query.setParameter("name", "%"+name+"%");
		List<Productos> productos = query.getResultList();

		if (productos != null) {
			return productos;
		}
		else
		return null;
	}

}
