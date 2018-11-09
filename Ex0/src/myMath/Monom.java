
package myMath;
/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author eilon,yitzhak
 
 */
public class Monom implements function{
	/**
	 * constructor of monom that get 2 parameters 
	 * @param a represent the coefficient of the monomial
	 * @param b represent the power of the monomial 
	 * @throws Exception when b is negative 
	 */
	public Monom(double a, int b) throws Exception{
		if (b>=0) {
		this.set_coefficient(a);
		this.set_power(b);
		}
		else throw new Exception("power cant be negative");
	}
	/**
	 * constructor that get other monom and build a new monom with its values
	 * @param ot monom
	 */
	public Monom(Monom ot){
		this.set_coefficient(ot.get_coefficient());
		this.set_power(ot.get_power());
	}

	/**
	 * the function get x value and return the calculate of this monom
	 * @param x double
	 */
	@Override
	public double f(double x) {
		return this._coefficient*Math.pow(x,this._power);
	} 
	/**
	 * the function derivate(gozeret) this monom and update it 
	 */
    public void derivative() {
    	if (this.get_power()==0) {
    		this.set_coefficient(0);
    		this.set_power(0);
    	}
    	else {
    	this.set_coefficient(this.get_coefficient()*this.get_power());
    	this.set_power(this.get_power()-1);
    	}
    	
    }
    /**
     * add other to this monom 
     * @param other monom
     * @throws Exception when the power of this monom are not equal to the power of other
     */
    public void add(Monom other) throws Exception {
    	if (this.get_power()==other.get_power()) 
    		this.set_coefficient(this.get_coefficient()+other.get_coefficient());
    	else throw new Exception("can't add two monoms with differnt power");
    	
    }
    /**
     * multiply this monom with other
     * @param other monom
     */
    public void multiply(Monom other) {
    	this.set_coefficient(this.get_coefficient()*other.get_coefficient());
    	this.set_power(this.get_power()+other.get_power());
    	
    }
    /**
     * the function return String that represent this monom
     */
    public String toString() {
    	
    	return ""+this.get_coefficient()+"*X^"+this.get_power();
    }
    /**
     * 
     * @return the value of _power
     */
	public int get_power() {
		return this._power;
	}
	/**
	 * 
	 * @return the value of _coefficient
	 */
	public double get_coefficient() {
		return this._coefficient;
	}
	/**
	 * the function update _coefficient to be the parameter a 
	 * @param a double 
	 */
	public void set_coefficient(double a){
		this._coefficient = a;
	}
	/**
	 * the function update _power to be the parameter p
	 * @param p int
	 * @throws Exception when p is negative
	 */
	private void set_power(int p) {
			this._power = p;
		
	}
	//****************** Private Methods and Data *****************
	


	private double _coefficient; // 
	private int _power;


}
