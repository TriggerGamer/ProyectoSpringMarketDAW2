package DAW.lope.tienda.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
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
	private LocalDateTime fechaDePedido;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ProductosCompras> comprado = new HashSet<>();
	
	public Set<ProductosCompras> getCompras() {
		return comprado;
	}

	public void setCompras(Set<ProductosCompras> compras) {
		this.comprado = compras;
	}

	public Compras() {
	}

	public Compras(int id_Compra, Usuario usuario, LocalDateTime fechaDePedido) {
		this.id_Compra = id_Compra;
		this.usuario = usuario;
		this.fechaDePedido = fechaDePedido;
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

	public LocalDateTime getFechaDePedido() {
		return fechaDePedido;
	}

	public void setFechaDePedido(LocalDateTime fechaDePedido) {
		this.fechaDePedido = fechaDePedido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<ProductosCompras> getComprado() {
		return comprado;
	}

	public void setComprado(Set<ProductosCompras> comprado) {
		this.comprado = comprado;
	}

}