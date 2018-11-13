import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import myMath.Monom;

class MonomTest {

	@Test
	void testMonomMonom() throws Exception {
		Monom m1 = new Monom(5,8);
		assertEquals("5.0*X^8",m1.toString());
		m1 = new Monom(7.9,0);
		assertEquals("7.9*X^0",m1.toString());
		m1 = new Monom(0,0);
		assertEquals("0.0*X^0",m1.toString());
		m1 = new Monom(-2,3);
		assertEquals("-2.0*X^3",m1.toString());
		Monom m2 = new Monom(m1);
		assertEquals("-2.0*X^3",m2.toString());
		try {
		m1= new Monom(4,-3);
		fail("expected exceptin");
		}
		catch(Exception e){
		}
	}


	@Test
	void testF() throws Exception {
		Monom m2 = new Monom(-2.2, 3);
		double round = (double)((int)(m2.f(-2.2)/0.001))/1000;;
		assertEquals(23.425, round);
		Monom m3 = new Monom(0, 3);
		double y = m3.f(0);
		String b = y + "";
		assertEquals("0.0", b);

	}


	@Test
	void testDerivative() throws Exception {
		Monom m2 = new Monom(-2,3);
		m2.derivative();
		assertEquals("-6.0*X^2",m2.toString());
		m2 = new Monom(7,0);
		m2.derivative();
		assertEquals("0.0*X^0",m2.toString());
	}

	@Test
	void testAdd() throws Exception {
	    Monom m1 = new Monom(3,3);
	    Monom m2= new Monom (-2,3);
	    m1.add(m2);
	    assertEquals("1.0*X^3",m1.toString());
	    m2= new Monom (-2,4);
	    try {
	    	m2.add(m1);
	    	fail("expected exceptin");
	    }
	    catch(Exception e) {
	    	
	    }
	    
	}

	@Test
	void testMultiply() throws Exception {
	    Monom m1 = new Monom(3,3);
	    Monom m2= new Monom (-2,3);
	    m2.multiply(m1);
	    assertEquals("-6.0*X^6", m2.toString());
	   
	}

	@Test
	void testGet_power() throws Exception {
		  Monom m1 = new Monom(3,4);
		  assertEquals(4,m1.get_power());			  	  
		  
}

	@Test
	void testGet_coefficient() throws Exception {
	  Monom m1 = new Monom(3,3);
	  assertEquals(3,m1.get_coefficient());	
}

}
