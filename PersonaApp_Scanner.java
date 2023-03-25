package PracticaED;

/**
 * Clase PersonaApp_Scanner ejecutable 
 * @version 1.1 25/03/2023 
 * @author eslooj
 */
import java.util.Locale;
import java.util.Scanner;

public class PersonaApp_Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Se muestra el menú para insertar pacientes, visitas o salir
		//
		boolean mostrarMenu=true;
		
		do{
			System.out.println("BASE DE DATOS DE PACIENTES/CONSULTAS v1.1");
			System.out.println("Indique la opción a ejecutar (1,2,3):");
			System.out.println("1. Añadir nuevo paciente");
			System.out.println("2. Añadir nueva visita");
			System.out.println("3. Salir");
			
			//Se captura la opcion
			Scanner opcion = new Scanner(System.in);
			int opcion_menu=opcion.nextInt();
			
			switch(opcion_menu) {
			case 1:
				nuevoPaciente();
			break;
			
			case 2:
				//nuevaVisita();
			break;
			
			case 3:
				System.out.println("Se cierra la aplicacion...");
				mostrarMenu=false;
			break;
			
			default:
				System.out.println("Opción inválida. Vuelva a indicar una opción");
			break;
			
			}
			
		}while(mostrarMenu);
		
		
	}//main
	
		/**
		 * Metodo que indica por consola si la persona tiene peso ideal , por encima o debajo del mismo
		 * @param p Objeto Persona
		 */
		public static void MuestraMensajePeso(Persona p) {
			int IMC = p.calcularIMC();
			switch (IMC) {
			case Persona.PESO_IDEAL:
				System.out.println("La persona esta en su peso ideal");
			break;
			case Persona.INFRAPESO:
				System.out.println("La persona esta por debajo de su peso ideal");
			break;
			case Persona.SOBREPESO:
				System.out.println("La persona esta por encima de su peso ideal");
			break;
			}//switch
		}
		
		//Metodo que añade un nuevo paciente si no esta dado de alta
		public static void nuevoPaciente() {
			
			Scanner sc = new Scanner(System.in);
			sc.useDelimiter("\n");
			sc.useLocale(Locale.US);
			//Introducimos los datos
			System.out.println("Introduce el nombre");
			String nombre = sc.nextLine();
			//Se instancian objetos scanners independientes para cada input por consola
			Scanner sc_edad = new Scanner(System.in);
			System.out.println("Introduce la edad");
			int edad = sc_edad.nextInt();
			Scanner sc_sexo = new Scanner(System.in);
			System.out.println("Introduce el sexo");
			char sexo = sc_sexo.next().charAt(0);
			System.out.println("Introduce el peso");
			Scanner sc_peso = new Scanner(System.in);
			double peso = sc_peso.nextDouble();
			Scanner sc_altura = new Scanner(System.in);
			System.out.println("Introduce la altura");
			double altura = sc_altura.nextDouble();

			//Se añaden calle , localidad y cod_postal
			Scanner sc_calle = new Scanner(System.in);
			System.out.println("Introduce la calle");
			String calle=sc_calle.nextLine();
			Scanner sc_localidad = new Scanner(System.in);
			System.out.println("Introduce la localidad");
			String localidad=sc_localidad.nextLine();
			Scanner sc_codPostal = new Scanner(System.in);
			System.out.println("Introduce el código postal");
			String codPostal=sc_codPostal.nextLine();
			
			//Se tienen todos los datos del paciente. Se genera una nueva persona
			
			Persona personaX = new Persona(nombre, edad, sexo, peso, altura,calle,localidad,codPostal);

			
			//Se comprueba si el DNI de la nueva persona ya existe en el fichero. Si es así no se inserta 
			TratamientoFicheros tf1=new TratamientoFicheros();
			if(tf1.esDNIduplicado(personaX.DNI)) {
				//DNI duplicado. No se inserta
				System.out.println("El paciente ya está registrado...");
			}else{
				//Se inserta el paciente
				tf1.escribeFichero(personaX);
				System.out.println("Se procederá a insertar un nuevo paciente...");
			}
		
			/*
			Persona persona1 = new Persona();
			Persona persona2 = new Persona(nombre, edad, sexo);
			Persona persona3 = new Persona(nombre, edad, sexo, peso, altura);
			persona1.setNombre("Laura");
			persona1.setEdad(30);
			persona1.setSexo('M');
			persona1.setPeso(60);
			persona1.setAltura(1.60);
			persona2.setPeso(90.5);
			persona2.setAltura(1.80);
			System.out.println("Persona1");
			MuestraMensajePeso(persona1);
			System.out.println(persona1.toString());
			System.out.println("Persona2");
			MuestraMensajePeso(persona2);
			System.out.println(persona2.toString());
			System.out.println("Persona3");
			MuestraMensajePeso(persona3);
			System.out.println(persona3.toString());
			*/
		}
		
}//clase PersonaApp_Scanner