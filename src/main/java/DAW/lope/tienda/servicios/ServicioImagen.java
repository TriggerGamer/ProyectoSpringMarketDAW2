package DAW.lope.tienda.servicios;

import org.springframework.web.multipart.MultipartFile;

import DAW.lope.tienda.entidades.Imagen;

public interface ServicioImagen {
	
	public int guardarImagen(Imagen img);
	public Imagen obtenerImagen(int id);
	public Boolean actualizarImagen(int id_Producto, MultipartFile file);
}
