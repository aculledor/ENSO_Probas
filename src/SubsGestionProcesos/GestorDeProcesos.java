package SubsGestionProcesos;

import java.util.ArrayList;
import java.util.List;

import ModeladoDeDatos.Incidencia;
import ModeladoDeDatos.OT;
import ModeladoDeDatos.Proceso;

public class GestorDeProcesos implements InterfazGestorProcesos {

	ArrayList<Proceso> procesos;
	
	@Override
	public ArrayList<Proceso> getProcesos(String campoFiltro, String valorFiltro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proceso crearProceso(String nombre, String descripcion, Float coste, Integer estimado, String estado,
			String responsable, String servicio, List<Incidencia> incidencia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarProceso(String nombre, String campo, String valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarProceso(String nombre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vincularIncidencia(Incidencia incidencia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vincularOT(OT ot) {
		// TODO Auto-generated method stub
		
	}
	
}
