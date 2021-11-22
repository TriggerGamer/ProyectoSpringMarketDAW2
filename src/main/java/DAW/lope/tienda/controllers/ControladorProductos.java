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

import DAW.lope.tienda.Entidades.Producto;
import DAW.lope.tienda.Entidades.Usuario;
import DAW.lope.tienda.servicios.ModuloServicioTemplate;

@Controller
public class ControladorProductos {

	// Conexión a los Servicios
	@Autowired
	private ModuloServicioTemplate servicio;

	// Métodos para buscar un producto
	@GetMapping(value = "/producto/buscar")
	public String buscarProducto_get(@RequestParam(value = "nombre", required = false) String busqueda, Model modelo,
			HttpSession session) {

		// Declarar la lista para obtener los datos
		List<Producto> producto = servicio.getProductoByName(busqueda);
		modelo.addAttribute("productos", producto);

		// session Usuarios
		String nombre = (String) session.getAttribute("user");
		String contrasenia = (String) session.getAttribute("contrasenia");

		if (nombre == null) {
			nombre = "f amigo";
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", "");
		} else {
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", nombre);
		}

		// Usuarios
		Usuario usuario = servicio.login(nombre, contrasenia);
		if (usuario == null) {

		} else {
			int id_usuario = usuario.getId_Usuario();
			modelo.addAttribute("usuario", id_usuario);
		}

		return "buscarProducto";
	}

	// Métodos para crear un producto
	@GetMapping(value = "/crear")
	public String crearProducto_get(HttpSession session, Model modelo) {

		// Session Usuarios
		String nombre = (String) session.getAttribute("user");
		String contrasenia = (String) session.getAttribute("contrasenia");

		if (nombre == null) {
			nombre = "f amigo";
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", "");
		} else {
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", nombre);
		}

		// Usuarios
		Usuario usuario = servicio.login(nombre, contrasenia);
		if (usuario == null) {

		} else {
			int id_usuario = usuario.getId_Usuario();
			modelo.addAttribute("usuario", id_usuario);
		}

		return "crearProducto";
	}

	@PostMapping(value = "/crear")
	public String crearProducto_post(@RequestParam String titulo, @RequestParam String descripcion,
			@RequestParam String precio) {

		double price = Double.parseDouble(precio);
		int descuento = 10;
		Producto producto = new Producto();

		producto.setTituloProducto(titulo);
		producto.setDescripcionProducto(descripcion);
		producto.setPrecio(price);
		producto.setDescuento(descuento);

		servicio.saveProductos(producto);

		return "redirect:/index";
	}

	// Métodos para ver la info de un producto
	@GetMapping(value = "/producto/{id_Producto}")
	public String infoProductos_get(Model modelo, @PathVariable int id_Producto, HttpSession session) {

		// Declarar la lista para obtener los datos
		Producto producto = servicio.findProductoById(id_Producto);
		modelo.addAttribute("producto", producto);

		// Session Usuarios
		String nombre = (String) session.getAttribute("user");
		String contrasenia = (String) session.getAttribute("contrasenia");

		if (nombre == null) {
			nombre = "f amigo";
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", "");
		} else {
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", nombre);
		}

		// Usuarios
		Usuario usuario = servicio.login(nombre, contrasenia);
		if (usuario == null) {

		} else {
			int id_usuario = usuario.getId_Usuario();
			modelo.addAttribute("usuario", id_usuario);
		}

		return "ProductosInfo";
	}

	// Métodos para Borrar producto
	@GetMapping(value = "/producto/borrar/{id_Producto}")
	public String borrar_get(Model modelo, @PathVariable int id_Producto, HttpSession session) {

		// Borrar los datos
		servicio.deleteProductoById(id_Producto);
		String borrar = "Borrado Correctamente";
		modelo.addAttribute("borrar", borrar);

		// Session Usuarios
		String nombre = (String) session.getAttribute("user");
		String contrasenia = (String) session.getAttribute("contrasenia");

		if (nombre == null) {
			nombre = "f amigo";
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", "");
		} else {
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", nombre);
		}

		// Usuarios
		Usuario usuario1 = servicio.login(nombre, contrasenia);
		if (usuario1 == null) {

		} else {
			int id_usuario = usuario1.getId_Usuario();
			modelo.addAttribute("usuario", id_usuario);
		}

		return "borrar";
	}
	
}