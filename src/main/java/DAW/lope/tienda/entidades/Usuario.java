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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Usuarios")

public class Usuario implements Serializable {

	private static final long serialVersionUID = -7470679502117636926L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Usuario")
	private int id_Usuario;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "nombreUsuario")
	private String nombreUsuario;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "contrasenia")
	private String contrasenia;

	@Column(name = "email")
	private String email;

	@Column(name = "fechaNacimiento")
	private String fechaNacimiento;

	@Column(name = "numeroTarjeta")
	private long numeroTarjeta;

	@Column(name = "titularTarjeta")
	private String titularTarjeta;

	@Column(name = "codigoSeguridad")
	private int codigoSeguridad;

	@Column(name = "direccionFacturacion")
	private String direccionFacturacion;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Compras> compras = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "UsuarioRol", joinColumns = @JoinColumn(name = "id_Usuario"), inverseJoinColumns = @JoinColumn(name = "id_Rol"))
	private Set<Rol> roles = new HashSet<>();

	public Usuario() {
	}

	public Usuario(int id_usuario, String nombreUsuario, String contrasenia) {
		this.id_Usuario = id_usuario;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
	}

	public Usuario(int id_usuario, String nombre, String nombreUsuario, String apellidos, String contrasenia,
			String email, String fechaNacimiento, long numeroTarjeta, String titularTarjeta, int codigoSeguridad,
			String direccionFacturacion) {
		this.id_Usuario = id_usuario;
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.apellidos = apellidos;
		this.contrasenia = contrasenia;
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

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	public Set<Compras> getCompras() {
		return compras;
	}

	public void setCompras(Set<Compras> compras) {
		this.compras = compras;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
	
	public boolean anadirRol(Rol rol) {
	    rol.addUsuario(this);
		return getRoles().add(rol);
	}
}
