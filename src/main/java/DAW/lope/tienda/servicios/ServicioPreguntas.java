package DAW.lope.tienda.servicios;

import java.util.List;

import DAW.lope.tienda.entidades.Preguntas;

public interface ServicioPreguntas {

	public int guardarPregunta(Preguntas pregunta, int idUsuario, int idProducto);
	public void borrarPregunta(int idUsuario, int idPregunta);
	public List<Preguntas> buscarTodas();
}
