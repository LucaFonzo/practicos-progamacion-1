package practicos2022.arreglos;
/*
* 7. Hacer un programa que dado un arreglo ordenado creciente de enteros
de tamaño 10 que se encuentra precargado, solicite al usuario un numero
entero y lo inserte en el arreglo manteniendo su orden. Para ello tendrá
que realizar un corrimiento a derecha (se pierde el último valor del arreglo)
y colocar el numero en el arreglo en la posición indicada.

* */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Ejercicio07 {
    public static int MAX = 10;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;
    public static void main(String[] args) {
        int [] arr = new int[MAX];
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        cargar_arreglo_aleatorio_int(arr);
        ordenar_arreglo_burbujeo(arr);
        imprimir_arreglo_int(arr);
        try {
            System.out.println("Ingrese un numero a insertar: ");
            int n = Integer.valueOf(entrada.readLine());
            insertarNumero(arr,n);
            imprimir_arreglo_int(arr);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void insertarNumero(int [] arr,int n){
        int pos = obtenerPosOrdenado(arr,n);
        corrimientoDerecha(arr,pos);
        arr[pos] = n;
    }
    public static int obtenerPosOrdenado(int [] arr,int n){
        int pos = 0;
        while (pos < MAX -1 && arr[pos] < n){
            pos++;
        }
        return pos;
    }
    public static void corrimientoDerecha(int [] arr,int pos){
        int index = MAX - 1;
        while (index > pos){
            arr[index] = arr[index - 1];
            index--;
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


