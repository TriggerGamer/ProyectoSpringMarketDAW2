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
@Table(name="Preguntas")
public class Preguntas implements Serializable {
	
	private static final long serialVersionUID = 7278434194430373852L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Pregunta")
	private int id_Pregunta;
	
	@ManyToOne
	@JoinColumn(name = "id_Producto")
	private Productos producto;
	
	@ManyToOne
	@JoinColumn(name = "id_Usuario")
	private Usuario usuario;
	
	@Column(name="pregunta")
	private String pregunta;
	
	@Column(name="fecha_Pregunta")
	private String fecha_Pregunta;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pregunta", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Respuestas> respuestas = new HashSet<>();
	
	public int getId_Pregunta() {
		return id_Pregunta;
	}

	public void setId_Pregunta(int id_Pregunta) {
		this.id_Pregunta = id_Pregunta;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getFecha_Pregunta() {
		return fecha_Pregunta;
	}

	public void setFecha_Pregunta(String fecha_Pregunta) {
		this.fecha_Pregunta = fecha_Pregunta;
	}
	
	

}