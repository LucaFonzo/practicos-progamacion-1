package arreglos;

import java.util.Random;
/*
* 2. Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, obtenga la cantidad de números pares que tiene y la imprima.
* */

public class Ejercicio02 {
    final static int MAX = 10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 0;
    public static void main(String[] args) {
        int[] arr = new int[MAX];
        cargar_arreglo_aleatorio_int(arr);
        imprimir_arreglo_int(arr);
        System.out.println(obtenerCantidadPares(arr));
    }

    public static int obtenerCantidadPares(int [] arr){
        int total = 0;
        for (int i = 0;i < MAX - 1;i++){
            if (arr[i] % 2 == 0){
                total++;
            }
        }
        return total;
    }
    public static void cargar_arreglo_aleatorio_int(int [] arr){
        Random r = new Random();
        for (int pos = 0; pos < MAX; pos++){
            arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
        }
    }
    public static void imprimir_arreglo_int(int [] arr){
        for (int pos = 0; pos < MAX; pos++){
            System.out.println("nombre_arreglo["+pos+"]=>: "+arr[pos]);
        }
    }
}
