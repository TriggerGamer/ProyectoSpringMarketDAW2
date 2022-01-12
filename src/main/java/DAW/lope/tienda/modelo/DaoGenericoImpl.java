package DAW.lope.tienda.modelo;

import java.lang.reflect.ParameterizedType;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mysql.cj.Query;
import aj.org.objectweb.asm.Type;

public abstract class DaoGenericoImpl<T> implements DaoGenerico<T> {
	@PersistenceContext
	protected EntityManager em;
	private Class<T> type;

	/*public DaoGenericoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}*/

	/*@Override
	public long contarTodos(final Map<String, Object> params) {
		final StringBuffer queryString = new StringBuffer("SELECT count(o) from ");
		queryString.append(type.getSimpleName()).append(" o ");
		queryString.append(this.getQueryClauses(params, null));
		final Query query = this.em.createQuery(queryString.toString());
		return (Long) query.getSingleResult();
	}*/

	@Override
	public T crear(final T t) {
		this.em.persist(t);
		return t;
	}

	@Override
	public T buscar(final Object id) {
		return (T) this.em.find(type, id);
	}

	@Override
	public T actualizar(final T t) {
		return this.em.merge(t);
	}

	@Override
	public void borrar(final Object id) {
		this.em.remove(this.em.getReference(type, id));
	}
}