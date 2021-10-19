package DAW.lope.tienda.modelo;


public class Productos {
	private int id_Usuario;
	private String nombreUsuario;
	private int puntuacion;
	private String personaje;
	
	public Productos() {}
	
	public Productos(int id_usuario, String nombreUsuario, int puntuacion, String personaje) {
		this.id_Usuario = id_usuario;
		this.nombreUsuario = nombreUsuario;
		this.puntuacion = puntuacion;	
		this.personaje = personaje;
	}
	
	//getters and setters
	public int getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(int id_usuario) {
		this.id_Usuario = id_usuario;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getPersonaje() {
		return personaje;
	}

	public void setPersonaje(String personaje) {
		this.personaje = personaje;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

}


