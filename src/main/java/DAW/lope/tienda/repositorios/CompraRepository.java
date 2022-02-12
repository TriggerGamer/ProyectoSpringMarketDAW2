package DAW.lope.tienda.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import DAW.lope.tienda.entidades.Compras;

@Repository
public interface CompraRepository extends JpaRepository<Compras, Integer>{
	@Query("SELECT c FROM Compras c WHERE id_Usuario = :id")
	List<Compras> findComprasbyidUsuario(@Param("id") int id);
}
