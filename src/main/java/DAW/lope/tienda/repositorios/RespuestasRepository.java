package DAW.lope.tienda.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DAW.lope.tienda.entidades.Respuestas;

@Repository
public interface RespuestasRepository extends JpaRepository<Respuestas, Integer> {

}
