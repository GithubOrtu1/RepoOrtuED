package GestionPedidos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MSI
 */
public class DatosClientes {
    
    public String Nombre;
	public String Apellidos;
	public String Tlfno;
	public String Direccion;
	
	
		/**
		 * @param nombre
		 * @param apellidos
		 * @param tlfno
		 * @param direccion
		 */
		DatosClientes (String nombre,String apellidos,String tlfno, String direccion){
			this.Nombre=nombre;
			this.Apellidos=apellidos;
			this.Tlfno=tlfno;
			this.Direccion=direccion;
		}
	
	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return Nombre;
	}
	
	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getApellidos() {
		return Apellidos;
	}
	
	/**
	 * 
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTlfno() {
		return Tlfno;
	}
	
	/**
	 * 
	 * @param tlfno
	 */
	public void setTlfno(String tlfno) {
		Tlfno = tlfno;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDireccion() {
		return Direccion;
	}
	/**
	 * 
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
    
}
