/**
 * 
 */
package PracticaED;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author x100171
 *
 */
public class TratamientoFicheros{
	
	//Ruta es global 
	String ruta = "C:\\Users\\X100171\\OneDrive - Santander Office 365\\Desktop\\Eclipse-Workspace\\PracticaED\\src\\PracticaED\\almacenamiento\\Pacientes.txt";
	
	//Metodo de escritura
	
	public void escribeFichero(Persona p) {
	
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			// Añadir flag a true para no machacar contenido del fichero de escritura
			fichero = new FileWriter(ruta, true);
			
			//Se guardan cada uno de los campos del paciente separados por el delimitador ,
			pw = new PrintWriter(fichero);
			/*
			for (int i = 0; i < 10; i++) {
				pw.println("Coche " + i);
				
			}*/
			pw.println(p.DNI+","+p.nombre+","+p.edad+","+p.calle+","+p.localidad+","+p.codPostal+",");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
					// Nuevamente aprovechamos el finally para
					// asegurarnos que se cierra el fichero.
				if (null != fichero) {
					fichero.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}//try
		}//finally
	
	}//escribeFichero
	
	public boolean esDNIduplicado(String dni){
			File f = new File(ruta);
			//System.out.println("La ruta del fichero es: " +f.getAbsolutePath());
			String dniOriginal;
			dniOriginal=dni;
			
			Scanner s;
				try {
					s = new Scanner(f);
					while (s.hasNextLine()) {
						String linea = s.nextLine();
						Scanner sl = new Scanner(linea);
						sl.useDelimiter("\\s*,\\s*");
					
						//System.out.println(sl.next());
						//System.out.println(sl.next());
						//System.out.println(sl.next());
						//System.out.println(sl.next());
						
						//Solo se lee el primer campo de cada linea del fichero , que es el DNI
						if(dniOriginal.equals(sl.next())) {
							//Se encuentra duplicidad
							return(true);
						}
						
					}//while
					s.close();
				} catch (FileNotFoundException e) {
					// PrintWriter pw = null;
					e.printStackTrace();
					// e.printStackTrace(pw);
				}//try
				
							//Si se llega aqui no se ha encontrado duplicidad
							return(false);
				
	}//comprobarDNIexistente

}//TratamientoFicheros
