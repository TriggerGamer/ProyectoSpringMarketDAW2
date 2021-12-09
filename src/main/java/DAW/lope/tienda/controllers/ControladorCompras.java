package DAW.lope.tienda.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import DAW.lope.tienda.entidades.Carrito;
import DAW.lope.tienda.entidades.Compra;
import DAW.lope.tienda.entidades.Usuario;
import DAW.lope.tienda.servicios.ServicioCompras;
import DAW.lope.tienda.servicios.ServicioUsuarios;

@Controller
public class ControladorCompras {

	// Conexión a los Servicios
	@Autowired
	private ServicioCompras servicioCompras;
	@Autowired
	private ServicioUsuarios servicioUsuarios;

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

	// Método para ver las compras hechas
	@GetMapping(value = "/compra/miscompras")
	public String listarcompra_get(Model modelo, HttpSession session) {

		int id = (int) session.getAttribute("id_Usuario");
		modelo.addAttribute("id_usuario", id);
		
		// Obtener las compras
		List<Compra> compra = servicioCompras.findComprasUsuario(id);
		modelo.addAttribute("compras", compra);

		// session Usuarios
		String nombre = (String) session.getAttribute("user");
		
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

		return "ListaCompras";
	}

	// Método para devolver las compras hechas
	@PostMapping(value = "/compra/devolver/{id_Compra}")
	public String devolvercompra_get(Model modelo, @PathVariable int id_Compra, HttpSession session) {

		servicioCompras.deleteCompra(id_Compra);

		// session Usuarios
		String nombre = (String) session.getAttribute("user");
		String roles =  (String) session.getAttribute("rol");		
		modelo.addAttribute("roles", roles);

		if (nombre == null) {
			nombre = "f amigo";
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", "");
		} else {
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", nombre);
		}

		// Usuarios
		Usuario usuario1 = servicioUsuarios.login(nombre);

		if (usuario1 == null) {

		} else {
			int id_usuario = usuario1.getId_Usuario();
			modelo.addAttribute("usuario", id_usuario);
		}

		return "redirect:/compra/miscompras";
	}
	
}