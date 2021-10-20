package DAW.lope.tienda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import DAW.lope.tienda.modelo.Productos;
import DAW.lope.tienda.modelo.ProductosDao;


@Controller
public class ControladorTienda {
	
	@Autowired
	private ProductosDao productosdao;

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
	
	@RequestMapping(value="/Productos", method=RequestMethod.GET)
	public String Productos_get(Model modelo) {
		
		//Declarar la lista para obtener los datos
		List<Productos> Productos = productosdao.findAll();
		modelo.addAttribute("Productos", Productos);

		return "ProductosInfo";
	}


}
