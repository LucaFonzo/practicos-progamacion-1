package practicos2022.matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
/*
* 10. Hacer un programa que dada la matriz de secuencias de enteros definida
y precargada, permita obtener a través de métodos la posición de inicio y
la posición de fin de la secuencia ubicada a partir de una posición entera
y una fila, ambas ingresadas por el usuario. Finalmente, si existen imprima
por pantalla ambas posiciones obtenidas.
* */

public class Ejercicio10 {
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
            System.out.println("Ingrese una pos fila: ");
            int posFila = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese una pos: ");
            int pos = Integer.valueOf(entrada.readLine());
            int inicio = obtenerInicio(mat[posFila],pos);
            int fin = obtnerFin(mat[posFila],inicio);
            System.out.println("Inicio: " + inicio +" Fin: " + fin);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static int obtenerInicio(int [] arr,int pos){
        while (pos > 0 && arr[pos] != 0){
            pos--;
        }
        return pos + 1;
    }
    public static int obtnerFin(int [] arr,int pos){
        while (pos < MAXCOL-1 && arr[pos] != 0){
            pos++;
        }
        return pos - 1;
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
