package PracticaED;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestConexion {

	private static String selectTableSQL;
	private static String insertTableSQL;
	//private static String updateTableSQL;

	public static void cerrar_conexion3(Connection cn, Statement stm, ResultSet rs) {
		// Liberar recursos revisar el orden en el que se cierran, orden inverso
		try {
			if (rs != null) {
				rs.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (cn != null) {
				cn.close();
			}
			//System.out.println("La conexión se ha cerrado con éxito");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}

	}

	/**
	 * 
	 * @param esDNIDuplicado
	 * @return
	 */
	public static boolean consulta_select_esDuplicado(String esDNIDuplicado) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		boolean esDuplicado = false;

		if(esDNIDuplicado.length()!=0) {
		selectTableSQL = "SELECT * FROM PACIENTES where dni='"+esDNIDuplicado+"'" ;
		
		}else {
		selectTableSQL = "SELECT cod_medico,nombre_completo,especialidad FROM PROFESIONALES_MEDICOS";
		}

		try {
			// Abrimos la conexion con la base de datos
			cn = conexion.conectar();
			stm = cn.createStatement();
			// Pasamos la consulta al ResultSet
			rs = stm.executeQuery(selectTableSQL);
			
			if(esDNIDuplicado.length()!=0) {

				while (rs.next()) {
				
					if(rs.getString(2).equals(esDNIDuplicado)){
						esDuplicado=true;
					}else {
					esDuplicado=false;
					}

				}//while
				
			}else {
				
				while (rs.next()) {
				System.out.println("Cod. profesional: "+rs.getString(1)+" Nombre profesional: "+rs.getString(2)+" Especialidad: "+rs.getString(3)+"\n");

				}//while
				
			}
				
		} catch (SQLException e) { // TODO: handle exception

		} finally {
			TestConexion.cerrar_conexion3(cn, stm, rs);
			/*
			 * try { if (rs != null) { rs.close(); } if (stm != null) { stm.close(); } if
			 * (cn != null) { cn.close(); }
			 * 
			 * } catch (Exception e2) {
			 * 
			 * }
			 */

		}
		return esDuplicado;

	}//consulta_select
	
	/**
	 * 
	 * @param DNI
	 * @param nombre
	 * @param edad
	 * @param calle
	 * @param localidad
	 * @param cp
	 */
	public static void consulta_insert_pacientes(String DNI, String nombre, int edad, String calle,String localidad,String cp) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		PreparedStatement ps = null;

		// Crear sentencia SQL para insertar en la base de datos
		insertTableSQL = "INSERT INTO pacientes (dni,nombre,edad,calle,localidad,cp) VALUES (?,?,?,?,?,?)";

		try {

			cn = conexion.conectar();
			ps = cn.prepareStatement(insertTableSQL);

			ps.setString(1, DNI);
			ps.setString(2, nombre);
			ps.setString(3,Integer. toString(edad));
			ps.setString(4, calle);
			ps.setString(5, localidad);
			ps.setString(6, cp);
			ps.execute();

			System.out.println("El paciente ha sido insertado con exito en la base de datos...\n");

		} catch (SQLException e) { // TODO: handle exception

			e.printStackTrace();

		} finally { // Liberar recursos revisar el orden en el que se cierran
			try {

				if (ps != null) {
					ps.close();
				}

				if (cn != null) {
					cn.close();
				}

			} catch (Exception e2) {

				e2.printStackTrace();

			}

		}

	}//consulta_insert_pacientes
	
	/**
	 * 
	 * @param dni_paciente
	 * @param dateTime
	 * @param peso
	 * @param altura
	 * @param imc
	 * @param cod_profesional
	 */
	public static void consulta_insert_visitas(String dni_paciente, LocalDateTime dateTime, double peso, double altura,int imc,int cod_profesional) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		PreparedStatement ps = null;

		// Crear sentencia SQL para insertar en la base de datos
		insertTableSQL = "INSERT INTO visitas (dni_paciente,fecha_visita,peso,altura,imc,cod_profesional) VALUES (?,?,?,?,?,?)";

		try {

			cn = conexion.conectar();
			ps = cn.prepareStatement(insertTableSQL);

			ps.setString(1, dni_paciente);
			ps.setString(2, dateTime.toString());
			ps.setString(3,Double.toString(peso));
			ps.setString(4, Double.toString(altura));
			ps.setString(5, Integer.toString(imc));
			ps.setString(6, Integer.toString(cod_profesional));
			ps.execute();

			System.out.println("La visita se ha insertado con exito en la base de datos...\n");

		} catch (SQLException e) { // TODO: handle exception

			e.printStackTrace();

		} finally { // Liberar recursos revisar el orden en el que se cierran
			try {

				if (ps != null) {
					ps.close();
				}

				if (cn != null) {
					cn.close();
				}

			} catch (Exception e2) {

				e2.printStackTrace();

			}

		}

	}//consulta_insert_visitas
	
	/**
	 * 
	 * @param dni_paciente
	 * @param peso
	 * @param altura
	 * @param cod_profesional
	 */
	public static void consulta_insert_visitas_paciente_existente(String dni_paciente,float peso, float altura,String cod_profesional) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		PreparedStatement ps = null;

		// Crear sentencia SQL para insertar en la base de datos
		insertTableSQL = "INSERT INTO visitas (dni_paciente,fecha_visita,peso,altura,imc,cod_profesional) VALUES (?,?,?,?,?,?)";

		try {

			cn = conexion.conectar();
			ps = cn.prepareStatement(insertTableSQL);
			
			LocalDateTime dateTime = LocalDateTime.now();
			DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
			dateTime.format(formatters);

			ps.setString(1, dni_paciente);
			ps.setString(2, dateTime.toString());
			ps.setString(3,Double.toString(peso));
			ps.setString(4, Double.toString(altura));
			ps.setString(5, Integer.toString(Persona.calcularIMC(altura,peso)));
			ps.setString(6, cod_profesional);
			ps.execute();

			System.out.println("La visita se ha insertado con exito en la base de datos...\n");

		} catch (SQLException e) { // TODO: handle exception

			e.printStackTrace();

		} finally { // Liberar recursos revisar el orden en el que se cierran
			try {

				if (ps != null) {
					ps.close();
				}

				if (cn != null) {
					cn.close();
				}

			} catch (Exception e2) {

				e2.printStackTrace();

			}

		}

	}//consulta_insert_visitas_paciente_existente
	
	
	/**
	 * 
	 * @param dni_paciente
	 * @param cod_profesional
	 * @param fecha
	 */
	public static void consulta_select_listado(String dni_paciente,String cod_profesional,String fecha) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;

		if(fecha.equals("")) {
		selectTableSQL = "SELECT fecha_visita,peso,altura,imc FROM VISITAS where dni_paciente='"+dni_paciente+"' and cod_profesional='"+cod_profesional+ "'";
		
		}else {
		selectTableSQL = "SELECT fecha_visita,peso,altura,imc FROM VISITAS where dni_paciente='"+dni_paciente+"' "
				+ "and cod_profesional='"+cod_profesional+ "' and fecha_visita>='"+fecha+" 00:00:00' and fecha_visita<'"+fecha+" 23:59:59' ";
				
		}

		try {
			// Abrimos la conexion con la base de datos
			cn = conexion.conectar();
			stm = cn.createStatement();
			// Pasamos la consulta al ResultSet
			rs = stm.executeQuery(selectTableSQL);
			
				System.out.println("Visitas disponibles:");
				
				while (rs.next()) {
					
				System.out.println("Fecha visita: "+rs.getString(1)+", peso: "+rs.getString(2)+", altura: "+rs.getString(3)+", IMC: "+rs.getString(4));

				}//while
				
		} catch (SQLException e) { // TODO: handle exception

		} finally {
			TestConexion.cerrar_conexion3(cn, stm, rs);
			/*
			 * try { if (rs != null) { rs.close(); } if (stm != null) { stm.close(); } if
			 * (cn != null) { cn.close(); }
			 * 
			 * } catch (Exception e2) {
			 * 
			 * }
			 */

		}

	}//consulta_select_listado
	
	
	
/*
	public static void consulta_update(int id_usuario, String usuario, String clave) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;

		// Crear sentencia SQL para insertar en la base de datos
		updateTableSQL = "UPDATE usuario set usuario ='" + usuario + "', clave='" + clave + "' where idusuario="
				+ id_usuario;

		try {

			cn = conexion.conectar();
			stm = cn.createStatement();
			int valor = stm.executeUpdate(updateTableSQL);
			if (valor == 1) {
				System.out.println("El usuario ha sido actualizado correctamente");
			} else {
				System.out.println("No existe usuario con el id_usuario referido");
			}

		} catch (SQLException e) { // TODO: handle exception

			e.printStackTrace();

		} finally { // Liberar recursos revisar el orden en el que se cierran
			try {

				if (stm != null) {
					stm.close();
				}

				if (cn != null) {
					cn.close();
				}

			} catch (Exception e2) {

				e2.printStackTrace();

			}

		}

	}
	*/
	
	/*
	public static void consulta_select() {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;

		selectTableSQL = "SELECT * FROM USUARIO";

		try {
			// Abrimos la conexion con la base de datos
			cn = conexion.conectar();
			stm = cn.createStatement();
			// Pasamos la consulta al ResultSet
			rs = stm.executeQuery(selectTableSQL);

			while (rs.next()) {
				int idUsuario = rs.getInt(1);
				String usuario = rs.getString(2);
				String clave = rs.getString(3);

				System.out.println(idUsuario + " " + usuario + " " + clave);
			}
		} catch (SQLException e) { // TODO: handle exception

		} finally {
			cerrar_conexion3(cn, stm, rs);
			*/
			/*
			 * try { if (rs != null) { rs.close(); } if (stm != null) { stm.close(); } if
			 * (cn != null) { cn.close(); }
			 * 
			 * } catch (Exception e2) {
			 * 
			 * }
			 */

		//}

	//}
	
	/*
	public static void main(String[] args) {
		System.out.println("HOLA MUNDO");
		//consulta_select();
		// consulta_insert("Lucas", "123");
		// consulta_update(7, "alvaro", "123");

	}
	*/
	
	
}
