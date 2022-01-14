package DAW.lope.tienda.controllers;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import DAW.lope.tienda.entidades.Producto;
import DAW.lope.tienda.servicios.ServicioProductos;


@Controller
public class ControladorProductos {

	// Conexión a los Servicios
	@Autowired
	private ServicioProductos servicioProductos;

	// Métodos para buscar un producto
	@GetMapping(value = "/producto/buscar")
	public String buscarProducto_get(@RequestParam(value = "nombre", required = false) String busqueda, Model modelo,
			HttpSession session) {

		if(busqueda == null) {
			busqueda = " ";
		}
		
		// Declarar la lista para obtener los datos
		List<Producto> producto = servicioProductos.getProductoByName(busqueda);
		modelo.addAttribute("productos", producto);

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

		return "BuscarProducto";
	}

	// Métodos para crear un producto
	@GetMapping(value = "/producto/crear")
	public String crearProducto_get(HttpSession session, Model modelo) {
		
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
		
		if(roles.equals("Admin")){
			return "CrearProducto";
		}
		else {
			return "redirect:/acceso-denegado";
		}

		
	}

	@PostMapping(value = "/producto/crear")
	public String crearProducto_post(@RequestParam String titulo, @RequestParam String descripcion,
			@RequestParam String precio) {

		double price = Double.parseDouble(precio);
		int descuento = 10;
		Producto producto = new Producto();

		producto.setTituloProducto(titulo);
		producto.setDescripcionProducto(descripcion);
		producto.setPrecio(price);
		producto.setDescuento(descuento);

//		servicioProductos.saveProductos(producto);

		return "redirect:/index";
	}

	// Métodos para ver la info de un producto
	@GetMapping(value = "/producto/{id_Producto}")
	public String infoProductos_get(Model modelo, @PathVariable int id_Producto, HttpSession session) {

		// Declarar la lista para obtener los datos
		Producto producto = servicioProductos.findProductoById(id_Producto);
		modelo.addAttribute("producto", producto);

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
		
		return "ProductosInfo";
	}

	// Métodos para Borrar producto
	@GetMapping(value = "/producto/borrar/{id_Producto}")
	public String borrar_get(Model modelo, @PathVariable int id_Producto, HttpSession session) {

		// Borrar los datos
	//	servicioProductos.deleteProductoById(id_Producto);
		String borrar = "Borrado Correctamente";
		modelo.addAttribute("borrar", borrar);

		// Session Usuarios
		String nombre = (String) session.getAttribute("user");
		int id = (int) session.getAttribute("id_Usuario");
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

		return "borrar";
	}

}
