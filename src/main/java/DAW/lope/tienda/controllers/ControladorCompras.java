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
import DAW.lope.tienda.entidades.Compras;
import DAW.lope.tienda.entidades.Productos;
import DAW.lope.tienda.servicios.ServicioCompras;
import DAW.lope.tienda.servicios.ServicioProductos;

@Controller
public class ControladorCompras {

	// Conexión a los Servicios
	@Autowired
	private ServicioCompras servicioCompras;
	
	@Autowired
	private ServicioProductos servicioProductos;

	// Método comprar un producto
	@PostMapping(value = "/compra")
	public String comprar_get(Model modelo, HttpSession session) {
		
		int id_Usuario = (int) session.getAttribute("id_Usuario");
		String roles = (String) session.getAttribute("rol");
		
		if(roles.equals("Publico")) {
			return "redirect:/acceso-denegado";
		}

		// Instanciar a compra
		Compras compra = new Compras();
		compra = servicioCompras.crear(id_Usuario, compra);
		
		// Obtener el carrito de la compra de session
		@SuppressWarnings("unchecked")
		List<Carrito> carrito = (List<Carrito>) session.getAttribute("carrito");

		for (int i = 0; i < carrito.size(); i++) {
			Carrito carrito2 = carrito.get(i);
			
			Productos productos = servicioProductos.findProductoById(carrito2.getId_Producto());

			// Guardar cada producto a la compra
			compra.anadirProductos(productos, carrito2.getNumeroUnidades());
		}
		
		session.setAttribute("carrito", null);
		session.setAttribute("vacio", null);
		
		return "redirect:/compra/miscompras";

	}

	// Método para ver las compras hechas
	@GetMapping(value = "/compra/miscompras")
	public String listarcompra_get(Model modelo, HttpSession session) {

		int id;
		
		try {
			id = (int) session.getAttribute("id_Usuario");
		}
		catch (Exception e) {
			id = 1;
		}
		
		modelo.addAttribute("id_usuario", id);

		// Obtener las compras
		List<Compras> compras = servicioCompras.findComprasUsuario(id);
		modelo.addAttribute("compras", compras);

		return "ListaCompras";
	}

	// Método para devolver las compras hechas
	@PostMapping(value = "/compra/devolver/{id_Compra}")
	public String devolvercompra_get(Model modelo, @PathVariable int id_Compra, HttpSession session) {

		servicioCompras.borrar(id_Compra);

		return "redirect:/compra/miscompras";
	}

}