package DAW.lope.tienda.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DAW.lope.tienda.entidades.Usuario;
import DAW.lope.tienda.servicios.ServicioUsuarios;

@Controller
@RequestMapping("usuario")
public class ControladorUsuarios {

	// Conexión a los Servicios
	@Autowired
	private ServicioUsuarios servicioUsuarios;

	// Metodos para registro de usuarios
	@GetMapping(value = "/signup")
	public String registrarUsuario_get(HttpSession session, Model modelo) {

		// Session Usuarios
		String nombre = (String) session.getAttribute("user");
		String roles = (String) session.getAttribute("rol");

		modelo.addAttribute("roles", roles);

		if (nombre == null) {
			nombre = "f amigo";
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", "");
		} else {
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", nombre);
		}

		return "Registro";
	}

	@PostMapping(value = "/signup")
	public String registrarUsuario_post(@RequestParam String nombreUsuario, @RequestParam String apellidosusuario,
			@RequestParam String contrasenia, @RequestParam String correo, @RequestParam String fechanacimiento,
			@RequestParam long numerotarjeta, @RequestParam String titulartarjeta, @RequestParam int codigoseguridad,
			@RequestParam String direccionfacturacion, @RequestParam String nombre) {

		Usuario registrar = new Usuario();

		registrar.setNombre(nombre);
		registrar.setNombreUsuario(nombreUsuario);
		registrar.setApellidos(apellidosusuario);
		registrar.setContrasenia(contrasenia);
		registrar.setEmail(correo);
		registrar.setFechaNacimiento(fechanacimiento);
		registrar.setNumeroTarjeta(numerotarjeta);
		registrar.setTitularTarjeta(titulartarjeta);
		registrar.setCodigoSeguridad(codigoseguridad);
		registrar.setDireccionFacturacion(direccionfacturacion);

		servicioUsuarios.crear(registrar);

		return "redirect:/index";
	}

	// Metodos para iniciar sesion
	@GetMapping(value = "/login")
	public String loginUsuario_get(Model modelo, HttpSession session) {

		return "Login";
	}

	// Métodos desloguear un usuario
	@GetMapping(value = "/logout")
	public String usuarioLogout() {

		return "redirect:/index";
	}

	// Métodos para ver la info de un usuario
	@GetMapping(value = "/perfil/{id_Usuario}")
	public String perfilUsuarios_get(Model modelo, @PathVariable int id_Usuario, HttpSession session) {

		// Declarar la lista para obtener los datos
		Usuario usuario = servicioUsuarios.findUsuarioById(id_Usuario);
		modelo.addAttribute("usuario", usuario);

		return "UsuariosInfo";
	}

	// Métodos para ver la info de un usuario
	@GetMapping(value = "/acceso-denegado")
	public String usuario_incorrecto(Model modelo, HttpSession session) {

		return "UsuarioIncorrecto";
	}

}
