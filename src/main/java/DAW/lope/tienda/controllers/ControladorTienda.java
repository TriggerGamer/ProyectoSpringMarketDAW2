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
	
	// Métodos para crear un producto
	@RequestMapping(value="/crearProducto", method=RequestMethod.GET)
	public String crearProducto_get() {


		return "crearProducto";
	}
	

	@RequestMapping(value="/buscarProducto", method=RequestMethod.GET)
	public String buscarProducto_get() {

		return "buscarProducto";
	}

}
