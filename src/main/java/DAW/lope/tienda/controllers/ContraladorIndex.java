package DAW.lope.tienda.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import DAW.lope.tienda.entidades.Producto;
import DAW.lope.tienda.servicios.ServicioProductos;

@Controller
public class ContraladorIndex {
	
	//Conexión a los Servicios
	@Autowired
	ServicioProductos servicioProductos;

	// Métodos para la página principal

	@GetMapping(value = "/index")
	public String index_get(Model modelo, HttpSession session) {

		// Producto
		List<Producto> Producto = servicioProductos.findEight();
		modelo.addAttribute("Productos", Producto);

		// Session Usuarios
		String nombre = (String) session.getAttribute("user");
		int id;
		
		try {
			id = (int) session.getAttribute("id_Usuario");
		}
		catch (Exception e) {
			id = 1;
		}
		
		modelo.addAttribute("id_usuario", id);
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

		return "index";
	}

}