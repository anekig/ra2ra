import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {

    // Constructor
    @Test
    public void testStandardConstructor() {
        Rational standard = new Rational();
        assertEquals("Standard constructor returns wrong numerator", 0, standard.getNumerator());
        assertEquals("Standard constructor returns wrong denominator", 1, standard.getDenominator());
    }

    @Test
    public void testProperFractionConstructor() {
        Rational properFraction = new Rational(1, 2);
        assertEquals("Proper fraction constructor returns wrong numerator", 1, properFraction.getNumerator());
        assertEquals("Proper fraction constructor returns wrong denominator", 2, properFraction.getDenominator());
    }

    @Test
    public void testImproperFractionConstructor() {
        Rational improperFraction = new Rational(5, 1);
        assertEquals("Improper fraction constructor returns wrong numerator", 5, improperFraction.getNumerator());
        assertEquals("Improper fraction constructor returns wrong denominator", 1, improperFraction.getDenominator());
    }

    @Test
    public void testReducedFractionConstructor() {
        Rational reducedFraction = new Rational(4, 4);
        assertEquals("Reduced fraction constructor returns wrong numerator", 1, reducedFraction.getNumerator());
        assertEquals("Reduced fraction constructor returns wrong denominator", 1, reducedFraction.getDenominator());
    }

    @Test
    public void testZeroDenominatorConstructor() {
        try {
            new Rational(1, 0);
        } catch (Exception e) {
            assertSame("Exception class must be ArithmeticException", e.getClass(), ArithmeticException.class);
        }
    }

    @Test
    public void testNegativeFractionWithNegativeNumeratorConstructor() {
        Rational negativeFractionWithNegativeNumerator = new Rational(-2, 5);
        assertEquals("Negative fraction with negative numerator constructor returns wrong numerator", -2, negativeFractionWithNegativeNumerator.getNumerator());
        assertEquals("Negative fraction with negative numerator constructor returns wrong numerator", 5, negativeFractionWithNegativeNumerator.getDenominator());
    }

    @Test
    public void testNegativeFractionWithNegativeDenominatorConstructor() {
        Rational negativeFractionWithNegativeNumerator = new Rational(2, -5);
        assertEquals("Negative fraction with negative denominator constructor returns wrong numerator returns wrong numerator", -2, negativeFractionWithNegativeNumerator.getNumerator());
        assertEquals("Negative fraction with negative denominator constructor returns wrong denominator", 5, negativeFractionWithNegativeNumerator.getDenominator());
    }

    @Test
    public void testPositiveFractionWithNegativeNumeratorAndDenominatorConstructor() {
        Rational positiveFractionWithNegativeNumeratorAndDenominator = new Rational(-2, -5);
        assertEquals("Positive fraction with negative numerator and denominator constructor returns wrong numerator", 2, positiveFractionWithNegativeNumeratorAndDenominator.getNumerator());
        assertEquals("Positive fraction with negative numerator and denominator constructor returns wrong denominator", 5, positiveFractionWithNegativeNumeratorAndDenominator.getDenominator());
    }

    // Equality
    @Test
    public void testEqualityIsEqual() {
        Rational a = new Rational(1, 2);
        Rational b = new Rational(1, 2);
        assertTrue(a + " and " + b + "are not equal", a.equals(b));
    }

    @Test
    public void testEqualityIsNotEqual() {
        Rational a = new Rational(2, 5);
        Rational b = new Rational(1, 3);
        assertFalse(a + " and " + b + "are equal", a.equals(b));
    }

    // Less
    @Test
    public void testLessDifferentNumeratorsDifferentDenominatorsIsTrue() {
        Rational a = new Rational(1, 4);
        Rational b = new Rational(5, 7);
        assertTrue(a + " is not less than " + b, a.less(b));
    }

    @Test
    public void testLessSameNumeratorsDifferentDenominatorsIsTrue() {
        Rational a = new Rational(1, 3);
        Rational b = new Rational(1, 2);
        assertTrue(a + " is not less than " + b, a.less(b));
    }

    @Test
    public void testLessDifferentNumeratorsSameDenominatorsIsTrue() {
        Rational a = new Rational(2, 3);
        Rational b = new Rational(4, 3);
        assertTrue(a + " is not less than " + b, a.less(b));
    }

    @Test
    public void testLessSameNumeratorsSameDenominatorsIsFalse() {
        Rational a = new Rational(2, 2);
        Rational b = new Rational(2, 2);
        assertFalse(a + " is less than " + b, a.less(b));
    }

    // Less than or equal to
    @Test
    public void testLessOrEqualEqualIsTrue() {
        Rational a = new Rational(1, 2);
        Rational b = new Rational(1, 2);
        assertTrue(a + " is not equal " + b, a.lessOrEqual(b));
    }

    @Test
    public void testLessOrEqualLessIsTrue() {
        Rational a = new Rational(1, 3);
        Rational b = new Rational(1, 2);
        assertTrue(a + " is not less than " + b, a.lessOrEqual(b));
    }

    // Plus
    @Test
    public void testNegativeFractionPlusPositiveFraction() {
        Rational a = new Rational(-2, 5);
        Rational b = new Rational(1, 10);
        Rational sum = new Rational(-3, 10);
        assertEquals(a + " + " + b + " not equal " + sum, sum, a.plus(b));
    }

    @Test
    public void testNegativeFractionPlusNegativeFraction() {
        Rational a = new Rational(-2, 5);
        Rational b = new Rational(-1, 3);
        Rational sum = new Rational(-11, 15);
        assertEquals(a + " + " + b + " not equal " + sum, sum, a.plus(b));
    }

    @Test
    public void testPositiveFractionPlusPositiveFraction() {
        Rational a = new Rational(3, 1);
        Rational b = new Rational(1, 10);
        Rational sum = new Rational(31, 10);
        assertEquals(a + " + " + b + " not equal " + sum, sum, a.plus(b));
    }

    // Minus
    @Test
    public void testPositiveFractionMinusNegativeFraction() {
        Rational a = new Rational(2, 5);
        Rational b = new Rational(-1, 10);
        Rational sum = new Rational(1, 2);
        assertEquals(a + " + " + b + " not equal " + sum, sum, a.minus(b));
    }

    @Test
    public void testNegativeFractionMinusNegativeFraction() {
        Rational a = new Rational(-2, 5);
        Rational b = new Rational(-1, 3);
        Rational diff = new Rational(-1, 15);
        assertEquals(a + " - " + b + " not equal " + diff, diff, a.minus(b));
    }

    // Multiply
    @Test
    public void testPositiveFractionMultipliedByPositiveFraction() {
        Rational a = new Rational(2, 5);
        Rational b = new Rational(1, 10);
        Rational sum = new Rational(1, 25);
        assertEquals(a + " * " + b + " not equal " + sum, sum, a.multiply(b));
    }

    @Test
    public void testNegativeFractionMultipliedByNegativeFraction() {
        Rational a = new Rational(-2, 5);
        Rational b = new Rational(-1, 10);
        Rational sum = new Rational(1, 25);
        assertEquals(a + " * " + b + " not equal " + sum, sum, a.multiply(b));
    }

    // Divide
    @Test
    public void testNegativeFractionDividedByPositiveFraction() {
        Rational a = new Rational(-2, 5);
        Rational b = new Rational(1, 10);
        Rational sum = new Rational(-4, 1);
        assertEquals(a + " / " + b + " not equal " + sum, sum, a.divide(b));
    }

    @Test
    public void testNegativeFractionDividedByNegativeFraction() {
        Rational a = new Rational(-2, 5);
        Rational b = new Rational(-1, 10);
        Rational sum = new Rational(4, 1);
        assertEquals(a + " * " + b + " not equal " + sum, sum, a.divide(b));
    }

    @Test
    public void testNegativeFractionDividedByZero() {
        Rational a = new Rational(-2, 5);
        Rational b = new Rational(-1, 10);
        try {
            a.divide(b);
        } catch (Exception e) {
            assertSame("Exception class must be ArithmeticException", e.getClass(), ArithmeticException.class);
        }
    }

}