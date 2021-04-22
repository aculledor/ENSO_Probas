package SubsGestionOOTT;

import java.util.ArrayList;
import java.util.List;

import ModeladoDeDatos.OT;
import ModeladoDeDatos.Proceso;

public class GestorDeOOTT implements InterfazGestorOOTT {

	ArrayList<OT> ots;

	// Constructors
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
		ArrayList<OT> resultado = new ArrayList<>();

		if (campoFiltro == null) {
			return this.ots;
		}

		if (campoFiltro.length() <= 0) {
			System.out.println("El campo introducido no es válido.");
			return null;
		}

		if (valorFiltro == null || valorFiltro.length() <= 0) {
			System.out.println("El valor introducido no es válido.");
			return null;
		}

		if (this.ots.isEmpty()) {
			System.out.println("No hay OOTT almacenadas todavía.");
			return null;
		}

		switch (campoFiltro) {
		case "id":
			if (valorFiltro.length() > 20 || Integer.parseInt(valorFiltro) < 0) {
				System.out.println("El ID introducido es incorrecto.");
				return null;
			}

			for (OT ot : this.ots) {
				if (ot.getID().equals(valorFiltro)) {
					resultado.add(ot);
				}
			}
			return resultado;

		case "descripcion":
			if (valorFiltro.length() > 200) {
				System.out.println("La descripcion introducida tiene más de 200 caracteres.");
				return null;
			}

			for (OT ot : this.ots) {
				if (ot.getDescripcion().equals(valorFiltro)) {
					resultado.add(ot);
				}
			}
			return resultado;

		case "material":
			if (valorFiltro.length() > 30) {
				System.out.println("El material introducido tiene más de 30 caracteres.");
				return null;
			}

			for (OT ot : this.ots) {
				for (String mat : ot.getMaterial()) {
					if (mat.equals(valorFiltro)) {
						resultado.add(ot);
					}
				}
			}
			return resultado;

		case "presupuestos":
			if (Double.parseDouble(valorFiltro) < 0) {
				System.out.println("El presupuesto introducido no es correcto.");
				return null;
			}

			for (OT ot : this.ots) {
				for (Double pr : ot.getPresupuestos()) {
					if (pr.equals(valorFiltro)) {
						resultado.add(ot);
					}
				}
			}
			return resultado;

		case "coste":
			if (Float.parseFloat(valorFiltro) <= 0) {
				System.out.println("El coste introducido no es correcto.");
				return null;
			}

			for (OT ot : this.ots) {
				if (ot.getCoste() == Float.parseFloat(valorFiltro)) {
					resultado.add(ot);
				}
			}
			return resultado;

		case "responsable":
			if (valorFiltro.length() > 20) {
				System.out.println("El responsable introducido tiene más de 20 caracteres.");
				return null;
			}

			for (OT ot : this.ots) {
				if (ot.getResponsable().equals(valorFiltro)) {
					resultado.add(ot);
				}
			}
			return resultado;

		case "personal":
			if (valorFiltro.length() != 9) {
				System.out.println("El DNI introducido no es correcto.");
				return null;
			}

			for (OT ot : this.ots) {
				for (String p : ot.getPersonal()) {
					if (p.equals(valorFiltro)) {
						resultado.add(ot);
					}
				}
			}
			return resultado;

		case "fechaInicio":
			String[] partes = valorFiltro.split("/");
			if (valorFiltro.length() == 8 && Character.isDigit(valorFiltro.charAt(0))
					&& Character.isDigit(valorFiltro.charAt(1)) && valorFiltro.charAt(2) == '/'
					&& Character.isDigit(valorFiltro.charAt(3)) && Character.isDigit(valorFiltro.charAt(4))
					&& valorFiltro.charAt(5) == '/' && Character.isDigit(valorFiltro.charAt(6))
					&& Character.isDigit(valorFiltro.charAt(7)) && Integer.valueOf(partes[0]) < 31
					&& Integer.valueOf(partes[1]) < 12
					&& (Integer.valueOf(partes[0]) <= 28 || Integer.valueOf(partes[1]) != 2)) {

				for (OT ot : this.ots) {
					if (ot.getFechaInicio().equals(valorFiltro)) {
						resultado.add(ot);
					}
				}
			}

			return resultado;

		case "duracion":
			if (Integer.parseInt(valorFiltro) <= 0) {
				System.out.println("La duracion introducida no es correcta.");
				return null;
			}

			for (OT ot : this.ots) {
				if (ot.getDuracion() == Integer.parseInt(valorFiltro)) {
					resultado.add(ot);
				}
			}
			return resultado;

		case "estado":
			if (valorFiltro.length() > 20) {
				System.out.println("El estado introducido tiene más de 20 caracteres.");
				return null;
			}

			for (OT ot : this.ots) {
				if (ot.getEstado().equals(valorFiltro)) {
					resultado.add(ot);
				}
			}
			return resultado;

		case "proceso":
			if (valorFiltro.length() <= 9 || valorFiltro.length() > 50) {
				System.out.println("El nombre de proceso introducido no es valido.");
				return null;
			}

			for (OT ot : this.ots) {
				if (ot.getProceso().getNombre().equals(valorFiltro)) {
					resultado.add(ot);
				}
			}

			return resultado;

		default:
			System.out.println("El campo indicado no existe.");
			return null;
		}

	}

	@Override
	public OT crearOT(String descripcion, List<String> material, List<Double> presupuestos, Float coste,
			String responsable, List<String> personal, String fechaInicio, Integer duracion, String estado,
			Proceso proceso) {
		// TODO Auto-generated method stub
		OT ot = null;
		if (descripcion != null && descripcion.length() > 0 && descripcion.length() <= 200) {
			if (material != null && !material.isEmpty()) {
				for (int i = 0; i < material.size(); i++) {
					if (material.get(i).length() <= 0 || material.get(i).length() > 30) {
						System.out
								.println("Algún material de los introducidos está vacío o tiene más de 30 caracteres");
						return null;
					}
					if (material.get(i) == null) {
						System.out.println("Algún material de los introducidos es nulo.");
						return null;
					}
				}
				if (presupuestos != null) {
					for (int i = 0; i < presupuestos.size(); i++) {
						if (presupuestos.get(i) == null) {
							System.out.println("Algún presupuesto de los introducidos es nulo.");
							return null;
						}
						if (presupuestos.get(i) < 0) {
							System.out.println("Algún presupuesto de los introducidos es menor de 0.");
							return null;
						}
					}
					if (coste != null && coste > 0) {
						if (responsable != null && responsable.length() > 0 && responsable.length() <= 20) {
							if (personal != null && !personal.isEmpty()) {
								for (int i = 0; i < personal.size(); i++) {
									if (personal.get(i) == null) {
										System.out.println("Algún personal de los introducidos es nulo.");
										return null;
									}
									if (personal.get(i).length() <= 0) {
										System.out.println("Algún personal de los introducidos está vacío.");
										return null;
									}
									if (personal.get(i).length() != 9) {
										System.out.println(
												"Algún personal de los introducidos no contiene los 9 caracteres.");
										return null;
									}
									// comprobar que los DNIs sean correctos
									int nums = 0;
									String DNI = personal.get(i);
									// si ya empieza por letra, es incorrecto
									if (Character.isAlphabetic(DNI.charAt(0))) {
										System.out.println(
												"Algún DNI de personal es incorrecto (empieza por una letra).");
										return null;
									}
									for (int j = 0; j < personal.get(i).length(); j++) {

										if (Character.isDigit(DNI.charAt(j))) {
											nums++;
										}
									}
									if (nums != 8) {
										System.out.println(
												"Algún DNI de personal es incorrecto (no contiene 8 números).");
										return null;
									} else {
										if (!Character.isAlphabetic(DNI.charAt(DNI.length() - 1))) {
											System.out.println(
													"Algún DNI de personal es incorrecto (no contiene letra).");
											return null;
										}
									}
								}
								if (fechaInicio != null) {
									String[] partes = fechaInicio.split("/");
									if (fechaInicio.length() == 8 && Character.isDigit(fechaInicio.charAt(0))
											&& Character.isDigit(fechaInicio.charAt(1)) && fechaInicio.charAt(2) == '/'
											&& Character.isDigit(fechaInicio.charAt(3))
											&& Character.isDigit(fechaInicio.charAt(4)) && fechaInicio.charAt(5) == '/'
											&& Character.isDigit(fechaInicio.charAt(6))
											&& Character.isDigit(fechaInicio.charAt(7))
											&& Integer.valueOf(partes[0]) < 31 && Integer.valueOf(partes[1]) < 12
											&& (Integer.valueOf(partes[0]) <= 28 || Integer.valueOf(partes[1]) != 2)) {
										if (duracion != null && duracion > 0) {
											if (estado.length() > 0 && estado != null && estado.length() <= 20) {
												if (proceso != null) {
													ArrayList<Float> presupuestos1 = new ArrayList<>();
													ot = new OT(((Integer) this.ots.size()).toString(), descripcion,
															new ArrayList<String>(material),
															new ArrayList<Double>(presupuestos), coste, responsable,
															new ArrayList<String>(personal), fechaInicio, duracion,
															estado, proceso);
													ots.add(ot);
													return ot;
												} else {
													System.out.println("El proceso proporcionado es null.");
													return null;
												}
											} else {
												System.out.println("El valor de 'estado' es incorrecto (nulo o vacío)");
												return null;
											}
										} else {
											System.out.println(
													"El valor de 'duracion' es incorrecto (nulo/menor o igual a 0).");
											return null;
										}
									} else {
										System.out.println(
												"El valor de 'fechaInicio' tiene un formato incorrecto o valores no válidos.");
										return null;
									}
								} else {
									System.out.println("El valor de 'fechaInicio' es incorrecto (nulo)");
									return null;
								}
							} else {
								System.out.println("El valor de 'personal' es incorrecto (nulo o vacío)");
								return null;
							}
						} else {
							System.out.println("El valor de 'responsable' es incorrecto (nulo o vacío)");
							return null;
						}
					} else {
						System.out.println("El valor de 'coste' es incorrecto (nulo o menor de 0)");
						return null;
					}
				} else {
					System.out.println("El valor de 'presupuestos' es incorrecto (nulo)");
					return null;
				}
			} else {
				System.out.println("El valor de 'material' es incorrecto (nulo o vacío)");
				return null;
			}
		} else {
			System.out.println("El valor de 'descripcion' es incorrecto (nulo o vacío)");
			return null;
		}
	}

	@Override
	public void actualizarOT(String ID, String campo, String valor) {
		// TODO Auto-generated method stub
		OT ot = null;
		if (ID == null || ID.length() <= 0 || ID.length() > 20 || Integer.parseInt(ID) < 0) {
			System.out.println("El ID introducido es incorrecto.");
			return;
		}

		for (int i = 0; i < this.ots.size(); i++) {
			if (this.ots.get(i).getID().equals(ID)) {
				ot = this.ots.get(i);
			}
		}
		if (ot == null) {
			System.out.println("No existe ninguna OT con el ID proporcionado.");
			return;
		}

		if (campo == null || campo.length() <= 0) {
			System.out.println("El campo a cambiar es nulo o vacío");
			return;
		}

		if (valor == null || valor.length() <= 0) {
			System.out.println("El valor a cambiar es nulo o vacío");
			return;
		}

		switch (campo) {
		case "descripcion":
			if (valor.length() <= 200) {
				ot.setDescripcion(valor);
			} else {
				System.out.println("La descripcion introducida sobrepasa los 200 caracteres.");
			}
			break;
		case "material":
			if (valor.length() <= 30) {
				ot.getMaterial().add(campo);
				ot.setMaterial(ot.getMaterial());
			} else {
				System.out.println("El material introducido sobrepasa los 30 caracteres.");
			}
			break;
		case "presupuestos":
			if (Double.parseDouble(valor) >= 0) {
				ot.getPresupuestos().add(Double.parseDouble(valor));
				ot.setPresupuestos(ot.getPresupuestos());
			} else {
				System.out.println("El presupuesto introducido es negativo.");
			}
			break;
		case "coste":
			if (Float.parseFloat(valor) > 0) {
				ot.setCoste(Float.parseFloat(valor));
			} else {
				System.out.println("El coste introducido es menor o igual que 0.");
			}
			break;
		case "responsable":
			if (valor.length() <= 20) {
				ot.setResponsable(valor);
			} else {
				System.out.println("El responsable introducido sobrepasa los 20 caracteres");
			}
			break;
		case "personal":
			if (valor.length() != 9) {
				System.out.println("El personal de los introducidos no contiene los 9 caracteres.");
				return;
			}

			int nums = 0;
			// si ya empieza por letra, es incorrecto
			if (Character.isAlphabetic(valor.charAt(0))) {
				System.out.println("El DNI de personal introducido es incorrecto (empieza por una letra).");
				return;
			}

			for (int j = 0; j < valor.length(); j++) {
				if (Character.isDigit(valor.charAt(j))) {
					nums++;
				}
				if (j != valor.length() - 1) {
					if (Character.isAlphabetic(valor.charAt(j))) {
						System.out.println("El DNI de personal introducido es incorrecto: la letra no esta al final.");
						return;
					}
				}
			}
			if (nums != 8) {
				System.out.println("El DNI de personal introducido es incorrecto (no contiene 8 números).");
				return;
			} else {
				if (!Character.isAlphabetic(valor.charAt(valor.length() - 1))) {
					System.out.println("El DNI de personal introducido es incorrecto (no contiene letra).");
					return;
				}
			}
			ot.getPersonal().add(valor);
			ot.setPersonal(ot.getPersonal());
			break;
		case "fechaInicio":
			String[] partes = valor.split("/");
			if (valor.length() == 8 && Character.isDigit(valor.charAt(0)) && Character.isDigit(valor.charAt(1))
					&& valor.charAt(2) == '/' && Character.isDigit(valor.charAt(3))
					&& Character.isDigit(valor.charAt(4)) && valor.charAt(5) == '/'
					&& Character.isDigit(valor.charAt(6)) && Character.isDigit(valor.charAt(7))
					&& Integer.valueOf(partes[0]) < 31 && Integer.valueOf(partes[1]) < 12
					&& (Integer.valueOf(partes[0]) <= 28 || Integer.valueOf(partes[1]) != 2)) {
				ot.setFechaInicio(valor);
			} else {
				System.out.println("La fecha introducida es incorrecta.");
			}
			break;
		case "duracion":
			if (Integer.parseInt(valor) > 0) {
				ot.setDuracion(Integer.parseInt(valor));
			} else {
				System.out.println("La duracion introducida es incorrecta.");
			}
			break;
		case "estado":
			if (valor.length() <= 20) {
				ot.setEstado(valor);
			} else {
				System.out.println("El estado introducido sobrepasa los 20 caracteres.");
			}
			break;
		default:
			System.out.println("El campo indicado es incorrecto.");
			break;
		}

	}

	@Override
	public void incluirPresupuesto(String ID, Float presupuesto) {
		// TODO Auto-generated method stub
		if (ID.length() <= 0 || ID.length() > 20 || Integer.parseInt(ID) < 0 || ID == null) {
			System.out.println("El ID introducido es incorrecto.");
			return;
		}

		if (presupuesto < 0) {
			System.out.println("El presupuesto introducido es incorrecto.");
			return;
		}

		boolean introducido = false;
		for (OT ot : this.ots) {
			if (ot.getID().equals(ID)) {
				Double p = (double) presupuesto;
				ot.getPresupuestos().add(p);
				ot.setPresupuestos(ot.getPresupuestos());
				introducido = true;
			}
		}

		if (introducido) {
			System.out.println("Se ha introducido el presupuesto.");
		} else {
			System.out.println("La OT con el ID introducido no existe.");
		}
	}

	@Override
	public void retirarPresupuesto(String ID, Float presupuesto) {
		// TODO Auto-generated method stub
		if (ID.length() <= 0 || ID.length() > 20 || Integer.parseInt(ID) < 0 || ID == null) {
			System.out.println("El ID introducido es incorrecto.");
			return;
		}

		if (presupuesto < 0) {
			System.out.println("El presupuesto introducido es incorrecto.");
			return;
		}

		boolean deleted = false;

		for (OT ot : this.ots) {
			if (ot.getID().equals(ID)) {
				for (int i=0;i<ot.getPresupuestos().size();i++) {
					if (ot.getPresupuestos().get(i) == (double) presupuesto) {
						ot.getPresupuestos().remove(i);
						ot.setPresupuestos(ot.getPresupuestos());
						deleted = true;
					}
				}
			}
		}

		if (deleted) {
			System.out.println("Se ha eliminado el presupuesto indicado.");
		} else {
			System.out.println("La OT con el ID introducido/presupuesto introducido no existe");
		}
	}

	@Override
	public void incluirMaterial(String ID, String material) {
		// TODO Auto-generated method stub
		if (ID.length() <= 0 || ID.length() > 20 || Integer.parseInt(ID) < 0 || ID == null) {
			System.out.println("El ID introducido es incorrecto.");
			return;
		}

		if (material.length() <= 0 || material.length() > 30 || material == null) {
			System.out.println("El material introducido es incorrecto.");
			return;
		}

		boolean introducido = false;

		for (OT ot : this.ots) {
			if (ot.getID().equals(ID)) {
				ot.getMaterial().add(material);
				ot.setMaterial(ot.getMaterial());
				introducido = true;
			}
		}

		if (introducido) {
			System.out.println("Se ha introducido el material.");
		} else {
			System.out.println("No existe la OT con el ID introducido.");
		}
	}

	@Override
	public void retirarMaterial(String ID, String material) {
		// TODO Auto-generated method stub
		if (ID.length() <= 0 || ID.length() > 20 || Integer.parseInt(ID) < 0 || ID == null) {
			System.out.println("El ID introducido es incorrecto.");
			return;
		}

		if (material.length() <= 0 || material.length() > 30 || material == null) {
			System.out.println("El material introducido es incorrecto.");
			return;
		}

		boolean deleted = false;

		for (OT ot : this.ots) {
			if (ot.getID().equals(ID)) {
				for (int i=0;i<ot.getMaterial().size();i++) {
					if (ot.getMaterial().get(i).equals(material)) {
						ot.getMaterial().remove(i);
						ot.setMaterial(ot.getMaterial());
						deleted = true;
					}
				}
			}
		}

		if (deleted) {
			System.out.println("Se ha eliminado el material.");
		} else {
			System.out.println("La OT con el ID introducido/material introducido no existe.");
		}
	}

	@Override
	public void incluirPersonal(String ID, String empleado) {
		// TODO Auto-generated method stub
		if (empleado.length() != 9 || empleado == null) {
			System.out.println("El DNI introducido es incorrecto.");
			return;
		}

		if (ID.length() <= 0 || ID.length() > 20 || Integer.parseInt(ID) < 0 || ID == null) {
			System.out.println("El ID introducido es incorrecto.");
			return;
		}

		int nums = 0;
		// si ya empieza por letra, es incorrecto
		if (Character.isAlphabetic(empleado.charAt(0))) {
			System.out.println("El DNI introducido es incorrecto (empieza por una letra).");
			return;
		}

		for (int j = 0; j < empleado.length(); j++) {
			if (Character.isDigit(empleado.charAt(j))) {
				nums++;
			}
			if (j != empleado.length() - 1) {
				if (Character.isAlphabetic(empleado.charAt(j))) {
					System.out.println("El DNI introducido es incorrecto: la letra no esta al final.");
					return;
				}
			}
		}

		if (nums != 8) {
			System.out.println("El DNI introducido es incorrecto (no contiene 8 números).");
			return;
		} else {
			if (!Character.isAlphabetic(empleado.charAt(empleado.length() - 1))) {
				System.out.println("El DNI introducido es incorrecto (no contiene letra).");
				return;
			}
		}

		boolean introducido = false;

		for (OT ot : this.ots) {
			if (ot.getID().equals(ID)) {
				ot.getPersonal().add(empleado);
				ot.setPersonal(ot.getPersonal());
				introducido = true;
			}
		}

		if (introducido) {
			System.out.println("Se ha introducido el empleado.");
		} else {
			System.out.println("No existe la OT con el ID indicado.");
		}
	}

	@Override
	public void retirarPersonal(String ID, String empleado) {
		// TODO Auto-generated method stub
		if (ID.length() <= 0 || ID.length() > 20 || Integer.parseInt(ID) < 0 || ID == null) {
			System.out.println("El ID introducido es incorrecto.");
			return;
		}

		if (empleado == null || empleado.length() == 0) {
			System.out.println("El empleado introducido es nulo o vacío.");
			return;
		}

		boolean deleted = false;

		for (OT ot : this.ots) {
			if (ot.getID().equals(ID)) {
				for (int i=0;i<ot.getPersonal().size();i++) {
					if (ot.getPersonal().get(i).equals(empleado)) {
						ot.getPersonal().remove(i);
						ot.setPersonal(ot.getPersonal());
						deleted = true;
					}
				}
			}

		}

		if (deleted) {
			System.out.println("Se ha retirado el empleado.");
		} else {
			System.out.println("La OT con el ID introducido/personal indicado no existe.");
		}

	}

	@Override
	public void eliminarOT(String ID) {
		// TODO Auto-generated method stub
		if (ID.length() <= 0 || ID.length() > 20 || Integer.parseInt(ID) < 0 || ID == null) {
			System.out.println("El ID introducido es incorrecto.");
			return;
		}

		boolean deleted = false;

		for (OT ot : this.ots) {
			if (ot.getID().equals(ID)) {
				this.ots.remove(ot);
				deleted = true;
			}
		}

		if (deleted) {
			System.out.println("Se ha borrado la OT.");
		} else {
			System.out.println("La OT con el ID indicado no existe.");
		}
	}

	@Override
	public Double consultarPreciosAcumulados(String campoFiltro, String valorFiltro) {
		// TODO Auto-generated method stub
		float total = 0;

		if (campoFiltro == null && valorFiltro==null) {

			for (OT ot : this.ots) {
				total += ot.getCoste();
			}
			return (double) total;
		}
		
		if (this.ots.isEmpty()) {
			System.out.println("Todavia no hay OOTT guardadas.");
			return null;
		}

		if (valorFiltro == null && campoFiltro!=null) {
			System.out.println("No se ha proporcionado ningún valor de filtrado.");
			return null;
		}

		switch (campoFiltro) {

		case "responsable":
			if (valorFiltro.length() > 20) {
				System.out.println("El nombre del responsable/empresa introducido es incorrecto.");
				return null;
			}

			for (OT ot : this.ots) {
				if (ot.getResponsable().equals(valorFiltro)) {
					total += ot.getCoste();
				}
			}
			return (double) total;

		case "proceso":
			if (valorFiltro.length() <= 9 || valorFiltro.length() > 50) {
				System.out.println("El nombre de proceso introducido no es valido.");
				return null;
			}

			for (OT ot : this.ots) {
				if (ot.getProceso().getNombre().equals(valorFiltro)) {
					total += ot.getCoste();
				}
			}
			return (double) total;
		}
		return null;
	}

}
