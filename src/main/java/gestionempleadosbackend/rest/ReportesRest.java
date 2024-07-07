package gestionempleadosbackend.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gestionempleadosbackend.model.Cuenta;
import gestionempleadosbackend.model.EstadoCuentaReporte;
import gestionempleadosbackend.model.Movimiento;
import gestionempleadosbackend.service.CuentaService;
import gestionempleadosbackend.service.MovimientoService;

@RestController
@RequestMapping("/reportes")
public class ReportesRest {
	
	@Autowired
	MovimientoService movimientoService;
	
	@Autowired
	CuentaService cuentaService;
	
	@GetMapping
    public ResponseEntity<EstadoCuentaReporte> generarEstadoCuentaReporte(
            @RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin,
            @RequestParam("idCliente") int idCliente) {

        try {
            EstadoCuentaReporte reporte = processGenerarEstadoCuentaReporte(fechaInicio, fechaFin,idCliente);
            return ResponseEntity.ok(reporte);
        } catch (Exception e) {
            // Manejo de errores
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	
	
	
	public EstadoCuentaReporte processGenerarEstadoCuentaReporte(Date fechaInicio, Date fechaFin, int idCliente) {
        // Obtener cuentas asociadas al cliente
        List<Cuenta> cuentas = cuentaService.findCuentaClienteById(idCliente);
        EstadoCuentaReporte reporte = new EstadoCuentaReporte();

        List<Movimiento> todosMovimientos = new ArrayList<>();

        for (Cuenta cuenta : cuentas) {
            List<Movimiento> movimientos = movimientoService.findMovimientoReporteById(fechaInicio, fechaFin, cuenta.getId());
            todosMovimientos.addAll(movimientos);
        }

        reporte.setMovimientos(todosMovimientos);

        return reporte;
    }
}
