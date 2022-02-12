package DAW.lope.tienda.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import DAW.lope.tienda.entidades.Preguntas;
import DAW.lope.tienda.entidades.Respuestas;
import DAW.lope.tienda.servicios.ServicioPreguntas;
import DAW.lope.tienda.servicios.ServicioRespuestas;

@Controller
public class ControlardorPyR {

	@Autowired
	private ServicioRespuestas servicioRespuestas;

	@Autowired
	private ServicioPreguntas servicioPreguntas;

	@ResponseBody
	@PostMapping("/crear/pregunta/{id}")
	public String crearPreguntas(@PathVariable int idProducto, @RequestParam String pregunta, HttpSession session) {
		Preguntas pregunta1 = new Preguntas();

		int idUsuario;

		try {
			idUsuario = (int) session.getAttribute("id_Usuario");
		} catch (Exception e) {
			idUsuario = 1;
		}
		pregunta1.setPregunta(pregunta);

		servicioPreguntas.guardarPregunta(pregunta1, idProducto, idUsuario);
		return "";
	}

	@ResponseBody
	@PostMapping("/borrar/pregunta/{idPregunta}")
	public String borrarPreguntas(@PathVariable int idPregunta) {
		servicioPreguntas.borrarPregunta(idPregunta);
		return "";
	}

	@ResponseBody
	@GetMapping("/obtener/preguntas")
	public List<Preguntas> obtenerPreguntas() {

		return servicioPreguntas.buscarTodas();
	}

	@ResponseBody
	@GetMapping("/obtener/idUsuario")
	public int obteneridUsuario(HttpSession session) {

		int idUsuario;

		try {
			idUsuario = (int) session.getAttribute("id_Usuario");
		} catch (Exception e) {
			idUsuario = 1;
		}

		return idUsuario;
	}

	@ResponseBody
	@GetMapping("/obtener/roles")
	public List<String> obtenerRoles(HttpSession session) {
		
		String rol = (String) session.getAttribute("rol");
		String rol2 = (String) session.getAttribute("rol2"); 
		
		List<String> roles = new ArrayList<String>();
		roles.add(rol);
		roles.add(rol2);
		
		return roles;
	}

	@ResponseBody
	@PostMapping("/crear/respuesta/{idPregunta}")
	public String crearRespuesta(@PathVariable int idPregunta, @RequestParam String respuesta, HttpSession session) {
		Respuestas respuesta1 = new Respuestas();

		int idUsuario;

		try {
			idUsuario = (int) session.getAttribute("id_Usuario");
		} catch (Exception e) {
			idUsuario = 1;
		}
		respuesta1.setRespuesta(respuesta);

		servicioRespuestas.guardarRespuesta(respuesta1, idUsuario, idPregunta);
		return "";
	}
	
	@ResponseBody
	@PostMapping("/borrar/respuesta/{idRespuesta}")
	public String borrarRespuestas(@PathVariable int idRespuesta) {
		servicioPreguntas.borrarPregunta(idRespuesta);
		return "";
	}

	@ResponseBody
	@PostMapping("/editar/respuesta/{idRespuesta}")
	public String editarRespuesta(@PathVariable int idRespuesta, @RequestParam String respuesta) {
		Respuestas respuesta1 = new Respuestas();
		respuesta1.setRespuesta(respuesta);
		servicioRespuestas.editarRespuesta(idRespuesta, respuesta);
		return "";
	}
	
	@ResponseBody
	@GetMapping("/obtener/respuesta")
	public List<Respuestas> obtenerRespuestas() {
		return servicioRespuestas.buscarTodas();
	}
}
