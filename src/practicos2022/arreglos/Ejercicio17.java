package practicos2022.arreglos;

import java.util.Random;

/*
* 17. Suponer que se tienen dos arreglos A y B de secuencias (de caracteres separados por uno o
más espacio) de tamaño MAX (arreglo empieza y termina con uno o más caracteres
espacio). A y B que están precargadas, y además se tienen los siguientes métodos (existen y
no se tienen que implementar):
a) un método que permite obtener el índice inicial de la secuencia que más se repite de un
arreglo de secuencias de tamaño MAX (que empieza y termina con o más caracteres
espacios).
b) un método que retorna el índice inicial de la secuencia que tiene más caracteres
repetidos de un arreglo de secuencias (de caracteres separados por uno o más caracteres
espacio) de tamaño MAX (que empieza y termina con espacio).
Se pide realizar un programa completo que (sin utilizar arreglos auxiliares/extras a los
mencionados):
_reemplace en A la secuencia que más se repite por la secuencia de B con más
caracteres repetidos (la separación previa entre las secuencias de A debe mantenerse).
En caso de utilizar uno o más de los métodos preexistentes mencionados en el enunciado
definir el o los encabezados de los mismos. No se requiere hacer métodos de carga e
impresión de arreglos.
* */
public class Ejercicio17 {
    public static int MAX = 20;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;
    public static double probabilidad_letra = 0.4;

    public static void main(String[] args) {
        char [] arrA = new char[MAX];
        char [] arrB = new char[MAX];
        cargar_arreglo_aleatorio_secuencias_char(arrA);
        cargar_arreglo_aleatorio_secuencias_char(arrB);
        reemplazarSec(arrA,arrB,inicioA,inicioB);
    }
    public static void reemplazarSec(char [] arrA,char [] arrB){
        int inicioA = obtenerInicioSecMasRepite(arrA);
        int inicioB = obtenerInicioSecMasCaracteres(arrB);
        int finA = obtenerFin(arrA,inicioA);
        int finB = obtenerFin(arrB,inicioB);
        int diferencia = (finA-inicioA+1) - (finB-inicioB+1);
        if (diferencia > 0){
            for (int i = 0;i < diferencia;i++){
                corrimientoIzquierda(arrA,inicioA);
            }
        }else if (diferencia < 0){
            for (int i = diferencia;i < 0;i++){
                corrimientoDerecha(arrA,inicioA);
            }
        }
        while (inicioA <= finA && inicioB <= finB){
            arrA[inicioA] = arrB[inicioB];
            inicioA++;
            inicioB++;
        }
    }
    public static void imprimir_arreglo_secuencias_char(char [] arr){
        System.out.print("Arreglo de secuencias char\n|");
        for (int pos = 0; pos < MAX; pos++){
            System.out.print(arr[pos]+"|");
        }
        System.out.print("\n");
    }

    public static void cargar_arreglo_aleatorio_secuencias_char(char
                                                                        [] arr){
        Random r = new Random();
        arr[0] = ' ';
        arr[MAX-1] = ' ';
        for (int pos = 1; pos < MAX-1; pos++){
            if (r.nextDouble()>probabilidad_letra){
                arr[pos]=(char)(r.nextInt(26) + 'a');
            }
            else{
                arr[pos]=' ';
            }
        }
    }

}
