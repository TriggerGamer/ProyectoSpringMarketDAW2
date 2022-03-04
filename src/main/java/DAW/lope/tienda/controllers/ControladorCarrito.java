package DAW.lope.tienda.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import DAW.lope.tienda.entidades.Carrito;
import DAW.lope.tienda.entidades.Productos;
import DAW.lope.tienda.servicios.ServicioProductos;


@Controller
public class ControladorCarrito {

	// Conexión a los Servicios
	@Autowired
	private ServicioProductos servicioProductos;

	// Método guardar un producto en session para el Carrito
	@GetMapping(value = "/carrito/guardar/{id_Producto}")
	public String carrito_guardar(@RequestParam(value = "numeroProductos", required = false) String numeroProductos,
			Model modelo, @PathVariable int id_Producto, HttpSession session) {

		// Obtener los datos del producto mediante el servicio
		Productos productos = servicioProductos.findProductoById(id_Producto);

		if (numeroProductos == "") {
			numeroProductos = "1";
		}

		int numeroPr = Integer.parseInt(numeroProductos);

		Carrito objeto = new Carrito(productos.getId_Producto(), productos.getTituloProducto(), numeroPr);

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

	// Métodos para ver el Carrito
	@GetMapping(value = "/carrito/listar")
	public String carrito_listar(Model modelo, HttpSession session) {

		// Session Usuarios
		int id;
		
		try {
			id = (int) session.getAttribute("id_Usuario");
		}
		catch (Exception e) {
			id = 1;
		}
		
		modelo.addAttribute("id_usuario", id);
		
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
	
	@GetMapping(value = "/carrito/borrar/{id_Producto}")
	public String carrito_borrar(Model modelo, HttpSession session, @PathVariable int id_Producto) {
		
		// Coger los atributos del carrito en session
		@SuppressWarnings("unchecked")
		List<Carrito> carrito = (List<Carrito>) session.getAttribute("carrito");
		if (carrito == null) {
			carrito = new ArrayList<Carrito>();
		}
		else {
			for (int i = 0; i < carrito.size(); i++) {
				Carrito carrito2 = carrito.get(i);

				if (carrito2.getId_Producto() == id_Producto) {
					carrito.remove(i);
					break;
				}
			}
		}
		session.setAttribute("carrito", carrito);

		return "redirect:/carrito/listar";
	}

}
