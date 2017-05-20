import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
class Arch{
  //Leer el archivo, guardarlo como un arrayist de string (filas), se usa para ambos archivos
  static ArrayList<String> leer_archivo(String nombre) throws FileNotFoundException , IOException{

    String linea;
    String archivo = nombre;

    File h = new File(archivo);
    FileReader f = new FileReader(h);
    BufferedReader b = new BufferedReader(f);
    ArrayList<String> filas = new ArrayList<String>();

    while((linea = b.readLine())!=null) {
      filas.add(linea);
    }

    b.close();
    f.close();

    return filas;
  }

  //Separar las letras para tener un arraylist de arrays de strings, se usa solo para la sopa
  static ArrayList<String[]> separar_letras(ArrayList<String> x){
    ArrayList<String[]> filas = new ArrayList<String[]>();
    for (String fila : x){
      String[] letras = fila.split(" ");
      filas.add(letras);
    }
    return filas;
  }
}
