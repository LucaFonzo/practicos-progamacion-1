package practicos2022.arreglos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*
* 5. Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, solicite al usuario un numero entero y elimine la primer ocurrencia del numero
(un número igual) en el arreglo (si existe). Para ello tendrá que buscar la posición y si está,
realizar un corrimiento a izquierda (queda una copia de la última posición del arreglo en la
anteúltima posición).
* */
public class Ejercicio05 {
    public static int MAX = 10;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;
    public static void main(String[] args) {
        int [] arr = new int[MAX];
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        cargar_arreglo_aleatorio_int(arr);
        imprimir_arreglo_int(arr);
        try {
            System.out.println("Ingrese un numero: ");
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
    }

    public static void corrimientoIzquierda(int [] arr,int pos) {
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
