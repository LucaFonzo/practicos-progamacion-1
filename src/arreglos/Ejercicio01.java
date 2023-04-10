package arreglos;

import java.util.Random;

/*
* Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, invierta el orden del contenido (por ejemplo: el que está en 0 se intercambia
con el que está en 9, el que está en 1 con el que está en 8...). Este intercambio no se debe
realizar de manera explícita, hay que hacer un método que incluya una iteración de
intercambio.
* */
public class Ejercicio01 {
    public static final int MAX = 10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 0;

    public static void main(String[] args) {
        try {
            int [] arr = new int[MAX];
            cargar_arreglo_aleatorio_int(arr);
            imprimir_arreglo_int(arr);
            System.out.println("----------");
            darVueltaArreglo(arr);
            imprimir_arreglo_int(arr);


        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void darVueltaArreglo(int [] arr){
        for (int i = 0;i < (MAX / 2);i++){
            int aux = arr[i];
            arr[i] = arr[MAX - i - 1];
            arr[MAX - i - 1] = aux;
        }
    }
    public static void cargar_arreglo_aleatorio_int(int [] arr){
        Random r = new Random();
        for (int pos = 0; pos < MAX; pos++){
            arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
        }
    }
    public static void imprimir_arreglo_int(int [] arr){
        for (int pos = 0; pos < MAX; pos++){
            System.out.println("nombre_arreglo["+pos+"]=>: "+arr[pos]);
        }
    }
}
