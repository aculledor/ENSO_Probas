package SubsGestionIncidencias;

import java.util.ArrayList;

import ModeladoDeDatos.Incidencia;

public class GestorDeIncidencias implements InterfazGestorIncidencias {
	
	ArrayList<Incidencia> incidencias;

	@Override
	public ArrayList<Incidencia> getIncidencias(String campoFiltro, String valorFiltro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Incidencia crearIncidencia(String DNI, String nombre, String tlf, String descripcion, String localizacion,
			String tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarIncidencia(String ID, String campo, String valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarIncidencia(String ID) {
		// TODO Auto-generated method stub
		
	}
	
}
