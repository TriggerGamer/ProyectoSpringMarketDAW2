package DAW.lope.tienda.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Imagen")
@Table(name = "Imagen")
public class Imagen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id_Imagen")
	private int id_Imagen;
	
	@ManyToOne
	@JoinColumn(name = "id_Producto")
	private Productos producto;
	
	@Lob
	@Column(name = "Imagen", columnDefinition="BLOB")
	private byte[] Imagen; 
	
	public Imagen() {
		super();
	}
	
	public Imagen(int id_Imagen, byte[] Imagen) {
		super();
		this.id_Imagen = id_Imagen;
		this.Imagen = Imagen;
	}

	public int getId_Imagen() {
		return id_Imagen;
	}

	public void setId_Imagen(int id_Imagen) {
		this.id_Imagen = id_Imagen;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	public byte[] getImagen() {
		return Imagen;
	}

	public void setImagen(byte[] imagen) {
		Imagen = imagen;
	}
	
	
}
