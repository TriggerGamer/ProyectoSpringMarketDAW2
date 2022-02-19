package DAW.lope.tienda.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import DAW.lope.tienda.entidades.Preguntas;

@Repository
public interface PreguntasRepository extends JpaRepository<Preguntas, Integer>{
	
	@Query(value = "SELECT p FROM Preguntas p WHERE id_Producto = :id")
	List<Preguntas> findPreguntasOfProductos(@Param("id") int id);
}
