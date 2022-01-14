package DAW.lope.tienda.entidades;

import java.io.Serializable;
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
	private String fechaDePedido;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Compras> comprado = new HashSet<>();
	
	public Set<Compras> getCompras() {
		return comprado;
	}

	public void setCompras(Set<Compras> compras) {
		this.comprado = compras;
	}

	public Compras() {
	}

	public Compras(int id_Compra, Usuario usuario, String fechaDePedido) {
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getFechaDePedido() {
		return fechaDePedido;
	}

	public void setFechaDePedido(String fechaDePedido) {
		this.fechaDePedido = fechaDePedido;
	}
}