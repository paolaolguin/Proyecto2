import java.lang.reflect.Array;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
class Busqueda{
    //Condiciones de la matriz al recorrer
    private static Boolean condiciones(ArrayList<String []> sopa, Estado e, String palabra){
        int index = e.generacion - 1;
        int y = e.camino_recorrido.get(index)[0];
        int x = e.camino_recorrido.get(index)[1];
        if ((y+1 >= sopa.size()) || (y-1 < 0)){
            return false;
        }
        else if ((x + 1 >= sopa.get(y).length) || (x-1 < 0)){
            return false;
        }
        else{
            if(sopa.get(y)[x].equals(palabra.substring(index,index+1))){
                return true;
            }
            else{
                return false;
            }
        }
    }

    static Estado encontrar_pl(ArrayList<String[]> sopa, String palabra){
        String letra = palabra.substring(0,1);
        for (int i = 0; i < sopa.size(); i++ ){
            for (int j = 0; j < sopa.get(i).length; j++){
                if (sopa.get(i)[j].equals(letra)){
                    ArrayList<int[]> recorrido = new ArrayList<int[]>();
                    int[] posicion_actual = {j,i};
                    recorrido.add(posicion_actual);
                    Estado nuevoE = new Estado(1,recorrido);
                    return nuevoE;
                }
            }
        }
        ArrayList<int[]> recorrido2 = new ArrayList<int[]>();
        Estado nuevoE2 = new Estado(0,recorrido2);
        return nuevoE2;
    }

    static ArrayList<Estado> generar(ArrayList<String[]> sopa, Estado e, String palabra){
        int index = e.generacion-1;
        int[] pactual = e.camino_recorrido.get(index);
        ArrayList<Estado> nuevosEstados = new ArrayList<Estado>();
        //Posicion superior
        int[] posS = {pactual[0]-1,pactual[1]};
        ArrayList<int[]> recSup = e.camino_recorrido;
        recSup.add(posS);
        Estado nuevoESup = new Estado(e.generacion+1,recSup);
        if ( condiciones(sopa,nuevoESup, palabra)) {
            nuevosEstados.add(nuevoESup);
        }
        //Posicion inferior
        int[] posInf = {pactual[0]+1, pactual[1]};
        ArrayList<int[]> recIn = e.camino_recorrido;
        recIn.add(posInf);
        Estado nuevoEIn = new Estado(e.generacion+1, recIn);
        if ( condiciones(sopa, nuevoEIn, palabra)){
            nuevosEstados.add(nuevoEIn);
        }

        //Posicion lateral derecha
        int[] posD = {pactual[0], pactual[1]+1};
        ArrayList<int[]> recD = e.camino_recorrido;
        recD.add(posD);
        Estado nuevoED = new Estado(e.generacion+1,recD);
        if (condiciones(sopa, nuevoED, palabra)){
            nuevosEstados.add(nuevoED);
        }

        //posicion lateral izquierda
        int[] posI = {pactual[0], pactual[1]-1};
        ArrayList<int[]> recI = e.camino_recorrido;
        recI.add(posI);
        Estado nuevoEI = new Estado(e.generacion+1, recI);
        if (condiciones(sopa, nuevoEI, palabra)){
            nuevosEstados.add(nuevoEI);
        }
        return nuevosEstados;
    }

    static Estado buscador(ArrayList<String[]> sopa, String palabra){
        Estado no1 = encontrar_pl(sopa, palabra);
        Estado test;
        if(no1.generacion == 0){
            return no1;
        }
        else{
            ArrayList<Estado> abiertitos = new ArrayList<>();
            ArrayList<Estado> cerraditos = new ArrayList<>();
            abiertitos.add(no1);
            while (abiertitos.size() != 0){
                test = abiertitos.get(0);
                cerraditos.add(test);
                abiertitos.remove(0);
                if(test.generacion < palabra.length()) {
                    abiertitos.addAll(generar(sopa, test, palabra));
                }
                else{
                    if(test.norepetido()){
                        return test;
                    }

                }
            }
            return no1;
        }
    }

    static ArrayList<Estado> recorrer_palabras(ArrayList<String[]> sopa, ArrayList<String> palabras) {
        ArrayList<Estado> palabras_encontradas = new ArrayList<>();
        for (String palabra : palabras) {
            Estado estadoValido = buscador(sopa, palabra);
            palabras_encontradas.add(estadoValido);
        }
        return palabras_encontradas;
    }
}
