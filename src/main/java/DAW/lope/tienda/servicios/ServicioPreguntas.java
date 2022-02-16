package DAW.lope.tienda.servicios;

import java.util.List;

import DAW.lope.tienda.Dtos.PreguntasDto;
import DAW.lope.tienda.entidades.Preguntas;

public interface ServicioPreguntas {

	public int guardarPregunta(Preguntas pregunta, int idUsuario, int idProducto);
	public void borrarPregunta(int idPregunta);
	public List<PreguntasDto> buscarPorProducto(int idProducto);
}
