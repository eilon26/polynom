package myMath;

public class Test {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		
		//****************** Monom class *****************
		System.out.println("****************** Monom class  *****************");
		//****************** constructions *****************
		System.out.println("****************** constructions  *****************");
		Monom m1 = new Monom(5,8);
		System.out.println("suppose to be 5*x^8 and it is: "+m1);
		m1 = new Monom(7.9,0);
		System.out.println("suppose to be 7.9*x^0 and it is: "+m1);
		m1 = new Monom(0,0);
		System.out.println("suppose to be 0*x^0 and it is: "+m1);
		m1 = new Monom(-2,3);
		System.out.println("suppose to be -2*x^3 and it is: "+m1);
		Monom m2 = new Monom(m1);
		System.out.println("suppose to be -2*x^3 and it is: "+m2);
		
		//****************** f function  *****************
		System.out.println("****************** f function  *****************");
		System.out.println("we insert x=-2.2 into this monom: -2*x^3 ");
	    System.out.println("so we suppose to get 21.296 and we got "+m2.f(-2.2));
		System.out.println("we insert x=0 into this monom: -2*x^3 ");
	    System.out.println("so we suppose to get 0*x^0 and we got "+m2.f(0));

		//****************** derivative function  *****************
	    System.out.println("****************** derivative function  *****************");
	    System.out.println("the derivate on this monom "+m2);
	    m2.derivative();
	    System.out.println("suppose to return -6*x^2 and it return "+m2);
	    m2 = new Monom(7,0);
	    System.out.println("the derivate on this monom "+m2);
	    m2.derivative();
	    System.out.println("suppose to return 0 and it return "+m2);
	    
		//****************** add function  *****************
	    System.out.println("****************** add function  *****************");
	    m1 = new Monom(3,3);
	    m2= new Monom (-2,3);
	    System.out.println("we add -2*x^3 to 3*x^3");
	    m1.add(m2);
	    System.out.println("suppose to get 1*x^3 and get: "+m1);
	    
		//****************** multiply function  *****************
        System.out.println("****************** multiply function  *****************");
	    m1 = new Monom(3,3);
	    System.out.println("we multiply -2*x^3 in 3*x^3");
	    m2.multiply(m1);
	    System.out.println("suppose to get -6*x^6 and get: "+m2);
	    
	    
	    
				
		//****************** Polynom class *****************
	    System.out.println();
		 System.out.println("****************** Polynom class  *****************");
    	//****************** constructions *****************
	    System.out.println("****************** constructions  *****************");
	    Polynom b1 = new Polynom("-5*x^2+5.4*x^1+3*x^2-6*x^7+0*x^0");
		System.out.println(" suppose to return -5*x^2+5.4*x^1+3*x^2-6*x^7+0*x^0 and the result is: "+b1);
		Polynom b2 = new Polynom("");
		System.out.println("suppose to return 0 and the result is: "+b2);
	    b2 = new Polynom();
	    System.out.println("suppose to return 0 and the result is: "+b2);
	    Polynom b3 = new Polynom(b1);
	    System.out.println("suppose to return -5*x^2+5.4*x^1+3*x^2-6*x^7+0*x^0 and the result is:" +b3);
	    System.out.println();
	    
		//****************** add function  *****************
	    System.out.println("****************** add function  *****************");
		m1 = new Monom(-5,1);
		m2 = new Monom(4,7);
		Monom m3 = new Monom(-4,7);
		Monom m4 = new Monom(4,0);
		Monom m5 = new Monom(0,0);
		Monom m6 = new Monom(3,6);
		Monom m7 = new Monom(2,3);
		b2.add(m1);
		b2.add(m2);
		b2.add(m3);
		b2.add(m4);
		b2.add(m5);
		b2.add(m6);
		b2.add(m7);
		System.out.println("we add to the empty polynom -5*x^1 and 4*x^7 and -4*x^7 and 4*x^0 and 0*x^0 and 3*x^6 and 2*x^3");
		System.out.println("suppose to return 4.0*X^0-5.0*X^1+2.0*X^3+3.0*X^6 and the result is: "+b2.toString());
		 Polynom b4 = new Polynom("6*x^7-4*x^3+2*x^6-2*x^4");
		 System.out.println("we add this polynom:  "+b4+ " to this polynom "+b1+" and we get " );
		 b1.add(b4);
		 System.out.println(b1+" and suppose to get:  5.4*X^1-2.0*X^2-4.0*X^3-2.0*X^4+2.0*X^6");
		 
		 b4 = new Polynom();
		 System.out.println("we add this polynom:  "+b4+ " to this polynom "+b1+" and we get: " );
		 b1.add(b4);
		 System.out.println(b1+" and suppose to get: 5.4*X^1-2.0*X^2-4.0*X^3-2.0*X^4+2.0*X^6");
		 System.out.println();
		
		//****************** f function  *****************
		System.out.println("****************** f function  *****************");
		System.out.println("in this polynom "+b3+" we check what happen if x=4");
		System.out.println("suppose to get -98314.4s and the result is: "+b3.f(4));
		System.out.println("in this polynom "+b3+" we check what happen if x=0");
		System.out.println("suppose to get 0 and the result is: "+b3.f(0));
		System.out.println("in this polynom "+b3+" we check what happen if x=-3");
		System.out.println("suppose to get -34.2 and the result is: "+b3.f(-3));
		System.out.println("in this polynom "+b3+" we check what happen if x=5.2");
		System.out.println("suppose to get -26 and the result is: "+b3.f(5.2));
		System.out.println();
		
		//****************** derivative function  *****************
		
	    System.out.println("****************** derivative function  *****************");
		Polynom o = new Polynom("-5*x^2+5*x^1+3*x^2-6*x^7");
        System.out.println("the derivate on this polynom "+o+" give you this "+o.derivative());
		o = new Polynom("3*x^0");
        System.out.println("the derivate on this polynom "+o+" give you this "+o.derivative());
        System.out.println();
        
    	//****************** root function  *****************
        System.out.println("****************** root function  *****************");
		Polynom p1 = new Polynom("-1*x^3+1*x^1-2*x^0");
		System.out.println("the root of this polynom "+p1+" between -30 to 50 is -1.5214");
		System.out.println("the eps is very close to zero: 0.0001, so we suppose to get approximately -1.5214");
		System.out.println("and the result is: "+p1.root(-30, 50, 0.0001));
		System.out.println();
		
		//****************** area function  *****************
	    System.out.println("****************** area function  *****************");
		p1 = new Polynom("5*x^6+3*x^2-4*x^4");
		System.out.println("the area of this polynom "+p1+" between 0 to 2 is 73.8286");
		System.out.println("so if eps value is 0.000001 so we suppose to get approximately the same: ");
		System.out.println(p1.area(0, 2, 0.000001));
		System.out.println();
		
		p1 = new Polynom("1*x^3-2*x^1+1*x^0");
		System.out.println("the area of this polynom "+p1+" between -2 to 2  (above axis x)is 4.54508 ");
		System.out.println("so if eps value is 0.000001 so we suppose to get approximately the same: ");
		System.out.println(p1.area(-2, 2, 0.000001));
		System.out.println();
		
		//****************** substract function  *****************
	    System.out.println("****************** substract function  *****************");
		b1 = new Polynom("5*x^6+3*x^2-4*x^4");
		b4 = new Polynom("7*x^4+1*x^9");
		System.out.println("we substract this polynom:  "+b4+ " from this polynom "+b1+" and we get: " );
		b1.substract(b4);
		System.out.println(b1+" and suppose to get 3*X^2-11*X^4+5*X^6-1*X^9");
        System.out.println();
        
		//****************** multiply function  *****************
        System.out.println("****************** multiply function  *****************");
		b1 = new Polynom("5*x^6+3*x^2-4*x^4");
		b4 = new Polynom("7*x^4+1*x^9");
		System.out.println("we multiply this polynom:  "+b4+ " in this polynom "+b1+" and we get: " );
		b1.multiply(b4);
		System.out.println(b1+" and suppose to get  21*x^6-28*x^8+35*x^10+3*x^11-4*x^13+5*x^15");
	    System.out.println();
		
	    //****************** equals function  *****************
	    System.out.println("****************** equals function  *****************");

	    System.out.println("we compare this polynom:  "+b4+ " to this polynom "+b1+" and we get: " );
	    System.out.println("it is "+b4.equals(b1)+" that the polynoms are equals");
	    System.out.println();
	    b2 = new Polynom("7*x^4+1*x^9");
	    System.out.println("we compare this polynom:  "+b4+ " to this polynom "+b2+" and we get: " );
	    System.out.println("it is "+b4.equals(b2)+" that the polynoms are equals");
	    System.out.println();
	    
	    //****************** isZero function  *****************
	    System.out.println("****************** isZero function  *****************");
	    System.out.println("it is " + b2.isZero()+ " that the polynom "+b2+" is 0");
	    b2 = new Polynom();
	    System.out.println("it is " + b2.isZero()+ " that the polynom "+b2+" is 0");
	    System.out.println();
	    //****************** copy function  *****************
	    System.out.println("****************** copy function  *****************");
	    b3=(Polynom)b2.copy();
	    System.out.println("this is the polynom that we copy from: " +b2);
	    System.out.println("this is the result: "+b3);
	    b3 = (Polynom)b1.copy();
	    System.out.println("this is the polynom that we copy from: " +b1);
	    System.out.println("this is the result: "+b3);
	    
	    
	}
}
