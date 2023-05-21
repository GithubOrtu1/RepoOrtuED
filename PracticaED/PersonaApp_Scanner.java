package PracticaED;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;

/**
 * Clase PersonaApp_Scanner ejecutable 
 * @version 3.2.2 16/05/2023 
 * @author eslooj
 * Se añade la funcionalidad de guardado en BBDD
 * Se permite listar visitas por paciente/profesional y fecha
 */


public class PersonaApp_Scanner {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			//Se carga el fichero de configuración
		
			Config configuracion=new Config();
			configuracion.leerConfig();
			
			//Se muestra el menú para insertar pacientes, visitas o salir
			Menu menu_inicial=new Menu();
			menu_inicial.mostrarMenuInicial(true);
			
			
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
			//Si el dni viene dado se considera el mismo en lugar del valor autogenerado
			if(dni_existente!="") {
				personaX.DNI=dni_existente;
			}
						
			//TratamientoFicheros tf1=new TratamientoFicheros();
			
			TestConexion newConnection=new TestConexion();
			
			//Se comprueba si el DNI de la nueva persona ya existe en el BBDD. Si es así no se inserta
			
			if(newConnection.consulta_select_esDuplicado(personaX.DNI)) {
				//DNI duplicado. No se inserta
				System.out.println("El paciente ya está registrado . No se ha insertado el mismo...\n");
			}else{
				//Se muestran los datos del nuevo paciente
				System.out.println(personaX.toString());
				//Se inserta en BBDD..
				newConnection.consulta_insert_pacientes(personaX.DNI,personaX.nombre,personaX.edad,personaX.calle,personaX.localidad,personaX.codPostal);
				//tf1.escribeFichero(personaX);
			}
			
			
			if(dni_existente!="") {
				personaX.DNI=dni_existente;
			}
			
			//Si insertarVisita es true se guarda la visita
			
			if(insertarVisita){
				
				//Se calcula el IMC y se guarda la visita
				//tf1.guardaVisita(personaX);
				
				
				LocalDateTime dateTime = LocalDateTime.now();
				DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
				dateTime.format(formatters);
				
				//Se muestran y se guardan los datos de la visita
				System.out.println("Los datos de la visita son:");
				System.out.println(personaX.DNI+","+dateTime+","+personaX.peso+" kg ,"+personaX.altura+" m ,"+personaX.calcularIMC()+" ,");
				System.out.println("El listado de profesionales medicos disponibles es: \n");
				newConnection.consulta_select_esDuplicado("");
				Scanner sc_codProfesional = new Scanner(System.in);
				boolean res=newConnection.consulta_select_esDuplicado("");
				System.out.println("Indique el codigo del profesional aspociado a la visita: \n");
				String codProfesional=sc_codProfesional.nextLine();
				newConnection.consulta_insert_visitas(personaX.DNI,dateTime,personaX.peso,personaX.altura,personaX.calcularIMC(),Integer.parseInt(codProfesional));
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
		//Se devuelve true si ya existe el paciente , se inserta la visita
		
		TestConexion newConnection2=new TestConexion();
		if(newConnection2.consulta_select_esDuplicado(dni_paciente)) {
			//Se inserta una nueva visita pidiendo la altura y peso
			System.out.println("El paciente ya estaba registrado en el sistema...\n");
			Scanner sc_altura=new Scanner(System.in);
			float altura;
			System.out.println("Indique la altura : ");
			altura=sc_altura.nextFloat();
			
			Scanner sc_peso=new Scanner(System.in);
			float peso;
			System.out.println("Indique el peso : ");
			peso=sc_peso.nextFloat();
			
			//TratamientoFicheros tf3=new TratamientoFicheros();
			//tf3.guardarVisita(dni_paciente,altura,peso);
			System.out.println("El listado de profesionales medicos disponibles es: \n");
			Scanner sc_codProfesional = new Scanner(System.in);
			boolean res=newConnection2.consulta_select_esDuplicado("");
			System.out.println("Indique el codigo del profesional asociado a la visita: \n");
			String cod_profesional=sc_codProfesional.nextLine();
			
			newConnection2.consulta_insert_visitas_paciente_existente(dni_paciente,altura,peso,cod_profesional);
			
		}else {
			//Se trata de un paciente nuevo. Se llama a nuevoPaciente con DNI informado
			nuevoPaciente(true,dni_paciente);
		}			
			
		}//nuevaVisita
		
		public static void listadoVisitas() {
			
			//Se toma el dni del paciente y el cod_profesional por consola
			
			TestConexion newConnection3=new TestConexion();
			
			Scanner sc_dni_paciente = new Scanner(System.in);
			System.out.println("Indique el dni del paciente: ");
			String dni_paciente=sc_dni_paciente.nextLine();
			Scanner sc_cod_profesional = new Scanner(System.in);
			System.out.println("El listado de profesionales medicos disponibles es: \n");
			boolean res=newConnection3.consulta_select_esDuplicado("");
			System.out.println("Indique el codigo de profesional: ");
			String cod_profesional=sc_cod_profesional.nextLine();
			System.out.println("¿Filtrar también por fecha (S/N)?: ");
			Scanner sc_filtrar_Fecha=new Scanner(System.in);
			String filtrar_Fecha=sc_filtrar_Fecha.nextLine();
			
			String fecha_filtrar;
			
			if((filtrar_Fecha.charAt(0)=='s')|| (filtrar_Fecha.charAt(0)=='S')) {
				Scanner sc_fecha = new Scanner(System.in);
				System.out.println("Indique la fecha (yyyy-MM-dd): ");
				fecha_filtrar=sc_fecha.nextLine();
			}else {
				fecha_filtrar = "";	
			}
			
			//Se llama a la consulta del listado en BBDD...
			
			newConnection3.consulta_select_listado(dni_paciente,cod_profesional,fecha_filtrar);
				
		}//listadoVisitas
		
}//clase PersonaApp_Scanner