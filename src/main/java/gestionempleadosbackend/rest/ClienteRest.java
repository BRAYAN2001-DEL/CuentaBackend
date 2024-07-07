package gestionempleadosbackend.rest;

import java.net.URI;
import java.util.List;

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

import gestionempleadosbackend.model.Cliente;
import gestionempleadosbackend.model.Cuenta;
import gestionempleadosbackend.service.ClienteService;
 
@RestController
@RequestMapping("/clientes")
public class ClienteRest {

	
	@Autowired
	private ClienteService clienteService;
	
	
	@GetMapping
    private ResponseEntity<List<Cliente>> getAllCliente(){
	  return ResponseEntity.ok(clienteService.findAll());
    }
	
	
	@PostMapping 
    private ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente){
    	try {
    	Cliente clienteGuardada = clienteService.save(cliente);
    	return ResponseEntity.created(new URI("/clientes/"+ clienteGuardada.getId())).body(clienteGuardada);
    	}catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();	
    	}
    }
	
	
	@GetMapping("/byId")
    private ResponseEntity<Cliente> getClienteById(@RequestHeader("id") Integer id) {
        try {
            Cliente cliente = clienteService.findClienteById(id);
            if (cliente != null) {
                return ResponseEntity.ok(cliente);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
	
	
	
	
	
	
    
    @PutMapping("/byIdPut")
    public ResponseEntity<Cliente> updateCliente(@RequestHeader("id") int id, @RequestBody Cliente cliente) {
        try {
            Cliente clienteActual = clienteService.findClienteById(id);
            if (clienteActual == null) {
                return ResponseEntity.notFound().build();
            }

            // Actualizar los campos de personaActual con los valores de la persona recibida
            if (cliente.getPersona() != null) {
            	clienteActual.setPersona(cliente.getPersona());
            }
            if (cliente.getEstado() != null) {
            	clienteActual.setEstado(cliente.getEstado());
            }
            
            if (cliente.getContrasena() != null) {
            	clienteActual.setContrasena(cliente.getContrasena());
            }
            
             
            // Guardar la persona actualizada en la base de datos
            Cliente clienteActualizada = clienteService.save(clienteActual);

            return ResponseEntity.ok(clienteActualizada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    
    @PatchMapping("/byIdPatch")
    public ResponseEntity<Cliente> updateClientePatch(@RequestHeader("id") int id, @RequestBody Cliente cliente) {
        try {
            Cliente clienteActual = clienteService.findClienteById(id);
            if (clienteActual == null) {
                return ResponseEntity.notFound().build();
            }

            // Actualizar los campos de personaActual con los valores de la persona recibida
            if (cliente.getPersona() != null) {
            	clienteActual.setPersona(cliente.getPersona());
            }
            if (cliente.getEstado() != null) {
            	clienteActual.setEstado(cliente.getEstado());
            }
            
            if (cliente.getContrasena() != null) {
            	clienteActual.setContrasena(cliente.getContrasena());
            }
            
             
            // Guardar la persona actualizada en la base de datos
            Cliente clienteActualizada = clienteService.save(clienteActual);

            return ResponseEntity.ok(clienteActualizada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    
    
    @DeleteMapping("/byIdDelete")
    public  ResponseEntity<String> deleteCliente(@RequestHeader("id") int id) {
        try {
            Cliente cliente = clienteService.findClienteById(id);
            if (cliente == null) {
                return ResponseEntity.notFound().build();
            }
            clienteService.delete(cliente);
            return ResponseEntity.ok("cliente eliminada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

	
}
