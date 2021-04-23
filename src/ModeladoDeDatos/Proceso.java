package ModeladoDeDatos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Proceso {
	
	// Atributos
	private String nombre;
	private String descripcion;
	private Float coste;
	private Integer estimado;
	private String estado;
	private String responsable;
	private String servicio;
	private ArrayList<Incidencia> incidencias;
	private ArrayList<OT> ots;
	private String fechaCreacion;
	
	// Constructor
	public Proceso(String nombre, String descripcion, Float coste, Integer estimado, String estado, String responsable,
			String servicio, ArrayList<Incidencia> incidencias, ArrayList<OT> ots) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.coste = coste;
		this.estimado = estimado;
		this.estado = estado;
		this.responsable = responsable;
		this.servicio = servicio;
		this.incidencias = incidencias;
		this.ots = ots;
		DateFormat format = new SimpleDateFormat("dd/MM/yy");
		Date hoy = new Date();
		this.fechaCreacion = format.format(hoy);
	}

	public Proceso(String nombre, String descripcion, Float coste, Integer estimado, String estado, String responsable,
			String servicio, ArrayList<Incidencia> incidencias) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.coste = coste;
		this.estimado = estimado;
		this.estado = estado;
		this.responsable = responsable;
		this.servicio = servicio;
		this.incidencias = incidencias;
		this.ots = new ArrayList<>();
		DateFormat format = new SimpleDateFormat("dd/MM/yy");
		Date hoy = new Date();
		this.fechaCreacion = format.format(hoy);
	}

	public Proceso(String nombre, String descripcion, Float coste, Integer estimado, String estado, String responsable,
			String servicio, Incidencia incidencia) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.coste = coste;
		this.estimado = estimado;
		this.estado = estado;
		this.responsable = responsable;
		this.servicio = servicio;
		this.incidencias = new ArrayList<>();
		this.incidencias.add(incidencia);
		this.ots = new ArrayList<>();
		DateFormat format = new SimpleDateFormat("dd/MM/yy");
		Date hoy = new Date();
		this.fechaCreacion = format.format(hoy);
	}
	
	
	
	// Getters y setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getCoste() {
		return coste;
	}

	public void setCoste(Float coste) {
		this.coste = coste;
	}

	public Integer getEstimado() {
		return estimado;
	}

	public void setEstimado(Integer estimado) {
		this.estimado = estimado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public ArrayList<Incidencia> getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(ArrayList<Incidencia> incidencias) {
		this.incidencias = incidencias;
	}

	public ArrayList<OT> getOts() {
		return ots;
	}

	public void setOts(ArrayList<OT> ots) {
		this.ots = ots;
	}
	
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	
	
	
}
