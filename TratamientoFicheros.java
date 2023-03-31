/**
 * 
 */
package PracticaED;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author x100171
 *
 */
public class TratamientoFicheros{
	
	//Ruta es global 
	String ruta_pacientes = "C:\\Users\\X100171\\OneDrive - Santander Office 365\\Desktop\\Eclipse-Workspace\\PracticaED\\src\\PracticaED\\almacenamiento\\Pacientes.txt";
	String ruta_visitas = "C:\\Users\\X100171\\OneDrive - Santander Office 365\\Desktop\\Eclipse-Workspace\\PracticaED\\src\\PracticaED\\almacenamiento\\Visitas.txt";
	
	//Metodo de escritura
	
	public void escribeFichero(Persona p) {
	
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			// Añadir flag a true para no machacar contenido del fichero de escritura
			fichero = new FileWriter(ruta_pacientes, true);
			
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
			File f = new File(ruta_pacientes);
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
	
	public String[] mostrarPacientesExistentes() {

		//Se lee el fichero de pacientes
		File f = new File(ruta_pacientes);
		String listaDNI[]=new String[50];

		
		Scanner s;
			try {
				s = new Scanner(f);
				int i=0;
				while (s.hasNextLine()) {
					String linea = s.nextLine();
					Scanner sl = new Scanner(linea);
					sl.useDelimiter("\\s*,\\s*");
				
					//Solo se lee el primer campo de cada linea , que es el DNI
					System.out.println("Paciente "+(i+1)+" DNI :"+sl.next());
					listaDNI[i]=sl.next();
					i++;
					
				}//while
				s.close();
				
				return(listaDNI);
				
			} catch (FileNotFoundException e) {
				// PrintWriter pw = null;
				e.printStackTrace();
				// e.printStackTrace(pw);
			}//try
			return listaDNI;
		
	}//mostrarPacientesExistentes
	
	public void guardaVisita(Persona p) {


		
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			// Añadir flag a true para no machacar contenido del fichero de escritura
			fichero = new FileWriter(ruta_visitas, true);
			
			//Se guardan cada uno de los campos de la visita separados por el delimitador ,
			pw = new PrintWriter(fichero);
			
			//Se genera un objeto tipo Calendar , Date esta deprecated
			Calendar calendario = new GregorianCalendar();
			
			//Se guardan los datos de la visita
			pw.println(p.DNI+","+calendario.get(Calendar.DATE)+","+calendario.get(Calendar.HOUR)+","+p.peso+" kg ,"+p.altura+" m ,"+p.calcularIMC()+" ,");
			
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
		
		System.out.println("Se ha añadido la visita con éxito de este paciente nuevo...");
	
	}//guardaVisita que recibe un objeto Persona
	
	//guardaVisita que recibe parametros y no un objeto Persona
	public void guardaVisita(String dni, float altura_actual ,float peso_actual) {

		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			// Añadir flag a true para no machacar contenido del fichero de escritura
			fichero = new FileWriter(ruta_visitas, true);
			
			//Se guardan cada uno de los campos de la visita separados por el delimitador ,
			pw = new PrintWriter(fichero);
			
			//Se genera un objeto tipo Calendar , Date esta deprecated
			Calendar calendario = new GregorianCalendar();
			
			//Se guardan los datos de la visita
			pw.println(dni+","+calendario.get(Calendar.DATE)+","+calendario.get(Calendar.HOUR)+","+peso_actual+" kg ,"+altura_actual+" m ,"+Persona.calcularIMC(altura_actual,peso_actual)+" , ");
			
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
		
		System.out.println("Se ha añadido la visita con éxito de este paciente existente...");
		
	}//guardaVisita que recibe parametros
	

	
}//TratamientoFicheros
