package DAW.lope.tienda.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DAW.lope.tienda.entidades.Productos;
import DAW.lope.tienda.servicios.ServicioProductos;


@Controller
@RequestMapping("producto")
public class ControladorProductos {

	// Conexión a los Servicios
	@Autowired
	private ServicioProductos servicioProductos;

	// Métodos para buscar un producto
	@GetMapping(value = "/buscar")
	public String buscarProducto_get(@RequestParam(value = "nombre", required = false) String busqueda, Model modelo, HttpSession session) {

		if(busqueda == null) {
			busqueda = " ";
		}
		
		// Declarar la lista para obtener los datos
		List<Productos> productos = servicioProductos.getProductoByName(busqueda);
		modelo.addAttribute("productos", productos);
		
		// Session Usuarios
				int id;

				try {
					id = (int) session.getAttribute("id_Usuario");
				} catch (Exception e) {
					id = 1;
				}
				modelo.addAttribute("id_usuario", id);

		return "BuscarProducto";
	}

	// Métodos para crear un producto
	@GetMapping(value = "/crear")
	public String crearProducto_get(HttpSession session, Model modelo) {
		
		// Session Usuarios
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
		
		if(roles.equals("Admin")){
			return "CrearProducto";
		}
		else {
			return "redirect:/usuario/acceso-denegado";
		}

		
	}

	@PostMapping(value = "/crear")
	public String crearProducto_post(@RequestParam String titulo, @RequestParam String descripcion,
			@RequestParam String precio) {

		double price = Double.parseDouble(precio);
		int descuento = 10;
		Productos productos = new Productos();

		productos.setTituloProducto(titulo);
		productos.setDescripcionProducto(descripcion);
		productos.setPrecio(price);
		productos.setDescuento(descuento);

		servicioProductos.crear(productos);

		return "redirect:/index";
	}

	// Métodos para ver la info de un producto
	@GetMapping(value = "/{id_Producto}")
	public String infoProductos_get(Model modelo, @PathVariable int id_Producto, HttpSession session) {

		// Declarar la lista para obtener los datos
		Productos producto = servicioProductos.findProductoById(id_Producto);
		modelo.addAttribute("producto", producto);
		
		// Session Usuarios
				int id;

				try {
					id = (int) session.getAttribute("id_Usuario");
				} catch (Exception e) {
					id = 1;
				}
				modelo.addAttribute("id_usuario", id);
		
		return "ProductosInfo";
	}

	// Métodos para Borrar producto
	@GetMapping(value = "/borrar/{id_Producto}")
	public String borrar_get(Model modelo, @PathVariable int id_Producto) {

		// Borrar los datos
		servicioProductos.borrar(id_Producto);
		
		String borrar = "Borrado Correctamente";
		modelo.addAttribute("borrar", borrar);
		
		return "Borrar";
	}

}
