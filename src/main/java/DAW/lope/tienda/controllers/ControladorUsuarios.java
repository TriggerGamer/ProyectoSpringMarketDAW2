package DAW.lope.tienda.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DAW.lope.tienda.Entidades.Usuario;
import DAW.lope.tienda.servicios.ModuloServicioTemplate;

@Controller
public class ControladorUsuarios {

	// Conexión a los Servicios
	@Autowired
	private ModuloServicioTemplate servicio;

	// Metodos para registro de usuarios
	@GetMapping(value = "/usuario/signup")
	public String registrarUsuario_get(HttpSession session, Model modelo) {
		// Session Usuarios
		String nombre = (String) session.getAttribute("user");

		if (nombre == null) {
			nombre = "f amigo";
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", "");
		} else {
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", nombre);
		}

		return "registro";
	}

	@PostMapping(value = "/usuario/signup")
	public String registrarUsuario_post(@RequestParam String nombreusuario, @RequestParam String apellidosusuario,
			@RequestParam String contrasenia, @RequestParam String correo, @RequestParam String fechanacimiento,
			@RequestParam long numerotarjeta, @RequestParam String titulartarjeta, @RequestParam int codigoseguridad,
			@RequestParam String direccionfacturacion) {

		Usuario registrar = new Usuario();

		registrar.setNombre(nombreusuario);
		registrar.setApellidos(apellidosusuario);
		registrar.setContrasenia(contrasenia);
		registrar.setEmail(correo);
		registrar.setFechaNacimiento(fechanacimiento);
		registrar.setNumeroTarjeta(numerotarjeta);
		registrar.setTitularTarjeta(titulartarjeta);
		registrar.setCodigoSeguridad(codigoseguridad);
		registrar.setDireccionFacturacion(direccionfacturacion);

		servicio.saveUsuarios(registrar);

		return "redirect:/index";
	}

	// Metodos para iniciar sesion
	@GetMapping(value = "/usuario/login")
	public String loginUsuario_get(Model modelo, HttpSession session) {
		String primeravez = (String) session.getAttribute("1vez");

		String nombre = (String) session.getAttribute("user");
		if (nombre == null && primeravez != null) {
			modelo.addAttribute("error", "Usuario incorrecto");
		}

		session.setAttribute("1vez", "hola");

		// Session Usuarios
		if (nombre == null) {
			nombre = "f amigo";
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", "");
		} else {
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", nombre);
		}

		return "acceso";
	}

	@PostMapping(value = "/usuario/login")
	public String loginUsuario_post(@RequestParam String nombreusuario, @RequestParam String contrasenia,
			HttpSession session, Model modelo) {

		Usuario usuario = servicio.login(nombreusuario, contrasenia);

		if (usuario == null) {
			return "redirect:/usuario/login";
		} else {
			session.setAttribute("id_Usuario", usuario.getId_Usuario());
			session.setAttribute("user", usuario.getNombre());
			session.setAttribute("contrasenia", usuario.getContrasenia());
			session.setAttribute("carrito", null);
		}

		return "redirect:/index";
	}

	// Métodos desloguear un usuario
	@GetMapping(value = "/usuario/logOut")
	public String usuarioLOGOUT_get(Model modelo, HttpSession session) {

		session.setAttribute("user", null);
		session.setAttribute("contrasenia", null);
		session.setAttribute("carrito", null);
		session.setAttribute("1vez", null);

		return "redirect:/index";
	}

	// Métodos para ver la info de un usuario
	@GetMapping(value = "/usuario/perfil/{id_Usuario}")
	public String perfilUsuarios_get(Model modelo, @PathVariable int id_Usuario, HttpSession session) {

		// Declarar la lista para obtener los datos
		Usuario usuario = servicio.findUsuarioById(id_Usuario);
		modelo.addAttribute("usuario", usuario);

		// Session Usuarios
		String nombre = (String) session.getAttribute("user");
		String contrasenia = (String) session.getAttribute("contrasenia");

		if (nombre == null) {
			nombre = "f amigo";
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", "");
		} else {
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", nombre);
		}

		// Usuarios
		Usuario usuario1 = servicio.login(nombre, contrasenia);
		if (usuario1 == null) {

		} else {
			int id_usuario = usuario1.getId_Usuario();
			modelo.addAttribute("usuarios", id_usuario);
		}

		return "UsuariosInfo";
	}
	
}