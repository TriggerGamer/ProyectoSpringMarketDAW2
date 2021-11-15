package DAW.lope.tienda.modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Carrito implements Serializable {
	private int id_Pedido;
	private int id_Usuario;
	private int id_Producto;
	private String nombreProducto;
	private int numeroUnidades;
	private String fechaDePedido;
	
	public Carrito(){}
	
	public Carrito(int id_producto, String nombre, int unidades){
		this.id_Producto = id_producto;
		this.nombreProducto = nombre;
		this.numeroUnidades = unidades;
	}

	public int getId_Producto() {
		return id_Producto;
	}

	public void setId_Producto(int id_Producto) {
		this.id_Producto = id_Producto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getNumeroUnidades() {
		return numeroUnidades;
	}

	public void setNumeroUnidades(int numeroUnidades) {
		this.numeroUnidades = numeroUnidades;
	}

	public int getId_Pedido() {
		return id_Pedido;
	}

	public void setId_Pedido(int id_Pedido) {
		this.id_Pedido = id_Pedido;
	}

	public int getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(int id_Usuario) {
		this.id_Usuario = id_Usuario;
	}

	public String getFechaDePedido() {
		return fechaDePedido;
	}

	public void setFechaDePedido(String fechaDePedido) {
		this.fechaDePedido = fechaDePedido;
	}
	
	
}
