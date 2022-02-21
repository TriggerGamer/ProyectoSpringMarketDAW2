package DAW.lope.tienda.servicios;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAW.lope.tienda.Dtos.PreguntasDto;
import DAW.lope.tienda.entidades.Preguntas;
import DAW.lope.tienda.entidades.Productos;
import DAW.lope.tienda.entidades.Usuario;
import DAW.lope.tienda.repositorios.PreguntasRepository;


@Transactional
@Service
public class ServicioPreguntasImpl implements ServicioPreguntas{

	@Autowired
	private PreguntasRepository preguntasRepository;

	@Autowired
	private ServicioUsuarios servicioUsuarios;
	
	@Autowired
	private ServicioProductos servicioProductos;
	
	@Override
	public int guardarPregunta(Preguntas pregunta, int idUsuario, int idProducto) {
		
		try {
			
			String f = LocalDateTime.now().toString();
			String nuevo[] = f.split("T");
			String fecha = nuevo[0];
			
			pregunta.setFecha_Pregunta(fecha);
			
			Usuario usuario = servicioUsuarios.findUsuarioById(idUsuario);
			Productos producto = servicioProductos.findProductoById(idProducto);
			
			pregunta.setUsuario(usuario);
			pregunta.setProducto(producto);
			
			usuario.anadirPregunta(pregunta);
			
			producto.anadirPregunta(pregunta);
			
			return 1;
		} catch (Exception e) {
			
			return 0;
		}
	}

	@Override
	public void borrarPregunta(int idPregunta) {
		
		try {
			preguntasRepository.deleteById(idPregunta);
			
		} catch (Exception e) {
			
		}
		
	}

	@Override
	public List<PreguntasDto> buscarPorProducto(int idProducto) {

		List<PreguntasDto> preguntas = new ArrayList<>();
		List<Preguntas> preguntas1 = preguntasRepository.findPreguntasOfProductos(idProducto);
		
		for (Preguntas pregunta : preguntas1) {
			
			PreguntasDto preguntas2 = new PreguntasDto();
			
			preguntas2.setId_pregunta(pregunta.getId_Pregunta());
			preguntas2.setPregunta(pregunta.getPregunta());
			preguntas2.setFecha(pregunta.getFecha_Pregunta());
			preguntas2.setId_usuario(pregunta.getUsuario().getId_Usuario());
			preguntas2.setNombre_usuario(pregunta.getUsuario().getNombreUsuario());
			
			preguntas.add(preguntas2);
		}
		
		return preguntas;
	}
}
