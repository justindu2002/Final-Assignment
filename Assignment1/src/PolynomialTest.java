import static org.junit.Assert.*;
import org.junit.Test;
/* 
 * Justin Du
 * Final Assignment Part 1
 * December 16, 2021
 * The PolynomialTest program contains unit tests designed to test the spcifications and functions of the Polynomial class
 * Input: N/A
 * Output: N/A
 */
public class PolynomialTest {
	@Test //Polynomial normal case
    public void testPolynomial_normal1() {
        Polynomial poly = new Polynomial();
        assertEquals(-1, poly.getDegree());
        assertEquals("0", poly.toString());
    }
   
    @Test //Polynomial(String str) normal case - Polynomial object is created
    public void testPolynomialString_normal1() {
    	Polynomial poly = new Polynomial("3.0x^2 + 2.0x + 1.0");
    	assertNotNull(poly);
   	}
    
    @Test //Polynomial(String str) normal case - handle inputs not in descending order of degree
    public void testPolynomialString_normal2() {
    	Polynomial poly = new Polynomial("1.0 + 2.0x + 3.0x^2");
    	assertNotNull(poly);
    }
    
    @Test //Polynomial(String str) normal case - input of ints
    public void testPolynomialString_normal3() {
    	Polynomial poly = new Polynomial("5x^3 + 2x + 10");
    	assertNotNull(poly);
    }
    
    @Test //Polynomial(String str) normal case - decimal coefficients
    public void testPolynomialString_normal4() {
    	Polynomial poly = new Polynomial("0.5x^3 + 2.5x^2 + 1.72x^7");
    	assertNotNull(poly);
    }
 
    @Test //Polynomial(String str) normal case - constant
    public void testPolynomialString_normal5() {
        Polynomial poly = new Polynomial("5.0");
        assertNotNull(poly);
    }
    
    @Test //Polynomial(String str) normal case - negative coefficients
    public void testPolynomialString_normal6() {
      Polynomial poly = new Polynomial("-5.0x");
      assertNotNull(poly);
    }
    
    @Test //Polynomial(String str) extreme case - constant monomial with power
    public void testPolynomialString_constantMonomial_extreme1() {
        Polynomial poly = new Polynomial("5.0x^0");
        assertNotNull(poly);
    }
    
    @Test //Polynomial(String str) extreme case - first order monomial with power
    public void testPolynomialString_firstOrderMonomial_extreme2() {
    	Polynomial poly = new Polynomial("5.0x^1");
    	assertNotNull(poly);
    }
    
    @Test //Polynomial(String str) extreme case - coefficient of 1 or -1
    public void testPolynomialString_coefficientOne_extreme3() {
    	Polynomial poly = new Polynomial("-1.0x^3 + 1.0x");
    	assertNotNull(poly);
    }
    
    @Test //Polynomial(String str) extreme case - large coefficients; large degrees; long polynomial
    public void testPolynomialString_largeCoefficient_extreme4() {
    	Polynomial poly = new Polynomial("99999.4x^5000 - 45613.2x^900 + 678.0x^73 + 9231.0x^4561 - 10003.5x^3");
    	assertNotNull(poly);
    }
    
    @Test(expected = IllegalArgumentException.class) //Polynomial(String str) exceptional case - text input
    public void testPolynomialString_textInput_exception1() {
    	Polynomial poly = new Polynomial("i love coding");
    }
    
    @Test(expected = IllegalArgumentException.class) //Polynomial(String str) exceptional case - empty string input
    public void testPolynomialString_nullInput_exception2() {    
    	Polynomial poly = new Polynomial("");
    }
    
    @Test(expected = IllegalArgumentException.class) //Polynomial(String str) exceptional case - double degree input
    public void testPolynomialString_doubleDegree_exception3() {
        Polynomial poly = new Polynomial("5x^5.0");
    }
    
    @Test(expected = IllegalArgumentException.class) //Polynomial(String str) exceptional case - negative coefficients
    public void testPolynomialString_negativeCoefficients_exception4() {
    	Polynomial poly = new Polynomial("-5.0x^4 + (-2.0)x^2 - 3.0x^7");
    }
    
    @Test //toString normal case
    public void testToString_normal1() {
    	Polynomial poly = new Polynomial("3.0x^2 + 2.0x + 1.0");
    	assertEquals("3.0x^2 + 2.0x + 1.0", poly.toString());
    }
    
    @Test //toString normal case - formatting into descending order
    public void testToString_normal2() {
    	Polynomial poly = new Polynomial("1.0 + 2.0x + 3.0x^2");
    	assertEquals("3.0x^2 + 2.0x + 1.0", poly.toString());
    }
    
    @Test //toString normal case - input of ints
    public void testToString_normal3() {
    	Polynomial poly = new Polynomial("5x^3 + 2x + 10");
    	assertEquals("5.0x^3 + 2.0x + 10.0", poly.toString());
    }
    
    @Test //toString normal case - decimal coefficients
    public void testToString_normal4() {
    	Polynomial poly = new Polynomial("0.5x^3 + 2.5x^2 - 1.7x^7");
    	assertEquals("-1.7x^7 + 0.5x^3 + 2.5x^2", poly.toString());
    }
    
    @Test //toString normal case - constant
    public void testToString_normal5() {
    	Polynomial poly = new Polynomial("5.0");
    	assertEquals("5.0", poly.toString());
    }
    
    @Test //toString normal case - zero polynomial
    public void testToString_normal6() {
    	Polynomial poly = new Polynomial("0.0");
    	assertEquals("0", poly.toString());
    }
    
    @Test //toString normal case - formatting of constant monomial with power
    public void testToString_normal7() {
    	Polynomial poly = new Polynomial("5.0x^0");
    	assertEquals("5.0", poly.toString());
    }
    
    @Test //toString normal case - formatting of first order monomial with power
    public void testToString_normal8() {
    	Polynomial poly = new Polynomial("5.0x^1");
    	assertEquals("5.0x", poly.toString());
    }
    
    @Test //toString normal case - formatting of coefficent of 1 and -1
    public void testToString_normal9() {
    	Polynomial poly = new Polynomial("-1.0x^3 + 1.0x");
    	assertEquals("-x^3 + x", poly.toString());
    }
    
    @Test //toString extreme case - large coefficients; large degrees; long polynomial
    public void testToString_largeCoefficient_extreme1() {
    	Polynomial poly = new Polynomial("99999.4x^5000 - 45613.2x^900 + 678.0x^73 + 9231.0x^4561 - 10003.5x^3");
    	assertEquals("99999.4x^5000 + 9231.0x^4561 - 45613.2x^900 + 678.0x^73 - 10003.5x^3", poly.toString());
    }
    
    @Test //toString extreme case - formatting of mutiple same degrees
    public void testToString_multipleDegrees_extreme2(){
        Polynomial poly = new Polynomial("3.0x^3 + 4.0x^3 + 5.0x^3");
        assertEquals("12.0x^3", poly.toString());
    }
    
    @Test //getDegree normal case
    public void testDegree_normal1() {
    	Polynomial poly = new Polynomial("4.0x^2 + 3.0x + 2.0");
    	assertEquals(2, poly.getDegree());
    }
    
    @Test //getDegree normal case - constant
    public void testDegree_normal2() {
    	Polynomial poly = new Polynomial("10.0");
    	assertEquals(0, poly.getDegree());
    }
    
    @Test //getDegree normal case - multiple same degrees
    public void testDegree_normal3() {
    	Polynomial poly = new Polynomial("5.0x^2 + 3.0x^2 + 10.0x^2");
    	assertEquals(2, poly.getDegree(), 0);
    }
    
    @Test //getDegree extreme case - very large degree
    public void testDegree_largeDegree_extreme1() {
    	Polynomial poly = new Polynomial("5.0x^1095142 + 4.0x - 3.0");
    	assertEquals(1095142, poly.getDegree());	
    }
    
    @Test //getCoefficient normal case
    public void testCoefficient_normal1() {
    	Polynomial poly = new Polynomial("3.0x^2 + 2.0x + 1.0");
    	assertEquals(3.0, poly.getCoefficient(2), 0);
    }
    
    @Test //getCoefficient normal case - no coefficient with specified degree
    public void testCoefficient_normal2() {
    	Polynomial poly = new Polynomial("3.0x^2 + 2.0x + 1.0");
    	assertEquals(0, poly.getCoefficient(4), 0);			
    }
    
    @Test //getCoefficient normal case - constant
    public void testCoefficient_normal3() {
    	Polynomial poly = new Polynomial("3.0x^2 + 2.0x + 2.0");
    	assertEquals(2, poly.getCoefficient(0), 0);
    }
    
    @Test //getCoefficient extreme case - very large coefficient
    public void testCoefficient_largeCoefficient_extreme1() {
    	Polynomial poly = new Polynomial("9005000000000.99x^9 + 2.0x + 1.0");
    	assertEquals(9005000000000.99, poly.getCoefficient(9), 0);
    }
    
    @Test //getCoefficient normal case - negative coefficient
    public void testCoefficient_normal4() {
    	Polynomial poly = new Polynomial("3.0x^2 - 2.0x^3 + 2.0");
    	assertEquals(-2, poly.getCoefficient(3), 0);
    }
    
    @Test //getCoefficient normal case - decimal coefficient
    public void testCoefficient_normal5() {
    	Polynomial poly = new Polynomial("3.12x^2 - 2.87x^3 + 2.99");
    	assertEquals(-2.87, poly.getCoefficient(3), 0);
    }
    
    @Test //update normal case
    public void testUpdate_normal1() {
    	Polynomial poly = new Polynomial("3.0x^3 + 2.0x^2 + x + 1.0");
    	poly.update(3.0, 3);
        assertEquals("6.0x^3 + 2.0x^2 + x + 1.0", poly.toString());
    } 
    
    @Test //update normal case - negative updated coefficient
    public void testUpdate_normal2() {
    	Polynomial poly = new Polynomial("3.0x^3 + 2.0x^2 + x + 1.0");
    	poly.update(-2.0, 3);
    	assertEquals("x^3 + 2.0x^2 + x + 1.0", poly.toString());
    }
    
    @Test //update normal case - initialize coefficient
    public void testUpdate_normal3() {
    	Polynomial poly = new Polynomial("3.0x^3 + 2.0x^2 + x + 1.0");
    	poly.update(4.0, 4);
    	assertEquals("4.0x^4 + 3.0x^3 + 2.0x^2 + x + 1.0", poly.toString());
    }
    
    @Test //update normal case - decimal update coefficient
    public void testUpdate_normal4() {
    	Polynomial poly = new Polynomial("3.0x^3 + 2.0x^2 + x + 1.0");
    	poly.update(2.5, 2);
    	assertEquals("3.0x^3 + 4.5x^2 + x + 1.0", poly.toString());
    }
    
    @Test //update normal case - constant update
    public void testUpdate_normal5() {
        Polynomial poly = new Polynomial("3.0x^3 + 2.0x^2 + x + 1.0");
        poly.update(5.0, 0);
        assertEquals("3.0x^3 + 2.0x^2 + x + 6.0", poly.toString());
    }
    
    @Test //update extreme case - multiple same degrees
    public void testUpdate_multipleDegrees_extreme1() {
    	Polynomial poly = new Polynomial("3.0x^3 + 4.0x^3 + 5.0x^3 + 10.0");
    	poly.update(10.0, 3);
    	assertEquals("22.0x^3 + 10.0", poly.toString());
    }
    
    @Test //update extreme case - large coefficient update
    public void testUpdate_largeCoefficient_extreme2() {
    	Polynomial poly = new Polynomial("3.0x^3 + 4.0x^2 + 5.0x + 10.0");
    	poly.update(10000000000.0, 3);
    	assertEquals("10000000003.0x^3 + 4.0x^2 + 5.0x + 10.0", poly.toString());
    }
    
    @Test(expected = IllegalArgumentException.class) //update exception case - negative degree
    public void testUpdate_negativeDegree_exception1() {
        Polynomial poly = new Polynomial("3.0x^3 + 2.0x^2 + x + 1.0");
        poly.update(5.0, -2);
    }
    
    @Test //add normal case
    public void testAdd_normal1() {
        Polynomial poly = new Polynomial("3.0x^3 + 2.0x^2 + x + 1.0");
        Polynomial polyResult = new Polynomial();
        Polynomial polyOther = new Polynomial("3.0x^3 + 2.0x^2 + x + 1.0");
        polyResult = poly.add(polyOther);
        assertEquals("6.0x^3 + 4.0x^2 + 2.0x + 2.0", polyResult.toString());
    }
    
    @Test //add normal case - negative coefficients
    public void testAdd_normal2() {
        Polynomial poly = new Polynomial("3.0x^3 + 2.0x^2 + x + 1.0");
        Polynomial polyResult = new Polynomial();
        Polynomial polyOther = new Polynomial("-5.0x^3 - 4.0x^2 - 5x - 1.0");
        polyResult = poly.add(polyOther);
        assertEquals("-2.0x^3 - 2.0x^2 - 4.0x", polyResult.toString());
    }
    
    @Test //add normal case - decimal coefficients
    public void testAdd_normal3() {
        Polynomial poly = new Polynomial("3.0x^3 + 2.0x^2 + x + 1.0");
        Polynomial polyResult = new Polynomial();
        Polynomial polyOther = new Polynomial("0.76x^3 + 1.33x^2 + 2.4x + 1.999");
        polyResult = poly.add(polyOther);
        assertEquals("3.76x^3 + 3.33x^2 + 3.4x + 2.999", polyResult.toString());
    }
    
    @Test //add normal case - new degrees
    public void testAdd_normal4() {
        Polynomial poly = new Polynomial("3.0x^3 + 2.0x^2 + x + 1.0");
        Polynomial polyResult = new Polynomial();
        Polynomial polyOther = new Polynomial("2.0x^5 + 6.0x^7 + 2.4x");
        polyResult = poly.add(polyOther);
        assertEquals("6.0x^7 + 2.0x^5 + 3.0x^3 + 2.0x^2 + 3.4x + 1.0", polyResult.toString());	
    }
    
    @Test //add normal case - adding zero polynomial
    public void testAdd_normal5() {
        Polynomial poly = new Polynomial("3.0x^3 + 2.0x^2 + x + 1.0");
        Polynomial polyResult = new Polynomial();
        Polynomial polyOther = new Polynomial();
        polyResult = poly.add(polyOther);
        assertEquals("3.0x^3 + 2.0x^2 + x + 1.0", polyResult.toString());
    }
   
    @Test //add extreme case - large coefficients
    public void testAdd_largeCoefficients_extreme1() {
        Polynomial poly = new Polynomial("3.0x^3 + 2.0x^2 + x + 1.0");
        Polynomial polyResult = new Polynomial();
        Polynomial polyOther = new Polynomial("30000.0x^3 + 299990.0x^2 + 10000080.0x - 1111111.0");
        polyResult = poly.add(polyOther);
        assertEquals("30003.0x^3 + 299992.0x^2 + 10000081.0x - 1111110.0", polyResult.toString());
    }
    
    @Test(expected = IllegalArgumentException.class) //add exceptional case - null string parameter
    public void testAdd_nullPolynomial_exception1() {
        Polynomial poly = new Polynomial("3.0x^3 + 2.0x^2 + x + 1.0");
        Polynomial polyResult = new Polynomial();
        Polynomial polyOther = new Polynomial("");
        polyResult = poly.add(polyOther);
    }
    
    @Test //subtract normal case
    public void testSubtract_normal1() {
        Polynomial poly = new Polynomial("3.0x^3 + 4.0x^2 + 5.0x + 6.0");
        Polynomial polyResult = new Polynomial();
        Polynomial polyOther = new Polynomial("2.0x^3 + 2.0x^2 + 3.0x + 3.0");
        polyResult = poly.subtract(polyOther);
        assertEquals("x^3 + 2.0x^2 + 2.0x + 3.0", polyResult.toString());
    }
    
    @Test //subtract normal case - negative coefficients
    public void testSubtract_normal2() {
        Polynomial poly = new Polynomial("3.0x^3 + 4.0x^2 + 5.0x + 6.0");
        Polynomial polyResult = new Polynomial();
        Polynomial polyOther = new Polynomial("2.0x^3 - 2.0x^2 - 3.0x + 3.0");
        polyResult = poly.subtract(polyOther);
        assertEquals("x^3 + 6.0x^2 + 8.0x + 3.0", polyResult.toString());
    }
    
    @Test //subtract normal case - decimal coefficients
    public void testSubtract_normal3() {
        Polynomial poly = new Polynomial("3.0x^3 + 4.0x^2 + 5.0x + 6.0");
        Polynomial polyResult = new Polynomial();
        Polynomial polyOther = new Polynomial("2.5x^3 + 2.7x^2 + 3.56x + 3.9");
        polyResult = poly.subtract(polyOther);
        assertEquals("0.5x^3 + 1.3x^2 + 1.44x + 2.1", polyResult.toString());
    }
    
    @Test //subtract normal case - new degrees
    public void testSubtract_normal4() {
        Polynomial poly = new Polynomial("3.0x^3 + 4.0x^2 + 5.0x + 6.0");
        Polynomial polyResult = new Polynomial();
        Polynomial polyOther = new Polynomial("2.0x^6 - 2.0x^5 + 3.0x^4");
        polyResult = poly.subtract(polyOther);
        assertEquals("-2.0x^6 + 2.0x^5 - 3.0x^4 + 3.0x^3 + 4.0x^2 + 5.0x + 6.0", polyResult.toString());
    }
    
    @Test //subtract normal case - same polynomial
    public void testSubtract_normal5() {
        Polynomial poly = new Polynomial("3.0x^3 + 4.0x^2 + 5.0x + 6.0");
        Polynomial polyResult = new Polynomial();
        Polynomial polyOther = new Polynomial("3.0x^3 + 4.0x^2 + 5.0x + 6.0");
        polyResult = poly.subtract(polyOther);
        assertEquals("0", polyResult.toString());
    }
    
    @Test //subtract normal case - zero polynomial
    public void testSubtract_normal6() {
        Polynomial poly = new Polynomial("3.0x^3 + 4.0x^2 + 5.0x + 6.0");
        Polynomial polyResult = new Polynomial();
        Polynomial polyOther = new Polynomial();
        polyResult = poly.subtract(polyOther);
        assertEquals("3.0x^3 + 4.0x^2 + 5.0x + 6.0", polyResult.toString());
    }
    
    @Test //subtract extreme case - large coefficients
    public void testSubtract_largeCoefficients_extreme1() {
        Polynomial poly = new Polynomial("30000.0x^3 + 400.0x^2 + 500000.0x + 60000.0");
        Polynomial polyResult = new Polynomial();
        Polynomial polyOther = new Polynomial("10000.0x^3 + 200.0x^2 + 5.0x + 90000.0");
        polyResult = poly.subtract(polyOther);
        assertEquals("20000.0x^3 + 200.0x^2 + 499995.0x - 30000.0", polyResult.toString());
    }
    
    @Test(expected = IllegalArgumentException.class) //subtract exception case - null string parameter
    public void testSubtract_nullPolynomial_exception1() {
        Polynomial poly = new Polynomial("3.0x^3 + 4.0x^2 + 5.0x + 6.0");
        Polynomial polyResult = new Polynomial();
        Polynomial polyOther = new Polynomial("");
        polyResult = poly.subtract(polyOther);
    }
    
    @Test //negate normal case
    public void testNegate_normal1() {
        Polynomial poly = new Polynomial("3.0x^3 + 4.0x^2 + 5.0x + 6.0");
        Polynomial polyResult = new Polynomial();
        polyResult = poly.negate();
        assertEquals("-3.0x^3 - 4.0x^2 - 5.0x - 6.0", polyResult.toString());
    }
    
    @Test //negate normal case - negative coefficients
    public void testNegate_normal2() {
        Polynomial poly = new Polynomial("-3.0x^3 - 4.0x^2 - 5.0x - 6.0");
        Polynomial polyResult = new Polynomial();
        polyResult = poly.negate();
        assertEquals("3.0x^3 + 4.0x^2 + 5.0x + 6.0", polyResult.toString()); 
    }
    
    @Test //negate normal case - decimals
    public void testNegatve_normal3() {
        Polynomial poly = new Polynomial("3.5x^3 + 4.87x^2 + 5.2x + 6.3");
        Polynomial polyResult = new Polynomial();
        polyResult = poly.negate();
        assertEquals("-3.5x^3 - 4.87x^2 - 5.2x - 6.3", polyResult.toString());
    }
    
    @Test //negate extreme case - zero polynomial
    public void testNegate_zeroPolynomial_extreme1() {
        Polynomial poly = new Polynomial();
        Polynomial polyResult = new Polynomial();
        polyResult = poly.negate();
        assertEquals("0", polyResult.toString());        
    }
    
    @Test //negate extreme case - large coefficients
    public void testNegate_largeCoefficients_extreme2() {
        Polynomial poly = new Polynomial("50000.0x^5 + 4000.0x^4 - 300.0x^3 - 29321.0x^2");
        Polynomial polyResult = new Polynomial();
        polyResult = poly.negate();
        assertEquals("-50000.0x^5 - 4000.0x^4 + 300.0x^3 + 29321.0x^2", polyResult.toString());
    }
    
    @Test //getValue normal case
    public void testGetValue_normal1() {
    	Polynomial poly = new Polynomial("3.0x^3 + 2.0x^2 + x + 1.0");
    	assertEquals(103.0, poly.getValue(3), 0);
    }
    
    @Test //getValue normal case - x = negative
    public void testGetValue_normal2() {
    	Polynomial poly = new Polynomial("3.0x^3 + 2.0x^2 + x + 1.0");
    	assertEquals(-65.0, poly.getValue(-3), 0);
    }
    
    @Test //getValue normal case - x = decimal
    public void testGetValue_normal3() {
    	Polynomial poly = new Polynomial("3.0x^3 + 2.0x^2 + x + 1.0");
    	assertEquals(62.875, poly.getValue(2.5), 0);
    }
    
    @Test //getValue normal case - x = 0
    public void testGetValue_normal4() {
    	Polynomial poly = new Polynomial("3.0x^3 + 2.0x^2 + x + 1.0");
    	assertEquals(1.0, poly.getValue(0), 0);
    }
    
    @Test //getValue normal case - zero polynomial
    public void testGetValue_normal5() {
    	Polynomial poly = new Polynomial();
    	assertEquals(0, poly.getValue(9), 0);
    }
    
    @Test //getValue extreme case - x = very large
    public void testGetValue_veryLargeX_extreme1() {
    	Polynomial poly = new Polynomial("3.0x^3 + 2.0x^2 + x + 1.0");
    	assertEquals(3020101, poly.getValue(100), 0);
    }
    
    @Test //getValue extreme case - x = very small
    public void testGetValue_verySmallX_extreme2() {
    	Polynomial poly = new Polynomial("3.0x^3 + 2.0x^2 + x + 1.0");
    	assertEquals(1.001002003, poly.getValue(0.001), 0);
    }
    
    @Test //getDerivative normal case
    public void testGetDerivative_normal1() {
    	Polynomial poly = new Polynomial("3.0x^3 + 2.0x^2");
    	Polynomial polyResult = new Polynomial();
    	polyResult = poly.getDerivative();
    	assertEquals("9.0x^2 + 4.0x", polyResult.toString());
    }
    
    @Test //getDerivative normal case - negative coefficients
    public void testGetDerivative_normal2() {
    	Polynomial poly = new Polynomial("-3.0x^3 - 2.0x^2");
    	Polynomial polyResult = new Polynomial();
    	polyResult = poly.getDerivative();
    	assertEquals("-9.0x^2 - 4.0x", polyResult.toString());
    }
    
    @Test //getDerivative normal case - decimal coefficients
    public void testGetDerivative_normal3() {
    	Polynomial poly = new Polynomial("3.5x^3 + 2.25x^2");
    	Polynomial polyResult = new Polynomial();
    	polyResult = poly.getDerivative();
    	assertEquals("10.5x^2 + 4.5x", polyResult.toString());
    }
    
    @Test //getDerivative normal case - constant
    public void testGetDerivative_normal4() {
    	Polynomial poly = new Polynomial("10.0");
    	Polynomial polyResult = new Polynomial();
    	polyResult = poly.getDerivative();
    	assertEquals("0", polyResult.toString());
    }
    
    @Test //getDerivative normal case - no coefficient
    public void testGetDerivative_normal5() {
    	Polynomial poly = new Polynomial("x^3");
    	Polynomial polyResult = new Polynomial();
    	polyResult = poly.getDerivative();
    	assertEquals("3.0x^2", polyResult.toString());
    }
    
    @Test //getDerivative normal case - first order monomial
    public void testGetDerivative_normal6() {
    	Polynomial poly = new Polynomial("10.0x");
    	Polynomial polyResult = new Polynomial();
    	polyResult = poly.getDerivative();
    	assertEquals("10.0", polyResult.toString());
    }
    
    @Test //getDerivative extreme case - large coefficients
    public void testGetDerivative_largeCoefficients_extreme1() {
    	Polynomial poly = new Polynomial("3095.2x^10 + 21000.0x^8");
    	Polynomial polyResult = new Polynomial();
    	polyResult = poly.getDerivative();
    	assertEquals("30952.0x^9 + 168000.0x^7", polyResult.toString());
    }
}
