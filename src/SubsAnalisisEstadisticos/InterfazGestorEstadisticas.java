package SubsAnalisisEstadisticos;

import java.util.HashMap;

public interface InterfazGestorEstadisticas {
	Integer totalIncidencias(String campoFiltro, String valorFiltro);
	Integer totalProcesos(String campoFiltro, String valorFiltro);
	Integer totalOOTT(String campoFiltro, String valorFiltro);
	Float costesProcesos(String campoFiltro, String valorFiltro);
	Float costesOOTT(String campoFiltro, String valorFiltro);
	HashMap<String, Integer> distribuci�nIncidencias(String campoFiltro, String valorFiltro);
	HashMap<String, Integer> distribuci�nProcesos(String campoFiltro, String valorFiltro);
	HashMap<String, Integer> distribuci�nOOTT(String campoFiltro, String valorFiltro);
}
