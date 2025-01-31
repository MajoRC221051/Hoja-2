public class PostfixCalculator {
    private Stack<Integer> stack;

    public PostfixCalculator(Stack<Integer> stack) {
        this.stack = stack;
    }

    
    /** 
     * @param expression
     * @return int
     */
    public int evaluate(String expression) {
        while (!stack.isEmpty()) {  // Limpia la pila antes de cada evaluación
            stack.pop();
        }

        String[] tokens = expression.trim().split("\\s+");

        for (String token : tokens) {
            if (token.matches("\\d+")) { 
                stack.push(Integer.parseInt(token));
            } else if (token.matches("[+\\-*/%]")) { 
                if (stack.size() < 2) {
                    throw new RuntimeException("Error: Operandos insuficientes.");
                }
                int b = stack.pop();
                int a = stack.pop();
                stack.push(applyOperation(a, b, token));
            } else {
                throw new RuntimeException("Error: Carácter inválido en la expresión.");
            }
        }

        if (stack.size() != 1) {
            throw new RuntimeException("Error: Expresión mal formada.");
        }

        return stack.pop();
    }

    private int applyOperation(int a, int b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": 
                if (b == 0) throw new ArithmeticException("Error: División por cero.");
                return a / b;
            case "%": return a % b;
            default: throw new RuntimeException("Error: Operador desconocido.");
        }
    }
}
