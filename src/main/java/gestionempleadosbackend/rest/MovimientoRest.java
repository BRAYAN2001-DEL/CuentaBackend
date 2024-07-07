package gestionempleadosbackend.rest;

import java.net.URI;
import java.util.Date;
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
import gestionempleadosbackend.model.Movimiento;
import gestionempleadosbackend.model.ResponseMessage;
import gestionempleadosbackend.service.CuentaService;
import gestionempleadosbackend.service.MovimientoService;

@RestController
@RequestMapping("/movimientos")
public class MovimientoRest {

	
	@Autowired
	private MovimientoService movimientoService;
	
	 @Autowired
	 private CuentaService cuentaService;
	 
	
	@GetMapping
    private ResponseEntity<List<Movimiento>> getAllMovimiento(){
	  return ResponseEntity.ok(movimientoService.findAll());
    }
	
	
	@PostMapping 
    private ResponseEntity<Movimiento> saveMovimiento(@RequestBody Movimiento movimiento){
    	try {
    		Movimiento movimientoGuardada = movimientoService.save(movimiento);
    	return ResponseEntity.created(new URI("/cuentas/"+ movimientoGuardada.getId())).body(movimientoGuardada);
    	}catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();	
    	}
    }
	
	
	
	@GetMapping("/byId")
    private ResponseEntity<Movimiento> getMovimientoById(@RequestHeader("id") Integer id) {
        try {
        	Movimiento movimiento = movimientoService.findMovimientoById(id);
            if (movimiento != null) {
                return ResponseEntity.ok(movimiento);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
	
	
	
	

    
    @PutMapping("/byIdPut")
    public ResponseEntity<Movimiento> updateMovimiento(@RequestHeader("id") int id, @RequestBody Movimiento movimiento) {
        try {
            Movimiento movimientoActual = movimientoService.findMovimientoById(id);
            if (movimientoActual == null) {
                return ResponseEntity.notFound().build();
            }

            // Actualizar los campos de movimientoActual con los valores del movimiento recibida
            if (movimiento.getCuenta() != null) {
            	movimientoActual.setCuenta(movimiento.getCuenta());
            }
            if (movimiento.getFecha() != null) {
            	movimientoActual.setFecha(movimiento.getFecha());
            }
            if (movimiento.getValor() != null) {
            	movimientoActual.setValor(movimiento.getValor());
            }
            if (movimiento.getSaldo() != null) {
            	movimientoActual.setSaldo(movimiento.getSaldo());
            }
            if (movimiento.getTipo_movimiento() != null) {
            	movimientoActual.setTipo_movimiento(movimiento.getTipo_movimiento());
            }
             
            // Guardar al movimiento actualizada en la base de datos
            Movimiento movimientoActualizada = movimientoService.save(movimientoActual);

            return ResponseEntity.ok(movimientoActualizada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    
    
    
    @PatchMapping("/byIdPatch")
    public ResponseEntity<Movimiento> updateMovimientoPatch(@RequestHeader("id") int id, @RequestBody Movimiento movimiento) {
        try {
            Movimiento movimientoActual = movimientoService.findMovimientoById(id);
            if (movimientoActual == null) {
                return ResponseEntity.notFound().build();
            }

            // Actualizar los campos de movimientoActual con los valores del movimiento recibida
            if (movimiento.getCuenta() != null) {
            	movimientoActual.setCuenta(movimiento.getCuenta());
            }
            if (movimiento.getFecha() != null) {
            	movimientoActual.setFecha(movimiento.getFecha());
            }
            if (movimiento.getValor() != null) {
            	movimientoActual.setValor(movimiento.getValor());
            }
            if (movimiento.getSaldo() != null) {
            	movimientoActual.setSaldo(movimiento.getSaldo());
            }
            if (movimiento.getTipo_movimiento() != null) {
            	movimientoActual.setTipo_movimiento(movimiento.getTipo_movimiento());
            }
             
            // Guardar al movimiento actualizada en la base de datos
            Movimiento movimientoActualizada = movimientoService.save(movimientoActual);

            return ResponseEntity.ok(movimientoActualizada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    
    
    
    @DeleteMapping("/byIdDelete")
    public  ResponseEntity<String> deleteMovimiento(@RequestHeader("id") int id) {
        try {
            Movimiento movimiento = movimientoService.findMovimientoById(id);
            if (movimiento == null) {
                return ResponseEntity.notFound().build();
            }
            movimientoService.delete(movimiento);
            return ResponseEntity.ok("movimiento eliminada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    
    
    
    
    //logica ------------------------------------
    
    
    @PostMapping("/realizarMovimiento")
    public ResponseEntity<ResponseMessage> realizarMovimiento(@RequestBody Movimiento request) {
        try {
        	ResponseMessage response = new ResponseMessage();
        	response = realizarMovimiento(request.getCuenta().getId(), request.getValor(), request.getTipo_movimiento());
             return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseMessage response = new ResponseMessage("Error al realizar el movimiento: " + e.getMessage(), "ERROR");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    
    
    
    public ResponseMessage realizarMovimiento(int idCuenta, double valorMovimiento, String tipoMovimiento) {
         
    	ResponseMessage responseMessage = new ResponseMessage();
    	
    	try {
    	Cuenta cuenta = cuentaService.findCuentaById(idCuenta);
    	 if (cuenta == null) {
              return responseMessage = new ResponseMessage("Cuenta no encontrad","500");
         }                 
        
        if ("Retiro".equals(tipoMovimiento)) {
            // Verificar si hay suficiente saldo para el retiro
            if (cuenta.getSaldo_Inicial() >= valorMovimiento) {
                // Registrar el movimiento de retiro
            	responseMessage = procesoRegistrarMovimiento(cuenta, valorMovimiento, tipoMovimiento);
            } else {
               // throw new RuntimeException("Saldo insuficiente para realizar el retiro");
                 responseMessage =  new  ResponseMessage("Saldo no disponible", "201");
            }
        } else if ("Deposito".equals(tipoMovimiento)) {
            // Realizar el depósito
        	responseMessage = procesoRegistrarMovimiento(cuenta, valorMovimiento, tipoMovimiento);
        } else {
           // throw new IllegalArgumentException("Tipo de movimiento no válido: " + tipoMovimiento);
            responseMessage =  new  ResponseMessage("Tipo de movimiento no válido", "201");

        }
    	}catch(Exception e) {
    		 throw new RuntimeException(e);
    	}
        
        return responseMessage;
    }

    
    
    private ResponseMessage procesoRegistrarMovimiento(Cuenta cuenta, double valorMovimiento, String tipoMovimiento) {
        
    	ResponseMessage responseMessage = new ResponseMessage();
    	// Crear el objeto de movimiento
        try {
    	
    	Movimiento movimiento = new Movimiento();
        movimiento.setCuenta(cuenta);
        movimiento.setFecha(new Date());
        movimiento.setValor(valorMovimiento);
        movimiento.setTipo_movimiento(tipoMovimiento);
        
        // Actualizar el saldo en la cuenta y en el movimiento
        if ("Retiro".equals(tipoMovimiento)) {
            double nuevoSaldo = cuenta.getSaldo_Inicial() - valorMovimiento;
            cuenta.setSaldo_Inicial(nuevoSaldo);
            movimiento.setSaldo(nuevoSaldo);
        } else if ("Deposito".equals(tipoMovimiento)) {
            double nuevoSaldo = cuenta.getSaldo_Inicial() + valorMovimiento;
            cuenta.setSaldo_Inicial(nuevoSaldo);
            movimiento.setSaldo(nuevoSaldo);
        }
        
        // Guardar el movimiento y actualizar la cuenta
        movimientoService.save(movimiento);
        cuentaService.save(cuenta);
        responseMessage =  new  ResponseMessage("Movimiento Realizado con exito", "200");
        
        }catch(Exception e) {
   		 	throw new RuntimeException(e);
        }
        
        return responseMessage;
    }
	
	
}
