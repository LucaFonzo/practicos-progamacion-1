package practicos2022.matrices;

import java.util.Random;

/*
* 14. Hacer un programa que dada la matriz de secuencias de caracteres definida y
precargada, elimine de cada fila todas las ocurrencias de una secuencia
patrón dada por un arreglo de caracteres de tamaño igual al tamaño de
columnas de la matriz (solo tiene esa secuencia con separadores al inicio y al
final). Al eliminar en cada fila se pierden los valores haciendo los corrimientos.

* */
public class Ejercicio14 {
    public static int MAXFILA = 4;
    public static int MAXCOL = 20;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;
    public static double probabilidad_letra = 0.4;
    public static void main(String[] args) {
        char [][] mat = new char[MAXFILA][MAXCOL];
        char [] patron = {' ','a','d','e','f',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
        cargarSecuenciasMatChar(mat);
        imprimirMatSecuenciasChar(mat);
        eliminarSecuenciasPatronMat(mat,patron);
    }
    public static void eliminarSecuenciasPatronMat(char [][] mat,char [] patron){
        for (int i = 0;i < MAXFILA;i++){
            eliminarSecuenciasPatronArr(mat[i],patron);
        }
    }
    public static void eliminarSecuenciasPatronArr(char [] arr,char [] patron){
        int finPatron = -1;
        int inicioPatron = obtenerInicio(patron,finPatron+1);
        finPatron = obtenerFin(patron,inicioPatron);
        int inicio = 0;
        int fin = -1;
        while (inicio < MAXCOL-1){
            inicio = obtenerInicio(arr,fin+1);
            if (inicio < MAXCOL-1){
                fin = obtenerFin(arr,inicio);
                if (esMismaSecuencia(arr,patron,inicio,fin,inicioPatron,finPatron)){
                    eliminarSecuencia(arr,inicio);
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
    public static boolean esMismaSecuencia(char [] arr,char [] patron,int inicio,int fin,int inicioPatron,int finPatron){
        if ((fin-inicio+1) == (finPatron-inicioPatron+1)){
            while (inicio <= fin && inicioPatron <= finPatron){
                if (arr[inicio] != patron[inicioPatron]){
                    return false;
                }
                inicio++;
                inicioPatron++;
            }
            return true;
        }
        return false;
    }
    public static void eliminarSecuencia(char [] arr,int pos){
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
