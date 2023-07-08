package practicos2022.matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*
* 9. Hacer un programa que dado una matriz de enteros de tamaño 4*5 que
se encuentra precargada, solicite al usuario el ingreso de una fila y dos
números enteros (columnas de la matriz), y ordene de forma creciente la
matriz en la fila indicada entre las dos posiciones columnas ingresadas.
* */
public class Ejercicio09 {
    public static int MAXFILA = 4;
    public static int MAXCOL = 5;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;

    public static void main(String[] args) {
        int [][] mat = new int[MAXFILA][MAXCOL];
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        cargar_matriz_aleatorio_int(mat);
        imprimir_matriz(mat);
        try {
            System.out.println("Ingrese una pos fila: ");
            int posFila = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese una pos col: ");
            int inicio = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese una segunda pos col: ");
            int fin = Integer.valueOf(entrada.readLine());
            ordenar_arreglo_burbujeo(mat[posFila],inicio,fin);
            imprimir_matriz(mat);
        }catch (Exception e){

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
    public static void ordenar_arreglo_burbujeo(int[] arr,int inicio,int fin){
        int temp;
        for(int i = inicio+ 1;i <= fin;i++){
            for (int j = inicio ; j <= fin - 1; j++){
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
