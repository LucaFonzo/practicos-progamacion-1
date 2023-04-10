package arreglos;
/*
3. Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, solicite al usuario una posición y realice un corrimiento a izquierda o hacia la
menor posición del arreglo.
* */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Ejercicio03 {
    public final static int MAX = 10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 0;
    public static void main(String[] args) {
        int[] arr = new int[MAX];
        cargar_arreglo_aleatorio_int(arr);
        imprimir_arreglo_int(arr);
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese una posicion: ");
            int pos = Integer.valueOf(entrada.readLine());
            corrimiento_izq(arr,pos);
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("---------");
        imprimir_arreglo_int(arr);
    }

    public static void corrimiento_izq(int [] arr,int pos){
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
            System.out.println("Arr["+pos+"]=>: "+arr[pos]);
        }
    }
}
