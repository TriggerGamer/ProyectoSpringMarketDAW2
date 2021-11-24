package DAW.lope.tienda.entidades;

public class Compra {
	private int id_Compra;
	private int id_Usuario;
	private String fechaDePedido;

	
	public Compra (){}
	
	public Compra (int id_Compra, int id_Usuario, String fechaDePedido) {
		this.id_Compra = id_Compra;
		this.id_Usuario = id_Usuario;
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