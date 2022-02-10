package DAW.lope.tienda.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAW.lope.tienda.entidades.Preguntas;
import DAW.lope.tienda.entidades.Usuario;
import DAW.lope.tienda.repositorios.PreguntasRepository;


@Transactional
@Service
public class ServicioPreguntasImpl implements ServicioPreguntas{

	@Autowired
	private PreguntasRepository preguntasRepository;

	@Autowired
	private ServicioUsuarios servicioUsuarios;
	
	@Override
	public int guardarPregunta(Preguntas pregunta, int idUsuario, int idProducto) {
		try {
			Usuario usuario = servicioUsuarios.findUsuarioById(idUsuario);
			pregunta.setUsuario(usuario);
			usuario.anadirPregunta(pregunta);			
			preguntasRepository.save(pregunta);
			
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public void borrarPregunta(int idUsuario, int idPregunta) {
		
		try {
			preguntasRepository.deleteById(idPregunta);
			
		} catch (Exception e) {
			
		}
		
	}

	@Override
	public List<Preguntas> buscarTodas() {
		return preguntasRepository.findAll();
	}
}