package DAW.lope.tienda.modelo;

public class Compras {
	
	private int id_Pedido;
	private int id_Usuario;
	private int id_Producto;
	private int numeroUnidades;
	private String fechaDePedido;

	
	public Compras (){}
	
	public Compras (int id_Pedido, int id_Usuario, int id_Producto, int numeroUnidades, String fechaDePedido) {
		this.id_Pedido = id_Pedido;
		this.id_Usuario = id_Usuario;
		this.id_Producto = id_Producto;
		this.numeroUnidades = numeroUnidades;
		this.fechaDePedido = fechaDePedido;
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
	public int getId_Producto() {
		return id_Producto;
	}
	public void setId_Producto(int id_Producto) {
		this.id_Producto = id_Producto;
	}
	public int getNumeroUnidades() {
		return numeroUnidades;
	}
	public void setNumeroUnidades(int numeroUnidades) {
		this.numeroUnidades = numeroUnidades;
	}
}
