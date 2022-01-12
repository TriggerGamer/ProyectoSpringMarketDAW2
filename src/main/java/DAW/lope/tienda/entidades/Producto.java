package DAW.lope.tienda.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Productos")
public class Producto implements Serializable {
	
	private static final long serialVersionUID = -8668594760203621162L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id_Producto")
	private int id_Producto;
	
	@Column(name = "tituloProducto")
	private String tituloProducto;
	
	@Column(name = "descripcionProducto")
	private String descripcionProducto;
	
	@Column(name = "precio")
	private double precio;
	
	@Column(name = "descuento")
	private int descuento;
	
	@OneToMany(mappedBy = "producto")
    public Set<Producto> productos = new HashSet<>();
	
	public Producto() {}
	
	public Producto(int id_producto, String tituloProducto, String descripcionProducto, double precio, int descuento) {
		this.id_Producto = id_producto;
		this.tituloProducto = tituloProducto;
		this.descripcionProducto = descripcionProducto;	
		this.precio = precio;
		this.descuento = descuento;
	}

	//getters y setters
	public int getId_Producto() {
		return id_Producto;
	}

	public void setId_Producto(int id_Producto) {
		this.id_Producto = id_Producto;
	}

	public String getTituloProducto() {
		return tituloProducto;
	}

	public void setTituloProducto(String tituloProducto) {
		this.tituloProducto = tituloProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
}


