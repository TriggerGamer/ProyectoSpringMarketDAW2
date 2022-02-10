package DAW.lope.tienda.controllers;

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
		pregunta1.setFecha_Pregunta(pregunta);

		servicioPreguntas.guardarPregunta(pregunta1, idProducto, idUsuario);
		return "";
	}
	
	@ResponseBody
	@PostMapping("/borrar/pregunta/{id}")
	public String borrarPreguntas(@PathVariable int idPregunta, HttpSession session) {
		Preguntas pregunta1 = new Preguntas();

		int idUsuario;

		try {
			idUsuario = (int) session.getAttribute("id_Usuario");
		} catch (Exception e) {
			idUsuario = 1;
		}
	
		servicioPreguntas.borrarPregunta(idPregunta, idUsuario);
		return "";
	}

	@ResponseBody
	@GetMapping("/obtener/preguntas")
	public List<Preguntas> obtenerPreguntas() {

		return servicioPreguntas.buscarTodas();
	}

	@ResponseBody
	@PostMapping("/crear/respuesta/{id}")
	public String crearRespuesta(@PathVariable int id) {
		return "";
	}

	@ResponseBody
	@GetMapping("/obtener/respuesta")
	public List<Respuestas> obtenerRespuestas() {

		return servicioRespuestas.buscarTodas();
	}
}
