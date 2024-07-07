package gestionempleadosbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
 
import gestionempleadosbackend.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Integer> {

}
