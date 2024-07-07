package gestionempleadosbackend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestionempleadosbackend.model.Estado;
import gestionempleadosbackend.service.EstadoService;

@RestController
@RequestMapping ("/estado/")
public class EstadoRest {
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping ("{id}")
	private ResponseEntity<List<Estado>> getAllEstadosByPais(@PathVariable("id") int idPais){
		return ResponseEntity.ok(estadoService.findAllByCountry(idPais));
	}
	
}
