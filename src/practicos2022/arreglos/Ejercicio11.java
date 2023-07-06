package practicos2022.arreglos;
/*
* 11. Hacer un programa que dado el arreglo definido y precargado permita encontrar la
posición de inicio de la secuencia cuya suma de valores sea mayor.
* */

import java.util.Random;

public class Ejercicio11 {
    public static int MAX = 20;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;
    public static double probabilidad_numero = 0.4;
    public static void main(String[] args) {
        int [] arr = new int[MAX];
        cargar_arreglo_aleatorio_secuencias_int(arr);
        imprimir_arreglo_secuencias_int(arr);
        int posInicio = obtenerPosInicioSecMasSuma(arr);
        System.out.println(posInicio);
    }

    public static int obtenerPosInicioSecMasSuma(int [] arr){
        int pos = -1;
        int suma = 0;
        int sumaMayor = -1;
        int inicio = 0;
        int fin = -1;
        while (inicio < MAX - 1){
            inicio = obtenerInicio(arr,fin+1);
            if (inicio < MAX - 1){
                fin = obtenerFin(arr,inicio);
                suma = obtenerSuma(arr,inicio,fin);
                if (suma > sumaMayor){
                    sumaMayor = suma;
                    pos = inicio;
                }
            }
        }
        return pos;
    }
    public static int obtenerSuma(int [] arr,int inicio,int fin){
        int suma = 0;
        while (inicio <= fin){
            suma += arr[inicio];
            inicio++;
        }
        return suma;
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
        return pos;
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
