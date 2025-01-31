import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VectorStackTest {
    private VectorStack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new VectorStack<>();
    }

    @Test
    public void testPushAndPop() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPeek() {
        stack.push(1);
        assertEquals(1, stack.peek());
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPopEmptyStack() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            stack.pop();
        });
        assertEquals("Error: Pila vacía.", exception.getMessage());
    }

    @Test
    public void testPeekEmptyStack() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            stack.peek();
        });
        assertEquals("Error: Pila vacía.", exception.getMessage());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, stack.size());
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
    }
}