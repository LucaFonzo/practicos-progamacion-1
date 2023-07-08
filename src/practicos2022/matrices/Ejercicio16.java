package practicos2022.matrices;

import java.util.Random;

public class Ejercicio16 {
    public static int MAXFILA = 4;
    public static int MAXCOL = 20;
    public static int MAXVALOR = 9;
    public static int MINVALOR = 1;
    public static double probabilidad_letra = 0.4;
    /*
    * 16. Hay dos matrices MAT1 y MAT2 de secuencias de caracteres letras separados
    por espacios de tamaño MAXF x MAXC que están precargadas. Ambas
    matrices están precargadas y cada fila empieza y termina con caracteres
    espacios. Además se tiene el siguiente método:
    – un método que retorna el índice inicial de la secuencia de mayor tamaño de un
    arreglo de secuencias (de caracteres letras minúsculas separados por espacios) de
    tamaño MAXFIL.
    Se pide realizar un programa que
    – contenga la definición de los encabezados de los métodos de carga de la matriz y
    del método mencionado en el enunciado (se supone que existen y no se requiere
    implementarlos).
    – para MAT1 y MAT2 elimine de cada secuencia el primer carácter vocal.
    – para MAT1 agregue al principio de cada secuencia el primer carácter de la
    secuencia de mayor tamaño de dicha fila.
    – en cada fila, si se verifica que la secuencia de mayor tamaño de la fila para MAT1 es
    mayor que la primer secuencia en dicha fila para MAT2, las intercambie (la que está
    en MAT1 pasa a MAT2 y la que esta en MAT2 pasa a MAT1) sin usar estructuras
    auxiliares (otros arreglos o matrices).
    – para un valor de fila ingresado por el usuario verifique e imprima si la primera
    secuencia de MAT1 en dicha fila es igual la primera secuencia de MAT2 en dicha fila.
    * */

    public static void main(String[] args) {
        char [][] mat1 = new char[MAXFILA][MAXCOL];
        char [][] mat2 = new char[MAXFILA][MAXCOL];
        cargarSecuenciasMatChar(mat1);
        cargarSecuenciasMatChar(mat2);
        elimiarPrimerVocalSecuenciaMat(mat1);
        elimiarPrimerVocalSecuenciaMat(mat2);

        agregarPrimerCaracterSecMasGrandeMat(mat1);
    }
    public static void agregarPrimerCaracterSecMasGrandeMat(char [][] mat){
        for (int i = 0;i < MAXFILA;i++){
            agregarPrimerCaracterSecMasGrandeArr(mat[i]);
        }
    }
    public static void agregarPrimerCaracterSecMasGrandeArr(char [] arr){
        int posCaracter = obtenerInicioSecMasGrande(arr);
        int inicio = 0;
        int fin = -1;
        while (inicio < MAXCOL-1){
            inicio = obtenerInicio(arr,fin+1);
            corrimientoDerecha(arr,inicio);
            arr[inicio] = arr[posCaracter];
        }
    }
    public static void corrimientoDerecha(char [] arr,int pos){
        int index = MAXCOL-1;
        while (pos < index){
            arr[index] = arr[index-1];
            index--;
        }
    }
    public static void elimiarPrimerVocalSecuenciaMat(char [][] mat){
        for (int i = 0;i < MAXFILA;i++){
            elimiarPrimerVocalSecuenciaArr(mat[i]);
        }
    }
    public static void elimiarPrimerVocalSecuenciaArr(char [] arr){
        int inicio = 0;
        int fin = -1;
        int posVocal = -1;
        while (inicio < MAXCOL-1){
            inicio = obtenerInicio(arr,fin+1);
            if (inicio < MAXCOL-1){
                fin = obtenerFin(arr,inicio);
                posVocal = obtenerPosPrimerVocal(arr,inicio,fin);
                if (posVocal != -1){
                    corrimientoIzquierda(arr,posVocal);
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
    public static int obtenerPosPrimerVocal(char [] arr,int inicio,int fin){
        while (inicio <= fin){
            if (arr[inicio] == 'a' || arr[inicio] == 'e' || arr[inicio] == 'i' || arr[inicio] == 'o' || arr[inicio] == 'u'){
                return inicio;
            }
            inicio++;
        }
        return -1;
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
    public static void cargar_arreglo_aleatorio_secuencias_char(char[] arr){
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
