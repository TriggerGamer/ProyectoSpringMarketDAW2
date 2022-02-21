package DAW.lope.tienda.servicios;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAW.lope.tienda.Dtos.RespuestasDto;
import DAW.lope.tienda.entidades.Preguntas;
import DAW.lope.tienda.entidades.Respuestas;
import DAW.lope.tienda.entidades.Usuario;
import DAW.lope.tienda.repositorios.PreguntasRepository;
import DAW.lope.tienda.repositorios.RespuestasRepository;

@Transactional
@Service
public class ServicioRespuestasImpl implements ServicioRespuestas{

	@Autowired
	private RespuestasRepository respuestasRepository;
	
	@Autowired
	private PreguntasRepository preguntasRepository;
	
	@Autowired
	private ServicioUsuarios servicioUsuarios;

	@Override
	public int guardarRespuesta(Respuestas respuesta, int idUsuario, int idPregunta) {
		try {
			
			String f = LocalDateTime.now().toString();
			String nuevo[] = f.split("T");
			String fecha = nuevo[0];
			
			respuesta.setFecha_Respuesta(fecha);
			
			Usuario usuario = servicioUsuarios.findUsuarioById(idUsuario);
			Preguntas pregunta = preguntasRepository.getById(idPregunta);
			
			respuesta.setUsuario(usuario);
			respuesta.setPregunta(pregunta);
			
			usuario.anadirRespuesta(respuesta);
			
			pregunta.anadirRespuesta(respuesta);
			
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public void borrarRespuesta(int id) {
		try {
			respuestasRepository.deleteById(id);
			
		} catch (Exception e) {
			
		}
	}
	
	@Override
	public List<RespuestasDto> buscarRespuestasPorPregunta(int idPregunta) {
		List<RespuestasDto> respuetas = new ArrayList<>();
		List<Respuestas> respuetas1 = respuestasRepository.findRespuestasFromPregunta(idPregunta);
		
		for (Respuestas respueta : respuetas1) {
			
			RespuestasDto respueta1 = new RespuestasDto();
			
			respueta1.setId_respuesta(respueta.getId_Respuesta());
			respueta1.setRespuesta(respueta.getRespuesta());
			respueta1.setId_pregunta(idPregunta);
			respueta1.setFecha(respueta.getFecha_Respuesta());
			respueta1.setId_usuario(respueta.getUsuario().getId_Usuario());
			respueta1.setNombre_usuario(respueta.getUsuario().getNombreUsuario());
			
			respuetas.add(respueta1);
		}
		
		return respuetas;
	}
	
	

	@Override
	public Respuestas editarRespuesta(int idRespuesta, String respuesta) {
		
		Respuestas editarRespuesta = respuestasRepository.getById(idRespuesta);
		
		editarRespuesta.setRespuesta(respuesta);
		
		return editarRespuesta;
	}
}
