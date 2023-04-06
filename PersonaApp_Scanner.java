package PracticaED;

/**
 * Clase PersonaApp_Scanner ejecutable 
 * @version 2.1 05/04/2023 
 * @author eslooj
 * Se añade la funcionalidad de guardar visitas. Codigo refactorizado
 */
import java.util.Locale;
import java.util.Scanner;

public class PersonaApp_Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Se muestra el menú para insertar pacientes, visitas o salir

			mostrarMenuInicial(true);
			
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
		public static void nuevoPaciente(boolean insertarVisita,String dni_existente) {
			
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
			//Si el dni viene dado se considera el mismo en lugar del vaor autogenerado
			if(dni_existente!="") {
				personaX.DNI=dni_existente;
			}
			
			//Se comprueba si el DNI de la nueva persona ya existe en el fichero. Si es así no se inserta 
			TratamientoFicheros tf1=new TratamientoFicheros();
			if(tf1.esDNIduplicado(personaX.DNI)) {
				//DNI duplicado. No se inserta
				System.out.println("El paciente ya está registrado...");
			}else{
				//Se muestran los datos del nuevo paciente
				System.out.println(personaX.toString());
				
				//Se guardan los datos del paciente en el fichero
				System.out.println("Se procederá a insertar un nuevo paciente...");
				tf1.escribeFichero(personaX);
			}
			
			if(dni_existente!="") {
				personaX.DNI=dni_existente;
			}
			
			//Si insertarVisita es true se guarda la visita
			if(insertarVisita){
				//Se calcula el IMC y se guarda la visita
				int calculo_IMC=personaX.calcularIMC();
				tf1.guardaVisita(personaX);
			}
			
		}//nuevoPaciente
		
		//Metodo que añade una nueva visita
		public static void nuevaVisita() {
			
		//Se pide al usuario que nos indique el DNI para comprobar si se trata de un paciente nuevo o no
		String dni_paciente=new String();
		boolean existePaciente=false;
		System.out.println("Indique el DNI del paciente: ");
		Scanner sc_dni=new Scanner(System.in);
		dni_paciente=sc_dni.nextLine();
		
		//Se comprueba si existe o no como paciente
		TratamientoFicheros tf2=new TratamientoFicheros();
		existePaciente=tf2.esDNIduplicado(dni_paciente);
		//Se devuelve true si ya existe el paciente , se inserta la visita
		
		if(existePaciente) {
			//Se inserta una nueva visita pidiendo la altura y peso
			System.out.println("El paciente ya estaba registrado en el sistema...");
			Scanner sc_altura=new Scanner(System.in);
			float altura;
			System.out.println("Indique la altura : ");
			altura=sc_altura.nextFloat();
			
			Scanner sc_peso=new Scanner(System.in);
			float peso;
			System.out.println("Indique el peso : ");
			peso=sc_peso.nextFloat();
			
			TratamientoFicheros tf3=new TratamientoFicheros();
			tf3.guardarVisita(dni_paciente,altura,peso);
			
		}else {
			//Se trata de un paciente nuevo. Se llama a nuevoPaciente con DNI vacio
			nuevoPaciente(true,"");
		}			
			
		}//nuevaVisita
		
		public static void mostrarMenuInicial(boolean mostrarMenu) {
			
			do{
				System.out.println("***********************************************");
				System.out.println("** BASE DE DATOS DE PACIENTES/CONSULTAS v2.1 **");
				System.out.println("***********************************************");
				System.out.println("");
				System.out.println("Indique la opción a ejecutar (1,2,3):");
				System.out.println("1. Añadir nuevo paciente");
				System.out.println("2. Añadir nueva visita");
				System.out.println("3. Salir");
			
				//Se captura la opcion
				Scanner opcion = new Scanner(System.in);
				int opcion_menu=opcion.nextInt();
			
				switch(opcion_menu) {
				case 1:
					nuevoPaciente(false,"");
				break;
			
				case 2:
					nuevaVisita();
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

		}//mostrarMenuInicial
		
		
}//clase PersonaApp_Scanner