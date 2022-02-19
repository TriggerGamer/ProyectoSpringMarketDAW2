package DAW.lope.tienda.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import DAW.lope.tienda.entidades.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {

	List<Productos> findBytituloProductoContainingIgnoreCase(String tituloProducto);

	@Query(value = "SELECT * FROM Productos ORDER BY id_Producto LIMIT 8", nativeQuery = true)
	List<Productos> findEight();
}
