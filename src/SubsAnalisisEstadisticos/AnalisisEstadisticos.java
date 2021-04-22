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
		if (campoFiltro == null) {
			// Se recorre la lista (para añadir complejidad ciclomática) y se aumenta el
			// contador
			for (int i = 0; i < listaIncidencias.size(); i++)
				contador++;
			// Se devuelve el contador
			return contador;

		} else {
			// Si se solicita un filtro, se comprueba que sea correcto
			switch (campoFiltro) {
			case "id":
				// Se comprueba que el valor del filtro no sea nulo
				if (valorFiltro != null) {
					// Se comprueba que se emplea el formato correcto
					if (valorFiltro.length() > 0 && valorFiltro.length() <= 20) {
						// Se recorre la lista
						for (Incidencia i : listaIncidencias)
							// Se aumenta el contador por cada elemento que cumpla el filtro
							if (i.getID().equals(valorFiltro))
								contador++;
						// Se devuelve el contador
						return contador;
					}
					// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
					// usuario y se devuelve un null
					System.out.println("El valor del filtro tiene un valor o formato incorrecto");
					return null;
				}
				// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
				System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
				return null;
			case "nombreCiudadano":
				// Se comprueba que el valor del filtro no sea nulo
				if (valorFiltro != null) {
					// Se comprueba que se emplea el formato correcto
					if (valorFiltro.length() > 0 && valorFiltro.length() <= 25) {
						// Se recorre la lista
						for (Incidencia i : listaIncidencias)
							// Se aumenta el contador por cada elemento que cumpla el filtro
							if (i.getNombreCiudadano().equals(valorFiltro))
								contador++;
						// Se devuelve el contador
						return contador;
					}
					// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
					// usuario y se devuelve un null
					System.out.println("El valor del filtro tiene un valor o formato incorrecto");
					return null;
				}
				// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
				System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
				return null;
			case "dni":
				// Se comprueba que el valor del filtro no sea nulo
				if (valorFiltro != null) {
					// Se comprueba que se emplea el formato correcto
					if (valorFiltro.length() == 9 && Character.isDigit(valorFiltro.charAt(0))
							&& Character.isDigit(valorFiltro.charAt(1)) && Character.isDigit(valorFiltro.charAt(2))
							&& Character.isDigit(valorFiltro.charAt(3)) && Character.isDigit(valorFiltro.charAt(4))
							&& Character.isDigit(valorFiltro.charAt(5)) && Character.isDigit(valorFiltro.charAt(6))
							&& Character.isDigit(valorFiltro.charAt(7)) && Character.isLetter(valorFiltro.charAt(8))) {
						// Se recorre la lista
						for (Incidencia i : listaIncidencias)
							// Se aumenta el contador por cada elemento que cumpla el filtro
							if (i.getDNI().equals(valorFiltro))
								contador++;
						// Se devuelve el contador
						return contador;
					}
					// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
					// usuario y se devuelve un null
					System.out.println("El valor del filtro tiene un valor o formato incorrecto");
					return null;
				}
				// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
				System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
				return null;
			case "telefono":
				// Se comprueba que el valor del filtro no sea nulo
				if (valorFiltro != null) {
					// Se comprueba que se emplea el formato correcto
					if (valorFiltro.length() == 12 && valorFiltro.charAt(0) == '+'
							&& Character.isDigit(valorFiltro.charAt(1)) && Character.isDigit(valorFiltro.charAt(2))
							&& Character.isDigit(valorFiltro.charAt(3)) && Character.isDigit(valorFiltro.charAt(4))
							&& Character.isDigit(valorFiltro.charAt(5)) && Character.isDigit(valorFiltro.charAt(6))
							&& Character.isDigit(valorFiltro.charAt(7)) && Character.isDigit(valorFiltro.charAt(8))
							&& Character.isDigit(valorFiltro.charAt(9)) && Character.isDigit(valorFiltro.charAt(10))
							&& Character.isDigit(valorFiltro.charAt(11))) {
						// Se recorre la lista
						for (Incidencia i : listaIncidencias)
							// Se aumenta el contador por cada elemento que cumpla el filtro
							if (i.getTelefono().equals(valorFiltro))
								contador++;
						// Se devuelve el contador
						return contador;
					}
					// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
					// usuario y se devuelve un null
					System.out.println("El valor del filtro tiene un valor o formato incorrecto");
					return null;
				}
				// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
				System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
				return null;
			case "descripcion":
				// Se comprueba que el valor del filtro no sea nulo
				if (valorFiltro != null) {
					// Se comprueba que se emplea el formato correcto
					if (valorFiltro.length() > 0 && valorFiltro.length() <= 200) {
						// Se recorre la lista
						for (Incidencia i : listaIncidencias)
							// Se aumenta el contador por cada elemento que cumpla el filtro
							if (i.getDescripcion().equals(valorFiltro))
								contador++;
						// Se devuelve el contador
						return contador;
					}
					// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
					// usuario y se devuelve un null
					System.out.println("El valor del filtro tiene un valor o formato incorrecto");
					return null;
				}
				// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
				System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
				return null;
			case "localizacion":
				// Se comprueba que el valor del filtro no sea nulo
				if (valorFiltro != null) {
					// Se comprueba que se emplea el formato correcto
					if (valorFiltro.length() > 0 && valorFiltro.length() <= 50) {
						// Se recorre la lista
						for (Incidencia i : listaIncidencias)
							// Se aumenta el contador por cada elemento que cumpla el filtro
							if (i.getLocalizacion().equals(valorFiltro))
								contador++;
						// Se devuelve el contador
						return contador;
					}
					// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
					// usuario y se devuelve un null
					System.out.println("El valor del filtro tiene un valor o formato incorrecto");
					return null;
				}
				// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
				System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
				return null;
			case "tipo":
				// Se comprueba que el valor del filtro no sea nulo
				if (valorFiltro != null) {
					// Se comprueba que se emplea el formato correcto
					if (valorFiltro.length() > 0 && valorFiltro.length() <= 20) {
						// Se recorre la lista
						for (Incidencia i : listaIncidencias)
							// Se aumenta el contador por cada elemento que cumpla el filtro
							if (i.getTipo().equals(valorFiltro))
								contador++;
						// Se devuelve el contador
						return contador;
					}
					// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
					// usuario y se devuelve un null
					System.out.println("El valor del filtro tiene un valor o formato incorrecto");
					return null;
				}
				// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
				System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
				return null;
			case "responsable":
				// Se comprueba que el valor del filtro no sea nulo
				if (valorFiltro != null) {
					// Se comprueba que se emplea el formato correcto
					if (valorFiltro.length() == 9
							&& (Character.isDigit(valorFiltro.charAt(0)) || Character.isLetter(valorFiltro.charAt(0)))
							&& Character.isDigit(valorFiltro.charAt(1)) && Character.isDigit(valorFiltro.charAt(2))
							&& Character.isDigit(valorFiltro.charAt(3)) && Character.isDigit(valorFiltro.charAt(4))
							&& Character.isDigit(valorFiltro.charAt(5)) && Character.isDigit(valorFiltro.charAt(6))
							&& Character.isDigit(valorFiltro.charAt(7)) && Character.isLetter(valorFiltro.charAt(8))) {
						// Se recorre la lista
						for (Incidencia i : listaIncidencias)
							// Se aumenta el contador por cada elemento que cumpla el filtro
							if (i.getProceso().getResponsable().equals(valorFiltro))
								contador++;
						// Se devuelve el contador
						return contador;
					}
					// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
					// usuario y se devuelve un null
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
		Integer contador = 0, iAux;
		Float fAux;
		// Se obtienen todos los procesos almacenados
		ArrayList<Proceso> listaProcesos = procesos.getProcesos(null, null);
		// Se comprueba si se ha solicitado un filtro
		if (campoFiltro == null) {
			// Se recorre la lista (para añadir complejidad ciclomática) y se aumenta el
			// contador
			for (int i = 0; i < listaProcesos.size(); i++)
				contador++;
			// Se devuelve el contador
			return contador;

		} else {
			// Si se solicita un filtro, se comprueba que sea correcto
			switch (campoFiltro) {
			case "nombre":
				// Se comprueba que el valor del filtro no sea nulo
				if (valorFiltro != null) {
					// Se comprueba que se emplea el formato correcto
					if (valorFiltro.length() > 0 && valorFiltro.length() <= 50) {
						// Se recorre la lista
						for (Proceso p : listaProcesos)
							// Se aumenta el contador por cada elemento que cumpla el filtro
							if (p.getNombre().equals(valorFiltro))
								contador++;
						// Se devuelve el contador
						return contador;
					}
					// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
					// usuario y se devuelve un null
					System.out.println("El valor del filtro tiene un valor o formato incorrecto");
					return null;
				}
				// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
				System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
				return null;
			case "descripcion":
				// Se comprueba que el valor del filtro no sea nulo
				if (valorFiltro != null) {
					// Se comprueba que se emplea el formato correcto
					if (valorFiltro.length() > 0 && valorFiltro.length() <= 200) {
						// Se recorre la lista
						for (Proceso p : listaProcesos)
							// Se aumenta el contador por cada elemento que cumpla el filtro
							if (p.getDescripcion().equals(valorFiltro))
								contador++;
						// Se devuelve el contador
						return contador;
					}
					// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
					// usuario y se devuelve un null
					System.out.println("El valor del filtro tiene un valor o formato incorrecto");
					return null;
				}
				// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
				System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
				return null;
			case "coste":
				// Se comprueba que el valor del filtro no sea nulo
				if (valorFiltro != null) {
					fAux = Float.valueOf(valorFiltro);
					// Se comprueba que se emplea el formato correcto
					if (fAux > 0) {
						// Se recorre la lista
						for (Proceso p : listaProcesos)
							// Se aumenta el contador por cada elemento que cumpla el filtro
							if (p.getCoste() == fAux)
								contador++;
						// Se devuelve el contador
						return contador;
					}
					// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
					// usuario y se devuelve un null
					System.out.println("El valor del filtro tiene un valor o formato incorrecto");
					return null;
				}
				// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
				System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
				return null;
			case "estimado":
				// Se comprueba que el valor del filtro no sea nulo
				if (valorFiltro != null) {
					iAux = Integer.valueOf(valorFiltro);
					// Se comprueba que se emplea el formato correcto
					if (iAux > 0) {
						// Se recorre la lista
						for (Proceso p : listaProcesos)
							// Se aumenta el contador por cada elemento que cumpla el filtro
							if (p.getEstimado() == iAux)
								contador++;
						// Se devuelve el contador
						return contador;
					}
					// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
					// usuario y se devuelve un null
					System.out.println("El valor del filtro tiene un valor o formato incorrecto");
					return null;
				}
				// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
				System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
				return null;
			case "estado":
				// Se comprueba que el valor del filtro no sea nulo
				if (valorFiltro != null) {
					// Se comprueba que se emplea el formato correcto
					if (valorFiltro.length() > 0 && valorFiltro.length() <= 20) {
						// Se recorre la lista
						for (Proceso p : listaProcesos)
							// Se aumenta el contador por cada elemento que cumpla el filtro
							if (p.getEstado().equals(valorFiltro))
								contador++;
						// Se devuelve el contador
						return contador;
					}
					// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
					// usuario y se devuelve un null
					System.out.println("El valor del filtro tiene un valor o formato incorrecto");
					return null;
				}
				// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
				System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
				return null;
			case "responsable":
				// Se comprueba que el valor del filtro no sea nulo
				if (valorFiltro != null) {
					// Se comprueba que se emplea el formato correcto
					if (valorFiltro.length() > 0 && valorFiltro.length() <= 50) {
						// Se recorre la lista
						for (Proceso p : listaProcesos)
							// Se aumenta el contador por cada elemento que cumpla el filtro
							if (p.getResponsable().equals(valorFiltro))
								contador++;
						// Se devuelve el contador
						return contador;
					}
					// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
					// usuario y se devuelve un null
					System.out.println("El valor del filtro tiene un valor o formato incorrecto");
					return null;
				}
				// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
				System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
				return null;
			case "servicio":
				// Se comprueba que el valor del filtro no sea nulo
				if (valorFiltro != null) {
					// Se comprueba que se emplea el formato correcto
					if (valorFiltro.length() > 0 && valorFiltro.length() <= 50) {
						// Se recorre la lista
						for (Proceso p : listaProcesos)
							// Se aumenta el contador por cada elemento que cumpla el filtro
							if (p.getServicio().equals(valorFiltro))
								contador++;
						// Se devuelve el contador
						return contador;
					}
					// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
					// usuario y se devuelve un null
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
		// Se declara un contador
		Integer contador = 0, iAux;
		Float fAux;
		// Se obtienen todos los procesos almacenados
		ArrayList<OT> listaOOTT = ots.getOOTT(null, null);
		// Se comprueba si se ha solicitado un filtro
		if (campoFiltro == null) {
			// Se recorre la lista (para añadir complejidad ciclomática) y se aumenta el
			// contador
			for (int i = 0; i < listaOOTT.size(); i++)
				contador++;
			// Se devuelve el contador
			return contador;

		} else {
			// Si se solicita un filtro, se comprueba que sea correcto
			switch (campoFiltro) {
			case "id":
				// Se comprueba que el valor del filtro no sea nulo
				if (valorFiltro != null) {
					// Se comprueba que se emplea el formato correcto
					if (valorFiltro.length() > 0 && valorFiltro.length() <= 20) {
						// Se recorre la lista
						for (OT ot : listaOOTT)
							// Se aumenta el contador por cada elemento que cumpla el filtro
							if (ot.getID().equals(valorFiltro))
								contador++;
						// Se devuelve el contador
						return contador;
					}
					// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
					// usuario y se devuelve un null
					System.out.println("El valor del filtro tiene un valor o formato incorrecto");
					return null;
				}
				// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
				System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
				return null;
			case "descripcion":
				// Se comprueba que el valor del filtro no sea nulo
				if (valorFiltro != null) {
					// Se comprueba que se emplea el formato correcto
					if (valorFiltro.length() > 0 && valorFiltro.length() <= 200) {
						// Se recorre la lista
						for (OT ot : listaOOTT)
							// Se aumenta el contador por cada elemento que cumpla el filtro
							if (ot.getDescripcion().equals(valorFiltro))
								contador++;
						// Se devuelve el contador
						return contador;
					}
					// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
					// usuario y se devuelve un null
					System.out.println("El valor del filtro tiene un valor o formato incorrecto");
					return null;
				}
				// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
				System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
				return null;
			case "coste":
				// Se comprueba que el valor del filtro no sea nulo
				if (valorFiltro != null) {
					fAux = Float.valueOf(valorFiltro);
					// Se comprueba que se emplea el formato correcto
					if (fAux > 0) {
						// Se recorre la lista
						for (OT ot : listaOOTT)
							// Se aumenta el contador por cada elemento que cumpla el filtro
							if (ot.getCoste() == fAux)
								contador++;
						// Se devuelve el contador
						return contador;
					}
					// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
					// usuario y se devuelve un null
					System.out.println("El valor del filtro tiene un valor o formato incorrecto");
					return null;
				}
				// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
				System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
				return null;
			case "responsable":
				// Se comprueba que el valor del filtro no sea nulo
				if (valorFiltro != null) {
					// Se comprueba que se emplea el formato correcto
					if (valorFiltro.length() > 0 && valorFiltro.length() <= 20) {
						// Se recorre la lista
						for (OT ot : listaOOTT)
							// Se aumenta el contador por cada elemento que cumpla el filtro
							if (ot.getResponsable().equals(valorFiltro))
								contador++;
						// Se devuelve el contador
						return contador;
					}
					// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
					// usuario y se devuelve un null
					System.out.println("El valor del filtro tiene un valor o formato incorrecto");
					return null;
				}
				// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
				System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
				return null;
			case "fechaInicio":
				// Se comprueba que el valor del filtro no sea nulo
				if (valorFiltro != null) {
					// Se comprueba que se emplea el formato correcto
					String[] partes = valorFiltro.split("/");
					if (valorFiltro.length() == 8
							&& Character.isDigit(valorFiltro.charAt(0)) && Character.isDigit(valorFiltro.charAt(1))
							&& valorFiltro.charAt(2) == '/'
							&& Character.isDigit(valorFiltro.charAt(3)) && Character.isDigit(valorFiltro.charAt(4))
							&& valorFiltro.charAt(5) == '/'
							&& Character.isDigit(valorFiltro.charAt(6)) && Character.isDigit(valorFiltro.charAt(7))
							&& Integer.valueOf(partes[0]) < 31 && Integer.valueOf(partes[1]) < 12
							&& (Integer.valueOf(partes[0]) <= 28 || Integer.valueOf(partes[1]) != 2) ) {
						// Se recorre la lista
						for (OT ot : listaOOTT)
							// Se aumenta el contador por cada elemento que cumpla el filtro
							if (ot.getFechaInicio().equals(valorFiltro))
								contador++;
						// Se devuelve el contador
						return contador;
					}
					// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
					// usuario y se devuelve un null
					System.out.println("El valor del filtro tiene un valor o formato incorrecto");
					return null;
				}
				// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
				System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
				return null;
			case "duracion":
				// Se comprueba que el valor del filtro no sea nulo
				if (valorFiltro != null) {
					iAux = Integer.valueOf(valorFiltro);
					// Se comprueba que se emplea el formato correcto
					if (iAux > 0) {
						// Se recorre la lista
						for (OT ot : listaOOTT)
							// Se aumenta el contador por cada elemento que cumpla el filtro
							if (ot.getDuracion() == iAux)
								contador++;
						// Se devuelve el contador
						return contador;
					}
					// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
					// usuario y se devuelve un null
					System.out.println("El valor del filtro tiene un valor o formato incorrecto");
					return null;
				}
				// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
				System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
				return null;
			case "estado":
				// Se comprueba que el valor del filtro no sea nulo
				if (valorFiltro != null) {
					// Se comprueba que se emplea el formato correcto
					if (valorFiltro.length() > 0 && valorFiltro.length() <= 20) {
						// Se recorre la lista
						for (OT ot : listaOOTT)
							// Se aumenta el contador por cada elemento que cumpla el filtro
							if (ot.getEstado().equals(valorFiltro))
								contador++;
						// Se devuelve el contador
						return contador;
					}
					// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
					// usuario y se devuelve un null
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
	public Float costesProcesos(String campoFiltro, String valorFiltro) {
		// Se declara un contador para el coste total
				Integer iAux;
				Float fAux, total = 0.0f;
				// Se obtienen todos los procesos almacenados
				ArrayList<Proceso> listaProcesos = procesos.getProcesos(null, null);
				// Se comprueba si se ha solicitado un filtro
				if (campoFiltro == null) {
					// Se recorre la lista (para añadir complejidad ciclomática) y se aumenta el
					// contador
					for (Proceso p : listaProcesos)
						total += p.getCoste();
					// Se devuelve el contador
					return total;

				} else {
					// Si se solicita un filtro, se comprueba que sea correcto
					switch (campoFiltro) {
					case "nombre":
						// Se comprueba que el valor del filtro no sea nulo
						if (valorFiltro != null) {
							// Se comprueba que se emplea el formato correcto
							if (valorFiltro.length() > 0 && valorFiltro.length() <= 50) {
								// Se recorre la lista
								for (Proceso p : listaProcesos)
									// Se aumenta el contador por cada elemento que cumpla el filtro
									if (p.getNombre().equals(valorFiltro))
										total += p.getCoste();
								// Se devuelve el contador
								return total;
							}
							// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
							// usuario y se devuelve un null
							System.out.println("El valor del filtro tiene un valor o formato incorrecto");
							return null;
						}
						// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
						System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
						return null;
					case "descripcion":
						// Se comprueba que el valor del filtro no sea nulo
						if (valorFiltro != null) {
							// Se comprueba que se emplea el formato correcto
							if (valorFiltro.length() > 0 && valorFiltro.length() <= 200) {
								// Se recorre la lista
								for (Proceso p : listaProcesos)
									// Se aumenta el contador por cada elemento que cumpla el filtro
									if (p.getDescripcion().equals(valorFiltro))
										total += p.getCoste();
								// Se devuelve el contador
								return total;
							}
							// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
							// usuario y se devuelve un null
							System.out.println("El valor del filtro tiene un valor o formato incorrecto");
							return null;
						}
						// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
						System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
						return null;
					case "coste":
						// Se comprueba que el valor del filtro no sea nulo
						if (valorFiltro != null) {
							fAux = Float.valueOf(valorFiltro);
							// Se comprueba que se emplea el formato correcto
							if (fAux > 0) {
								// Se recorre la lista
								for (Proceso p : listaProcesos)
									// Se aumenta el contador por cada elemento que cumpla el filtro
									if (p.getCoste() == fAux)
										total += p.getCoste();
								// Se devuelve el contador
								return total;
							}
							// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
							// usuario y se devuelve un null
							System.out.println("El valor del filtro tiene un valor o formato incorrecto");
							return null;
						}
						// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
						System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
						return null;
					case "estimado":
						// Se comprueba que el valor del filtro no sea nulo
						if (valorFiltro != null) {
							iAux = Integer.valueOf(valorFiltro);
							// Se comprueba que se emplea el formato correcto
							if (iAux > 0) {
								// Se recorre la lista
								for (Proceso p : listaProcesos)
									// Se aumenta el contador por cada elemento que cumpla el filtro
									if (p.getEstimado() == iAux)
										total += p.getCoste();
								// Se devuelve el contador
								return total;
							}
							// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
							// usuario y se devuelve un null
							System.out.println("El valor del filtro tiene un valor o formato incorrecto");
							return null;
						}
						// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
						System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
						return null;
					case "estado":
						// Se comprueba que el valor del filtro no sea nulo
						if (valorFiltro != null) {
							// Se comprueba que se emplea el formato correcto
							if (valorFiltro.length() > 0 && valorFiltro.length() <= 20) {
								// Se recorre la lista
								for (Proceso p : listaProcesos)
									// Se aumenta el contador por cada elemento que cumpla el filtro
									if (p.getEstado().equals(valorFiltro))
										total += p.getCoste();
								// Se devuelve el contador
								return total;
							}
							// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
							// usuario y se devuelve un null
							System.out.println("El valor del filtro tiene un valor o formato incorrecto");
							return null;
						}
						// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
						System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
						return null;
					case "responsable":
						// Se comprueba que el valor del filtro no sea nulo
						if (valorFiltro != null) {
							// Se comprueba que se emplea el formato correcto
							if (valorFiltro.length() > 0 && valorFiltro.length() <= 50) {
								// Se recorre la lista
								for (Proceso p : listaProcesos)
									// Se aumenta el contador por cada elemento que cumpla el filtro
									if (p.getResponsable().equals(valorFiltro))
										total += p.getCoste();
								// Se devuelve el contador
								return total;
							}
							// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
							// usuario y se devuelve un null
							System.out.println("El valor del filtro tiene un valor o formato incorrecto");
							return null;
						}
						// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
						System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
						return null;
					case "servicio":
						// Se comprueba que el valor del filtro no sea nulo
						if (valorFiltro != null) {
							// Se comprueba que se emplea el formato correcto
							if (valorFiltro.length() > 0 && valorFiltro.length() <= 50) {
								// Se recorre la lista
								for (Proceso p : listaProcesos)
									// Se aumenta el contador por cada elemento que cumpla el filtro
									if (p.getServicio().equals(valorFiltro))
										total += p.getCoste();
								// Se devuelve el contador
								return total;
							}
							// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
							// usuario y se devuelve un null
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
	public Float costesOOTT(String campoFiltro, String valorFiltro) {
		// Se declara un contador para el coste total
				Integer iAux;
				Float fAux, total = 0.0f;
				// Se obtienen todos los procesos almacenados
				ArrayList<OT> listaOOTT = ots.getOOTT(null, null);
				// Se comprueba si se ha solicitado un filtro
				if (campoFiltro == null) {
					// Se recorre la lista (para añadir complejidad ciclomática) y se aumenta el
					// contador
					for (OT ot : listaOOTT)
						total += ot.getCoste();
					// Se devuelve el contador
					return total;

				} else {
					// Si se solicita un filtro, se comprueba que sea correcto
					switch (campoFiltro) {
					case "id":
						// Se comprueba que el valor del filtro no sea nulo
						if (valorFiltro != null) {
							// Se comprueba que se emplea el formato correcto
							if (valorFiltro.length() > 0 && valorFiltro.length() <= 20) {
								// Se recorre la lista
								for (OT ot : listaOOTT)
									// Se aumenta el contador por cada elemento que cumpla el filtro
									if (ot.getID().equals(valorFiltro))
										total += ot.getCoste();
								// Se devuelve el contador
								return total;
							}
							// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
							// usuario y se devuelve un null
							System.out.println("El valor del filtro tiene un valor o formato incorrecto");
							return null;
						}
						// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
						System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
						return null;
					case "descripcion":
						// Se comprueba que el valor del filtro no sea nulo
						if (valorFiltro != null) {
							// Se comprueba que se emplea el formato correcto
							if (valorFiltro.length() > 0 && valorFiltro.length() <= 200) {
								// Se recorre la lista
								for (OT ot : listaOOTT)
									// Se aumenta el contador por cada elemento que cumpla el filtro
									if (ot.getDescripcion().equals(valorFiltro))
										total += ot.getCoste();
								// Se devuelve el contador
								return total;
							}
							// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
							// usuario y se devuelve un null
							System.out.println("El valor del filtro tiene un valor o formato incorrecto");
							return null;
						}
						// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
						System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
						return null;
					case "coste":
						// Se comprueba que el valor del filtro no sea nulo
						if (valorFiltro != null) {
							fAux = Float.valueOf(valorFiltro);
							// Se comprueba que se emplea el formato correcto
							if (fAux > 0) {
								// Se recorre la lista
								for (OT ot : listaOOTT)
									// Se aumenta el contador por cada elemento que cumpla el filtro
									if (ot.getCoste() == fAux)
										total += ot.getCoste();
								// Se devuelve el contador
								return total;
							}
							// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
							// usuario y se devuelve un null
							System.out.println("El valor del filtro tiene un valor o formato incorrecto");
							return null;
						}
						// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
						System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
						return null;
					case "responsable":
						// Se comprueba que el valor del filtro no sea nulo
						if (valorFiltro != null) {
							// Se comprueba que se emplea el formato correcto
							if (valorFiltro.length() > 0 && valorFiltro.length() <= 20) {
								// Se recorre la lista
								for (OT ot : listaOOTT)
									// Se aumenta el contador por cada elemento que cumpla el filtro
									if (ot.getResponsable().equals(valorFiltro))
										total += ot.getCoste();
								// Se devuelve el contador
								return total;
							}
							// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
							// usuario y se devuelve un null
							System.out.println("El valor del filtro tiene un valor o formato incorrecto");
							return null;
						}
						// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
						System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
						return null;
					case "fechaInicio":
						// Se comprueba que el valor del filtro no sea nulo
						if (valorFiltro != null) {
							// Se comprueba que se emplea el formato correcto
							String[] partes = valorFiltro.split("/");
							if (valorFiltro.length() == 8
									&& Character.isDigit(valorFiltro.charAt(0)) && Character.isDigit(valorFiltro.charAt(1))
									&& valorFiltro.charAt(2) == '/'
									&& Character.isDigit(valorFiltro.charAt(3)) && Character.isDigit(valorFiltro.charAt(4))
									&& valorFiltro.charAt(5) == '/'
									&& Character.isDigit(valorFiltro.charAt(6)) && Character.isDigit(valorFiltro.charAt(7))
									&& Integer.valueOf(partes[0]) < 31 && Integer.valueOf(partes[1]) < 12
									&& (Integer.valueOf(partes[0]) <= 28 || Integer.valueOf(partes[1]) != 2) ) {
								// Se recorre la lista
								for (OT ot : listaOOTT)
									// Se aumenta el contador por cada elemento que cumpla el filtro
									if (ot.getFechaInicio().equals(valorFiltro))
										total += ot.getCoste();
								// Se devuelve el contador
								return total;
							}
							// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
							// usuario y se devuelve un null
							System.out.println("El valor del filtro tiene un valor o formato incorrecto");
							return null;
						}
						// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
						System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
						return null;
					case "duracion":
						// Se comprueba que el valor del filtro no sea nulo
						if (valorFiltro != null) {
							iAux = Integer.valueOf(valorFiltro);
							// Se comprueba que se emplea el formato correcto
							if (iAux > 0) {
								// Se recorre la lista
								for (OT ot : listaOOTT)
									// Se aumenta el contador por cada elemento que cumpla el filtro
									if (ot.getDuracion() == iAux)
										total += ot.getCoste();
								// Se devuelve el contador
								return total;
							}
							// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
							// usuario y se devuelve un null
							System.out.println("El valor del filtro tiene un valor o formato incorrecto");
							return null;
						}
						// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
						System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
						return null;
					case "estado":
						// Se comprueba que el valor del filtro no sea nulo
						if (valorFiltro != null) {
							// Se comprueba que se emplea el formato correcto
							if (valorFiltro.length() > 0 && valorFiltro.length() <= 20) {
								// Se recorre la lista
								for (OT ot : listaOOTT)
									// Se aumenta el contador por cada elemento que cumpla el filtro
									if (ot.getEstado().equals(valorFiltro))
										total += ot.getCoste();
								// Se devuelve el contador
								return total;
							}
							// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
							// usuario y se devuelve un null
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
