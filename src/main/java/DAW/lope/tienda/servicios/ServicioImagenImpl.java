package DAW.lope.tienda.servicios;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import DAW.lope.tienda.entidades.Imagen;
import DAW.lope.tienda.entidades.Productos;
import DAW.lope.tienda.repositorios.ImagenRepository;
import DAW.lope.tienda.repositorios.ProductosDao;

@Transactional
@Service
public class ServicioImagenImpl implements ServicioImagen {
	
	@Autowired
	private ImagenRepository imagenRepository;

	@Autowired
	private ProductosDao productosdao;

	@Override
	public int guardarImagen(Imagen img) {
		try {
			imagenRepository.save(img);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public Imagen obtenerImagen(int id) {
		
		Imagen findById = imagenRepository.findById(id).orElse(null);
		
		if (findById != null) {
			return findById;
		} else {
			return null;
		}
	}

	@Override
	public Boolean actualizarImagen(int id_Producto, MultipartFile file) {
		
		Productos p = productosdao.findById(id_Producto);

		if (p == null)
			return false;
		try {
			byte[] image = file.getBytes();
			if (!p.getImagen().isEmpty()) {
				Set<Imagen> img = p.getImagen();
				for (Imagen a : img) {
					a.setImagen(image);
					imagenRepository.save(a);
					return true;
				}
				return null;
			} else {
				Imagen img = new Imagen(image);
				img.setProducto(p);
				p.addImagen(img);
				imagenRepository.save(img);
				productosdao.actualizar(p);
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
