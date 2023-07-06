package practicos2022.arreglos;

import java.util.Random;

/*
* 15. Hacer un programa que dado el arreglo definido y precargado elimine del arreglo
todas las ocurrencias de una secuencia patrón dada por otro arreglo de iguales
características (solo tiene esa secuencia). Al eliminar se pierden valores haciendo
corrimientos.
* */
public class Ejercicio15 {
    public static int MAX = 10;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;
    public static double probabilidad_numero = 0.4;

    public static void main(String[] args) {
        int [] arr = {0,0,1,9,0,0,2,4,6,0};
        int [] patron = {0,0,2,4,6,0,0,0,0,0};
        eliminarSecPatron(arr,patron);
        imprimir_arreglo_secuencias_int(arr);
    }
    public static void eliminarSecPatron(int [] arr,int [] patron){
        int finPatron = -1;
        int inicioPatron = obtenerInicio(patron,finPatron+1);
        finPatron = obtenerFin(patron,inicioPatron);
        int inicio = 0;
        int fin = -1;
        while (inicio < MAX - 1){
            inicio = obtenerInicio(arr,fin+1);
            if (inicio < MAX -1 ){
                fin = obtenerFin(arr,inicio);
                if (esMismaSec(arr,patron,inicio,fin,inicioPatron,finPatron)){
                    eliminarSecuencia(arr,inicio);
                }
            }
        }
    }
    public static int obtenerInicio(int [] arr,int pos){
        while (pos < (MAX - 1) && arr[pos] == 0){
            pos++;
        }
        return pos;
    }
    public static int obtenerFin(int [] arr,int pos){
        while (pos < (MAX - 1)  && arr[pos] != 0){
            pos++;
        }
        return pos - 1;
    }
    public static void corrrimientoIzquierda(int [] arr,int pos){
        while (pos < MAX - 1){
            arr[pos] = arr[pos + 1];
            pos++;
        }
    }
    public static void eliminarSecuencia(int [] arr,int pos){
        while (arr[pos] != 0){
            corrrimientoIzquierda(arr,pos);
        }
    }
    public static boolean esMismaSec(int [] arr,int [] patron,int inicio,int fin,int inicioPatron,int finPatron){
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
