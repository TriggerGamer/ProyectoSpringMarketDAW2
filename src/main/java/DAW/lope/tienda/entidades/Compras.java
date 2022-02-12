package DAW.lope.tienda.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Compras")
@Table(name = "Compras")
public class Compras implements Serializable {

	private static final long serialVersionUID = 1278961066258620588L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Compra")
	private int id_Compra;

	@ManyToOne
	@JoinColumn(name = "id_Usuario")
	private Usuario usuario;

	@Column(name = "fechaDeCompra")
	private String fechaDePedido;

	@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ProductosCompras> productos = new HashSet<>();
	
	
	public Compras() {
	}

	public Compras(int id_Compra, Usuario usuario, String fechaDePedido) {
		this.id_Compra = id_Compra;
		this.usuario = usuario;
		this.fechaDePedido = fechaDePedido;
	}
	
	//getter and setters
	public Set<ProductosCompras> getProductos() {
		return productos;
	}

	public void setProductos(Set<ProductosCompras> productos) {
		this.productos = productos;
	}

	public Compras(int id_Compra) {
		this.id_Compra = id_Compra;
	}

	public int getId_Compra() {
		return id_Compra;
	}

	public void setId_Compra(int id_Compra) {
		this.id_Compra = id_Compra;
	}

	public String getFechaDePedido() {
		return fechaDePedido;
	}

	public void setFechaDePedido(String fechaDePedido) {
		this.fechaDePedido = fechaDePedido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void addUsuario(Usuario usuario) {
		setUsuario(usuario);
		usuario.getCompras().add(this);
	}
	
	public void anadirProductos(Productos productos, int numerounidades) {
		ProductosCompras productoscompra = new ProductosCompras(productos, this);
		productoscompra.setNumeroUnidades(numerounidades);
		this.productos.add(productoscompra);
		productos.getCompra().add(productoscompra);
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaDePedido, id_Compra, productos, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compras other = (Compras) obj;
		return Objects.equals(fechaDePedido, other.fechaDePedido) && id_Compra == other.id_Compra
				&& Objects.equals(productos, other.productos) && Objects.equals(usuario, other.usuario);
	}
	
	
}