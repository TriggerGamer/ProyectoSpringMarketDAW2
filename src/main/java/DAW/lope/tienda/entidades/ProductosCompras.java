package DAW.lope.tienda.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ProductosCompras")
public class ProductosCompras implements Serializable {
	
	private static final long serialVersionUID = 5086722733899392543L;
	
	@Column(name = "numeroUnidades")
	private int numeroUnidades;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Producto")  
    private Producto producto;
 
	@Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Compra")
    private Compra compras;

	public int getNumeroUnidades() {
		return numeroUnidades;
	}

	public void setNumeroUnidades(int numeroUnidades) {
		this.numeroUnidades = numeroUnidades;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public void setCompras(Compra compra) {
		this.compras = compra;
	}
}
