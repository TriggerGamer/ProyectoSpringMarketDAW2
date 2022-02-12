package DAW.lope.tienda.entidades;

import java.io.Serializable;


public class Carrito implements Serializable {
	
	private static final long serialVersionUID = 2956724154503745381L;
	private int id_Producto;
	private String nombreProducto;
	private int numeroUnidades;

	public Carrito() {
	}

	public Carrito(int id_producto, String nombre, int unidades) {
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

}
