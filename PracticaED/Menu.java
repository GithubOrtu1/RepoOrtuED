package PracticaED;

import java.util.Scanner;

/**
 * 
 * @author MSI
 *
 */
public class Menu {
	
	Menu (){
		
	}
	
	
	public static void mostrarMenuInicial(boolean mostrarMenu) {
		
		do{
			System.out.println("***********************************************");
			System.out.println("* BASE DE DATOS DE PACIENTES/CONSULTAS v3.2.2 *");
			System.out.println("***********************************************");
			System.out.println("");
			System.out.println("Indique la opción a ejecutar (1,2,3):");
			System.out.println("1. Añadir nuevo paciente");
			System.out.println("2. Añadir nueva visita");
			System.out.println("3. Listar las visitas de paciente por profesional (y fecha,opcional)");
			
			
		
			//Se captura la opcion
			Scanner opcion = new Scanner(System.in);
			int opcion_menu=opcion.nextInt();
		
			switch(opcion_menu) {
			case 1:
				PersonaApp_Scanner.nuevoPaciente(false,"");
			break;
		
			case 2:
				PersonaApp_Scanner.nuevaVisita();
			break;
		
			case 3:
				PersonaApp_Scanner.listadoVisitas();
			break;
		
			default:
				System.out.println("Opción inválida. Vuelva a indicar una opción");
			break;
			}
			
		}while(mostrarMenu);

	}//mostrarMenuInicial

}
