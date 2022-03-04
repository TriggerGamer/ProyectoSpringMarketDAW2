package DAW.lope.tienda.Dtos;

public class RespuestasDto {
	
	private int id_respuesta;
	private String respuesta;
	private int id_pregunta;
	private int id_usuario;
	private String nombre_usuario;
	private String fecha;
	
	public RespuestasDto() {
		super();
	}
	
	public RespuestasDto(int id_respuesta, String respuesta, int id_pregunta, int id_usuario, String nombre_usuario,
			String fecha) {
		super();
		this.id_respuesta = id_respuesta;
		this.respuesta = respuesta;
		this.id_pregunta = id_pregunta;
		this.id_usuario = id_usuario;
		this.nombre_usuario = nombre_usuario;
		this.fecha = fecha;
	}
	
	public int getId_respuesta() {
		return id_respuesta;
	}
	public void setId_respuesta(int id_respuesta) {
		this.id_respuesta = id_respuesta;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public int getId_pregunta() {
		return id_pregunta;
	}
	public void setId_pregunta(int id_pregunta) {
		this.id_pregunta = id_pregunta;
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
