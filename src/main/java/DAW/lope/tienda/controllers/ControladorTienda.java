package DAW.lope.tienda.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import DAW.lope.tienda.modelo.Productos;
import DAW.lope.tienda.modelo.ProductosDao;


@Controller
public class ControladorTienda {
	
	@Autowired
	private ProductosDao productosdao;

	// Métodos para la página principal
	@GetMapping(value="/index")
	public String index_get() {

		return "Index";
	}
	
	@PostMapping(value="/index")
	public String index_post(@RequestParam String Pr1) {
		
		
		
		return "redirect:/Productos";
	}
	
	// Métodos para crear un producto
	@GetMapping(value="/crearProducto")
	public String crearProducto_get() {


		return "crearProducto";
	}
	@PostMapping(value="/crearProducto")
	public String crearProducto_post(@RequestParam String titulo,
			@RequestParam String descripcion,
			@RequestParam String precio) {
		
			double price = Double.parseDouble(precio);

			Productos producto = new Productos(1,titulo, descripcion, price, 5);
			productosdao.save(producto);			
		return "redirect:/index";
	}
	

	@GetMapping(value="/buscarProducto")
	public String buscarProducto_get() {
		
		return "buscarProducto";
	}
	
	@GetMapping(value="/Productos")
	public String Productos_get(Model modelo) {
		
		//Declarar la lista para obtener los datos
		List<Productos> Productos = productosdao.findAll();
		modelo.addAttribute("Productos", Productos);

		return "producto/1";
	}
	
	@PostMapping(value="/Productos")
	public String Productos_post(Model modelo) {
		
		//Declarar la lista para obtener los datos
		List<Productos> Productos = productosdao.findAll();
		modelo.addAttribute("Productos", Productos);

		return "producto/1";
	}


}
