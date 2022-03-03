package DAW.lope.tienda.controllers;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import DAW.lope.tienda.entidades.Productos;
import DAW.lope.tienda.servicios.ServicioProductos;

@Controller
public class ContraladorIndex {
	
	//Conexión a los Servicios
	@Autowired
	ServicioProductos servicioProductos;

	// Métodos para la página principal

	@GetMapping(value={"/index","/"})
	public String index_get(Model modelo, HttpSession session) {

		// Productos
		List<Productos> Productos = servicioProductos.findEight();
		modelo.addAttribute("Productos", Productos);

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
		
		List<String> roles = new ArrayList<String>();
		
		String rol1 = (String) session.getAttribute("rol");
		String rol2 = (String) session.getAttribute("rol2");
		
		if (rol1 == null) {
			session.setAttribute("rol", "Publico");
		}
		
		roles.add(rol1);
		roles.add(rol2);
			
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