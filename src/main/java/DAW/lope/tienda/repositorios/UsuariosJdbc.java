package DAW.lope.tienda.repositorios;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import DAW.lope.tienda.entidades.Usuario;

@Repository
@Component("UsuarioDao")
public class UsuariosJdbc extends DaoGenericoImpl<Usuario> implements UsuariosDao {

	@Override
	public List<Usuario> findAll() {
		
		Query query = this.em.createQuery("FROM Usuario");
		
		List<Usuario> usuario = query.getResultList();

		if (usuario != null) {
			return usuario;
		}
		return null;
	}

	@Override
	public Usuario findById(int id) {
		Query query = this.em.createQuery("FROM Usuario u where u.id_Usuario = :id");
		query.setParameter("id", id);
		Usuario usuario = (Usuario) query.getSingleResult();

		if (usuario != null) {
			return usuario;
		}
		return null;
	}

	@Override
	public Usuario findByName(String nombreUsuario) {
		Query query = this.em.createQuery("FROM Usuario u where u.nombreUsuario= :nombreUs");
		query.setParameter("nombreUs", nombreUsuario);
		Usuario usuario = (Usuario) query.getSingleResult();

		if (usuario != null) {
			return usuario;
		}
		return null;
	}
	
}
