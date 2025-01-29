import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        String fileName = "datos.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String expression = br.readLine(); // Leer primera línea del archivo
            if (expression != null) {
                PostfixCalculator calculator = new PostfixCalculator(new VectorStack<>());
                int result = calculator.evaluate(expression);
                System.out.println("Resultado: " + result);
            } else {
                System.out.println("Error: El archivo está vacío.");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
