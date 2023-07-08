package practicos2022.matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
/*
* 5. Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, solicite al usuario un numero entero y elimine la primer ocurrencia de numero
en la matriz (un número igual) si existe. Para ello tendrá que buscar la posición y si está,
realizar un corrimiento a izquierda y no continuar buscando.
* */

public class Ejercicio05 {
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
            eliminarOcurrenciaMat(mat,n);
            imprimir_matriz(mat);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void eliminarOcurrenciaMat(int [][] mat,int n){
        boolean estaEliminado;
        for (int i = 0;i < MAXFILA;i++){
            estaEliminado = eliminarOcurrenciaArr(mat[i],n);
            if (estaEliminado){
                return;
            }
        }
    }
    public static boolean eliminarOcurrenciaArr(int [] arr,int n){
        for (int i = 0;i < MAXCOL;i++){
            if (arr[i] == n){
                corrimientoIzquierda(arr,i);
                return true;
            }
        }
        return false;
    }
    public static void corrimientoIzquierda(int [] arr,int pos){
        while (pos < MAXCOL - 1){
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
