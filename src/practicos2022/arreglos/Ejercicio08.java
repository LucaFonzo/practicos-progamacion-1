package practicos2022.arreglos;
/*
* 8. Hacer un programa que dado un arreglo ordenado creciente de enteros
de tamaño 10 que se encuentra precargado, solicite al usuario un numero
entero y elimine la primer ocurrencia de numero (un número igual) en el
arreglo (si existe).

* */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Ejercicio08 {
    public static int MAX = 10;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;
    public static void main(String[] args) {
        int [] arr = new int[MAX];
        cargar_arreglo_aleatorio_int(arr);
        ordenar_arreglo_burbujeo(arr);
        imprimir_arreglo_int(arr);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Ingrese un numero a eliminar: ");
            int n = Integer.valueOf(entrada.readLine());
            eliminarNumero(arr,n);
            imprimir_arreglo_int(arr);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void eliminarNumero(int [] arr,int n){
        for (int i = 0;i < MAX - 1;i++){
            if (arr[i] == n){
                corrimientoIzquierda(arr,i);
                return;
            }
        }
        if (arr[MAX - 1] == n){
            arr[MAX - 1] = 0;
        }
    }
    public static void corrimientoIzquierda(int [] arr,int pos){
        while (pos < MAX - 1){
            arr[pos] = arr[pos+1];
            pos++;
        }
    }
    public static void ordenar_arreglo_burbujeo(int[] arr){
        int temp;
        for(int i = 1;i < MAX;i++){
            for (int j = 0 ; j < MAX - 1; j++){
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void cargar_arreglo_aleatorio_int(int [] arr){
        Random r = new Random();
        for (int pos = 0; pos < MAX; pos++){
            arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
        }
    }
    public static void imprimir_arreglo_int(int [] arr){
        for (int pos = 0; pos < MAX; pos++){
            System.out.print("["+arr[pos]+"]");
        }
    }
}
