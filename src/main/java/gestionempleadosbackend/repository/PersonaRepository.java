package gestionempleadosbackend.repository;

 

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gestionempleadosbackend.model.Estado;
import gestionempleadosbackend.model.Pais;
import gestionempleadosbackend.model.Persona;
import javax.transaction.Transactional;
 
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

	
	@Query("SELECT p FROM Persona p WHERE p.id = :id")
    Persona findPersonaById(@Param("id") Integer id);
	
	
	 


}
