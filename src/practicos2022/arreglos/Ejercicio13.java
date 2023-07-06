package practicos2022.arreglos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*
* 13. Hacer un programa que dado el arreglo definido y precargado, y un número entero
ingresado por el usuario, elimine las secuencias de tamaño igual al número ingresado.

* */
public class Ejercicio13 {
    public static int MAX = 20;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;
    public static double probabilidad_numero = 0.4;
    public static void main(String[] args) {
        int [] arr = new int[MAX];
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        cargar_arreglo_aleatorio_secuencias_int(arr);
        imprimir_arreglo_secuencias_int(arr);
        try {
            System.out.println("Ingrese un numero: ");
            int n = Integer.valueOf(entrada.readLine());
            eliminarSecuenciaTam(arr,n);
            imprimir_arreglo_secuencias_int(arr);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void eliminarSecuenciaTam(int [] arr,int n){
        int inicio = 0;
        int fin = -1;
        while (inicio < MAX - 1){
            inicio = obtenerInicio(arr,fin+1);
            if (inicio < MAX - 1){
                fin = obtenerFin(arr,inicio);
                if ((fin-inicio+1) == n){
                    eliminarSecuencia(arr,inicio);
                }
            }
        }
    }
    public static int obtenerFin(int [] arr,int pos){
        while (pos < MAX - 1 && arr[pos] != 0){
            pos++;
        }
        return pos - 1;
    }
    public static int obtenerInicio(int [] arr,int pos){
        while (pos < MAX - 1 && arr[pos] == 0){
            pos++;
        }
        return pos;
    }
    public static void eliminarSecuencia(int [] arr,int pos){
        while (arr[pos] != 0){
            corrimientoIzquierda(arr,pos);
        }
    }
    public static void corrimientoIzquierda(int [] arr,int pos){
        while (pos < MAX - 1){
            arr[pos] = arr[pos + 1];
            pos++;
        }
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
