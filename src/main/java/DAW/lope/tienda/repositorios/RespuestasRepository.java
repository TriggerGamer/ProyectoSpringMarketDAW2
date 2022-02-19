package DAW.lope.tienda.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import DAW.lope.tienda.entidades.Respuestas;

@Repository
public interface RespuestasRepository extends JpaRepository<Respuestas, Integer> {
	
	@Query(value = "SELECT r FROM Respuestas r WHERE id_Pregunta = :id")
	List<Respuestas> findRespuestasFromPregunta(@Param("id") int id);
}
