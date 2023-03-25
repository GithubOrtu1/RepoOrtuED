/**
 * 
 */
package PracticaED;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author x100171
 *
 */
public class FileScanner {
	public static void main(String[] args) {
		String ruta = "C:\\\\Users\\\\X100171\\\\OneDrive - Santander Office 365\\\\Desktop\\\\Eclipse-Workspace\\\\PracticaED\\\\src\\\\PracticaED\\\\almacenamiento\\\\escritura.txt";
		File f = new File(ruta);
		System.out.println("La ruta del fichero es: " +f.getAbsolutePath());
		Scanner s;
			try {
				s = new Scanner(f);
				while (s.hasNextLine()) {
					String linea = s.nextLine();
					Scanner sl = new Scanner(linea);
					sl.useDelimiter("\\s*,\\s*");
					System.out.println(sl.next());
					System.out.println(sl.next());
					System.out.println(sl.next());
					System.out.println(sl.next());
					System.out.println(sl.next());
					
				}//while
				s.close();
			} catch (FileNotFoundException e) {
				// PrintWriter pw = null;
				e.printStackTrace();
				// e.printStackTrace(pw);
			}//try
	}//main
}//FileScanner
