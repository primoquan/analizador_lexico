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


/*Vamos a poner la salida como que fuera un formato tabla para que se vea mas ordenado*/
            System.out.printf("%-20s %-30s %-15s %-6s %-8s%n","TOKEN","LEXEMA","PATRON","FILA","COLUMNA");
            writer.printf("%-20s %-30s %-15s %-6s %-8s%n","TOKEN","LEXEMA","PATRON","FILA","COLUMNA");

            while ((token = lexer.yylex()) != null) {

                System.out.printf("%-20s %-30s %-15s %-6d %-8d%n",
                        token.nombre,
                        token.lexema,
                        token.patron,
                        token.fila,
                        token.columna);

                writer.printf("%-20s %-30s %-15s %-6d %-8d%n",
                        token.nombre,
                        token.lexema,
                        token.patron,
                        token.fila,
                        token.columna);
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