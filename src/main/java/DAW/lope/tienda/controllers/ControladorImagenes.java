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

import DAW.lope.tienda.entidades.Imagen;
import DAW.lope.tienda.servicios.ServicioImagen;
import DAW.lope.tienda.servicios.ServicioProductos;

@Controller
@RequestMapping(value = "/img")
public class ControladorImagenes {

	@Autowired
	ServicioImagen imgServicio;

	@Autowired
	ServicioProductos ServicioProducto;

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

	@GetMapping(value = "/producto/{id}/imagen")
	public @ResponseBody ResponseEntity getImageAsResponseEntity(@PathVariable int id) {

		try {
			Imagen imagesObj = imgServicio.obtenerImagen(id);
			byte[] media = imagesObj.getImagen();
			
			ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, HttpStatus.OK);
			return responseEntity;

		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
}
