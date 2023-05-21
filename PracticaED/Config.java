package PracticaED;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Config {
	private static final String RUTA_CONF = "C:\\Users\\MSI\\eclipse-workspace\\Practica_final_ED\\src\\PracticaED\\conf.txt";
	private static String NOMBRE_BD;
	private static String UBICACION;
	private static String PUERTO;
	private static String USUARIO;
	private static String CLAVE;
	
	public Config() {
		
	}

	public static String getNombreBBDD() {
		return NOMBRE_BD;
	}

	public static void setNombreBBDD(String nombreBBDD) {
		Config.NOMBRE_BD = nombreBBDD;
	}

	public static String getUbicacion() {
		return UBICACION;
	}

	public static void setUbicacion(String ubicacion) {
		Config.UBICACION = ubicacion;
	}

	public static String getPuerto() {
		return PUERTO;
	}

	public static void setPuerto(String puerto) {
		Config.PUERTO = puerto;
	}

	public static String getUsuario() {
		return USUARIO;
	}

	public static void setUsuario(String usuario) {
		Config.USUARIO = usuario;
	}

	public static String getClave() {
		return CLAVE;
	}

	public static void setClave(String clave) {
		Config.CLAVE = clave;
	}
	
	/**
	 * 
	 */
    public static void leerConfig(){
		String rutaConfiguracion = "C:\\Users\\MSI\\eclipse-workspace\\Practica_final_ED\\src\\PracticaED\\conf.txt";
		File listadoParametrosF = new File(rutaConfiguracion);
                FileReader listadoParametrosFR = null;
                BufferedReader listadoParametrosBR = null;
        
        try {
            listadoParametrosFR = new FileReader(listadoParametrosF);
            listadoParametrosBR = new BufferedReader(listadoParametrosFR);
            
            int i = 0;
            String linea;
            while ((linea = listadoParametrosBR.readLine())!= null && i<5){
                String[] lineas = linea.split("\\;");
                switch(i){
                    case 0:
                        setNombreBBDD(lineas[0]);
                        break;
                    case 1:
                        setUbicacion(lineas[0]);
                        break;
                    case 2:
                        setPuerto(lineas[0]);
                        break;
                    case 3:
                        setUsuario(lineas[0]);
                        break;
                    case 4:
                        setClave(lineas[0]);
                        break;
                }
                i++;
            }
            listadoParametrosBR.close();
        }
        catch(IOException e){
        	System.out.println("Falta fichero properties..\n");
        }
    }

}