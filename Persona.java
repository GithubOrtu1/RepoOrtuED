package PracticaED;

/** 
 * Clase Persona que se instancia con los campos y los valores de los mismos informados por consola
 * Muestra todos los datos de la persona asi commo el calculo del IMC
 * Se muestra si la persona en mayor de edad o no
 * @version 1.1 25/03/2023 
 *
 * @author eslooj
 *
 */
public class Persona {

	private final static char SEXO_DEF = 'H';
	public static final int INFRAPESO = -1;
	public static final int PESO_IDEAL = 0;
	public static final int SOBREPESO = 1;
	public String nombre;
	public int edad;
	public String DNI;
	public char sexo;
	public double peso;
	public double altura;
	public String calle;
	public String localidad;
	public String codPostal;
	
		/**
		 * Constructor de Persona sin parametros
		 */
	
		/*
		public Persona() {
			this("", 0, SEXO_DEF, 0, 0);
		}
		*/
	
		/**
		 * Constructor de Persona con 3 parametros
		 * @param nombre
		 * @param edad
		 * @param sexo
		 */
		/*
		public Persona(String nombre, int edad, char sexo) {
			this(nombre, edad, sexo, 0, 0);
		}
	
		/**
		 * Constructor de persona con 5 parametros
		 * @param nombre
		 * @param edad
		 * @param sexo
		 * @param peso
		 * @param altura
		 */
		
		public Persona(String nombre, int edad, char sexo, double peso, double altura,String calle,String localidad,String codPostal) {
			this.nombre = nombre;
			this.edad = edad;
			this.peso = peso;
			this.altura = altura;
			this.calle=calle;
			this.localidad=localidad;
			this.codPostal=codPostal;
			generarDni();
			this.sexo = sexo;
			comprobarSexo();
		}
	
		/** Metodo que setea un sexo por defecto si no se ha indicado uno valido
		 *
		 */
		private void comprobarSexo() {
			if (sexo != 'H' && sexo != 'M') {
			this.sexo = SEXO_DEF;
			}
		}
		
		/** Genera DNI para el campo dni de Persona partiendo un numero aleatorio
		 */
		private void generarDni() {
			final int divisor = 23;
			int numDNI = ((int) Math.floor(Math.random() * (100000000 - 10000000) + 10000000));
			int res = numDNI - (numDNI / divisor * divisor);
			char letraDNI = generaLetraDNI(res);
			DNI = Integer.toString(numDNI) + letraDNI;
		}
		/**
		 * 
		 * @param res
		 * @return 
		 */
		private char generaLetraDNI(int res) {
			char letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y',
			'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
			'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
			return letras[res];
		}
			
		/**
		 * Setter del campo nombre de Persona
		 * @param nombre
		 */
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		/**
		 * Setter del campo edad de Persona
		 * @param edad
		 */
		public void setEdad(int edad) {
			this.edad = edad;
		}
		
		/**
		 * Setter del campo sexo de Persona
		 * @param sexo
		 */
		public void setSexo(char sexo) {
			this.sexo = sexo;
		}
		/**
		 * Setter del campo peso de Persona
		 * @param peso
		 */
		public void setPeso(double peso) {
			this.peso = peso;
		}
		
		/**
		 * Setter del campo altura de Persona
		 * @param altura
		 */
		public void setAltura(double altura) {
			this.altura = altura;
		}
		
		/**
		//v0.1 Metodo que nos devuelven booleano indicando si es mayor o menor de edad
		 * */
		
		public boolean esMayorDeEdad(){
			
			//Se comprueba para cada objeto Persona si es mayor de edad o no
			if(this.edad>=18){
				return(true);
			}else {
				return(false);
			}
		}
		
		
		/**
		 * 
		 * @return Devuelve constante indicando IMC
		 */
		public int calcularIMC() {
			//Calculamos el peso de la persona
			double pesoActual = peso / (Math.pow(altura, 2));
			//Segun el peso, devuelve un codigo
			if (pesoActual >= 20 && pesoActual <= 25) {
			return PESO_IDEAL;
			} else if (pesoActual < 20) {
			return INFRAPESO;
			} else {
			return SOBREPESO;
			}
		}
			
		/**
		 * Metodo que muestra todos los datos asociados a Persona
		 */
		public String toString() {
			String sexo;
			if (this.sexo == 'H') {
			sexo = "hombre";
			} else {
			sexo = "mujer";
			}
			/**
			//v0.1 Se indica por consola si la persona es mayor de edad o no
			 * */
			
			
			if(this.esMayorDeEdad()) {
				System.out.println("Es MAYOR de edad..");
			}else {
				System.out.println("Es MENOR de edad..");
			}
			
			
			return "Informacion de la persona:\n"
			+ "Nombre: " + nombre + "\n"
			+ "Sexo: " + sexo + "\n"
			+ "Edad: " + edad + " años\n"
			+ "DNI: " + DNI + "\n"
			+ "Peso: " + peso + " kg\n"
			+ "Altura: " + altura + " metros\n";
		}
		
}//clase persona