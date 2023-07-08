package practicos2022.matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
/*
* 13. Hacer un programa que dada la matriz de secuencias de enteros definida y
precargada, y un número entero ingresado por el usuario, elimine de cada fila
las secuencias de tamaño igual al número ingresado.
* */

public class Ejercicio13 {
    public static int MAXFILA = 4;
    public static int MAXCOL = 20;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;
    public static double probabilidad_numero = 0.4;

    public static void main(String[] args) {
        int [][] mat = new int[MAXFILA][MAXCOL];
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        cargarSecuenciasMat(mat);
        imprimirMatSecuenciasInt(mat);
        try {
            System.out.println("Ingrese un numero: ");
            int tam = Integer.valueOf(entrada.readLine());
            eliminarSecXTamMat(mat,tam);
            imprimirMatSecuenciasInt(mat);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void eliminarSecXTamMat(int [][] mat,int tam){
        for (int i = 0;i < MAXFILA;i++){
            eliminarSecXTamArr(mat[i],tam);
        }
    }
    public static void eliminarSecXTamArr(int [] arr,int tam){
        int inicio = 0;
        int fin = -1;
        while (inicio < MAXCOL-1){
            inicio = obtenerInicio(arr,fin+1);
            if (inicio < MAXCOL-1){
                fin = obtenerFin(arr,inicio);
                if ((fin-inicio+1) == tam){
                    eliminarSec(arr,inicio);
                }
            }
        }
    }
    public static int obtenerInicio(int [] arr,int pos){
        while (pos < MAXCOL-1 && arr[pos] == 0){
            pos++;
        }
        return pos;
    }
    public static int obtenerFin(int [] arr,int pos){
        while (pos < MAXCOL-1 && arr[pos] != 0){
            pos++;
        }
        return pos-1;
    }
    public static void eliminarSec(int [] arr,int pos){
        while (arr[pos] != 0){
            corrimientoIzquierda(arr,pos);
        }
    }
    public static void corrimientoIzquierda(int [] arr,int pos){
        while (pos < MAXCOL-1){
            arr[pos] = arr[pos+1];
            pos++;
        }
    }
    public static void cargarSecuenciasMat(int [][] mat){
        for (int i = 0;i < MAXFILA;i++){
            cargar_arreglo_aleatorio_secuencias_int(mat[i]);
        }
    }
    public static void cargar_arreglo_aleatorio_secuencias_int(int [] arr){
        Random r = new Random();
        arr[0] = 0;
        arr[MAXCOL-1] = 0;
        for (int pos = 1; pos < MAXCOL-1; pos++){
            if (r.nextDouble()>probabilidad_numero){
                arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
            }
            else{
                arr[pos]=0;
            }
        }
    }
    public static void imprimirMatSecuenciasInt(int [][] mat){
        for (int i = 0;i < MAXFILA;i++){
            imprimir_arreglo_secuencias_int(mat[i]);
        }
    }
    public static void imprimir_arreglo_secuencias_int(int [] arr){
        for (int pos = 0; pos < MAXCOL; pos++){
            System.out.print(arr[pos]+"|");
        }
        System.out.print("\n");
    }
}
