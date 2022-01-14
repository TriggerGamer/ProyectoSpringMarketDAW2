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

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Producto")
	private Producto producto;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Compra")
	private Compra compra;
	
	public ProductosCompras() {}
	
	public ProductosCompras(Producto Producto, Compra compra) {
		this.compra = compra;
        this.producto = producto;	
		this.id = new ProductosComprasId(producto.getId_Producto(), compra.getId_Compra());
	}
	
	

	public int getNumeroUnidades() {
		return numeroUnidades;
	}

	public void setNumeroUnidades(int numeroUnidades) {
		this.numeroUnidades = numeroUnidades;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public ProductosComprasId getId() {
		return id;
	}

	public void setId(ProductosComprasId id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}
}
