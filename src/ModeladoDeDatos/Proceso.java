package ModeladoDeDatos;

public class Proceso {
	
	// Atributos
	private String nombre;
	private String descripcion;
	private Float coste;
	private Integer estimado;
	private String estado;
	private String responsable;
	private String servicio;
	
	// Constructor
	
	public Proceso(String nombre, String descripcion, Float coste, Integer estimado, String estado, String responsable,
			String servicio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.coste = coste;
		this.estimado = estimado;
		this.estado = estado;
		this.responsable = responsable;
		this.servicio = servicio;
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
	
}
