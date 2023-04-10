package arreglos;
/*
* Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, solicite al usuario un numero entero y lo agregue al principio del arreglo
(posición 0). Para ello tendrá que realizar un corrimiento a derecha (se pierde el último valor
del arreglo) y colocar el numero en el arreglo en la posición indicada.
* */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Ejercicio04 {
    public final static int MAX = 10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 0;
    public static void main(String[] args) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            int[] arr = new int[MAX];
            cargar_arreglo_aleatorio_int(arr);
            imprimir_arreglo_int(arr);
            System.out.println("Ingrese un numero a insertar: ");
            int num = Integer.valueOf(entrada.readLine());
            insertar(arr,0,num);
            imprimir_arreglo_int(arr);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void insertar(int [] arr, int pos ,int value){
        corrimientoDer(arr,pos);
        arr[pos] = value;
    }

    public static void corrimientoDer(int [] arr ,int pos){
        int index = MAX - 1;
        while(index > pos){
            arr[index] = arr[index - 1];
            index--;
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
