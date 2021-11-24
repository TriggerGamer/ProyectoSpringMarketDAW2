package DAW.lope.tienda.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DAW.lope.tienda.entidades.Carrito;
import DAW.lope.tienda.entidades.Compra;
import DAW.lope.tienda.entidades.Producto;
import DAW.lope.tienda.entidades.Usuario;
import DAW.lope.tienda.servicios.ServicioComprasImpl;
import DAW.lope.tienda.servicios.ServicioProductosImpl;
import DAW.lope.tienda.servicios.ServicioUsuariosImpl;

@Controller
public class ControladorCompras {

	// Conexión a los Servicios
	@Autowired
	private ServicioComprasImpl servicioCompras;
	@Autowired
	private ServicioUsuariosImpl servicioUsuarios;
	@Autowired
	private ServicioProductosImpl servicioProductos;

	// Método comprar un producto
	@PostMapping(value = "/compra")
	public String comprar_get(Model modelo, HttpSession session) {

		// Comprobar usuario
		String nombre = (String) session.getAttribute("user");
		int id_Usuario = (int) session.getAttribute("id_Usuario");

		if (nombre == null) {
			return "redirect:/usuario/login";
		} else {

			// Guardar la compra
			servicioCompras.saveCompras(id_Usuario);

			Compra compra = servicioCompras.getCompras(id_Usuario);

			// Obtener el carrito de la compra de session
			@SuppressWarnings("unchecked")
			List<Carrito> carrito = (List<Carrito>) session.getAttribute("carrito");

			for (int i = 0; i < carrito.size(); i++) {
				Carrito carrito2 = carrito.get(i);

				// Guardar cada producto el la base de datos
				servicioCompras.saveProductosCompra(compra.getId_Compra(), carrito2.getId_Producto(),
						carrito2.getNumeroUnidades());
			}
			session.setAttribute("carrito", null);
			session.setAttribute("vacio", null);
			return "redirect:/compra/miscompras";
		}
	}

	// Método guardar un producto en session para el Carrito
	@GetMapping(value = "/carrito/guardar/{id_Producto}")
	public String carritoGuardar_get(@RequestParam(value = "numeroProductos", required = false) String numeroProductos,
			Model modelo, @PathVariable int id_Producto, HttpSession session) {

		// Obtener los datos del producto mediante el servicio
		Producto producto = servicioProductos.findProductoById(id_Producto);

		if (numeroProductos == null) {
			numeroProductos = "1";
		}

		int numeroPr = Integer.parseInt(numeroProductos);

		Carrito objeto = new Carrito(producto.getId_Producto(), producto.getTituloProducto(), numeroPr);

		// Guardar los atributos del producto en session
		@SuppressWarnings("unchecked")
		List<Carrito> carrito = (List<Carrito>) session.getAttribute("carrito");

		if (carrito == null) {
			carrito = new ArrayList<Carrito>();
			session.setAttribute("carrito", carrito);
		} else {
			for (int i = 0; i < carrito.size(); i++) {
				Carrito carrito2 = carrito.get(i);

				if (carrito2.getId_Producto() == objeto.getId_Producto()) {
					objeto.setNumeroUnidades((carrito2.getNumeroUnidades() + objeto.getNumeroUnidades()));
					carrito.remove(i);
					break;
				}
			}
		}

		carrito.add(objeto);
		session.setAttribute("carrito", carrito);
		session.setAttribute("vacio", "Lleno");

		return "redirect:/carrito/listar";
	}

	// Método para ver las compras hechas
	@GetMapping(value = "/compra/miscompras")
	public String listarcompra_get(Model modelo, HttpSession session) {

		// session Usuarios
		String nombre = (String) session.getAttribute("user");
		String contrasenia = (String) session.getAttribute("contrasenia");
		int id = (int) session.getAttribute("id_Usuario");

		// Obtener las compras

		List<Compra> compra = servicioCompras.findComprasUsuario(id);
		modelo.addAttribute("compras", compra);

		if (nombre == null) {
			nombre = "f amigo";
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", "");
		} else {
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", nombre);
		}

		// Usuarios
		Usuario usuario1 = servicioUsuarios.login(nombre, contrasenia);

		if (usuario1 == null) {

		} else {
			int id_usuario = usuario1.getId_Usuario();
			modelo.addAttribute("usuario", id_usuario);
		}

		return "ListaCompras";
	}

	// Método para devolver las compras hechas
	@PostMapping(value = "/compra/devolver/{id_Compra}")
	public String devolvercompra_get(Model modelo, @PathVariable int id_Compra, HttpSession session) {

		servicioCompras.deleteCompra(id_Compra);

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
		Usuario usuario1 = servicioUsuarios.login(nombre, contrasenia);

		if (usuario1 == null) {

		} else {
			int id_usuario = usuario1.getId_Usuario();
			modelo.addAttribute("usuario", id_usuario);
		}

		return "redirect:/compra/miscompras";
	}

	// Métodos para ver el Carrito
	@GetMapping(value = "/carrito/listar")
	public String carrito_get(Model modelo, HttpSession session) {

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
		Usuario usuario1 = servicioUsuarios.login(nombre, contrasenia);

		if (usuario1 == null) {

		} else {
			int id_usuario = usuario1.getId_Usuario();
			modelo.addAttribute("usuario", id_usuario);
		}

		// Coger los atributos del carrito en session
		@SuppressWarnings("unchecked")
		List<Carrito> carrito = (List<Carrito>) session.getAttribute("carrito");
		if (carrito == null) {
			carrito = new ArrayList<Carrito>();
		}
		modelo.addAttribute("carrito", carrito);

		String vacio = (String) session.getAttribute("vacio");

		modelo.addAttribute("vacio", vacio);
		modelo.addAttribute("novacio", null);

		return "Carrito";
	}
	
}