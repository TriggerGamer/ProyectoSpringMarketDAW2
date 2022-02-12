package DAW.lope.tienda.entidades;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "ProductosCompras")
public class ProductosCompras implements Serializable {

	private static final long serialVersionUID = 5086722733899392543L;
	
	@EmbeddedId
	private ProductosComprasId id;

	@Column(name = "numeroUnidades")
	private int numeroUnidades;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idProducto")
	private Productos producto;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idCompra")
	private Compras compra;
	
	public ProductosCompras() {}
	
	public ProductosCompras(Productos productos, Compras compra) {
		this.compra = compra;
        this.producto = productos;	
		this.id = new ProductosComprasId(productos.getId_Producto(), compra.getId_Compra());
	}

	public int getNumeroUnidades() {
		return numeroUnidades;
	}

	public void setNumeroUnidades(int numeroUnidades) {
		this.numeroUnidades = numeroUnidades;
	}

	public void setProducto(Productos productos) {
		this.producto = productos;
	}

	public ProductosComprasId getId() {
		return id;
	}

	public void setId(ProductosComprasId id) {
		this.id = id;
	}

	public Productos getProducto() {
		return producto;
	}

	public Compras getCompra() {
		return compra;
	}

	public void setCompra(Compras compra) {
		this.compra = compra;
	}

}
