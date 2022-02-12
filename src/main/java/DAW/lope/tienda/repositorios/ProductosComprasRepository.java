package DAW.lope.tienda.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DAW.lope.tienda.entidades.ProductosCompras;

@Repository
public interface ProductosComprasRepository extends JpaRepository<ProductosCompras, Integer>{

}
