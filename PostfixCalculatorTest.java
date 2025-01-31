import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PostfixCalculatorTest {
    private PostfixCalculator calculator;
    private VectorStack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new VectorStack<>();
        calculator = new PostfixCalculator(stack);
    }

    @Test
    public void testSimpleAddition() {
        assertEquals(5, calculator.evaluate("2 3 +")); // 2 + 3
    }

    @Test
    public void testSimpleSubtraction() {
        assertEquals(1, calculator.evaluate("3 2 -")); // 3 - 2
    }

    @Test
    public void testSimpleMultiplication() {
        assertEquals(6, calculator.evaluate("2 3 *")); // 2 * 3
    }

    @Test
    public void testSimpleDivision() {
        assertEquals(2, calculator.evaluate("6 3 /")); // 6 / 3
    }

    @Test
    public void testComplexExpression() {
        assertEquals(20, calculator.evaluate("2 3 + 4 *")); // (2 + 3) * 4
        assertEquals(14, calculator.evaluate("5 1 2 + 4 * + 3 -")); // 5 + ((1 + 2) * 4) - 3
    }

    @Test
    public void testInvalidCharacter() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            calculator.evaluate("2 3 &");
        });
        assertEquals("Error: Carácter inválido en la expresión.", exception.getMessage());
    }

    @Test
    public void testInsufficientOperands() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            calculator.evaluate("2 +");
        });
        assertEquals("Error: Operandos insuficientes.", exception.getMessage());
    }

    @Test
    public void testMalformedExpression() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            calculator.evaluate("2 3 + 4 + +");
        });
        assertEquals("Error: Expresión mal formada.", exception.getMessage());
    }

    @Test
    public void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.evaluate("4 0 /");
        });
        assertEquals("Error: División por cero.", exception.getMessage());
    }
}
