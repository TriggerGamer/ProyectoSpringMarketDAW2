package DAW.lope.tienda.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import DAW.lope.tienda.entidades.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
	@Query(value = "SELECT r FROM Roles r WHERE id_Rol = :id")
	Rol findRegistradoRol(@Param("id") int id);
}
