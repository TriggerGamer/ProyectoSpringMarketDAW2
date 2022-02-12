package DAW.lope.tienda.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAW.lope.tienda.entidades.Respuestas;
import DAW.lope.tienda.repositorios.RespuestasRepository;

@Transactional
@Service
public class ServicioRespuestasImpl implements ServicioRespuestas{

	@Autowired
	private RespuestasRepository respuestasRepository;

	@Override
	public int guardarRespuesta(Respuestas respuesta, int idUsuario, int idPregunta) {
		try {
			respuestasRepository.save(respuesta);
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
	public List<Respuestas> buscarTodas() {
		return respuestasRepository.findAll();
	}

	@Override
	public Respuestas editarRespuesta(int idRespuesta, String respuesta) {
		
		Respuestas editarRespuesta = respuestasRepository.getById(idRespuesta);
		
		editarRespuesta.setRespuesta(respuesta);
		
		return editarRespuesta;
	}
}
