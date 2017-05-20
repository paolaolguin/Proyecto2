import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
class PrincipalSopa{
  public static void main(String[] args) throws FileNotFoundException, IOException {
    Scanner input = new Scanner(System.in);
    System.out.println("Bienvenido. Favor ingresar si va a entregar un archivo(0) o una carpeta (oprima cualquier otro numero)");
    int opcion = input.nextInt();
    if( opcion == 0){
      //Se pide ruta del archivo con las palabras
      //RutaPalabraArchivo
      //nombrePalabraArchivo
      Scanner rutaPA = new Scanner(System.in);
      Scanner nombrePA = new Scanner(System.in);
      System.out.println("Ingrese ruta del archivo con las palabras a buscar");
      String ruta = rutaPA.nextLine();
      System.out.println("Ingrese nombre del archivo con las palabras");
      String nombre = nombrePA.nextLine();
      String archivo = ruta+"/"+nombre+".txt";
      ArrayList<String> ListaPalabras = Arch.leer_archivo(archivo);

      //Se pide ruta de la sopa de letras
      //RutaSopaArchivo
      //nombreSopaArchivo
      Scanner rutaSA = new Scanner(System.in);
      Scanner nombreSA = new Scanner(System.in);
      System.out.println("Ingrese ruta del archivo con la sopa de letras ");
      String rutaSopa = rutaSA.nextLine();
      System.out.println("Ingrese el nombre de la sopa de letras ");
      String nombreSopa = nombreSA.nextLine();
      String archivoSopa = ruta+"/"+nombreSopa+".txt";
      ArrayList<String> ListaSopa = Arch.leer_archivo(archivoSopa);
      ArrayList<String[] > Letras = Arch.separar_letras(ListaSopa);
      for (String[] letra : Letras ){
        for (String l : letra){
        System.out.println(l);
        }
      }


    }
    /*else{
      //Se pide ruta de la carpeta
      Scanner input3 = new Scanner(System.in);
      Scanner input4 = new Scanner(System.in);
      System.out.println("Ingrese ruta de la carpeta");
      String path = input3.nextLine();
      System.out.println("ingrese el nombre de la carpeta");
      String nombrecarpeta = input4.nextLine();
      String archivos;
      nombrecarpeta = nombrecarpeta + "/";
      path = path + "/" + nombrecarpeta;
      File carpeta = new File(path);
      File[] lista_archivos = carpeta.listFiles();
      String[] lista_nombres = new String[lista_archivos.length];
      //Lista que guarda todos los nombres de los archivos (String)
      for (int i = 0; i < lista_archivos.length; i++){

        if (lista_archivos[i].isFile()){
          lista_nombres[i] = lista_archivos[i].getName();
        }
      }
      //Se modifica para tener la ruta completa de cada archivo
      for (int j = 0; j < lista_nombres.length; j++){
        String nombrearchivo = lista_nombres[j];
        lista_nombres[j] = path + nombrearchivo;
      }
      for (String nombrearch : lista_nombres){
        leer_archivo(nombrearch)
      }

      System.out.println("Revise su carpeta por un archivo llamado archivo_nuevo");

    }*/
  }
}
