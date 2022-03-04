package DAW.lope.tienda.Dtos;

public class PreguntasDto {
	private int id_pregunta;
	private String pregunta;
	private int id_usuario;
	private String nombre_usuario;
	private String fecha;
	
	public PreguntasDto() {
		super();
	}

	public PreguntasDto(int id_pregunta, String pregunta, int id_usuario, String nombre_usuario, String fecha) {
		super();
		this.id_pregunta = id_pregunta;
		this.pregunta = pregunta;
		this.id_usuario = id_usuario;
		this.nombre_usuario = nombre_usuario;
		this.fecha = fecha;
	}

	public int getId_pregunta() {
		return id_pregunta;
	}

	public void setId_pregunta(int id_pregunta) {
		this.id_pregunta = id_pregunta;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
