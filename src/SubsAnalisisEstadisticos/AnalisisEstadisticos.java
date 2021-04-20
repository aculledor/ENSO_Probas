package SubsAnalisisEstadisticos;

import java.util.*;
import ModeladoDeDatos.*;

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
		// Se declara un contador
		Integer contador = 0;
		// Se obtienen todas las incidencias almacenadas
		ArrayList<Incidencia> listaIncidencias = incidencias.getIncidencias(null, null);
		// Se comprueba si se ha solicitado un filtro
		if(campoFiltro == null) {
			// Se recorre la lista (para añadir complejidad ciclomática) y se aumenta el contador
			for(int i = 0; i < listaIncidencias.size(); i++) contador++;
			//Se devuelve el contador
			return contador;
			
		}else {
			// Si se solicita un filtro, se comprueba que sea correcto
			switch(campoFiltro){
				case "id":
					// Se comprueba que el valor del filtro no sea nulo
					if(valorFiltro != null) {
						//Se comprueba que se emplea el formato correcto
						if(valorFiltro.length() > 0 && valorFiltro.length() <= 20) {
							// Se recorre la lista
							for(Incidencia i : listaIncidencias)
								// Se aumenta el contador por cada elemento que cumpla el filtro
								if(i.getID().equals(valorFiltro)) contador++;
							// Se devuelve el contador
							return contador;
						}
						// Si el valor del filtro tiene un valor o formato incorrecto, se informa al usuario y se devuelve un null
						System.out.println("El valor del filtro tiene un valor o formato incorrecto");
						return null;
					}
					// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
					System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
					return null;
				case "nombreCiudadano":
					// Se comprueba que el valor del filtro no sea nulo
					if(valorFiltro != null) {
						//Se comprueba que se emplea el formato correcto
						if(valorFiltro.length() > 0 && valorFiltro.length() <= 25) {
							// Se recorre la lista
							for(Incidencia i : listaIncidencias)
								// Se aumenta el contador por cada elemento que cumpla el filtro
								if(i.getNombreCiudadano().equals(valorFiltro)) contador++;
							// Se devuelve el contador
							return contador;
						}
						// Si el valor del filtro tiene un valor o formato incorrecto, se informa al usuario y se devuelve un null
						System.out.println("El valor del filtro tiene un valor o formato incorrecto");
						return null;
					}
					// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
					System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
					return null;
				case "dni":
					// Se comprueba que el valor del filtro no sea nulo
					if(valorFiltro != null) {
						//Se comprueba que se emplea el formato correcto
						if(valorFiltro.length() == 9 
								&& Character.isDigit(valorFiltro.charAt(0)) && Character.isDigit(valorFiltro.charAt(1))
								&& Character.isDigit(valorFiltro.charAt(2)) && Character.isDigit(valorFiltro.charAt(3))
								&& Character.isDigit(valorFiltro.charAt(4)) && Character.isDigit(valorFiltro.charAt(5))
								&& Character.isDigit(valorFiltro.charAt(6)) && Character.isDigit(valorFiltro.charAt(7))
								&& Character.isLetter(valorFiltro.charAt(8))) {
							// Se recorre la lista
							for(Incidencia i : listaIncidencias)
								// Se aumenta el contador por cada elemento que cumpla el filtro
								if(i.getDNI().equals(valorFiltro)) contador++;
							// Se devuelve el contador
							return contador;
						}
						// Si el valor del filtro tiene un valor o formato incorrecto, se informa al usuario y se devuelve un null
						System.out.println("El valor del filtro tiene un valor o formato incorrecto");
						return null;
					}
					// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
					System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
					return null;
				case "telefono":
					// Se comprueba que el valor del filtro no sea nulo
					if(valorFiltro != null) {
						//Se comprueba que se emplea el formato correcto
						if(valorFiltro.length() == 12 
								&& valorFiltro.charAt(0) == '+' && Character.isDigit(valorFiltro.charAt(1))
								&& Character.isDigit(valorFiltro.charAt(2)) && Character.isDigit(valorFiltro.charAt(3))
								&& Character.isDigit(valorFiltro.charAt(4)) && Character.isDigit(valorFiltro.charAt(5))
								&& Character.isDigit(valorFiltro.charAt(6)) && Character.isDigit(valorFiltro.charAt(7))
								&& Character.isDigit(valorFiltro.charAt(8)) && Character.isDigit(valorFiltro.charAt(9))
								&& Character.isDigit(valorFiltro.charAt(10)) && Character.isDigit(valorFiltro.charAt(11))) {
							// Se recorre la lista
							for(Incidencia i : listaIncidencias)
								// Se aumenta el contador por cada elemento que cumpla el filtro
								if(i.getTelefono().equals(valorFiltro)) contador++;
							// Se devuelve el contador
							return contador;
						}
						// Si el valor del filtro tiene un valor o formato incorrecto, se informa al usuario y se devuelve un null
						System.out.println("El valor del filtro tiene un valor o formato incorrecto");
						return null;
					}
					// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
					System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
					return null;
				case "descripcion":
					// Se comprueba que el valor del filtro no sea nulo
					if(valorFiltro != null) {
						//Se comprueba que se emplea el formato correcto
						if(valorFiltro.length() > 0 && valorFiltro.length() <= 200) {
							// Se recorre la lista
							for(Incidencia i : listaIncidencias)
								// Se aumenta el contador por cada elemento que cumpla el filtro
								if(i.getDescripcion().equals(valorFiltro)) contador++;
							// Se devuelve el contador
							return contador;
						}
						// Si el valor del filtro tiene un valor o formato incorrecto, se informa al usuario y se devuelve un null
						System.out.println("El valor del filtro tiene un valor o formato incorrecto");
						return null;
					}
					// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
					System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
					return null;
				case "localizacion":
					// Se comprueba que el valor del filtro no sea nulo
					if(valorFiltro != null) {
						//Se comprueba que se emplea el formato correcto
						if(valorFiltro.length() > 0 && valorFiltro.length() <= 50) {
							// Se recorre la lista
							for(Incidencia i : listaIncidencias)
								// Se aumenta el contador por cada elemento que cumpla el filtro
								if(i.getLocalizacion().equals(valorFiltro)) contador++;
							// Se devuelve el contador
							return contador;
						}
						// Si el valor del filtro tiene un valor o formato incorrecto, se informa al usuario y se devuelve un null
						System.out.println("El valor del filtro tiene un valor o formato incorrecto");
						return null;
					}
					// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
					System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
					return null;
				case "tipo":
					// Se comprueba que el valor del filtro no sea nulo
					if(valorFiltro != null) {
						//Se comprueba que se emplea el formato correcto
						if(valorFiltro.length() > 0 && valorFiltro.length() <= 20 && (
								valorFiltro.equals("mobiliario público") || valorFiltro.equals("tráfico")
								|| valorFiltro.equals("economía") || valorFiltro.equals("malestar público") 
								|| valorFiltro.equals("agresiones") || valorFiltro.equals("otras causas") )) {
							// Se recorre la lista
							for(Incidencia i : listaIncidencias)
								// Se aumenta el contador por cada elemento que cumpla el filtro
								if(i.getTipo().equals(valorFiltro)) contador++;
							// Se devuelve el contador
							return contador;
						}
						// Si el valor del filtro tiene un valor o formato incorrecto, se informa al usuario y se devuelve un null
						System.out.println("El valor del filtro tiene un valor o formato incorrecto");
						return null;
					}
					// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
					System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
					return null;
				case "responsable":
					// Se comprueba que el valor del filtro no sea nulo
					if(valorFiltro != null) {
						//Se comprueba que se emplea el formato correcto
						if(valorFiltro.length() == 9 
								&& (Character.isDigit(valorFiltro.charAt(0)) ||Character.isLetter(valorFiltro.charAt(0)))
								&& Character.isDigit(valorFiltro.charAt(1)) && Character.isDigit(valorFiltro.charAt(2))
								&& Character.isDigit(valorFiltro.charAt(3)) && Character.isDigit(valorFiltro.charAt(4))
								&& Character.isDigit(valorFiltro.charAt(5)) && Character.isDigit(valorFiltro.charAt(6))
								&& Character.isDigit(valorFiltro.charAt(7)) && Character.isLetter(valorFiltro.charAt(8))) {
							// Se recorre la lista
							for(Incidencia i : listaIncidencias)
								// Se aumenta el contador por cada elemento que cumpla el filtro
								if(i.getP().equals(valorFiltro)) contador++;
							// Se devuelve el contador
							return contador;
						}
						// Si el valor del filtro tiene un valor o formato incorrecto, se informa al usuario y se devuelve un null
						System.out.println("El valor del filtro tiene un valor o formato incorrecto");
						return null;
					}
					// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
					System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
					return null;
				default:
					System.out.println("El campo de filtro indicado no existe");
					return null;
			}
		}
	}

	@Override
	public Integer totalProcesos(String campoFiltro, String valorFiltro) {
		// Se declara un contador
				Integer contador = 0;
				// Se obtienen todos los procesos almacenados
				ArrayList<Proceso> listaProcesos = incidencias.getIncidencias(null, null);
				// Se comprueba si se ha solicitado un filtro
				if(campoFiltro == null) {
					// Se recorre la lista (para añadir complejidad ciclomática) y se aumenta el contador
					for(int i = 0; i < listaProcesos.size(); i++) contador++;
					//Se devuelve el contador
					return contador;
					
				}else {
					// Si se solicita un filtro, se comprueba que sea correcto
					switch(campoFiltro){
						case "id":
							// Se comprueba que el valor del filtro no sea nulo
							if(valorFiltro != null) {
								//Se comprueba que se emplea el formato correcto
								if(valorFiltro.length() > 0 && valorFiltro.length() <= 20) {
									// Se recorre la lista
									for(Incidencia i : listaProcesos)
										// Se aumenta el contador por cada elemento que cumpla el filtro
										if(i.getID().equals(valorFiltro)) contador++;
									// Se devuelve el contador
									return contador;
								}
								// Si el valor del filtro tiene un valor o formato incorrecto, se informa al usuario y se devuelve un null
								System.out.println("El valor del filtro tiene un valor o formato incorrecto");
								return null;
							}
							// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
							System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
							return null;
						case "nombreCiudadano":
							// Se comprueba que el valor del filtro no sea nulo
							if(valorFiltro != null) {
								//Se comprueba que se emplea el formato correcto
								if(valorFiltro.length() > 0 && valorFiltro.length() <= 25) {
									// Se recorre la lista
									for(Incidencia i : listaProcesos)
										// Se aumenta el contador por cada elemento que cumpla el filtro
										if(i.getNombreCiudadano().equals(valorFiltro)) contador++;
									// Se devuelve el contador
									return contador;
								}
								// Si el valor del filtro tiene un valor o formato incorrecto, se informa al usuario y se devuelve un null
								System.out.println("El valor del filtro tiene un valor o formato incorrecto");
								return null;
							}
							// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
							System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
							return null;
						case "dni":
							// Se comprueba que el valor del filtro no sea nulo
							if(valorFiltro != null) {
								//Se comprueba que se emplea el formato correcto
								if(valorFiltro.length() == 9 
										&& Character.isLetter(valorFiltro.charAt(0)) && Character.isLetter(valorFiltro.charAt(1))
										&& Character.isLetter(valorFiltro.charAt(2)) && Character.isLetter(valorFiltro.charAt(3))
										&& Character.isLetter(valorFiltro.charAt(4)) && Character.isLetter(valorFiltro.charAt(5))
										&& Character.isLetter(valorFiltro.charAt(6)) && Character.isLetter(valorFiltro.charAt(7))
										&& Character.isDigit(valorFiltro.charAt(8))) {
									// Se recorre la lista
									for(Incidencia i : listaProcesos)
										// Se aumenta el contador por cada elemento que cumpla el filtro
										if(i.getDNI().equals(valorFiltro)) contador++;
									// Se devuelve el contador
									return contador;
								}
								// Si el valor del filtro tiene un valor o formato incorrecto, se informa al usuario y se devuelve un null
								System.out.println("El valor del filtro tiene un valor o formato incorrecto");
								return null;
							}
							// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
							System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
							return null;
						case "telefono":
							// Se comprueba que el valor del filtro no sea nulo
							if(valorFiltro != null) {
								//Se comprueba que se emplea el formato correcto
								if(valorFiltro.length() == 12 
										&& valorFiltro.charAt(0) == '+' && Character.isDigit(valorFiltro.charAt(1))
										&& Character.isDigit(valorFiltro.charAt(2)) && Character.isDigit(valorFiltro.charAt(3))
										&& Character.isDigit(valorFiltro.charAt(4)) && Character.isDigit(valorFiltro.charAt(5))
										&& Character.isDigit(valorFiltro.charAt(6)) && Character.isDigit(valorFiltro.charAt(7))
										&& Character.isDigit(valorFiltro.charAt(8)) && Character.isDigit(valorFiltro.charAt(9))
										&& Character.isDigit(valorFiltro.charAt(10)) && Character.isDigit(valorFiltro.charAt(11))) {
									// Se recorre la lista
									for(Incidencia i : listaProcesos)
										// Se aumenta el contador por cada elemento que cumpla el filtro
										if(i.getTelefono().equals(valorFiltro)) contador++;
									// Se devuelve el contador
									return contador;
								}
								// Si el valor del filtro tiene un valor o formato incorrecto, se informa al usuario y se devuelve un null
								System.out.println("El valor del filtro tiene un valor o formato incorrecto");
								return null;
							}
							// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
							System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
							return null;
						case "descripcion":
							// Se comprueba que el valor del filtro no sea nulo
							if(valorFiltro != null) {
								//Se comprueba que se emplea el formato correcto
								if(valorFiltro.length() > 0 && valorFiltro.length() <= 200) {
									// Se recorre la lista
									for(Incidencia i : listaProcesos)
										// Se aumenta el contador por cada elemento que cumpla el filtro
										if(i.getDescripcion().equals(valorFiltro)) contador++;
									// Se devuelve el contador
									return contador;
								}
								// Si el valor del filtro tiene un valor o formato incorrecto, se informa al usuario y se devuelve un null
								System.out.println("El valor del filtro tiene un valor o formato incorrecto");
								return null;
							}
							// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
							System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
							return null;
						case "localizacion":
							// Se comprueba que el valor del filtro no sea nulo
							if(valorFiltro != null) {
								//Se comprueba que se emplea el formato correcto
								if(valorFiltro.length() > 0 && valorFiltro.length() <= 50) {
									// Se recorre la lista
									for(Incidencia i : listaProcesos)
										// Se aumenta el contador por cada elemento que cumpla el filtro
										if(i.getLocalizacion().equals(valorFiltro)) contador++;
									// Se devuelve el contador
									return contador;
								}
								// Si el valor del filtro tiene un valor o formato incorrecto, se informa al usuario y se devuelve un null
								System.out.println("El valor del filtro tiene un valor o formato incorrecto");
								return null;
							}
							// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
							System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
							return null;
						case "tipo":
							// Se comprueba que el valor del filtro no sea nulo
							if(valorFiltro != null) {
								//Se comprueba que se emplea el formato correcto
								if(valorFiltro.length() > 0 && valorFiltro.length() <= 20 && (
										valorFiltro.equals("mobiliario público") || valorFiltro.equals("tráfico")
										|| valorFiltro.equals("economía") || valorFiltro.equals("malestar público") 
										|| valorFiltro.equals("agresiones") || valorFiltro.equals("otras causas") )) {
									// Se recorre la lista
									for(Incidencia i : listaProcesos)
										// Se aumenta el contador por cada elemento que cumpla el filtro
										if(i.getTipo().equals(valorFiltro)) contador++;
									// Se devuelve el contador
									return contador;
								}
								// Si el valor del filtro tiene un valor o formato incorrecto, se informa al usuario y se devuelve un null
								System.out.println("El valor del filtro tiene un valor o formato incorrecto");
								return null;
							}
							// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
							System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
							return null;
						default:
							System.out.println("El campo de filtro indicado no existe");
							return null;
					}
				}
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
