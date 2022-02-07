package DAW.lope.tienda.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DAW.lope.tienda.entidades.Imagen;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Integer> {

}
