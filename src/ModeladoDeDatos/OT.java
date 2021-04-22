package ModeladoDeDatos;

import java.util.ArrayList;

public class OT {

	// Atributos
	private String ID;
	private String descripcion;
	private ArrayList<String> material;
	private ArrayList<Double> presupuestos;
	private Float coste;
	private String responsable;
	private ArrayList<String> personal;
	private String fechaInicio;
	private Integer duracion;
	private String estado;
	private Proceso proceso;
	
	// Constructor
	public OT(String ID, String descripcion, ArrayList<String> material, ArrayList<Double> presupuestos, Float coste,
			String responsable, ArrayList<String> personal, String fechaInicio, Integer duracion, String estado, Proceso proceso) {
		super();
		this.ID = ID;
		this.descripcion = descripcion;
		this.material = material;
		this.presupuestos = presupuestos;
		this.coste = coste;
		this.responsable = responsable;
		this.personal = personal;
		this.fechaInicio = fechaInicio;
		this.duracion = duracion;
		this.estado = estado;
		this.proceso = proceso;
	}

	// Getters y setters
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ArrayList<String> getMaterial() {
		return material;
	}

	public void setMaterial(ArrayList<String> material) {
		this.material = material;
	}

	public ArrayList<Double> getPresupuestos() {
		return presupuestos;
	}

	public void setPresupuestos(ArrayList<Double> presupuestos) {
		this.presupuestos = presupuestos;
	}

	public Float getCoste() {
		return coste;
	}

	public void setCoste(Float coste) {
		this.coste = coste;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public ArrayList<String> getPersonal() {
		return personal;
	}

	public void setPersonal(ArrayList<String> personal) {
		this.personal = personal;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Proceso getProceso() {
		return proceso;
	}
	
	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}
	
}
