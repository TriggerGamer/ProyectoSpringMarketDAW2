package DAW.lope.tienda.Entidades;

public class Usuario {
	private int id_Usuario;
	private String nombre;
	private String apellidos;
	private String contrasenia;
	private String email;
	private String fechaNacimiento;
	private long numeroTarjeta;
	private String titularTarjeta;
	private int codigoSeguridad;
	private String direccionFacturacion;
	
	public Usuario() {}
	
	public Usuario(int id_usuario, String nombre, String contrasenia) {
		this.id_Usuario = id_usuario;
		this.nombre = nombre;
		this.contrasenia = contrasenia;
	}
	
	public Usuario(int id_usuario, String nombre, String apellidos, String contrasenia, String email, String fechaNacimiento, long numeroTarjeta, String titularTarjeta, int codigoSeguridad, String direccionFacturacion) {
		this.id_Usuario = id_usuario;
		this.nombre = nombre;
		this.apellidos = apellidos;	
		this.contrasenia =contrasenia;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.numeroTarjeta = numeroTarjeta;
		this.titularTarjeta = titularTarjeta;
		this.codigoSeguridad = codigoSeguridad;
		this.direccionFacturacion = direccionFacturacion;
	}

	public int getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(int id_Usuario) {
		this.id_Usuario = id_Usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public long getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(long numerotarjeta2) {
		this.numeroTarjeta = numerotarjeta2;
	}

	public String getTitularTarjeta() {
		return titularTarjeta;
	}

	public void setTitularTarjeta(String titularTarjeta) {
		this.titularTarjeta = titularTarjeta;
	}

	public int getCodigoSeguridad() {
		return codigoSeguridad;
	}

	public void setCodigoSeguridad(int codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}

	public String getDireccionFacturacion() {
		return direccionFacturacion;
	}

	public void setDireccionFacturacion(String direccionFacturacion) {
		this.direccionFacturacion = direccionFacturacion;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
}