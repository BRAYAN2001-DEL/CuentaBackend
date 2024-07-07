package gestionempleadosbackend.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional; // Importación correcta de Optional

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;


import gestionempleadosbackend.model.Persona;
import gestionempleadosbackend.service.PersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaRest {
	
	@Autowired
	private PersonaService personaService;
	
    @GetMapping
    private ResponseEntity<List<Persona>> getAllPersonas(){
	  return ResponseEntity.ok(personaService.findAll());
	  
    }
    
    @PostMapping 
    private ResponseEntity<Persona> savePersona(@RequestBody Persona persona){
    	try {
    	Persona personaGuardada = personaService.save(persona);
    	return ResponseEntity.created(new URI("/personas/"+ personaGuardada.getId())).body(personaGuardada);
    	}catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();	
    	}
    }
    
    
    
    // Nuevo método GET para filtrar por ID usando headers
    @GetMapping("/byId")
    private ResponseEntity<Persona> getPersonaById(@RequestHeader("id") Integer id) {
        try {
            Persona persona = personaService.findPersonaById(id);
            if (persona != null) {
                return ResponseEntity.ok(persona);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    
    
    @PutMapping("/byIdPut")
    public ResponseEntity<Persona> updatePersona(@RequestHeader("id") int id, @RequestBody Persona persona) {
        try {
            Persona personaActual = personaService.findPersonaById(id);
            if (personaActual == null) {
                return ResponseEntity.notFound().build();
            }

            // Actualizar los campos de personaActual con los valores de la persona recibida
            if (persona.getNombre() != null) {
            	personaActual.setNombre(persona.getNombre());
            }
            if (persona.getApellido() != null) {
            	personaActual.setApellido(persona.getApellido());
            }
            if (persona.getEdad() != 0) {
            	personaActual.setEdad(persona.getEdad());
            }
             
            if (persona.getGenero() != null) {
            	personaActual.setGenero(persona.getGenero());
            }
            if (persona.getIdentificacion() != null) {
            	personaActual.setIdentificacion(persona.getIdentificacion());
            }
            if (persona.getDireccion() != null) {
            	personaActual.setDireccion(persona.getDireccion());
            }
            if (persona.getTelefono() != null) {
            	personaActual.setTelefono(persona.getTelefono());
            }
            // Guardar la persona actualizada en la base de datos
            Persona personaActualizada = personaService.save(personaActual);

            return ResponseEntity.ok(personaActualizada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    

    @PatchMapping("/byIdPatch")
    public ResponseEntity<Persona> updatePersonaPatch(@RequestHeader("id") int id, @RequestBody Persona persona) {
        try {
            Persona personaActual = personaService.findPersonaById(id);
            if (personaActual == null) {
                return ResponseEntity.notFound().build();
            }

            // Actualizar los campos de personaActual con los valores de la persona recibida
            if (persona.getNombre() != null) {
            	personaActual.setNombre(persona.getNombre());
            }
            if (persona.getApellido() != null) {
            	personaActual.setApellido(persona.getApellido());
            }
            if (persona.getEdad() != 0) {
            	personaActual.setEdad(persona.getEdad());
            }
          
            if (persona.getGenero() != null) {
            	personaActual.setGenero(persona.getGenero());
            }
            if (persona.getIdentificacion() != null) {
            	personaActual.setIdentificacion(persona.getIdentificacion());
            }
            if (persona.getDireccion() != null) {
            	personaActual.setDireccion(persona.getDireccion());
            }
            if (persona.getTelefono() != null) {
            	personaActual.setTelefono(persona.getTelefono());
            }
            // Guardar la persona actualizada en la base de datos
            Persona personaActualizada = personaService.save(personaActual);

            return ResponseEntity.ok(personaActualizada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    
    @DeleteMapping("/byIdDelete")
    public  ResponseEntity<String> deletePersona(@RequestHeader("id") int id) {
        try {
            Persona persona = personaService.findPersonaById(id);
            if (persona == null) {
                return ResponseEntity.notFound().build();
            }

            personaService.delete(persona);
            return ResponseEntity.ok("Persona eliminada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    
    
}
