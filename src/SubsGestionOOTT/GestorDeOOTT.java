package SubsGestionOOTT;

import java.util.ArrayList;
import java.util.List;

import ModeladoDeDatos.OT;
import ModeladoDeDatos.Proceso;

public class GestorDeOOTT implements InterfazGestorOOTT {

	ArrayList<OT> ots;
	
	//Constructors
	public GestorDeOOTT() {
		super();
		this.ots = new ArrayList<>();
	}
	
	public GestorDeOOTT(ArrayList<OT> ots) {
		super();
		this.ots = ots;
	}



	@Override
	public ArrayList<OT> getOOTT(String campoFiltro, String valorFiltro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OT crearOT(String descripcion, List<String> material, List<Double> presupuestos, Float coste,
			String responsable, List<String> personal, String fechaInicio, Integer duracion, String estado,
			Proceso proceso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarOT(String ID, String campo, String valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incluirPresupuesto(String ID, Float presupuesto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retirarPresupuesto(String ID, Float presupuesto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incluirMaterial(String ID, String material) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retirarMaterial(String ID, String material) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incluirPersonal(String ID, String empleado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retirarPersonal(String ID, String empleado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarOT(String ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double consultarPreciosAcumulados(String campoFiltro, String valorFiltro) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
