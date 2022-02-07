package DAW.lope.tienda.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import DAW.lope.tienda.entidades.Imagen;
import DAW.lope.tienda.entidades.Productos;
import DAW.lope.tienda.servicios.ServicioImagen;
import DAW.lope.tienda.servicios.ServicioProductos;

@Controller
@RequestMapping("/imagenes")
public class ControladorImagenes {

	@Autowired
	ServicioImagen imgServicio;

	@Autowired
	ServicioProductos ServicioProducto;

	@GetMapping(value = "/producto/{idProducto}/img")
	public ModelAndView actualizarFotoPerfil(HttpServletRequest request, @PathVariable("idProducto") int idProducto) {

		ModelAndView mav = new ModelAndView();

		Productos profesor = ServicioProducto.findProductoById(idProducto);
		Imagen img = null;
		if (!profesor.getImagen().isEmpty()) {
			for (Imagen i : profesor.getImagen()) {
				img = i;
				break;
			}
		}
		mav.addObject("imagen", img);
		mav.addObject("profesor", profesor);
		mav.setViewName("/imagen/imagen_subir");
		return mav;
	}

	@PostMapping(value = "/producto/{idProducto}/imagen")
	public String fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request,
			@PathVariable("idProducto") int idProducto) {
		
		try {
			Boolean saveImage = imgServicio.actualizarImagen(idProducto, file);
			if (saveImage) {
				return "redirect:/";
			} else {
				return "redirect:/";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/";
		}
	}

	@GetMapping(value = "/{id}")
	public @ResponseBody ResponseEntity<byte[]> getImageAsResponseEntity(@PathVariable int id) {

		try {
			Imagen imagesObj = imgServicio.obtenerImagen(id);
			byte[] media = imagesObj.getImagen();

			ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(media, HttpStatus.OK);
			return responseEntity;

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
