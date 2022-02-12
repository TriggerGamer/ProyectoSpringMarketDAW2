package DAW.lope.tienda.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class Rol implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id_Rol")
	private int id_Rol;
	
	@Column(name = "nombre_Rol")
	private String nombreRol; 
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	private Set<Usuario> Usuarios = new HashSet<>();
	
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
	
	public Set<Usuario> getUsuarios() {
		return Usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		Usuarios = usuarios;
	}
	
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	
	public void addUsuario(Usuario usuario) {
		this.Usuarios.add(usuario);
		usuario.getRoles().add(this);
	}

}
