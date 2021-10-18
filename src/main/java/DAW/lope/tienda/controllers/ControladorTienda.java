package DAW.lope.tienda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControladorTienda {

	// Métodos para la página principal
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index_get() {

		return "Index";
	}
	
	// Métodos para la página principal
	@RequestMapping(value="/crearProducto", method=RequestMethod.GET)
	public String creaProducto_get() {

		return "crearProducto";
	}
	
	
}
