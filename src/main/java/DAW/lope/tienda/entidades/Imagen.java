package DAW.lope.tienda.entidades;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity(name = "Imagen")
@Table(name = "Imagen")
public class Imagen implements Serializable {

	private static final long serialVersionUID = -2803090463325137236L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id_Imagen")
	private int id_Imagen;
	
	@ManyToOne
	@JoinColumn(name = "id_Producto")
	private Productos producto;
	
	@Lob
	@Type(type="org.hibernate.type.BinaryType")
	@Column(name = "Imagen")
	private byte[] Imagen; 
	
	public Imagen() {
		super();
	}
	
	public Imagen(byte[] Imagen) {
		super();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(Imagen);
		result = prime * result + Objects.hash(id_Imagen, producto);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imagen other = (Imagen) obj;
		return Arrays.equals(Imagen, other.Imagen) && id_Imagen == other.id_Imagen
				&& Objects.equals(producto, other.producto);
	}
	
}
