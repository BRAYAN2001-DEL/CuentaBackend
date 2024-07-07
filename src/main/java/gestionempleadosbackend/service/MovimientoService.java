package gestionempleadosbackend.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
 import org.springframework.stereotype.Service;

import gestionempleadosbackend.model.Cuenta;
import gestionempleadosbackend.model.Movimiento;
import gestionempleadosbackend.repository.CuentaRepository;
import gestionempleadosbackend.repository.MovimientoRepository;

@Service
public class MovimientoService implements MovimientoRepository {

	@Autowired
	private MovimientoRepository movimientoRepository;

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Movimiento> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Movimiento> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Movimiento> entities) {
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
	public Movimiento getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movimiento getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	 

	@Override
	public <S extends Movimiento> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Movimiento> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Movimiento> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movimiento> findAll() {
		// TODO Auto-generated method stub
		return movimientoRepository.findAll();
	}

	@Override
	public List<Movimiento> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Movimiento> S save(S entity) {
		// TODO Auto-generated method stub
		return movimientoRepository.save(entity);
	}

	@Override
	public Optional<Movimiento> findById(Integer id) {
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
	public void delete(Movimiento entity) {
		// TODO Auto-generated method stub
		movimientoRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Movimiento> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Movimiento> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Movimiento> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Movimiento> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Movimiento> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Movimiento> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Movimiento> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	 


 	@Override
    public Movimiento findMovimientoById(Integer id) {
        return movimientoRepository.findMovimientoById(id);
    }

	@Override
	public List<Movimiento> findMovimientoReporteById(Date fechaInicio, Date fechaFin, int cuentaId) {
		// TODO Auto-generated method stub
		return movimientoRepository.findMovimientoReporteById(fechaInicio,fechaFin,cuentaId);
	}

	

	
 	
 	
	
	
}
