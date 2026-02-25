# Analizador Léxico de Archivos JSON en Java con JFlex

**Herramienta de análisis léxico desarrollada con JFlex para procesar estructuras de archivos JSON.**

## Descripcion del programa 

Este programa es un analizador léxico desarrollado en lenguaje Java utilizando la herramienta JFlex.

Su función es poder leer un archivo JSON, analizar su contenido y mostrar los tokens encontrados.

## *¿Pero que significa esto?* 
Lo que permite realizar el programa es meter informacion en formato JSON con un archivo llamado base.json y al ejecutarlo nos va a dar una salida llamada "resultado.txt" donde nos a desplegar una tabla mostrando a detalle el desglose del archivo JSON.

El desglose nos lo dara como:
* **Tipo de token** (Ej.: String, Coma, DOS_PUNTOS)
* **Texto encontrado** (Ej.: "nombreComputadora" )
* **Patron**
* **Fila** 
* **Columna**

Todo esto lo podremos encontrar en el archivo resultado.txt

## Requisitos del sistema

Para poder ejecutar el programa necesitas tener instalado en tu computadora lo siguiente:

* **Java JDK 17**  [Descargar aquí](https://adoptium.net/temurin/releases/?version=17)

* **Jflex** [Descargar aquí](https://www.jflex.de/download.html)

* **Terminal o consola** (CMD si es en Windows, Terminal si es en MacOS o Linux)

* **Editor de texto** (Ej.: Visual Studio Code)

## Como ejectuar el programa

Aqui te dejo los pasos de como ejecutarlo

### Paso 1: Esto se hace solo la primera vez

Aqui vamos a generar el analizador

Abrimos la terminal y ejecutamos este comando:

jflex analizador.flex

Esto generarar un archivo llamado:

Analizado.java

### Paso 2: Compilar nuestro programa

En la terminal colocoamos este comando:

java *.java

### Paso 3: Ejecutamos el programa

En la terminal colocamos:

java Main

Esto nos dara como resultado nuesto archivo resultado.txt

Ejemplo de resultado: 

TOKEN                LEXEMA                         PATRON          FILA   COLUMNA 

LLAVE_ABRE           {                              {               2      1       
STRING               "nombreComputadora"            STRING          3      3       
DOS_PUNTOS           :                              :               3      22 



## ¿Como analizamos archivos JSON?

Abrimos nuestro archivo base.json y cambiamos toda la informacion, ejemplo:

{
  "nombre": "Luis",
  "edad": 20,
  "activo": true
}

y luego volvemos a ejecutar nuestro programa desde la terminal.


## Posibles Errores

Error: Archivo no encontrado

Solucion: Hay que verificar que el archivo base.json este en nuestra carpeta.

Error: javac no reconocido

Solucion: Verifique que tenga instalado Java JDK 17

## Autor 

Luis Miguel Quan Carranza
201927151

