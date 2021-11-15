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
import DAW.lope.tienda.modelo.Carrito;
import DAW.lope.tienda.modelo.Producto;
import DAW.lope.tienda.modelo.Usuario;
import DAW.lope.tienda.servicios.ModuloServicioTemplate;

@Controller
public class ControladorTienda {

	@Autowired
	private ModuloServicioTemplate servicio;
	
	// Métodos para la página principal
	@GetMapping(value = "/index")
	public String index_get(Model modelo, HttpSession session) {
		
		//Producto
		List<Producto> Producto = servicio.findEight();
		modelo.addAttribute("Productos", Producto);
		
		//session Usuarios
		String nombre = (String) session.getAttribute("user");
		String contrasenia = (String) session.getAttribute("contrasenia");
		
		if(nombre == null) {
			nombre = "f amigo";
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", "");
		}
		else {
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", nombre);
		}
		
		//Usuarios
		Usuario usuario = servicio.findByName(nombre, contrasenia);
		if(usuario == null) {
			
		}
		else {
			int id_usuario = usuario.getId_Usuario();
			modelo.addAttribute("id_usuario", id_usuario);
		}
		
		return "Index";
	}

	// Métodos para buscar un producto
	@GetMapping(value = "/producto/buscar")
	public String buscarProducto_get(@RequestParam(value = "nombre", required = false) String busqueda, Model modelo, HttpSession session) {

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
		Usuario usuario = servicio.findByName(nombre, contrasenia);
		if (usuario == null) {

		} else {
			int id_usuario = usuario.getId_Usuario();
			modelo.addAttribute("usuario", id_usuario);
		}
		
		return "buscarProducto";
	}

	// Métodos para crear un producto
	@GetMapping(value = "/crear")
	public String crearProducto_get(HttpSession session,  Model modelo) {

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
		Usuario usuario = servicio.findByName(nombre, contrasenia);
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
		Usuario usuario = servicio.findByName(nombre, contrasenia);
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

		//Usuarios
		Usuario usuario1 = servicio.findByName(nombre, contrasenia);
		if(usuario1 == null) {
			
		}
		else {
			int id_usuario = usuario1.getId_Usuario();
			modelo.addAttribute("usuario", id_usuario);
		}

		return "borrar";
	}

	// Metodos para registro de usuarios
	@GetMapping(value = "/usuario/signup")
	public String registrarUsuario_get() {

		return "registro";
	}

	@PostMapping(value = "/usuario/signup")
	public String registrarUsuario_post(@RequestParam String nombreusuario, @RequestParam String apellidosusuario,
			@RequestParam String contrasenia, @RequestParam String correo, @RequestParam String fechanacimiento,
			@RequestParam long numerotarjeta, @RequestParam String titulartarjeta, @RequestParam int codigoseguridad,
			@RequestParam String direccionfacturacion) {

		Usuario registrar = new Usuario();

		registrar.setNombre(nombreusuario);
		registrar.setApellidos(apellidosusuario);
		registrar.setContrasenia(contrasenia);
		registrar.setEmail(correo);
		registrar.setFechaNacimiento(fechanacimiento);
		registrar.setNumeroTarjeta(numerotarjeta);
		registrar.setTitularTarjeta(titulartarjeta);
		registrar.setCodigoSeguridad(codigoseguridad);
		registrar.setDireccionFacturacion(direccionfacturacion);

		servicio.saveUsuarios(registrar);

		return "redirect:/index";
	}
	
	// Metodos para iniciar sesion
	@GetMapping(value = "/usuario/login")
	public String loginUsuario_get(Model modelo, HttpSession session) {
		
		String nombre = (String) session.getAttribute("user");
		String primeravez= (String) session.getAttribute("1vez");
		
		if(nombre == null && primeravez != null) {
			modelo.addAttribute("error", "Usuario incorrecto");
		}
		session.setAttribute("1vez", "hola");
		
		return "acceso";
	}

	@PostMapping(value = "/usuario/login")
	public String loginUsuario_post(@RequestParam String nombreusuario, @RequestParam String contrasenia, HttpSession session, Model modelo) {

		Usuario usuario = servicio.login(nombreusuario, contrasenia);
		
		if (usuario == null) {
			return	"redirect:/usuario/login";
		}else {
			session.setAttribute("user", usuario.getNombre());
			session.setAttribute("contrasenia", usuario.getContrasenia());
			session.setAttribute("carrito", null);
		}

		return "redirect:/index";
	}

	// Métodos desloguear un usuario
	@GetMapping(value = "/usuario/logOut")
	public String usuarioLOGOUT_get(Model modelo, HttpSession session) {

		session.setAttribute("user", null);
		session.setAttribute("contrasenia", null);
		session.setAttribute("carrito", null);
		session.setAttribute("1vez", null);

		return "redirect:/index";
	}

	// Métodos para ver la info de un usuario
	@GetMapping(value = "/usuario/perfil/{id_Usuario}")
	public String perfilUsuarios_get(Model modelo, @PathVariable int id_Usuario,  HttpSession session) {

		// Declarar la lista para obtener los datos
		List<Usuario> usuario = servicio.findUsuarioById(id_Usuario);
		modelo.addAttribute("usuarios", usuario);
		
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
		Usuario usuario1 = servicio.findByName(nombre, contrasenia);
		if (usuario1 == null) {

		} else {
			int id_usuario = usuario1.getId_Usuario();
			modelo.addAttribute("usuario", id_usuario);
		}

		return "UsuariosInfo";
	}
	
	// Método comprar un producto
	@PostMapping(value = "/comprar/producto/{id_Producto}")
	public String comprar_get(Model modelo, @PathVariable int id_Producto, HttpSession session) {

		// Comprobar usuario
		String nombre = (String) session.getAttribute("user");

		if (nombre == null) {
			nombre = "f amigo";
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", "");
			return "redirect:/usuario/login";
		} else {
			modelo.addAttribute("usuario1", nombre);
			modelo.addAttribute("usuario2", nombre);
			return "redirect:/compra/miscompras";
		}

	}

	// Método guardar un producto en session para el Carrito
	@GetMapping(value = "/carrito/guardar/{id_Producto}")
	public String carritoGuardar_get(@RequestParam(value = "numeroProductos", required = false) int numeroProductos,
			Model modelo, @PathVariable int id_Producto, HttpSession session) {

		// Obtener los datos del producto mediante el servicio
		Producto producto = servicio.findProductoById(id_Producto);

		Carrito compra = new Carrito(producto.getId_Producto(), producto.getTituloProducto(), numeroProductos);

		// Guardar los atributos del producto en session
		@SuppressWarnings("unchecked")
		List<Carrito> carrito = (List<Carrito>) session.getAttribute("carrito");

		if (carrito == null) {
			carrito = new ArrayList<Carrito>();
			session.setAttribute("carrito", carrito);
		}
		carrito.add(compra);
		session.setAttribute("carrito", carrito);

		return "redirect:/carrito/listar";
	}

	// Método para ver las compras hechas
	@GetMapping(value = "/compra/miscompras")
	public String listarcompra_get(Model modelo, HttpSession session) {
		

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
		Usuario usuario1 = servicio.findByName(nombre, contrasenia);

		if (usuario1 == null) {

		} else {
			int id_usuario = usuario1.getId_Usuario();
			modelo.addAttribute("usuario", id_usuario);
		}

		return "ListaCompras";
	}
	
	// Método para ver las compras hechas
		@GetMapping(value = "/compra/devolver/{idCompra}")
		public String devolvercompra_get(Model modelo, @PathVariable int id_Compra, HttpSession session) {
			

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
			Usuario usuario1 = servicio.findByName(nombre, contrasenia);

			if (usuario1 == null) {

			} else {
				int id_usuario = usuario1.getId_Usuario();
				modelo.addAttribute("usuario", id_usuario);
			}

			return "ListaCompras";
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
		Usuario usuario1 = servicio.findByName(nombre, contrasenia);

		if (usuario1 == null) {

		} else {
			int id_usuario = usuario1.getId_Usuario();
			modelo.addAttribute("usuario", id_usuario);
		}

		@SuppressWarnings("unchecked")
		List<Carrito> carrito = (List<Carrito>) session.getAttribute("carrito");
		if (carrito == null) {
			carrito = new ArrayList<Carrito>();
		}
		modelo.addAttribute("carrito", carrito);
		// Coger los atributos del carrito en session

		return "Carrito";
	}

}
