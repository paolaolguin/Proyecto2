import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;

class PrincipalSopa {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Bienvenido. Favor ingresar la ruta de donde estan ambos archivos (Palabras.in y Sopa.in) ");
        //Se pide ruta del archivo con las palabras
        Scanner rutaPS = new Scanner(System.in);
        String ruta = rutaPS.nextLine()+"/";
        String nombre = "Palabras.in";
        String archivo = ruta + nombre;
        ArrayList<String> palabras = Arch.leer_archivo(archivo);
        String nombreSopa = "Sopa.in";
        String archivoSopa = ruta + nombreSopa;
        ArrayList<String> listaSopa = Arch.leer_archivo(archivoSopa);
        ArrayList<String[]> sopa = Arch.separar_letras(listaSopa);
        ArrayList<Estado> estadosValidos = Busqueda.recorrer_palabras(sopa, palabras);
        Arch.escribirArchivo(estadosValidos, palabras, ruta);
        System.out.println("Revisar ruta donde se encontraban las palabras por un archivo llamado Solucion.out");
    }
}