import static org.junit.Assert.assertEquals;

import org.junit.Test;
	
public class SubscripcionTest {
	@Test
	public void testprecioPorMes() {
		double esperado=100;
		Subscripcion s = new Subscripcion(200,2) ;
		double resultado = s.precioPorMes();
		assertEquals(esperado, resultado,0) ;
	}
	
	@Test
	public void testprecioPorMes2() {
		double esperado=67;
		Subscripcion s = new Subscripcion(200,3) ;
		double resultado= s.precioPorMes();
		assertEquals(esperado, resultado, 0.67) ;
	}
	
	
	@Test
	public void testCancel(){
		double esperado=0;
		Subscripcion s=new Subscripcion(200,0);
		s.cancel();
		double resultado= s.precioPorMes();
		assertEquals(esperado,resultado,0);
	}
	
}