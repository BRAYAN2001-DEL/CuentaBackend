package gestionempleadosbackend.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gestionempleadosbackend.model.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer>{
	

	@Query("SELECT p FROM Movimiento p WHERE p.id = :id")
	Movimiento findMovimientoById(@Param("id") Integer id);
	
	
	
	@Query("SELECT p FROM Movimiento p WHERE  p.fecha Between :fechaInicio and :fechaFin and  p.cuenta.id = :cuentaId ")
	List<Movimiento> findMovimientoReporteById(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin,  @Param("cuentaId") int cuentaId);


}
