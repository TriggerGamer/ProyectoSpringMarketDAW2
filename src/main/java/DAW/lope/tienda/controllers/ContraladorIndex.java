package DAW.lope.tienda.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import DAW.lope.tienda.entidades.Producto;
import DAW.lope.tienda.entidades.Usuario;
import DAW.lope.tienda.servicios.ServiciosProductos;
import DAW.lope.tienda.servicios.ServiciosUsuarios;

@Controller
public class ContraladorIndex {
	
	//Conexión a los Servicios
	@Autowired
	ServiciosUsuarios servicioUsuarios;
	@Autowired
	ServiciosProductos servicioProductos;

	// Métodos para la página principal
	@GetMapping(value = "/index")
	public String index_get(Model modelo, HttpSession session) {

		// Producto
		List<Producto> Producto = servicioProductos.findEight();
		modelo.addAttribute("Productos", Producto);

		// session Usuarios
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
		Usuario usuario = servicioUsuarios.login(nombre, contrasenia);
		if (usuario == null) {

		} else {
			int id_usuario = usuario.getId_Usuario();
			modelo.addAttribute("id_usuario", id_usuario);
		}

		return "Index";
	}

}