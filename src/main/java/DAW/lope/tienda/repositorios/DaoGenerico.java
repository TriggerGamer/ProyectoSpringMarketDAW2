package DAW.lope.tienda.repositorios;

public interface DaoGenerico<T> {
		T crear(T t);
		void borrar(Object id);
		T buscar(Object id);
		T actualizar(T t);		
}
