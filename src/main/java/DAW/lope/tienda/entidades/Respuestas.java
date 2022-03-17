package DAW.lope.tienda.entidades;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Respuestas")
public class Respuestas implements Serializable{

	private static final long serialVersionUID = 7957061115154640117L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Respuesta")
	private int id_Respuesta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Pregunta")
	private Preguntas pregunta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Usuario")
	private Usuario usuario;
	
	@Column(name="respuesta")
	private String respuesta;
	
	@Column(name="fecha_Respuesta")
	private Date fecha_Respuesta;
	
	public Respuestas() {
		
	}

	public Respuestas(int id_Respuesta, Preguntas pregunta, Usuario usuario, String respuesta, Date fecha_Respuesta) {
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

	@JsonBackReference
	public Preguntas getPregunta() {
		return pregunta;
	}

	public void setPregunta(Preguntas pregunta) {
		this.pregunta = pregunta;
	}

	@JsonBackReference
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

	public Date getFecha_Respuesta() {
		return fecha_Respuesta;
	}

	public void setFecha_Respuesta(Date fecha_Respuesta) {
		this.fecha_Respuesta = fecha_Respuesta;
	}
	
}
