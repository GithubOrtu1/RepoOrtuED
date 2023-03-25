/**
 * 
 */
package PracticaED;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author x100171
 *
 */
public class LeerFichero {

	/**
	 * @param args
	 */
	public static void muestraContenido(String archivo) throws
		FileNotFoundException, IOException {
		String cadena;
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		while ((cadena = b.readLine()) != null) {
			System.out.println(cadena);
		}
			b.close();
		}
	public static void main(String[] args) throws IOException {
		String ruta = "C:\\\\Users\\\\X100171\\\\OneDrive - Santander Office 365\\\\Desktop\\\\Eclipse-Workspace\\\\PracticaED\\\\src\\\\PracticaED\\\\almacenamiento\\\\escritura.txt";
		muestraContenido(ruta);
	}//main
}//LeerFichero
