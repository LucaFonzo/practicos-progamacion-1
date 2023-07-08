package practicos2022.matrices;

import java.util.Random;

/*
* 2. Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, obtenga la cantidad de números pares que tiene y la imprima.
* */
public class Ejercicio2 {
    public static int MAXFILA = 5;
    public static int MAXCOL = 10;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;
    public static void main(String[] args) {
        int [][] mat = new int[MAXFILA][MAXCOL];
        cargar_matriz_aleatorio_int(mat);
        imprimir_matriz(mat);
        int cant = obtenerCantNumerosParesMat(mat);
        System.out.println("Cant pares: " + cant);
    }
    public static int obtenerCantNumerosParesMat(int [][] mat){
        int total = 0;
        for (int i = 0;i < MAXFILA;i++){
            total += obtenerCantNumerosParesArr(mat[i]);
        }
        return total;
    }
    public static int obtenerCantNumerosParesArr(int [] arr){
        int total = 0;
        for (int i = 0;i < MAXCOL;i++){
            if (arr[i] % 2 == 0){
                total++;
            }
        }
        return total;
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
