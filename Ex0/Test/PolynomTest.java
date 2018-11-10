import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myMath.Monom;
import myMath.Polynom;

class PolynomTest {
Monom m1;
Monom m2;
//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//	}

//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//	}
//
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}

//	@Test
//	void testPolynomPolynom() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testF() {
//		fail("Not yet implemented");
//	}

	@Test
	void testAddPolynom_able() throws Exception {
		 Polynom b4 = new Polynom("6*x^7-4*x^3+2*x^6-2*x^4");
		 Polynom b1 = new Polynom("-5*x^2+5.4*x^1+3*x^2-6*x^7+0*x^0");
		 b1.add(b4);
		 assertEquals("5.4*X^1-2.0*X^2-4.0*X^3-2.0*X^4+2.0*X^6", b1.toString());
		 b4 = new Polynom(); 
		 b1.add(b4);
		 assertEquals("5.4*X^1-2.0*X^2-4.0*X^3-2.0*X^4+2.0*X^6", b1.toString());
	
	}

	@Test
	void testAddMonom() throws Exception {
		m1 = new Monom(-5,1);
		m2 = new Monom(4,7);
		Monom m3 = new Monom(-4,7);
		Monom m4 = new Monom(4,0);
		Monom m5 = new Monom(0,0);
		Monom m6 = new Monom(3,6);
		Monom m7 = new Monom(2,3);
		Polynom b2 = new Polynom();
		b2.add(m1);
		b2.add(m2);
		b2.add(m3);
		b2.add(m4);
		b2.add(m5);
		b2.add(m6);
		b2.add(m7);
		assertEquals("4.0*X^0-5.0*X^1+2.0*X^3+3.0*X^6", b2.toString());
	}

	@Test
	void testSubstract() throws Exception {
		Polynom b1 = new Polynom("5*x^6+3*x^2-4*x^4");
		Polynom b4 = new Polynom("7*x^4+1*x^9");
		b1.substract(b4);
		assertEquals("3.0*X^2-11.0*X^4+5.0*X^6-1.0*X^9", b1.toString());
	}

	@Test
	void testMultiply() throws Exception {
		Polynom b1 = new Polynom("5*x^6+3*x^2-4*x^4");
		Polynom b4 = new Polynom("7*x^4+1*x^9");
		b1.multiply(b4);
		assertEquals("21.0*X^6-28.0*X^8+35.0*X^10+3.0*X^11-4.0*X^13+5.0*X^15",b1.toString());
	}

	@Test
	void testEqualsPolynom_able() throws Exception {
		Polynom b4 = new Polynom("7*x^4+1*x^9");
		Polynom b1 = new Polynom("5*x^6+3*x^2-4*x^4");
	    assertFalse(b4.equals(b1));
	    Polynom b2 = new Polynom("7*x^4+1*x^9");
	    assertTrue(b4.equals(b2));
	    
	}

	@Test
	void testIsZero() throws Exception {
		Polynom b2 = new Polynom("7*x^4+1*x^9");
	    assertFalse(b2.isZero());
	    b2 = new Polynom();
	    assertTrue(b2.isZero());
	}

	@Test
	void testRoot() throws Exception {
		Polynom p1 = new Polynom("-1*x^3+1*x^1-2*x^0");
		double round =  (double)((int)(p1.root(-30, 50, 0.0001)/0.001))/1000;
		assertEquals(-1.521,round);
	}

	@Test
	void testCopy() throws Exception {
		Polynom b2 = new Polynom("7*x^4+1*x^9");
	    Polynom b3=(Polynom)b2.copy();
	    assertEquals(b2.toString(),b3.toString());
		Polynom b1 = new Polynom("5*x^6+3*x^2-4*x^4");
	    b3 = (Polynom)b1.copy();
	    assertEquals(b1.toString(),b3.toString());

	}

	@Test
	void testDerivative() throws Exception {
		Polynom o = new Polynom("-5*x^2+5*x^1+3*x^2-6*x^7");
        assertEquals("5.0*X^0-4.0*X^1-42.0*X^6",((Polynom)(o.derivative())).toString());
		o = new Polynom("3*x^0");
		assertEquals("0*X^0",((Polynom)(o.derivative())).toString());
	}

	@Test
	void testArea() throws Exception {
		Polynom p1 = new Polynom("5*x^6+3*x^2-4*x^4");
		double round = (double)((int)(p1.area(0, 2, 0.000001)*1000))/1000;
		assertEquals(73.828, round);
		
		p1 = new Polynom("1*x^3-2*x^1+1*x^0");
		
		round = (double)((int)(p1.area(-2, 2, 0.000001)*1000))/1000;
		System.out.println(p1.area(-2, 2, 0.000001));
		assertEquals(4.545, round);
	}


}
