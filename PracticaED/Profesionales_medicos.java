/**
 * 
 */
package PracticaED;

/**
 * @author MSI
 *
 */
public class Profesionales_medicos {
	
	String nombre_completo;
	String dni_medico;
	String localidad;
	String telefono;
	String especialidad;

		
	Profesionales_medicos(String nombre_completo,String dni_medico,String localidad,String telefono,String especialidad){
		this.nombre_completo=nombre_completo;
		this.dni_medico=dni_medico;
		this.localidad=localidad;
		this.telefono=telefono;
		this.especialidad=especialidad;
	}

	/**
	 * @return the nombre_completo
	 */
	public String getNombre_completo() {
		return nombre_completo;
	}


	/**
	 * @param nombre_completo the nombre_completo to set
	 */
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}


	/**
	 * @return the dni_medico
	 */
	public String getDni_medico() {
		return dni_medico;
	}


	/**
	 * @param dni_medico the dni_medico to set
	 */
	public void setDni_medico(String dni_medico) {
		this.dni_medico = dni_medico;
	}


	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}


	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}


	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	/**
	 * @return the especialidad
	 */
	public String getEspecialidad() {
		return especialidad;
	}


	/**
	 * @param especialidad the especialidad to set
	 */
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

}
