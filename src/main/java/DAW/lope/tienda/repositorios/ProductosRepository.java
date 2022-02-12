package DAW.lope.tienda.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DAW.lope.tienda.entidades.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer>{

	List<Productos> findByNameContaining(String name);
	
	 List<Productos> findTop8ByOderByid_ProductoAsc();
}
