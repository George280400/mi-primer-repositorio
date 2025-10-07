package com.mx.PadreHijo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.engine.AttributeName;

import com.mx.PadreHijo.Dominio.Hijo;
import com.mx.PadreHijo.Dominio.Padre;
import com.mx.PadreHijo.Service.HijoServiceImp;
import com.mx.PadreHijo.Service.PadreServiceImp;

@Controller // funciona como un rest controller pero este se usa para comunicar clases entre
			// spring
// y mas usado con thymeleave
@RequestMapping("/")

public class PruebaController {

	public @ResponseBody String Prueba() {

		return "Hola, Mundo";

	}

	@Autowired
	private PadreServiceImp service;

	@GetMapping
	// es una interfaz que ya esta definida, que nos va a agregar nuestros atributos
	public String index(Model model) {
		var lista = service.listar();
		model.addAttribute("lista", lista);
		return "index";
	}

	// metodo para abrir la pagina de guardar
	@GetMapping(path = "/nuevo")
	public String nuevo(Padre padre, Model model) {
		model.addAttribute("padre", padre);
		return "guardar";
	}

	// metodo para abrir la pagina de editar
	@GetMapping(path = "/abrirEditar/{idPadre}")
	public String abrirEditar(Padre padre, Model model) {
		padre = service.buscar(padre.getIdPadre());
		model.addAttribute("padre", padre);
		return "editar";
	}

	// metodo para guardar el registro en la base de datos
	@PostMapping("/guardar")
	public String guardar(Padre padre, RedirectAttributes redirectAttrs) {
	    service.guardar(padre);
	    redirectAttrs.addFlashAttribute("success", "Padre guardado correctamente."); // Agrega un mensaje flash
	    return "redirect:/";
	}

	// metodo que editara el registro
	@PostMapping(path = "/editar")
	public String editar(Padre padre) {
		service.editar(padre);
		return "redirect:/";
	}

	// metodo para eliminar el registro
	@GetMapping(path = "/eliminar")
	public String eliminar(@RequestParam("idPadre") int idPadre) {
		service.eliminar(idPadre);
		return "redirect:/";
	}

	// H I J O

	@Autowired
	private HijoServiceImp hijoService;

	@GetMapping("/hijo")
	public String indexHijo(Model model) {
		var lista = hijoService.listar();
		model.addAttribute("listaHijo", lista);
		return "indexHijo";
	}

	// metodo para abrir la pagina de guardar
	@GetMapping(path = "/nuevoHijo")
	public String nuevo(Hijo hijo, Model model) {
		model.addAttribute("hijo", hijo);
		return "guardarhijo";
	}

	// metodo para guardar el registro en la base de datos
	@PostMapping("/guardarHijo")
	public String guardar(Hijo hijo) {
		hijoService.guardar(hijo);
		return "redirect:/hijo";
	}
	
	// metodo para abrir la pagina de editar
		@GetMapping(path = "/abrirEditarHijo/{idHijo}")
		public String abrirEditarHijo(Hijo hijo, Model model) {
			hijo = hijoService.buscar(hijo.getIdHijo());
			model.addAttribute("hijo", hijo);
			return "editarhijo";
		}
		
		// metodo que editara el registro
		@PostMapping(path = "/editarHijo")
		public String editarHijo(Hijo hijo) {
			hijoService.editar(hijo);
			return "redirect:/hijo";
		}
		
		// metodo para eliminar el registro
		@GetMapping(path = "/eliminarHijo")
		public String eliminarHijo(@RequestParam("idHijo") int idHijo) {
			hijoService.eliminar(idHijo);
			return "redirect:/hijo";
		}

}
