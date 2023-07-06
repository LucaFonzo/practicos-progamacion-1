package practicos2022.arreglos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*
* 10. Se tiene un arreglo de enteros de tamaño 20 de secuencias de números
entre 1 y 9, separadas por 0. El arreglo esta precargado, y además
empieza y termina con uno o más separadores 0. Hacer un programa que
permita obtener a través de métodos la posición de inicio y la posición de
fin de la secuencia ubicada a partir de una posición entera ingresada por
el usuario. Finalmente, si existen imprima por pantalla ambas posiciones
obtenidas.
* */
public class Ejercicio10 {
    public static int MAX = 20;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;
    public static double probabilidad_numero = 0.4;
    public static void main(String[] args) {
        int [] arr = new int[MAX];
        cargar_arreglo_aleatorio_secuencias_int(arr);
        imprimir_arreglo_secuencias_int(arr);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Ingrese una posicion: ");
            int pos = Integer.valueOf(entrada.readLine());
            int inicio = obtenerPosInicio(arr,pos);
            int fin = obtenerPosFin(arr,pos);
            System.out.println("Inicio: " + inicio + ": Fin: " + fin);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static int obtenerPosInicio(int [] arr,int pos){
        while (arr[pos] != 0){
            pos--;
        }
        return pos+1;
    }
    public static int obtenerPosFin(int [] arr,int pos){
        while (arr[pos] != 0){
            pos++;
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

