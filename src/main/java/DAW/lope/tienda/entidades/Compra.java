package DAW.lope.tienda.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Compras")

public class Compra implements Serializable{
	
	private static final long serialVersionUID = 1278961066258620588L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id_Compra")
	private int id_Compra;
	
	@ManyToOne
	@JoinColumn(name = "id_Usuario")
	private Usuario usuario;
	
	@Column(name = "fechaDeCompra")
	private String fechaDePedido;
	
	
	
	public Compra (){}
	
	public Compra (int id_Compra,Usuario usuario, String fechaDePedido) {
		this.id_Compra = id_Compra;
		this.usuario = usuario;
		this.fechaDePedido = fechaDePedido;
	}
	
	public Compra(int id_Compra) {
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