package DAW.lope.tienda.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DAW.lope.tienda.entidades.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{

}
