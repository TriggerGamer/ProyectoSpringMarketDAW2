package DAW.lope.tienda.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DAW.lope.tienda.modelo.Productos;
import DAW.lope.tienda.modelo.ProductosDao;
import DAW.lope.tienda.modelo.Usuarios;
import DAW.lope.tienda.modelo.UsuariosDao;

@Controller
public class ControladorTienda {

	@Autowired
	private ProductosDao productosdao;

	@Autowired
	private UsuariosDao usuariosdao;

	// Métodos para la página principal
	@GetMapping(value = "/index")
	public String index_get(Model modelo) {

		List<Productos> Productos = productosdao.findEight();
		modelo.addAttribute("Productos", Productos);

		return "Index";
	}

	// Métodos para buscar un producto
	@GetMapping(value = "/producto/buscar")
	public String buscarProducto_get(@RequestParam(value = "nombre", required = false) String busqueda, Model modelo) {

		// Declarar la lista para obtener los datos
		List<Productos> producto = productosdao.getProductoByName(busqueda);
		modelo.addAttribute("productos", producto);

		return "buscarProducto";
	}

	// Métodos para crear un producto
	@GetMapping(value = "/crear")
	public String crearProducto_get() {

		return "crearProducto";
	}

	@PostMapping(value = "/crear")
	public String crearProducto_post(@RequestParam String titulo, @RequestParam String descripcion,
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

	// Métodos para ver la info de un producto
	@GetMapping(value = "/producto/{id_Producto}")
	public String Productos_get(Model modelo, @PathVariable int id_Producto) {

		// Declarar la lista para obtener los datos
		List<Productos> producto = productosdao.findById(id_Producto);
		modelo.addAttribute("productos", producto);

		return "ProductosInfo";
	}

	// Métodos para Borrar producto
	@GetMapping(value = "/producto/borrar/{id_Producto}")
	public String borrar_get(Model modelo, @PathVariable int id_Producto) {

		// Borrar los datos
		productosdao.deleteById(id_Producto);

		String borrar = "Borrado Correctamente";
		modelo.addAttribute("borrar", borrar);

		return "borrar";
	}

	// Metodos para registro de usuarios
	@GetMapping(value = "/usuario/signup")
	public String registrarUsuario_get() {

		return "registro";
	}

	@PostMapping(value = "/usuario/signup")
	public String registrarUsuario_post(@RequestParam String nombreusuario,
			@RequestParam String apellidosusuario,
			@RequestParam String contrasenia,
			@RequestParam String correo,
			@RequestParam String fechanacimiento,
			@RequestParam long numerotarjeta,
			@RequestParam String titulartarjeta,
			@RequestParam int codigoseguridad,
			@RequestParam String direccionfacturacion) {

		Usuarios registrar = new Usuarios();

		registrar.setNombre(nombreusuario);
		registrar.setApellidos(apellidosusuario);
		registrar.setContrasenia(contrasenia);
		registrar.setEmail(correo);
		registrar.setFechaNacimiento(fechanacimiento);
		registrar.setNumeroTarjeta(numerotarjeta);
		registrar.setTitularTarjeta(titulartarjeta);
		registrar.setCodigoSeguridad(codigoseguridad);
		registrar.setDireccionFacturacion(direccionfacturacion);

		usuariosdao.save(registrar);

		return "redirect:/index";
	}

	// Metodos para inicio de sesion
	@GetMapping(value = "/usuario/login")
	public String loginUsuario_get() {
		
		
		return "acceso";
	}

	@PostMapping(value = "/usuario/login")
	public String loginUsuario_post(@RequestParam String nombreusuario, @RequestParam String contrasenia) {
		
		Optional<Usuarios> usuario = usuariosdao.login(nombreusuario, contrasenia);
		Usuarios nombreUsuario = usuario.get();
		
		if(nombreusuario == nombreUsuario.getNombre() && contrasenia == nombreUsuario.getContrasenia()) {
			
		}
		
		
		
		return "redirect:/index";
	}

	// Métodos para ver la info de un producto
	@GetMapping(value = "/usuario/perfil/{id_Usuario}")
	public String Usuarios_get(Model modelo, @PathVariable int id_Usuario) {

		// Declarar la lista para obtener los datos
		List<Usuarios> usuario = usuariosdao.findById(id_Usuario);
		modelo.addAttribute("usuarios", usuario);

		return "UsuariosInfo";
	}

}
