package practicos2022.matrices;

import java.util.Random;
/*
11. Hacer un programa que dada la matriz de secuencias de enteros definida y
precargada permita encontrar por cada fila la posición de inicio y fin de la
secuencia cuya suma de valores sea mayor.
* */

public class Ejercicio11 {
    public static int MAXFILA = 4;
    public static int MAXCOL = 20;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;
    public static double probabilidad_numero = 0.4;
    public static void main(String[] args) {
        int [][] mat = new int[MAXFILA][MAXCOL];
        cargarSecuenciasMat(mat);
        imprimirMatSecuenciasInt(mat);
        encontrarInicioSecMasSumaMat(mat);
    }
    public static void encontrarInicioSecMasSumaMat(int [][] mat){
        int pos;
        for(int i = 0;i < MAXFILA;i++){
            pos = encontrarInicioSecMasSumaArr(mat[i]);
            System.out.println("Para la fila: " + i + " inicio: " + pos);
        }
    }
    public static int encontrarInicioSecMasSumaArr(int [] arr){
        int posInicio = -1;
        int sumaMayor = -1;
        int sumaActual;
        int inicio = 0;
        int fin = -1;
        while (inicio < MAXCOL - 1){
            inicio = obtenerInicio(arr,fin+1);
            if (inicio < MAXCOL-1){
                fin = obtenerFin(arr,inicio);
                sumaActual = obtenerSumaSec(arr,inicio,fin);
                if (sumaActual > sumaMayor){
                    sumaMayor = sumaActual;
                    posInicio = inicio;
                }
            }
        }
        return posInicio;
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
    public static int obtenerSumaSec(int [] arr,int inicio,int fin){
        int result = 0;
        while (inicio <= fin){
            result += arr[inicio];
            inicio++;
        }
        return result;
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
