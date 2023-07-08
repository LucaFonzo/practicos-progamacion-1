package practicos2022.matrices;

import java.util.Random;
/*
* 15. Hacer un programa que dada la matriz de secuencias de caracteres definida y
precargada elimine todas las secuencias que tienen orden descendente entre
sus elementos.
* */

public class Ejercicio15 {
    public static int MAXFILA = 4;
    public static int MAXCOL = 20;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;
    public static double probabilidad_letra = 0.4;

    public static void main(String[] args) {
        char [][] mat = new char[MAXFILA][MAXCOL];
        cargarSecuenciasMatChar(mat);
        imprimirMatSecuenciasChar(mat);
        eliminarSecuenciasOrdDescMat(mat);
        System.out.println("Mat con eliminacion: ");
        imprimirMatSecuenciasChar(mat);
    }
    public static void eliminarSecuenciasOrdDescMat(char [][] mat){
        for (int i = 0;i < MAXFILA;i++){
            eliminarSecuenciasOrdDescArr(mat[i]);
        }
    }
    public static void eliminarSecuenciasOrdDescArr(char [] arr){
        int inicio = 0;
        int fin = -1;
        while (inicio < MAXCOL-1){
            inicio = obtenerInicio(arr,fin+1);
            if (inicio < MAXCOL-1){
                fin = obtenerFin(arr,inicio);
                if(esDeOrdDesc(arr,inicio,fin)){
                    eliminarSec(arr,inicio);
                }
            }
        }
    }
    public static int obtenerInicio(char [] arr,int pos){
        while (pos < MAXCOL-1 && arr[pos] == ' '){
            pos++;
        }
        return pos;
    }
    public static int obtenerFin(char [] arr,int pos){
        while (pos < MAXCOL-1 && arr[pos] != ' '){
            pos++;
        }
        return pos;
    }
    public static boolean esDeOrdDesc(char [] arr,int inicio,int fin){
        while (inicio < fin){
            if (arr[inicio] < arr[inicio+1]){
                return false;
            }
            inicio++;
        }
        return true;
    }
    public static void eliminarSec(char [] arr,int pos){
        while (arr[pos] != ' '){
            corrimientoIzquierda(arr,pos);
        }
    }
    public static void corrimientoIzquierda(char [] arr,int pos){
        while (pos < MAXCOL-1){
            arr[pos] = arr[pos+1];
            pos++;
        }
    }
    public static void imprimirMatSecuenciasChar(char [][] mat){
        for (int i = 0;i < MAXFILA;i++){
            imprimir_arreglo_secuencias_char(mat[i]);
        }
    }
    public static void cargarSecuenciasMatChar(char [][] mat){
        for (int i = 0;i < MAXFILA;i++){
            cargar_arreglo_aleatorio_secuencias_char(mat[i]);
        }
    }
    public static void cargar_arreglo_aleatorio_secuencias_char(char
                                                                        [] arr){
        Random r = new Random();
        arr[0] = ' ';
        arr[MAXCOL-1] = ' ';
        for (int pos = 1; pos < MAXCOL-1; pos++){
            if (r.nextDouble()>probabilidad_letra){
                arr[pos]=(char)(r.nextInt(26) + 'a');
            }
            else{
                arr[pos]=' ';
            }
        }
    }
    public static void imprimir_arreglo_secuencias_char(char [] arr){
        for (int pos = 0; pos < MAXCOL; pos++){
            System.out.print("|"+arr[pos]+"|");
        }
        System.out.print("\n");
    }
}
