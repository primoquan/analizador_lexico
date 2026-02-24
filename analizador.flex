%%
/* Aqui vamos a poner el nombre de la clase de jflex, el tipo de caracteres a leer, 
vamos a leer lineas y columnas, y vamos a decir que vamos a crear tokens*/
%class Analizador

%unicode
%line 
%column
%type token


/*Con esta clase vamos a guardar cada token que se encuentre*/
%{
    public static class Token {
        public String nombre;
        public String lexema;
        public String patron;
        public int fila;
        public int columna;

        public Token(String nombre, String lexema, String patron, int fila, int columna){
            this.nombre = nombre;
            this.lexema = lexema;
            this.patron = patron;
            this.fila = fila;
            this.columna = columna;
        }
    }
%}

//Estas son nuestras expresiones

STRING = \"([^\"\\]|\\.)*\"  //Esta es nuestra cadena de texto
NUMERO = [0-9]+  //Este es nuestra cadena de entero
DECIMAL = [0-9]+\.[0-9]+  //Esta es para decimal
BOOLEAN = true|false  //Para guardar booleano uno u otro
NULL = null  //Nulo
ESPACIO = [ \t\r\n]+ //Este es para que nos reconozca el espacio

%% 

//Aqui vamos a hacer nuestra reglas

"{"         { return new Token("LLAVE_ABRE", yytext(), "\\{", yyline+1, yycolumn+1); }
"}"         { return new Token("LLAVE_CIERRA", yytext(), "\\}", yyline+1, yycolumn+1); }
"["         { return new Token("CORCHETE_ABRE", yytext(), "\\[", yyline+1, yycolumn+1); }
"]"         { return new Token("CORCHETE_CIERRA", yytext(), "\\]", yyline+1, yycolumn+1); }
":"         { return new Token("DOS_PUNTOS", yytext(), ":", yyline+1, yycolumn+1); }
","         { return new Token("COMA", yytext(), ",", yyline+1, yycolumn+1); }
{STRING}    { return new Token("STRING", yytext(), STRING, yyline+1, yycolumn+1); }
{DECIMAL}   { return new Token("DECIMAL", yytext(), DECIMAL, yyline+1, yycolumn+1); }
{NUMERO}    { return new Token("NUMERO", yytext(), NUMERO, yyline+1, yycolumn+1); }
{BOOLEAN}   { return new Token("BOOLEAN", yytext(), BOOLEAN, yyline+1, yycolumn+1); }
{NULL}      { return new Token("NULL", yytext(), NULL, yyline+1, yycolumn+1); }


//Vamos a ignorar los espacios por que no nos los piden

{ESPACIO} {}

//Nuestra validacion de error
.           { return new Token("ERROR", yytext(), "DESCONOCIDO", yyline+1, yycolumn+1); }