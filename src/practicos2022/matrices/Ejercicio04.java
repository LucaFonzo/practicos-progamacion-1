package practicos2022.matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*
* 4. Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, solicite al usuario un numero entero y una posición fila, columna. Con estos
datos tendrá que realizar un corrimiento a derecha (se pierde el último valor en dicha fila)
y colocar el numero en la matriz en la posición fila, columna indicada.

* */
public class Ejercicio04 {
    public static int MAXFILA = 5;
    public static int MAXCOL = 10;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;

    public static void main(String[] args) {
        int [][] mat = new int[MAXFILA][MAXCOL];
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        cargar_matriz_aleatorio_int(mat);
        imprimir_matriz(mat);
        try {
            System.out.println("Ingrese una pos fila: ");
            int posFila = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese una pos col: ");
            int posCol = Integer.valueOf(entrada.readLine());
            corrimientoDerecha(mat[posFila],posCol);
            imprimir_matriz(mat);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void corrimientoDerecha(int [] arr,int pos){
        int index = MAXCOL - 1;
        while (pos < index){
            arr[index] = arr[index - 1];
            index--;
        }
    }
    public static void imprimir_matriz(int [][] mat){
        for (int i = 0;i < MAXFILA;i++){
            imprimir_arreglo_int(mat[i]);
            System.out.println("");
        }
    }
    public static void cargar_matriz_aleatorio_int(int [][] mat){
        for (int i = 0;i < MAXFILA;i++){
            cargar_arreglo_aleatorio_int(mat[i]);
        }
    }
    public static void cargar_arreglo_aleatorio_int(int [] arr){
        Random r = new Random();
        for (int pos = 0; pos < MAXCOL; pos++){
            arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
        }
    }
    public static void imprimir_arreglo_int(int [] arr){
        for (int pos = 0; pos < MAXCOL; pos++){
            System.out.print("["+arr[pos]+"]");
        }
    }
}
