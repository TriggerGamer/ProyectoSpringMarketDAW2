package DAW.lope.tienda.modelo;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import DAW.lope.tienda.entidades.Producto;
import DAW.lope.tienda.entidades.ProductosCompras;

@Repository
@Component("ProductosDao")
public class ProductosJdbc extends DaoGenericoImpl<Producto> implements ProductosDao {

	@Override
	public List<Producto> findAll() {

		Query query = this.em.createQuery("FROM Producto");
		
		List<Producto> producto = query.getResultList();

		if (producto != null) {
			return producto;
		}
		return null;
	}

	@Override
	public List<Producto> findEight() {
		Query query = this.em.createQuery("FROM Producto ORDER BY id_Producto ASC").setMaxResults(8);

		List<Producto> producto = query.getResultList();

		if (producto != null) {
			return producto;
		}
		return null;
	}

	@Override
	public Producto findById(int id) {
		Query query = this.em.createQuery("FROM Producto where id_Producto =:id");
		query.setParameter("id", id);
		Producto producto = (Producto) query.getSingleResult();

		if (producto != null) {
			return producto;
		}
		return null;
	}

	@Override
	public List<Producto> getProductoByName(String name) {
		Query query = this.em.createQuery("FROM Producto where tituloProducto LIKE :name");
		query.setParameter("name", "%"+name+"%");
		List<Producto> producto = query.getResultList();

		if (producto != null) {
			return producto;
		}
		else
		return null;
	}

	@Override
	public ProductosCompras guardarProductoCompra(int id_Producto, ProductosCompras productos) {
		Producto producto  = this.buscar(id_Producto);
		producto.addProductoCompra(productos);
		this.em.merge(productos);
		this.em.refresh(productos);

		return productos;
	}

}
