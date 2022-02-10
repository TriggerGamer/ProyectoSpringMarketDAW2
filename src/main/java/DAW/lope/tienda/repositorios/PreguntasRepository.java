package DAW.lope.tienda.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DAW.lope.tienda.entidades.Preguntas;

@Repository
public interface PreguntasRepository extends JpaRepository<Preguntas, Integer>{

}
