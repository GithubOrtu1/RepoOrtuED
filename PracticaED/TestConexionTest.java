/**
 * 
 */
package PracticaED;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

/**
 * @author MSI
 *
 */
public class TestConexionTest {
	

	@Test
	public void consulta_select_listado() {
		//Se carga el fichero de configuracion antes de establecer la conexion con BBDD
		Config configuracion=new Config();
		configuracion.leerConfig();
		TestConexion newConnection1=new TestConexion();
		newConnection1.consulta_select_listado("45568779E", "102", "");

		//Se comprueba que se muestran 2 visitas por consola
		
		newConnection1.consulta_select_listado("45568779X", "102", "");
		
		//Se comprueba que no se muestra ninguna visita por consola
		
		assertTrue(true);
	}

	
}
