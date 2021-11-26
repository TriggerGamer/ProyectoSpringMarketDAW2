package DAW.lope.tienda.entidades;

public class Rol {
	private int id_Rol;
	private String nombreRol;
	private int id_Usuario;
	
	public Rol() {}
	
	public Rol(int iD_Rol, String nombreRol) {
		this.id_Rol = iD_Rol;
		this.nombreRol = nombreRol;		
	}
	public Rol(int iD_Rol, String nombreRol, int id_Usuario) {
		this.id_Rol = iD_Rol;
		this.nombreRol = nombreRol;		
		this.id_Usuario = id_Usuario;
	}
	
	
	public int getId_Rol() {
		return id_Rol;
	}
	public void setId_Rol(int id_Rol) {
		this.id_Rol = id_Rol;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public int getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(int id_Usuario) {
		this.id_Usuario = id_Usuario;
	}
	
}
