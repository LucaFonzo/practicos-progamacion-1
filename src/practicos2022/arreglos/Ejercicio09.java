package practicos2022.arreglos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*
*
* 9. Hacer un programa que dado un arreglo de enteros de tamaño 10 que se
encuentra precargado, solicite al usuario el ingreso de dos números
enteros (posiciones del arreglo) y ordene de forma creciente el arreglo
entre dos posiciones correspondientes a los números ingresados.
* */
public class Ejercicio09 {
    public static int MAX = 10;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;
    public static void main(String[] args) {
        int [] arr = new int[MAX];
        cargar_arreglo_aleatorio_int(arr);
        imprimir_arreglo_int(arr);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Ingrese una pos de inicio a ordenar: ");
            int posInicio = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrse una pos de fin a ordenar: ");
            int posFin = Integer.valueOf(entrada.readLine());
            ordenar_arreglo_burbujeo(arr,posInicio,posFin);
            imprimir_arreglo_int(arr);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void ordenar_arreglo_burbujeo(int[] arr,int inicio,int fin){
        int temp;
        for(int i = inicio + 1;i < fin;i++){
            for (int j = inicio; j < fin - 1; j++){
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
