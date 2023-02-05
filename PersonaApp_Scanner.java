package PracticaED;

/**
 * Clase PersonaApp_Scanner ejecutable 
 * @version 0.0 04/02/2023
 * @author eslooj
 */
import java.util.Locale;
import java.util.Scanner;

public class PersonaApp_Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		sc.useLocale(Locale.US);
		//Introducimos los datos
		System.out.println("Introduce el nombre");
		String nombre = sc.next();
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

}//clase PersonaApp_Scanner