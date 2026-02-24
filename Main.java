import java.io.FileReader;
import java.io.PrintWriter;


/* Este main solo va a tener su clase main
Este va a ser la funcion principal de mandar a llamar el json y analizarlo
con jflex, y luego va a imprimir los tokens encontrados al analizar
*/
public class Main {
    public static void main(String[] args){
        try {
            FileReader reader = new FileReader("base.json");

            Analizador lexer = new Analizador(reader);

            /* archivo donde se guardaran los tokens */
            PrintWriter writer = new PrintWriter("resultado.txt");

            Analizador.Token token;

            System.out.println("TOKEN\tLEXEMA\tPATRON\tFILA\tCOLUMNA");
            writer.println("TOKEN\tLEXEMA\tPATRON\tFILA\tCOLUMNA");

            while ((token = lexer.yylex()) != null) {

                String linea =
                        token.nombre + "\t" +
                        token.lexema + "\t" +
                        token.patron + "\t" +
                        token.fila + "\t" +
                        token.columna;

                System.out.println(linea);
                writer.println(linea);
            }

            /* cerrar archivo */
            writer.close();
        }
        
        /*Con esto vamos a ver errores por si no esta el archivo */ 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}