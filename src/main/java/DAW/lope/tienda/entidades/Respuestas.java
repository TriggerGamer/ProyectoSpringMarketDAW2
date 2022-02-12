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
@Table(name="Respuestas")
public class Respuestas implements Serializable{

	private static final long serialVersionUID = 7957061115154640117L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Respuesta")
	private int id_Respuesta;
	
	@ManyToOne
	@JoinColumn(name = "id_Pregunta")
	private Preguntas pregunta;
	
	@ManyToOne
	@JoinColumn(name = "id_Usuario")
	private Usuario usuario;
	
	@Column(name="respuesta")
	private String respuesta;
	
	@Column(name="fecha_Respuesta")
	private String fecha_Respuesta;
	
	public Respuestas() {
		
	}

	public Respuestas(int id_Respuesta, Preguntas pregunta, Usuario usuario, String respuesta, String fecha_Respuesta) {
		super();
		this.id_Respuesta = id_Respuesta;
		this.pregunta = pregunta;
		this.usuario = usuario;
		this.respuesta = respuesta;
		this.fecha_Respuesta = fecha_Respuesta;
	}

	public int getId_Respuesta() {
		return id_Respuesta;
	}

	public void setId_Respuesta(int id_Respuesta) {
		this.id_Respuesta = id_Respuesta;
	}

	public Preguntas getPregunta() {
		return pregunta;
	}

	public void setPregunta(Preguntas pregunta) {
		this.pregunta = pregunta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getFecha_Respuesta() {
		return fecha_Respuesta;
	}

	public void setFecha_Respuesta(String fecha_Respuesta) {
		this.fecha_Respuesta = fecha_Respuesta;
	}
	
}
