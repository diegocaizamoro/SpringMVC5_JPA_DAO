package com.boot.controlador;

import java.net.MalformedURLException;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import com.boot.modelo.Cliente;
import com.boot.servicio.IClienteServicio;
import com.boot.servicio.ISubidaDeArchivosService;

@Controller
@SessionAttributes("cliente")
public class ClienteControlador {

	@Autowired
	private IClienteServicio iClienteServicio;  //inyecto la clase servicio para acceder a sus metodos
	
	@Autowired
	ISubidaDeArchivosService iSubidaDeArchivosService;
	
	
	@SuppressWarnings("unchecked")
	@GetMapping(value="/uploads/{filename:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String filename){
		
		Resource recurso=null;
		try {
			recurso= iSubidaDeArchivosService.load(filename);
			
		}catch(MalformedURLException e) {
			
			e.printStackTrace();
		} 
		return (ResponseEntity<Resource>) ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""
				+ recurso.getFilename() + "\"");
		
	}

	//localhost:8080/listar   lista en un html todos los clientes
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listarClientes(Model model) {

		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", iClienteServicio.findAll());
		return "listar";

	}

	@RequestMapping(value = "/formulario")
	public String crear(Map<String, Object> map) {
		Cliente cliente = new Cliente();
		map.put("cliente", cliente);
		map.put("titulo", "Formulario de Cliente");
		return "formulario";

	}

	@RequestMapping(value = "/formulario/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> map) {
		Cliente cliente = null;
		if (id > 0) {
			cliente = iClienteServicio.findOne(id);
		} else {
			return "redirect:/listar";
		}
		map.put("cliente", cliente);
		map.put("titulo", "Editar Cliente");
		return "formulario";

	}

	@RequestMapping(value = "/formulario", method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult resul, Map<String, Object> map, SessionStatus status) {
		if (resul.hasErrors()) {
			map.put("titulo", "Formulario Cliente");
			return "formulario";

		} else {
			iClienteServicio.save(cliente);
			status.setComplete();
			return "redirect:/listar";
		}

	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		if (id > 0) {
			iClienteServicio.delete(id);
		} 
		return "redirect:/listar";
	}
	

}
