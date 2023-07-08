package practicos2022.matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
/*
* 7. Hacer un programa que dado una matriz ordenada creciente por filas de
enteros de tamaño 4*5 que se encuentra precargada, solicite al usuario un
numero entero y una fila, y luego inserte el numero en la matriz en la fila
indicada manteniendo su orden.
* */

public class Ejercicio07 {
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
            System.out.println("Ingrese un numero a insertar: ");
            int n = Integer.valueOf(entrada.readLine());
            insertarNumero(mat[posFila],n);
            imprimir_matriz(mat);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void insertarNumero(int [] arr,int n){
        int pos = obtenerPosOrdenada(arr,n);
        corrimientoDerecha(arr,pos);
        arr[pos] = n;
    }
    public static void corrimientoDerecha(int [] arr,int pos){
        int index = MAXCOL-1;
        while (pos < index){
            arr[index] = arr[index - 1];
            index--;
        }
    }
    public static int obtenerPosOrdenada(int [] arr,int n){
        int pos = 0;
        while (pos < MAXCOL-1 && arr[pos] < n){
            pos++;
        }
        return pos;
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
