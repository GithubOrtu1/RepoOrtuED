/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionPedidos;

import java.util.Date;

/**
 *
 * @author MSI
 */
public abstract class DatosProductos {
    
	public String nombre;
	public String precio;

	
		/**
		 * 
		 * @param nombre
		 * @param precio

		 */
		DatosProductos (String nombre,String precio){
			this.nombre=nombre;
			this.precio=precio;
		}


		/**
		 * @return the nombre
		 */
		public String getNombre() {
			return nombre;
		}


		/**
		 * @param nombre the nombre to set
		 */
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		/**
		 * @return the precio
		 */
		public String getPrecio() {
			return precio;
		}


		/**
		 * @param precio the precio to set
		 */
		public void setPrecio(String precio) {
			this.precio = precio;
		}
	
                
               public abstract String obtenerCaducidad(String fechaEnvase);
               public abstract String detalleProducto();
              
                    
}
