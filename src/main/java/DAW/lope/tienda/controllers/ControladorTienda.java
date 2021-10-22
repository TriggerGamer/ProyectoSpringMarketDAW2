package DAW.lope.tienda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String index_get (Model modelo) {
		
		List<Productos> Productos = productosdao.findEight();
		modelo.addAttribute("Productos", Productos);
		
		return "Index";
	}
	
	@PostMapping(value="/index")
	public String index_post(@RequestParam (value="Pr1", required=false) String Pr1, 
			@RequestParam(value="busqueda", required=false)String busqueda, Model modelo) {
		
		List<Productos> Productos = productosdao.getProductoByName(busqueda);
		modelo.addAttribute("busqueda", Productos);

		return "";
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
		int descuento = 10;
		Productos producto = new Productos();
		
		producto.setTituloProducto(titulo);
		producto.setDescripcionProducto(descripcion);
		producto.setPrecio(price);
		producto.setDescuento(descuento);
		
		productosdao.save(producto);	
		
		return "redirect:/index";
	}
	
	//Métodos para buscar un producto
	@GetMapping(value="/buscarProducto")
	public String buscarProducto_get() {
		
		return "buscarProducto";
	}
	
	@GetMapping(value="/producto/{id_Producto}")
	public String Productos_get(Model modelo, @PathVariable int id_Producto) {
		
		//Declarar la lista para obtener los datos
		List<Productos> producto = productosdao.findById(id_Producto);
		modelo.addAttribute("productos", producto);
		
		return "/ProductosInfo";
	}
	
	
	// Métodos para Borrar producto
	@GetMapping(value="/producto/borrar/{id_Producto}")
	public String borrar_get(Model modelo, @PathVariable int id_Producto) {
		
		return "borrar";
	}
	
	@PostMapping(value="/producto/borrar/{id_Producto}")
	public String borrar_post(Model modelo, @PathVariable int id_Producto) {
		
		//Borrar los datos
		productosdao.deleteById(id_Producto);
		
		String borrar = "borrado correctamente";
		modelo.addAttribute("borrar", borrar);

		return "borrar";
	}
	


}
