import java.io.FileReader;


/* Este main solo va a tener su clase main
Este va a ser la funcion principal de mandar a llamar el json y analizarlo
con jflex, y luego va a imprimir los tokens encontrados al analizar
*/
public class Main {
    public static void main(String[] args){
        try {
            FileReader reader = FileReader("base.json");

            Analizador lexer = Analizador(reader);

            Analizador.Token token;

            System.out.println("TOKEN\tLEXEMA\tPATRON\tFILA\tCOLUMNA");

            while ((token = lexer.yylex()) != null) {

                System.out.println(
                        token.nombre + "\t" +
                        token.lexema + "\t" +
                        token.patron + "\t" +
                        token.fila + "\t" +
                        token.columna
                );
            }
        }
        
        /*Con esto vamos a ver errores por si no esta el archivo */ 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
