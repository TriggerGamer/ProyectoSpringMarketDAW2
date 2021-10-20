package DAW.lope.tienda.modelo;


public class Productos {
	private int id_Producto;
	private String tituloProducto;
	private String descripcionProducto;
	private double precio;
	private int descuento;
	
	public Productos() {}
	
	public Productos(int id_producto, String tituloProducto, String descripcionProducto, double precio, int descuento) {
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


