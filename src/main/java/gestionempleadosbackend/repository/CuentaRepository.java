package gestionempleadosbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gestionempleadosbackend.model.Cuenta;
import gestionempleadosbackend.model.Persona;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer>{

	
	@Query("SELECT p FROM Cuenta p WHERE p.id = :id")
    Cuenta findCuentaById(@Param("id") Integer id);
	
	@Query("SELECT p FROM Cuenta p WHERE p.cliente.id = :id")
    List<Cuenta> findCuentaClienteById(@Param("id") Integer id);
}
