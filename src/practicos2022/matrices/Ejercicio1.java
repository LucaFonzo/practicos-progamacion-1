package practicos2022.matrices;

import java.util.Random;

/*
* 1. Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, invierta el orden del contenido por fila. Este intercambio no se debe realizar
de manera explícita, hay que hacer un método que incluya una iteración de intercambio.
* */
public class Ejercicio1 {
    public static int MAXFILA = 5;
    public static int MAXCOL = 10;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;
    public static void main(String[] args) {
        int [][] mat = new int[MAXFILA][MAXCOL];
        cargar_matriz_aleatorio_int(mat);
        imprimir_matriz(mat);
        invertirFilasMat(mat);
        System.out.println("Mat invertida");
        imprimir_matriz(mat);
    }
    public static void invertirFilasMat(int [][] mat){
        for (int i = 0;i < MAXFILA;i++){
            invertirArreglo(mat[i]);
        }
    }
    public static void invertirArreglo(int [] arr){
        for (int i = 0;i < (MAXCOL / 2);i++){
            int aux = arr[i];
            arr[i] = arr[MAXCOL - i - 1];
            arr[MAXCOL - i - 1] = aux;
        }
    }
    public static void imprimir_matriz(int [][] mat){
        for (int i = 0;i < MAXFILA;i++){
            imprimir_arreglo_int(mat[i]);
            System.out.println("");
        }
    }
    public static void cargar_matriz_aleatorio_int(int [][] mat){
        for (int i = 0;i < MAXFILA;i++){
            cargar_arreglo_aleatorio_int(mat[i]);
        }
    }
    public static void cargar_arreglo_aleatorio_int(int [] arr){
        Random r = new Random();
        for (int pos = 0; pos < MAXCOL; pos++){
            arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
        }
    }
    public static void imprimir_arreglo_int(int [] arr){
        for (int pos = 0; pos < MAXCOL; pos++){
            System.out.print("["+arr[pos]+"]");
        }
    }
}
