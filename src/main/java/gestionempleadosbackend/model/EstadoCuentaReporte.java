package gestionempleadosbackend.model;

import java.util.List;

public class EstadoCuentaReporte {
	 private List<Movimiento> movimientos;

	public EstadoCuentaReporte() {
		 
	}

	public EstadoCuentaReporte(List<Movimiento> movimientos) {
		super();
		this.movimientos = movimientos;
	}

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	 

	 
	 
}
