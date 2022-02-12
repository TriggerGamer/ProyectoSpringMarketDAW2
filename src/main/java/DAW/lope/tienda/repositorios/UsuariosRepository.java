package DAW.lope.tienda.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DAW.lope.tienda.entidades.Usuario;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {
	Usuario findBynombreUsuario(String nombreUsuario);
}
