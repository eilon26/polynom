package myMath;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;

import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 4. value at x
 * 5. substract
 * 6. equals
 * 7. iszero
 * 8.copy
 * 
 * @author Boaz
 *
 */
public class Polynom implements Polynom_able{
	/**
	 * the function get string  that represent polynom and build a polynom
	 * @param s the string  that represent polynom
	 * @throws Exception when the string is not by the typical pattern we throw exception(a*x^b+...+a*x^b) when space between the letters is not allowed a is double and b is positive int. 
	 * if there is monom without the signs '*' and '^' it is illegal. after the sign '^' it is illegal to put any sign except a number (not '+' or '-')
	 */
    public Polynom(String s) throws Exception {
    	p = new ArrayList<Monom>();
    	int i;
    	int b;
    	double a;
    	boolean minus=false;
    	while (s!="") {
    		for (i =0;(i<s.length()&&s.charAt(i)!='*');i++);
    		if (s.charAt(i)=='*') {
    			String curr = s.substring(0,i);
    			s=s.substring(i+1);
    			a = Double.parseDouble(curr);
    			if (minus) {
    				a=a*(-1);
    				minus=false;
    			}
    			if ((s.length()>2)&&((s.charAt(0)=='x')||(s.charAt(0)=='X'))&&(s.charAt(1)=='^')&&(s.charAt(2)!='-')) {
    				for (i =2;((i<s.length())&&(s.charAt(i)!='+')&&(s.charAt(i)!='-'));i++);
    				
    				curr = s.substring(2,i);
    				if (i==s.length()) 
    					s="";
    				else { 
    					if (s.charAt(i)=='-')
    						minus=true;
    				    s=s.substring(i+1);
    				}
    				b = Integer.parseInt(curr);
    			}
    			else throw new Exception("string is illegal");	
    		}
    		else throw new Exception("string is illegal");
    		Monom first = new Monom(a,b);
    	    this.add(first);
    		
    	}
    }
    /**
     * the constructor that build an empy polynom (equal to zero)
     */
    public Polynom() {
    	p = new ArrayList<Monom>();
    }
    /**
     * the constructor that get other polynom and by its parameter build a new polynom
     * @param other the polynom that by its parammeters the constructor build a new polynom
     */
    public Polynom(Polynom other) {
    	p = new ArrayList<Monom>();
    	Iterator<Monom> iterOther = other.iteretor();
    	while (iterOther.hasNext()) 
    		this.add(new Monom(iterOther.next()));
    }
    /**
     * the function get number by parameter x and place it in this polynom and return the result
     * @param x the number that the function get 
     */
	@Override
	public double f(double x) {
    	Iterator<Monom> iterP = this.iteretor();
    	double sum=0;
    	while (iterP.hasNext()) {
    		Monom m = new Monom(iterP.next());
    	    sum+=m.f(x);
    	}
    	return sum;
	}
    /**
     * Add p1 to this Polynom by the arithmetics rules
     * @param p1  polynom 
     */
	@Override
	public void add(Polynom_able p1) {
		Iterator<Monom> iterP1 = p1.iteretor();
		while (iterP1.hasNext()) {
			this.add(new Monom(iterP1.next()));
		}
	}
	/**
	 *  Add m1 to this Polynom and keep it sorted from the lower power to the highest and only one monom from each power
	 *  @param m1 monom
	 */
	@Override
	public void add(Monom m1) {
		
		boolean isInserted=false;
		Iterator<Monom> iterP = this.iteretor();
		Monom CurrMonom;
		while (iterP.hasNext()&&!isInserted) {
			CurrMonom = iterP.next();
			if (CurrMonom.get_power()==m1.get_power()) {
				try {
					CurrMonom.add(m1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (CurrMonom.get_coefficient()==0) iterP.remove();
				isInserted=true;
			}
		}
		if (!isInserted) {
			if (m1.get_coefficient()!=0) 
				p.add(m1);
			//we use this imported function inorder to sort the arraylist p by the power of the monoms from little to big
			Collections.sort(p, new Monom_Comperator());
		}
		
	}
	/**
	 * the function substract p1 from this polynom
	 * @param p1 polynom_able
	 */
	@Override
	public void substract(Polynom_able p1) {
		Iterator<Monom> iterP1 = p1.iteretor();
		while (iterP1.hasNext()) {
			Monom curr = iterP1.next();
			curr.set_coefficient(curr.get_coefficient()*(-1));
		}
		this.add(p1);
	}
	/**
	 *  Multiply this Polynom by p1
	 *  @param p1 Polynom_able
	 */
	@Override
	public void multiply(Polynom_able p1) {
		Polynom resultPolynom = new Polynom();
		Iterator<Monom> iterP = this.iteretor();
		Monom currP;
		while (iterP.hasNext()) {
			currP = iterP.next();
			Iterator<Monom> iterP1 = p1.iteretor();
			Monom currP1;
			Monom copyCurrP;
			while (iterP1.hasNext()) {
				copyCurrP=new Monom(currP);
				currP1 = iterP1.next();
				copyCurrP.multiply(currP1);
				resultPolynom.add(copyCurrP);
			}
		}
		p.clear();
		this.add(resultPolynom);
	}
	/**
	 * Test if this Polynom is logically equals to p1
	 * @param p1 Polynom_able 
	 * @return true if this polynom represents the same function as p1
	 */
	@Override
	public boolean equals(Polynom_able p1) {
		return this.toString().equals(p1.toString());
	}
	/**
	 * Test if this is the Zero Polynom
	 * @return true if the polynom is zero
	 */
	@Override
	public boolean isZero() {
            if (this.p.size()==0) return true;
			else return false;
	}
	/**
	 * Compute a value x' (x0<=x'<=x1) such that f(x')=0
	 * assuming (f(x0)*f(x1)<=0)
	 * @param x0 starting point
	 * @param x1 end point
	 * @param eps step (positive) value 
	 * @return  x2 such that x0<=x2<=x1 and x'-eps<=x2<=x'+eps
	 */
	@Override
	public double root(double x0, double x1, double eps){
		double middle;
		if (Math.abs(this.f(x0)) < eps)
			return x0;
		if (Math.abs(this.f(x1)) < eps)
			return x1;
		middle = (x0 + x1) / 2;
		while (Math.abs(this.f(middle))>= eps) {
			if (this.f(x0) * this.f(middle) < 0)
				x1 = middle;
			else
				x0 = middle;
			middle = (x0 + x1) / 2;
		} 
		return middle;
	
	}
	/**
	 * create a deep copy of this Polynum
	 * @return Polynom that it is deep copy of this Polynum
	 */
	@Override
	public Polynom_able copy() {
		Polynom_able copy = new Polynom(this);
		return copy;
	}
	/**
	 * Compute a new Polynom which is the derivative of this Polynom
	 * @return new Polynom that it is the derivative of this Polynom
	 */
	@Override
	public Polynom_able derivative() {
		Monom derivedMonom;
		Polynom derivedPolynom = new Polynom();
		Iterator<Monom> it = this.iteretor();
		while (it.hasNext()) {
			derivedMonom = new Monom(it.next());
			derivedMonom.derivative();
			derivedPolynom.add(derivedMonom);
		}
		return derivedPolynom;
	}
	/**
	 * Compute Riemann's Integral over this Polynom starting from x0, till x1 using eps size steps,
	 * see: https://en.wikipedia.org/wiki/Riemann_integral
	 * @return the approximated area above the x-axis below this Polynom and between the [x0,x1] range.
	 */
	@Override
	public double area(double x0, double x1, double eps) {
		if (x0>x1) {
			double temp=x0;
			x0=x1;
			x1=temp;
		}
		double rymanSum=0;
		while (x0<x1) {
			if ((this.f(x0)*eps)>0)
				rymanSum += this.f(x0)*eps;
			x0+=eps;
		}
		return rymanSum;
	}
/**
 * iterator function for polynom 
 */
	
	@Override
	public Iterator<Monom> iteretor() {
	    Iterator<Monom> it = p.iterator();
	    return it;

	}
    /**
     * the function return String that represent this Polynom
     */
    public String toString() {
    	String s = "";
	    Iterator<Monom> it = this.iteretor();
	    if (this.isZero()) return "0*x^0";
	    while (it.hasNext()) {
	        Monom currMonom = it.next();
	    	if (currMonom.get_coefficient()<0)
	    		s=s+currMonom;
	    	else 
	    	s=s+"+"+currMonom;
	    }
	    if (s.charAt(0)=='+') return s.substring(1);
	    else return s;
    }

	//****************** Private Methods and Data *****************
	private ArrayList<Monom> p; 
	
}
