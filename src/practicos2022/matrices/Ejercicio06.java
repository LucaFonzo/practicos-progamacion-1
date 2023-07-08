package practicos2022.matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*
* 6. Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, solicite al usuario un numero entero y elimine todas las ocurrencia de numero
en la matriz si existe. Mientras exista (en cada iteración tiene que buscar la posición fila y
columna) tendrá que usar dicha posición para realizar un corrimiento a izquierda.

* */
public class Ejercicio06 {
    public static int MAXFILA = 5;
    public static int MAXCOL = 10;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;

    public static void main(String[] args) {
        int [][] mat = new int[MAXFILA][MAXCOL];
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        cargar_matriz_aleatorio_int(mat);
        imprimir_matriz(mat);
        try {
            System.out.println("Ingrese un numero a eliminar: ");
            int n = Integer.valueOf(entrada.readLine());
            eliminarOcurrenciasMat(mat,n);
            imprimir_matriz(mat);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void eliminarOcurrenciasMat(int [][] mat,int n){
        for (int i = 0;i < MAXFILA;i++){
            eliminarOcurrenciasArr(mat[i],n);
        }
    }
    public static void eliminarOcurrenciasArr(int [] arr,int n){
        for (int i = 0;i < MAXCOL-1;i++){
            if (arr[i] == n){
                corrimientoIzquierda(arr,i);
                i--;
            }
        }
    }
    public static void corrimientoIzquierda(int [] arr,int pos){
        while (pos < MAXCOL-1){
            arr[pos] = arr[pos + 1];
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

}
