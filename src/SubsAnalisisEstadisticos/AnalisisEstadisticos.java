package SubsAnalisisEstadisticos;

import java.util.HashMap;

import SubsGestionIncidencias.InterfazGestorIncidencias;
import SubsGestionOOTT.InterfazGestorOOTT;
import SubsGestionProcesos.InterfazGestorProcesos;

public class AnalisisEstadisticos implements InterfazGestorEstadisticas {
	
	InterfazGestorIncidencias incidencias;
	InterfazGestorProcesos procesos;
	InterfazGestorOOTT ots;
	

	public AnalisisEstadisticos(InterfazGestorIncidencias incidencias, InterfazGestorProcesos procesos,
			InterfazGestorOOTT ots) {
		super();
		this.incidencias = incidencias;
		this.procesos = procesos;
		this.ots = ots;
	}

	@Override
	public Integer totalIncidencias(String campoFiltro, String valorFiltro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer totalProcesos(String campoFiltro, String valorFiltro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer totalOOTT(String campoFiltro, String valorFiltro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float costesProcesos(String campoFiltro, String valorFiltro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float costesOOTT(String campoFiltro, String valorFiltro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Integer> distribucionIncidencias(String campoFiltro, String valorFiltro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Integer> distribucionProcesos(String campoFiltro, String valorFiltro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Integer> distribucionOOTT(String campoFiltro, String valorFiltro) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
