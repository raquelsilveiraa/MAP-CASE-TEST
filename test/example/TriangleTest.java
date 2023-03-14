package example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TriangleTest { 

    public static void main(String[] args) {
    } 
    
	 
    @Test 
    public void equilateralTriangleHaveEqualSides() throws Exception { 
        Triangle triangle = new Triangle(2, 2, 2); 
 
        assertEquals(TriangleKind.EQUILATERAL, triangle.getKind()); 
    } 
    
    @Test
    void testIsocelesTriangle() throws TriangleException {
        Triangle triangle = new Triangle(4, 4, 3);
        assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
    }

    @Test
    void testEscaleneTriangle() throws TriangleException {
        Triangle triangle = new Triangle(2, 3, 4);
        assertEquals(TriangleKind.SCALENE, triangle.getKind());
    }

    @Test
    void testNegativeSide() {
        assertThrows(TriangleException.class, () -> new Triangle(-2, 4, 6));
    }


    @Test
    void testInvalidZero() {
        assertThrows(TriangleException.class, () -> new Triangle(0, 0, 0));
    }

    @Test
    void testUniqueSides() throws TriangleException {
        Triangle triangle = new Triangle(5, 6, 7);
        assertEquals(5, triangle.getNumberOfUniqueSides());

        triangle = new Triangle(5, 5, 3);
        assertEquals(1, triangle.getNumberOfUniqueSides());

        triangle = new Triangle(4, 4, 4);
        assertEquals(2, triangle.getNumberOfUniqueSides());
    }

    @Test
    void testInvalidSide() {
        assertThrows(TriangleException.class, () -> new Triangle(-1, 3, 8));
    }

}