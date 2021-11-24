package DAW.lope.tienda.entidades;

public class Rol {
	private int id_Rol;
	private String nombreRol;
	
	public Rol() {}
	
	public Rol(int iD_Rol, String nombreRol) {
		this.id_Rol = iD_Rol;
		this.nombreRol = nombreRol;		
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
	
}
