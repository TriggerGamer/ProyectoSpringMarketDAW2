package DAW.lope.tienda.controllers;

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

	//Métodos para la página principal

	@GetMapping(value={"/index","/"})
	public String index_get(Model modelo, HttpSession session) {

		// Productos
		List<Productos> Productos = servicioProductos.findEight();
		modelo.addAttribute("Productos", Productos);
		
		return "Index";
	}

}