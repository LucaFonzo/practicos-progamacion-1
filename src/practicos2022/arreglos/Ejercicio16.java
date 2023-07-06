package practicos2022.arreglos;

import java.util.Random;

/*
* 16. Hacer un programa que dado el arreglo definido y precargado elimine todas las
secuencias que tienen orden descendente entre sus elementos.
* */
public class Ejercicio16 {
    public static int MAX = 20;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;
    public static double probabilidad_numero = 0.4;

    public static void main(String[] args) {
        int [] arr = new int[MAX];
        cargar_arreglo_aleatorio_secuencias_int(arr);
        imprimir_arreglo_secuencias_int(arr);
        eliminarSecOrdDesc(arr);
        imprimir_arreglo_secuencias_int(arr);
    }
    public static void eliminarSecOrdDesc(int [] arr){
        int inicio = 0;
        int fin = -1;
        while (inicio < MAX - 1){
            inicio = obtenerInicio(arr,fin+1);
            if (inicio < MAX - 1){
                fin = obtenerFin(arr,inicio);
                if (esOrdDesc(arr,inicio,fin)){
                    eliminarSec(arr,inicio);
                }
            }
        }
    }
    public static void eliminarSec(int [] arr,int pos){
        while (arr[pos] != 0){
            corrimientoIzq(arr,pos);
        }
    }
    public static void corrimientoIzq(int [] arr,int pos){
        while (pos < MAX - 1){
            arr[pos] = arr[pos + 1];
            pos++;
        }
    }
    public static int obtenerInicio(int [] arr,int pos){
        while (pos < MAX - 1 && arr[pos] == 0){
            pos++;
        }
        return pos;
    }
    public static int obtenerFin(int [] arr,int pos){
        while (pos < MAX - 1 && arr[pos] != 0){
            pos++;
        }
        return pos-1;
    }
    public static boolean esOrdDesc(int [] arr,int inicio,int fin){
        while (inicio < fin){
            if (arr[inicio] < arr[inicio+1]){
                return false;
            }
            inicio++;
        }
        return true;
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
