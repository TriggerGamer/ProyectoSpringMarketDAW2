package DAW.lope.tienda.servicios;

import java.util.List;

import DAW.lope.tienda.entidades.Respuestas;

public interface ServicioRespuestas {

	public int guardarRespuesta(Respuestas respuesta, int idUsuario, int idPregunta);
	public void borrarRespuesta(int id);
	public List<Respuestas> buscarTodas();
	public int editarRespuesta(int idRespuesta, String respuesta);
}
