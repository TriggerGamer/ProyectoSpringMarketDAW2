package DAW.lope.tienda.modelo;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import DAW.lope.tienda.entidades.Producto;
import DAW.lope.tienda.entidades.Rol;
import DAW.lope.tienda.entidades.Usuario;

@Repository
@Component("RolDao")
public class RolJdbc  extends DaoGenericoImpl<Rol> implements RolDao {

	@Override
	public Rol save(int id_Rol, Usuario usuario) {
		Rol rol = this.buscar(id_Rol);
		rol.addUsuario(usuario);
		this.em.merge(rol);
		this.em.refresh(rol);

		return rol;
	}

	@Override
	public Rol findById(int id) {
		Query query = this.em.createQuery("FROM Rol where id_Rol = :id");
		query.setParameter("id", id);
		Rol rol = (Rol) query.getSingleResult();

		if (rol != null) {
			return rol;
		}
		return null;
	}

	@Override
	public List<Rol> buscarRol(int id) {
		Query query = this.em.createQuery("FROM UsuarioRol where id_Usuario = :id");
		query.setParameter("id", id);
		List<Rol> roles = query.getResultList();

		if (roles != null) {
			return roles;
		}
		else
		return null;
	}

}
