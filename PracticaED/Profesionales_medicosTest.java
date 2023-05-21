/**
 * 
 */
package PracticaED;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author MSI
 *
 */
public class Profesionales_medicosTest {
	
	//Se añaden las clases de prueba para validar los metodos getters y setters de la clase Profesionales_medicos

	@Test
	public void getNombre() {
		Profesionales_medicos X=new Profesionales_medicos("medico1","45568772E","localidad","95303132","GASTRO");
		assertEquals(X.getNombre_completo(),"medico1");
	}
	
	@Test
	public void getDni_medico(){
		Profesionales_medicos X=new Profesionales_medicos("medico1","45568772E","localidad","95303132","GASTRO");
		assertEquals(X.getDni_medico(),"45568772E");
	}
	
	@Test
	public void getLocalidad(){
		Profesionales_medicos X=new Profesionales_medicos("medico1","45568772E","localidad","95303132","GASTRO");
		assertEquals(X.getLocalidad(),"localidad");
	}
	
	@Test
	public void getTelefono(){
		Profesionales_medicos X=new Profesionales_medicos("medico1","45568772E","localidad","95303132","GASTRO");
		assertEquals(X.getTelefono(),"95303132");
	}
	
	@Test
	public void getEspecialidad(){
		Profesionales_medicos X=new Profesionales_medicos("medico1","45568772E","localidad","95303132","GASTRO");
		assertEquals(X.getEspecialidad(),"GASTRO");
	}
	
	@Test
	public void setNombre() {
		Profesionales_medicos X=new Profesionales_medicos("medico1","45568772E","localidad","95303132","GASTRO");
		X.setNombre_completo("medico1_editado");
		assertEquals(X.getNombre_completo(),"medico1_editado");
	}

	@Test
	public void setDni_medico(){
		Profesionales_medicos X=new Profesionales_medicos("medico1","45568772E","localidad","95303132","GASTRO");
		X.setDni_medico("45568772X");
		assertEquals(X.getDni_medico(),"45568772X");
	}
	
	@Test
	public void setLocalidad(){
		Profesionales_medicos X=new Profesionales_medicos("medico1","45568772E","localidad","95303132","GASTRO");
		X.setLocalidad("localidad_editada");
		assertEquals(X.getLocalidad(),"localidad_editada");
	}
	
	@Test
	public void setTelefono(){
		Profesionales_medicos X=new Profesionales_medicos("medico1","45568772E","localidad","95303132","GASTRO");
		X.setTelefono("95303133");
		assertEquals(X.getTelefono(),"95303133");
	}
	
	@Test
	public void setEspecialidad(){
		Profesionales_medicos X=new Profesionales_medicos("medico1","45568772E","localidad","95303132","GASTRO");
		X.setEspecialidad("GASTRO1");
		assertEquals(X.getEspecialidad(),"GASTRO1");
	}
	
}
