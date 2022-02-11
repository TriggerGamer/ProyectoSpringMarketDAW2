package DAW.lope.tienda.servicios;

import java.util.List;
import java.util.Optional;

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
	public int editarRespuesta(int idRespuesta, String respuesta) {
		
		Optional<Respuestas> editarRespuesta = respuestasRepository.findById(idRespuesta);
		
		Respuestas respuesta1 = editarRespuesta.get();
		
		respuesta1.setRespuesta(respuesta);
		
		return 0;
	}
}
