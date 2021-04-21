package SubsGestionIncidencias;

import java.util.ArrayList;

import ModeladoDeDatos.Incidencia;

public class GestorDeIncidencias implements InterfazGestorIncidencias {

	ArrayList<Incidencia> incidencias;

	// Constructors
	public GestorDeIncidencias(ArrayList<Incidencia> incidencias) {
		super();
		this.incidencias = incidencias;
	}

	public GestorDeIncidencias() {
		super();
		this.incidencias = new ArrayList<>();
	}

	@Override
	public ArrayList<Incidencia> getIncidencias(String campoFiltro, String valorFiltro) {
		ArrayList<Incidencia> resultado = new ArrayList<Incidencia>();
		//si campoFiltro es null, devuelvo todas las incidencias
		if(campoFiltro == null) {
			return this.incidencias;
		}else {
			switch (campoFiltro) {
			case "id":
				// se comprueba que el valor del filtro no sea nulo
				if (valorFiltro != null) {
					// Se comprueba que se emplea el formato correcto
					if (valorFiltro.length() > 0 && valorFiltro.length() <= 20) {
						// Se recorre la lista
						for (Incidencia i : this.incidencias)
							// Se a�ade a la lista "resultado" cada elemento que cumpla el filtro
							if (i.getID().equals(valorFiltro))
								resultado.add(i);
						// Se devuelve el contador
						return resultado;
					} else {
						System.out.println("El valor del filtro tiene un valor o formato incorrecto");
						return null;
					}
				}
					System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
					return null;
			case "nombreCiudadano":
				// Se comprueba que el valor del filtro no sea nulo
					if (valorFiltro != null) {
						// Se comprueba que se emplea el formato correcto
						if (valorFiltro.length() > 0 && valorFiltro.length() <= 25) {
							// Se recorre la lista
							for (Incidencia i : incidencias)
								// Se a�de a la lista el elemento que cumpla el filtro
								if (i.getNombreCiudadano().equals(valorFiltro))
									resultado.add(i);
							// Se devuelve el contador
							return resultado;
						}else {
						// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
						// usuario y se devuelve un null
							System.out.println("El valor del filtro tiene un valor o formato incorrecto");
							return null;
						}
					}					// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
					System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
					return null;
				case "DNI":
					// Se comprueba que el valor del filtro no sea nulo
					if (valorFiltro != null) {
						// Se comprueba que se emplea el formato correcto
						if (valorFiltro.length() == 9 && Character.isDigit(valorFiltro.charAt(0))
								&& Character.isDigit(valorFiltro.charAt(1)) && Character.isDigit(valorFiltro.charAt(2))
								&& Character.isDigit(valorFiltro.charAt(3)) && Character.isDigit(valorFiltro.charAt(4))
								&& Character.isDigit(valorFiltro.charAt(5)) && Character.isDigit(valorFiltro.charAt(6))
								&& Character.isDigit(valorFiltro.charAt(7)) && Character.isLetter(valorFiltro.charAt(8))) {
							// Se recorre la lista
							for (Incidencia i : incidencias)
								// Se a�ade a la lista cada elemento que cumpla el filtro
								if (i.getDNI().equals(valorFiltro))
									resultado.add(i);
							// Se devuelve el contador
							return resultado;
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
							for (Incidencia i : incidencias)
								// Se a�ade a la lista cada elemento que cumpla el filtro
								if (i.getTelefono().equals(valorFiltro))
									resultado.add(i);
							// Se devuelve el contador
							return resultado;
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
							for (Incidencia i : incidencias)
								// Se a�ade al array cada elemento que cumpla el filtro
								if (i.getDescripcion().equals(valorFiltro))
									resultado.add(i);
							// Se devuelve el contador
							return resultado;
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
							for (Incidencia i : incidencias)
								// Se a�ade al array cada elemento que cumpla el filtro
								if (i.getLocalizacion().equals(valorFiltro))
									resultado.add(i);
							// Se devuelve el contador
							return resultado;
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
							for (Incidencia i : incidencias)
								// Se a�ade al array cada elemento que cumpla el filtro
								if (i.getTipo().equals(valorFiltro))
									resultado.add(i);
							// Se devuelve el contador
							return resultado;
						}
						// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
						// usuario y se devuelve un null
						System.out.println("El valor del filtro tiene un valor o formato incorrecto");
						return null;
					}
					// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
					System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
					return null;
				case "proceso":
					// Se comprueba que el valor del filtro no sea nulo
					if (valorFiltro != null) {
						// Se comprueba que se emplea el formato correcto
						if (valorFiltro.length() > 9){
							if(valorFiltro.length() <=50) {
								// Se recorre la lista
								for (Incidencia i : incidencias)
									// Se a�de al array cada elemento que cumpla el filtro
									if (i.getProceso().getNombre().equals(valorFiltro))
										resultado.add(i);
								// Se devuelve el contador
								return resultado;
							}
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
						System.out.println("El campo indicado no existe");
						return null;
			}
		}
	}


	@Override
	public Incidencia crearIncidencia(String DNI, String nombre, String tlf, String descripcion, String localizacion,String tipo) {
		Incidencia inc;
		int dniCount = 0, sum = 0, mod;
		Character minus, mayus;
		// array de letras para comprobar validez de dni seg�n el m�dulo
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		String id;
		// compruebo validez de cada campo por orden
		// compruebo valided del dni
		if (DNI != null) {
			if (DNI.length() == 9) {
				// contamos cuentos numeros hay y los sumamos
				for (int i = 0; i < DNI.length(); i++) {
					if (Character.isDigit(DNI.charAt(i))) {
						dniCount++;
						sum += Integer.valueOf(DNI.charAt(i));
					}
				}
				// si el dni tiene 8 n�meros
				if (dniCount == 8) {
					// comprobamos que el caracter final es una letra
					if (!Character.isAlphabetic(DNI.charAt(DNI.length() - 1))) {
						System.out.println("el dni debe contener 8 n�emros seguidos de una letra");
						return null;
					}
					// comprobamos que la letra es la que le corresponde
					mod = sum % 23;
					// obtenemos la letra esperada
					mayus = letras.charAt(mod);
					// pasamos la letra esperada a minuscula
					minus = letras.toLowerCase().charAt(mod);
					// si la letra introducida no es la esperdada en mayuscula
					if (!mayus.equals(DNI.charAt(DNI.length() - 1))) {
						System.out.println("El dni no tiene un formato v�lido");
						return null;
					}
					// si la letra introducida no es la esperada en minuscula
					else if (!minus.equals(DNI.charAt(DNI.length() - 1))) {
						System.out.println("El dni no tiene un formato v�lido");
						return null;
					} else {
						System.out.println("El dni debe contener 8 cifras");
						return null;
					}
				} else {
					System.out.println("El dni tiene un formato incorrecto");
					return null;
				}
			} else {
				System.out.println("El dni es null");
				return null;
			}
		}
		// compruebo validez del nombre
		if (nombre == null) {
			System.out.println("El nombre es null");
			return null;
			// si tiene longitud menos que 0
		} else if (!(nombre.length() > 0)) {
			System.out.println("El campo nombre est� vac�o");
			return null;
		}
		// si tiene longitud mayor que 25
		else if (!(nombre.length() <= 25)) {
			System.out.println("El campo nombre tiene formato incorrecto");
			return null;
		}

		// compruebo validez del telefono
		if (tlf == null) {
			System.out.println("El telefono es null");
			return null;
		} else if (tlf.length() != 12) {
			System.out.println("El telefono no tiene un formato v�lido");
			return null;
		} else {
			// compruebo que el formato es correcto +012345678912
			if (tlf.charAt(0) != '+') {
				System.out.println("El telefono no tiene un formato v�lido");
				return null;
			}
			// compruebo que todos son digitos
			for (int i = 1; i < 12; i++) {
				// si no es un d�gito, dvuelvo null e informo al usuario
				if (!Character.isDigit(tlf.charAt(i))) {
					System.out.println("El telefono debe contener 12 d�gitos");
					return null;
				}
			}
		}
		// compruebo la descripcion
		if (descripcion != null) {
			if (descripcion.length() > 0) {
				if (descripcion.length() <= 20) {
					// compruebo la localizacion
					if (localizacion != null) {
						if (localizacion.length() > 0) {
							if (localizacion.length() <= 50) {
								// comrpuebo el tipo
								if (tipo != null) {
									if (tipo.length() > 0) {
										if (tipo.length() <= 20) {
											// si todos los campos son v�lidos
											// se instancia la Incidencia
											id = ((Integer) incidencias.size()).toString(); // se le asigna como id, el
																							// numero de incidencias que
																							// hay en el
																							// array
											inc = new Incidencia(id, nombre, DNI, tlf, descripcion, localizacion, tipo);
											// se guarda la incidencia en el array
											incidencias.add(inc);
											// si todos los campos son v�lidos se devuelve la instancia de la incidencia
											return inc;
										}
									}
								}
								System.out.println("El valor tipo tiene un formato no valido");
								return null;
							}
						}
					}
					System.out.println("El valor localizacion tiene un formato no valido");
					return null;
				}
			}
		}
		System.out.println("El valor descripcion tiene un formato no valido");
		return null;
	}

	@Override
	//solo se pueden actualizar los campos correspondientes a localizacion, descripcion y tipo
	public void actualizarIncidencia(String ID, String campo, String valor) {
		Incidencia inc;
		// comprobamos ID
		if (ID != null) {
			// Se comprueba que se emplea el formato correcto
			if (ID.length() > 0 && ID.length() <= 20) {
				// Se recorre la lista
				for (Incidencia i : incidencias) {
					// la incidencia que coincide con el ID se guarda
					if (i.getID().equals(ID)) {
						inc = i;
						
						// si el campo a cambiar es null
						if (campo == null) {
							// aviso al usuario
							System.out.println("El campo especificado es null, no se peude realizar esta acci�n");
						} else {
							//dependiendo del campo introducido
							switch (campo) {
							case "descripcion":
								// Se comprueba que el valor del filtro no sea nulo
								if (valor != null) {
									// Se comprueba que se emplea el formato correcto
									if (valor.length() > 0 && valor.length() <= 200) {
										//Se modifica la incidencia
										inc.setDescripcion(valor);
									}
									// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
									// usuario y se devuelve un null
									System.out.println("El valor del filtro tiene un valor o formato incorrecto");

								}
								// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
								System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");

							case "localizacion":
								// Se comprueba que el valor del filtro no sea nulo
								if (valor != null) {
									// Se comprueba que se emplea el formato correcto
									if (valor.length() > 0 && valor.length() <= 50) {
										// Se recorre la lista
										//Se modifica la incidencia
										inc.setLocalizacion(valor);
									}
									// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
									// usuario y se devuelve un null
									System.out.println("El valor del filtro tiene un valor o formato incorrecto");

								}
								// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
								System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");

							case "tipo":
								// Se comprueba que el valor del filtro no sea nulo
								if (valor != null) {
									// Se comprueba que se emplea el formato correcto
									if (valor.length() > 0 && valor.length() <= 20) {
										//Se modifica la incidencia
										inc.setTipo(valor);
									}
									// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
									// usuario y se devuelve un null
									System.out.println("El valor del filtro tiene un valor o formato incorrecto");
								}
								// Si el valor del filtro es nulo, se informa al usuario y se devuelve un null
								System.out.println("El valor del filtro no puede ser nulo si se ha indicado un campo de filtro");
							case"id":
							case "nombreCiudadano":
							case "dni":
							case "telefono":
								System.out.println("El campo especificado no se puede modificar");
								break;
								
							default:
								System.out.println("El campo indicado no existe");
							}
						}
						
						//finalizamos la funcion
						return;
					}
				}
				
			}
			// Si el valor del filtro tiene un valor o formato incorrecto, se informa al
			// usuario y se devuelve un null
			System.out.println("El valor del ID tiene un valor o formato incorrecto");
		}

	}

	@Override
	public void eliminarIncidencia(String ID) {
		// se comprueba que el valor del filtro no sea nulo
		if (ID != null) {
			// Se comprueba que se emplea el formato correcto
			if (ID.length() > 0 && ID.length() <= 20) {
				// recorremos array de incidencias
				for (Incidencia i : incidencias) {
					// si el ID coincide con el buscado
					if (ID.equals(i.getID())) {
						// se borra del array
						incidencias.remove(i);
						// finalizamos
						return;
					}
				}
				//Avisamos al usuario de que la incidencia no existe
				System.out.println("No existe la incidencia");
			}else {
				//Avisamos al usuario de que el ID no tiene un formato valido
				System.out.println("El ID tiene un formato no valido");
			}

		}else {
			//Avisamos al usuario de que el ID no tiene un formato valido
			System.out.println("El ID tiene un formato no valido");
		}
		
	}
}
