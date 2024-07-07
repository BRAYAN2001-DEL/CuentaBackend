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

import gestionempleadosbackend.model.Cuenta;
import gestionempleadosbackend.model.Persona;
import gestionempleadosbackend.service.CuentaService;

@RestController
@RequestMapping("/cuentas")
public class CuentaRest {

	
	@Autowired
	private CuentaService cuentaService;
	
	@GetMapping
    private ResponseEntity<List<Cuenta>> getAllCuentas(){
	  return ResponseEntity.ok(cuentaService.findAll());
    }
	
	
	@PostMapping 
    private ResponseEntity<Cuenta> saveCuenta(@RequestBody Cuenta cuenta){
    	try {
    	Cuenta cuentaGuardada = cuentaService.save(cuenta);
    	return ResponseEntity.created(new URI("/cuentas/"+ cuentaGuardada.getId())).body(cuentaGuardada);
    	}catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();	
    	}
    }
	
	
	
	@GetMapping("/byId")
    private ResponseEntity<Cuenta> getCuentaById(@RequestHeader("id") Integer id) {
        try {
            Cuenta cuenta = cuentaService.findCuentaById(id);
            if (cuenta != null) {
                return ResponseEntity.ok(cuenta);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
	
	
	
	

    
    @PutMapping("/byIdPut")
    public ResponseEntity<Cuenta> updatePersona(@RequestHeader("id") int id, @RequestBody Cuenta cuenta) {
        try {
            Cuenta cuentaActual = cuentaService.findCuentaById(id);
            if (cuentaActual == null) {
                return ResponseEntity.notFound().build();
            }

            // Actualizar los campos de personaActual con los valores de la persona recibida
            if (cuenta.getCliente() != null) {
            	cuentaActual.setCliente(cuenta.getCliente());
            }
            if (cuenta.getNumero_cuenta() != null) {
            	cuentaActual.setNumero_cuenta(cuenta.getNumero_cuenta());
            }
            if (cuenta.getTipo_cuenta() != null) {
            	cuentaActual.setTipo_cuenta(cuenta.getTipo_cuenta());
            }
            if (cuenta.getSaldo_Inicial() != null) {
            	cuentaActual.setSaldo_Inicial(cuenta.getSaldo_Inicial());
            }
            if (cuenta.getEstado() != null) {
            	cuentaActual.setEstado(cuenta.getEstado());
            }
             
            // Guardar la persona actualizada en la base de datos
            Cuenta cuentaActualizada = cuentaService.save(cuentaActual);

            return ResponseEntity.ok(cuentaActualizada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    

    @PatchMapping("/byIdPatch")
    public ResponseEntity<Cuenta> updatePersonaPatch(@RequestHeader("id") int id, @RequestBody Cuenta cuenta) {
        try {
            Cuenta cuentaActual = cuentaService.findCuentaById(id);
            if (cuentaActual == null) {
                return ResponseEntity.notFound().build();
            }

            // Actualizar los campos de personaActual con los valores de la persona recibida
            if (cuenta.getCliente() != null) {
            	cuentaActual.setCliente(cuenta.getCliente());
            }
            if (cuenta.getNumero_cuenta() != null) {
            	cuentaActual.setNumero_cuenta(cuenta.getNumero_cuenta());
            }
            if (cuenta.getTipo_cuenta() != null) {
            	cuentaActual.setTipo_cuenta(cuenta.getTipo_cuenta());
            }
            if (cuenta.getSaldo_Inicial() != null) {
            	cuentaActual.setSaldo_Inicial(cuenta.getSaldo_Inicial());
            }
            if (cuenta.getEstado() != null) {
            	cuentaActual.setEstado(cuenta.getEstado());
            }
             
            // Guardar la persona actualizada en la base de datos
            Cuenta cuentaActualizada = cuentaService.save(cuentaActual);

            return ResponseEntity.ok(cuentaActualizada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    
    
    
    @DeleteMapping("/byIdDelete")
    public  ResponseEntity<String> deleteCuenta(@RequestHeader("id") int id) {
        try {
            Cuenta cuenta = cuentaService.findCuentaById(id);
            if (cuenta == null) {
                return ResponseEntity.notFound().build();
            }
            cuentaService.delete(cuenta);
            return ResponseEntity.ok("cuenta eliminada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

	
	
}
