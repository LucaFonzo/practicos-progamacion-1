package practicos2022.matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
/*
* 8. Hacer un programa que dado una matriz ordenada creciente por filas de
enteros de tamaño 4*5 que se encuentra precargada, solicite al usuario un
numero entero y una fila, y elimine la primer ocurrencia de numero en la
fila indicada (un número igual) si existe.
* */

public class Ejercicio8 {
    public static int MAXFILA = 4;
    public static int MAXCOL = 5;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;

    public static void main(String[] args) {
        int [][] mat = new int[MAXFILA][MAXCOL];
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        cargar_matriz_aleatorio_int(mat);
        ordenarMatrizBurbujeo(mat);
        imprimir_matriz(mat);
        try {
            System.out.println("Ingrese una pos fila: ");
            int posFila = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese un numero a eliminar: ");
            int n = Integer.valueOf(entrada.readLine());
            eliminarOcurrenciaArr(mat[posFila],n);
            imprimir_matriz(mat);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void eliminarOcurrenciaArr(int [] arr,int n){
        for (int i = 0;i < MAXCOL;i++){
            if (arr[i] == n){
                corrimientoIzquierda(arr,i);
                return;
            }
        }
    }
    public static void corrimientoIzquierda(int [] arr,int pos){
        while (pos < MAXCOL-1){
            arr[pos] = arr[pos+1];
            pos++;
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
    public static void ordenarMatrizBurbujeo(int [][] mat){
        for (int i = 0;i < MAXFILA-1;i++){
            ordenar_arreglo_burbujeo(mat[i]);
        }
    }
    public static void ordenar_arreglo_burbujeo(int[] arr){
        int temp;
        for(int i = 1;i < MAXCOL;i++){
            for (int j = 0 ; j < MAXCOL - 1; j++){
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
