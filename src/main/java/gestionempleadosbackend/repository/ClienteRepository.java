package gestionempleadosbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
import gestionempleadosbackend.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	
	@Query("SELECT p FROM Cliente p WHERE p.id = :id")
    Cliente findClienteById(@Param("id") Integer id);
}
