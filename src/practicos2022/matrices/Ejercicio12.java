package practicos2022.matrices;

import java.util.Random;
/*
* 12. Hacer un programa que dada la matriz de secuencias de caracteres definida y
precargada, permita encontrar por cada fila la posición de inicio y fin de la
anteúltima secuencia (considerar comenzar a buscarla a partir de la ultima
posición de la fila).

* */

public class Ejercicio12 {
    public static int MAXFILA = 4;
    public static int MAXCOL = 20;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;
    public static double probabilidad_numero = 0.4;
    public static void main(String[] args) {
        int [][] mat = new int[MAXFILA][MAXCOL];
        cargarSecuenciasMat(mat);
        imprimirMatSecuenciasInt(mat);
        encontrarPosInicioAntUltSecMat(mat);
    }
    public static void encontrarPosInicioAntUltSecMat(int [][] mat){
        int pos;
        for (int i = 0;i < MAXFILA;i++){
            pos = encontrarPosInicioAntUltSecArr(mat[i]);
            System.out.println("Para la fila: " + i + " inicio: " + pos);
        }
    }
    public static int encontrarPosInicioAntUltSecArr(int [] arr){
        int fin = obtenerFin(arr,MAXCOL-1);
        int inicio = obtenerInicio(arr,fin);
        fin = obtenerFin(arr,inicio-1);
        inicio = obtenerInicio(arr,fin);
        return inicio;
    }
    public static int obtenerFin(int [] arr,int pos){
        while (pos > 0 && arr[pos] == 0){
            pos--;
        }
        return pos;
    }
    public static int obtenerInicio(int [] arr,int pos){
        while (pos > 0 && arr[pos] != 0){
            pos--;
        }
        return pos+1;
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
