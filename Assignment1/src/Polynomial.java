	import java.io.FileNotFoundException;
	import java.util.Arrays;
	import java.io.File;
	import java.math.BigDecimal;
	/* 
	 * Justin Du
	 * Final Assignment Part 2
	 * December 16, 2021
	 * The Polynomial program contains code applicable for the assignment
	 * Input: N/A
	 * Output: N/A
	 */	
public class Polynomial {
	//Assign int degree and double coefficient for future code reference as a private.	
	private int degree;
    private double[] coefficient;
    
    //This method creates a new Polynomial object of degree -1      
    public Polynomial() {
        //Sets the degree to -1 for a zero polynomial
    	this.degree = 0;
    	//Sets the coefficient to 0
        this.coefficient = new double[1];
        this.coefficient[0] = 0;
    }
    
    //Method returns the degree of a certain polynomial
    public int getDegree(){
        //Returns Degree
    	return this.degree;
    }
   
    //Method returns the coefficient of a certain polynomial
    public double getCoefficient(int degree){
    	//Returns Coefficient if called upon
    	return coefficient[degree];
    }
    
    //Returns the result of calculating the polynomial with given x
    public double getValue(double x) {
		//Create a results variable 
    	double result = 0;
		//Loops through the degree number to 0, i amount of times
    	for (int i = degree; i >= 0; i--) {
			//result is equal to the coefficient plus x times the result
    		result = coefficient[i] + (x*result);
			//return result to the initial for loop
    		return result;
		}
    	//return the final result
		return result;
    }
    
    //Updates the degree and coefficient of the polynomial
    public void update(double[] coefficient, int degree){
        //If statement, if the degree is greater than the length of the coefficient then proceed
    	if (degree >= coefficient.length)  {
            double[] temp = null;
            //Loop from 0 to the value of the degree and increments by 1
            for (int i = 0; i <= degree; ++i) {
                temp[i] = coefficient[i];
            }
            coefficient = temp;
        }
    	//Updates the new coefficient with the coefficient provided
        coefficient[degree] = coefficient;
    	//Updates the new degree with the degree provided if it is larger than this degree
        if (degree > this.degree) {
            this.degree = degree;
        }
    }
    
    //Adds together two sets of polynomials
    public Polynomial add(Polynomial other){
    	//Create a new Polynomial called returnValue which represents the final polynomial
        Polynomial returnValue = new Polynomial(); 
        //Create a loop that goes from 0 to the greater of this degree or the other degree
        for (int i = 0; i < Math.max(this.degree, other.getDegree()); i++){
            //if i is less than both degrees then it will add the two coefficients together 
        	if (i < this.degree && i < other.getDegree()) {
                returnValue.update(this.coefficient[i]+other.getCoefficient(i), i);
            //otherwise if i is only less than this degree, it will update only this.coefficient
        	} else if (i < this.degree) {
                returnValue.update(this.coefficient[i], i);
            //otherwise if i is only less than this degree, it will update only the other.coefficient
        	} else if (i < other.getDegree()) {
                returnValue.update(other.getCoefficient(i), i);
            } 
        }
        return returnValue; 
    }
    
    //Substracts together two sets of polynomials
    public Polynomial substact(Polynomial other){
    	//Create a new Polynomial called returnValue which represents the final polynomial
    	Polynomial returnValue = new Polynomial();
        //Create a loop that goes from 0 to the greater of this degree or the other degree
    	for (int i = 0; i < Math.max(this.degree, other.getDegree()); i++){
            //if i is less than both degrees then it will substract the two coefficients together 
    		if (i < this.degree && i < other.getDegree()) {
                returnValue(this.coefficient[i]-other.getCoefficient(i), i);
            //otherwise if i is only less than this degree, it will update only this.coefficient
    		} else if (i < this.degree) {
            	returnValue.update(this.coefficient[i], i);
            //otherwise if i is only less than this degree, it will update only the other.coefficient
    		} else if (i < other.getDegree()) {
                returnValue.update(other.getCoefficient(i), i);
            } 
        } 
        return returnValue; 
    }
    
    //Negates each term in the polynomial and returns the result
    public Polynomial negate(){
    	//Create a new polynomial which will contain the final answer
    	Polynomial returnValue = new Polynomial();
    	//Loop that goes from 0 to the value of the degree
    	for (int i = 0; i < this.degree; ++i) {
    	   //Multiplies all the coefficients by negative one
           returnValue.update(-1 * this.coefficient[i], i);
       }
    	//Returns the new zero value
        return returnValue;
    }
    //Calculates the derivative of the polynomial
    public Polynomial getDerrivative() {
    	//Create a new polynomial which will contain the final answer
    	Polynomial returnValue = new Polynomial();
    	//Loop that sorts from 0 to value of degree and adds one to i and multiples the coefficient by the value
    	//Then multiples it again by (i+1) 
    	for (int i = 0; i < degree; i++) {
            returnValue.coefficient = (i + 1) * coefficient[i + 1];
        }
        return returnValue;
    }
    
    //Returns a string that is a representation of the polynomial 
    public String toString() {
        //The degree of a polynomial can not be less or equal to -1, so throw an Illegal Argument Exception
    	if (degree <= -1) {
        	throw new IllegalArgumentException("Exponent can not be negative");
        }
    	//If the degree is zero return coefficient[0]
        else if (degree ==  0) {
        	return "" + coefficient[0];
        }
    	//If the degree is one then return the coefficient as well as the x variable
        else if (degree ==  1) {
        	return coefficient[1] + "x + " + coefficient[0];
        }
        //Loop through 0 to value of the degree and return the coefficient and degree i times       
        for (int i = 0; i < degree; i++) {
        	String returnString = coefficient[degree] + "x^" + degree;
            //if the coefficient is positive put a plus in front of it
        	if (coefficient[i]  > 0) {
            	returnString = returnString + " + " + (coefficient[i]);
            }
        	//if the coefficient is negative put a minus in front of it
            else if (coefficient[i]  < 0) {
            	returnString = returnString + " - " + (-coefficient[i]);
            }
        }
		return null;
    }
}
	