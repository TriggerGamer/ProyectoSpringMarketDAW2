package DAW.lope.tienda.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import DAW.lope.tienda.Dtos.PreguntasDto;
import DAW.lope.tienda.Dtos.RespuestasDto;
import DAW.lope.tienda.entidades.Preguntas;
import DAW.lope.tienda.entidades.Respuestas;
import DAW.lope.tienda.servicios.ServicioPreguntas;
import DAW.lope.tienda.servicios.ServicioRespuestas;

@Controller
public class ControlardorPyR {

	// Conexión a los Servicios
	@Autowired
	private ServicioRespuestas servicioRespuestas;

	@Autowired
	private ServicioPreguntas servicioPreguntas;

	// Crear Preguntas y Respuestas
	@ResponseBody
	@PostMapping("/crear/pregunta/{idProducto}")
	public ResponseEntity<Object> crearPreguntas(@PathVariable int idProducto, @RequestBody Map<String, String> json,
			HttpSession session) {
		
		Preguntas pregunta = new Preguntas();

		int idUsuario;

		try {
			idUsuario = (int) session.getAttribute("id_Usuario");
		} catch (Exception e) {
			idUsuario = 1;
		}
		
		pregunta.setPregunta(json.get("pregunta"));

		int id = servicioPreguntas.guardarPregunta(pregunta, idUsuario, idProducto);
		
		PreguntasDto dto = new PreguntasDto(id, json.get("pregunta"), idUsuario, null, null);
		
		return new ResponseEntity<Object>(dto, HttpStatus.OK);
	}

	@ResponseBody
	@PostMapping("/crear/respuesta/{idPregunta}")
	public ResponseEntity<Object> crearRespuesta(@PathVariable int idPregunta, @RequestBody Map<String, String> json,
			HttpSession session) {

		Respuestas respuesta = new Respuestas();

		int idUsuario;

		try {
			idUsuario = (int) session.getAttribute("id_Usuario");
		} catch (Exception e) {
			idUsuario = 1;
		}

		respuesta.setRespuesta(json.get("respuesta"));

		int id = servicioRespuestas.guardarRespuesta(respuesta, idUsuario, idPregunta);
		
		RespuestasDto dto = new RespuestasDto(id, json.get("respuesta"), idPregunta, idUsuario, null, null);

		return new ResponseEntity<Object>(dto, HttpStatus.OK);

	}

	// Obtener Preguntas y Respuestas
	@ResponseBody
	@GetMapping("/obtener/preguntas/{idProducto}")
	public List<PreguntasDto> obtenerPreguntas(@PathVariable int idProducto) {
		return servicioPreguntas.buscarPorProducto(idProducto);
	}

	@ResponseBody
	@GetMapping("/obtener/respuesta/{idPregunta}")
	public List<RespuestasDto> obtenerRespuestas(@PathVariable int idPregunta) {
		return servicioRespuestas.buscarRespuestasPorPregunta(idPregunta);
	}

	// Obtener información importante para ajax
	@ResponseBody
	@GetMapping("/obtener/idUsuario")
	public int obteneridUsuario(HttpSession session) {

		int idUsuario;

		try {
			idUsuario = (int) session.getAttribute("id_Usuario");
		} catch (Exception e) {
			idUsuario = 0;
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

	// Borrar Preguntas y Respuestas
	@ResponseBody
	@GetMapping("/borrar/pregunta/{idPregunta}")
	public String borrarPreguntas(@PathVariable int idPregunta) {
		servicioPreguntas.borrarPregunta(idPregunta);
		return "true";
	}

	@ResponseBody
	@GetMapping("/borrar/respuesta/{idRespuesta}")
	public String borrarRespuestas(@PathVariable int idRespuesta) {
		servicioRespuestas.borrarRespuesta(idRespuesta);
		return "true";
	}

	// Editar respuestas
	@ResponseBody
	@PostMapping("/editar/respuesta/{idRespuesta}")
	public ResponseEntity<Object> editarRespuesta(@PathVariable int idRespuesta,
			@RequestBody Map<String, String> json) {
		
			servicioRespuestas.editarRespuesta(idRespuesta, json.get("respuesta"));
			
			RespuestasDto dto = new RespuestasDto(idRespuesta, json.get("respuesta"), 0, 0, null, null);
		return new ResponseEntity<Object>(dto, HttpStatus.OK);
	}
	
}
