package gestionempleadosbackend.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gestionempleadosbackend.model.Cliente;
import gestionempleadosbackend.model.Cuenta;
import gestionempleadosbackend.model.Persona;
import gestionempleadosbackend.repository.CuentaRepository;

@Service
public class CuentaService implements CuentaRepository  {

	
	
	@Autowired
	private CuentaRepository cuentaRepository;

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Cuenta> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Cuenta> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Cuenta> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cuenta getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cuenta getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	 

	@Override
	public <S extends Cuenta> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Cuenta> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Cuenta> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cuenta> findAll() {
		// TODO Auto-generated method stub
		return cuentaRepository.findAll();
	}

	@Override
	public List<Cuenta> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Cuenta> S save(S entity) {
		// TODO Auto-generated method stub
		return cuentaRepository.save(entity);
	}

	@Override
	public Optional<Cuenta> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cuenta entity) {
		// TODO Auto-generated method stub
		cuentaRepository.delete(entity);
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Cuenta> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cuenta> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Cuenta> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Cuenta> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Cuenta> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Cuenta> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Cuenta> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	 

	
	 	@Override
	    public Cuenta findCuentaById(Integer id) {
	        return cuentaRepository.findCuentaById(id);
	    }
	 	
	  

		@Override
		public List<Cuenta> findCuentaClienteById(Integer id) {
			// TODO Auto-generated method stub
			return cuentaRepository.findCuentaClienteById(id);
		}
		
		
		@KafkaListener(topics = "test-topic", groupId = "group_id")
	    public void handlePersonaCreated(String message) {
	        // Extraer el ID de la persona del mensaje
	       // int personaId = Integer.parseInt(message.split(":")[1].trim());
	        
			 Cliente cliente = convertJsonToCliente(message);
	        
	        // Crear una nueva cuenta para la persona
	        Cuenta nuevaCuenta = new Cuenta();
	        nuevaCuenta.setCliente(cliente);
	        nuevaCuenta.setEstado(true);
	        nuevaCuenta.setNumero_cuenta(cliente.getPersona().getIdentificacion());
	        nuevaCuenta.setTipo_cuenta("CUENTA DE AHORROS");
	        nuevaCuenta.setSaldo_Inicial(1000.0);
	        cuentaRepository.save(nuevaCuenta);
	    }
		
		
		
		 private Cliente convertJsonToCliente(String message) {
		        // Utiliza una biblioteca como Jackson para convertir el JSON a un objeto Persona
		        ObjectMapper objectMapper = new ObjectMapper();
		        try {
		            return objectMapper.readValue(message, Cliente.class);
		        } catch (JsonProcessingException e) {
		            throw new RuntimeException("Error converting JSON to Cliente", e);
		        }
		    }
		
	
}
