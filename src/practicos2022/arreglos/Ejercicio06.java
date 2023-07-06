package practicos2022.arreglos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*
* 6. Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, solicite al usuario un numero entero y elimine todas las ocurrencia de numero
en el arreglo. Mientras exista (en cada iteración tiene que buscar la posición dentro del
arreglo) tendrá que usar la posición para realizar un corrimiento a izquierda (quedarán
tantas copias de la última posición del arreglo como cantidad de ocurrencias del número).
* */
public class Ejercicio06 {
    public static int MAX = 10;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;
    public static void main(String[] args) {
        int [] arr = new int[MAX];
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        cargar_arreglo_aleatorio_int(arr);
        imprimir_arreglo_int(arr);
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
        if (arr[MAX - 1] == n){
            arr[MAX - 1] = 0;
        }
        for (int i = 0;i < MAX - 1;i++){
            if (arr[i] == n){
                corrimientoIzquierda(arr,i);
                i--;
            }
        }
    }
    public static void corrimientoIzquierda(int [] arr,int pos){
        while (pos < MAX - 1){
            arr[pos] = arr[pos + 1];
            pos++;
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
