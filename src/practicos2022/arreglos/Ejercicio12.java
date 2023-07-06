package practicos2022.arreglos;
/*
* 12. Hacer un programa que dado el arreglo definido y precargado permita encontrar la
posición de inicio de la anteúltima secuencia (considerar comenzar a buscarla a
partir de la ultima posición del arreglo).
* */

import java.util.Random;

public class Ejercicio12 {
    public static int MAX = 20;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;
    public static double probabilidad_numero = 0.4;
    public static void main(String[] args) {
        int [] arr = new int[MAX];
        cargar_arreglo_aleatorio_secuencias_int(arr);
        imprimir_arreglo_secuencias_int(arr);
        int pos = obtenerInicioAnteUltSec(arr);
        System.out.println("Posicion de inicio: " + pos);
    }
    public static int obtenerInicioAnteUltSec(int [] arr){
        int fin = obtenerFin(arr,MAX - 1);
        int inicio = obtenerInicio(arr,fin);
        fin = obtenerFin(arr,inicio-1);
        inicio = obtenerInicio(arr,fin);
        return inicio;
    }
    public static int obtenerInicio(int [] arr,int pos){
        while (pos > 0 && arr[pos] != 0){
            pos--;
        }
        return pos+1;
    }
    public static int obtenerFin(int [] arr,int pos){
        while (pos > 0 && arr[pos] == 0){
            pos--;
        }
        return pos-1;
    }
    public static void cargar_arreglo_aleatorio_secuencias_int(int []
                                                                       arr){
        Random r = new Random();
        arr[0] = 0;
        arr[MAX-1] = 0;
        for (int pos = 1; pos < MAX-1; pos++){
            if (r.nextDouble()>probabilidad_numero){
                arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
            }
            else{
                arr[pos]=0;
            }
        }
    }
    public static void imprimir_arreglo_secuencias_int(int [] arr){
        System.out.print("Arreglo de secuencias int\n|");
        for (int pos = 0; pos < MAX; pos++){
            System.out.print(arr[pos]+"|");
        }
        System.out.print("\n");
    }
}
