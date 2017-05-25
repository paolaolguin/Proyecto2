import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileWriter;

class Arch{
  //Leer el archivo, guardarlo como un arrayist de string (filas), se usa para ambos archivos
  static ArrayList<String> leer_archivo(String nombre) throws FileNotFoundException , IOException{

    String linea;

    File h = new File(nombre);
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

      //Crear archivo de salida
      static File escribirArchivo(ArrayList<Estado> estadosValidos, ArrayList<String> palabras, String ruta) throws IOException{
      File archivo = new File(ruta + "Solucion.out");
      FileWriter fw = new FileWriter(archivo);
      PrintWriter pw = new PrintWriter(fw);

      String palabrasEncontradas = "Palabras encontradas: \n";
      String palabrasNoEncontradas = "Palabras no encontradas: \n";
      String sfinal = palabrasEncontradas + palabrasNoEncontradas;
      for(int i = 0; i< palabras.size(); i++){
          if (estadosValidos.get(i).generacion == 0){
              palabrasNoEncontradas = palabrasNoEncontradas + palabras.get(i) + "\n";
          }
            else{
              palabrasEncontradas = palabrasEncontradas + palabras.get(i) + "\n";
          }
      }
      pw.println(palabrasEncontradas);
      pw.println(palabrasNoEncontradas);
      pw.close();
      fw.close();
      return archivo;
      }
}
