package practicos2022.arreglos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*
* 14. Hacer un programa que dado el arreglo definido y precargado, y un número entero
ingresado por el usuario, copie de forma continua las secuencias de tamaño igual al
número ingresado en otro arreglo de iguales características e inicializado con 0. La
copia en este último arreglo deben comenzar desde el principio del mismo.
*/
public class Ejercicio14 {

    public static int MAX = 20;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;
    public static double probabilidad_numero = 0.4;
    public static void main(String[] args) {
        int [] arr = new int[MAX];
        int [] aux = new int[MAX];
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        cargar_arreglo_aleatorio_secuencias_int(arr);
        imprimir_arreglo_secuencias_int(arr);
        try {
            System.out.println("Ingrese un numero: ");
            int n = Integer.valueOf(entrada.readLine());
            copiarSecuenciasTam(arr,aux,n);
            imprimir_arreglo_secuencias_int(aux);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void copiarSecuenciasTam(int [] arr,int [] aux,int n){
        int inicio = 0;
        int fin = -1;
        int posAux = 0;
        while (inicio < MAX - 1){
            inicio = obtenerInicio(arr,fin+1);
            if (inicio < MAX - 1){
                fin = obtenerFin(arr,inicio);
                int tam = (fin-inicio+1);
                if (tam == n){
                    copiarSecuencia(arr,aux,inicio,fin,posAux);
                    posAux = tam;
                }
            }
        }
    }
    public static int obtenerInicio(int [] arr,int pos){
        while (pos < MAX - 1 && arr[pos] == 0){
            pos++;
        }
        return pos;
    }
    public static int obtenerFin(int [] arr,int pos){
        while (pos < MAX - 1 && arr[pos] != 0){
            pos++;
        }
        return pos-1;
    }
    public static void copiarSecuencia(int [] arr,int [] aux,int inicio,int fin,int posAux){
        while (inicio <= fin && posAux < MAX - 1){
            aux[posAux] = arr[inicio];
            inicio++;
            posAux++;
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
