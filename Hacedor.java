import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Hacedor {

    public Hacedor() throws IOException{
        Arch arch = new Arch();
        Busqueda bus = new Busqueda();
        Scanner input = new Scanner(System.in);
        System.out.println("Bienvenido. Favor ingresar la ruta de donde estan ambos archivos (Palabras.in y Sopa.in) ");
        //Se pide ruta del archivo con las palabras
        Scanner rutaPS = new Scanner(System.in);
        String ruta = rutaPS.nextLine()+"/";
        String nombre = "Palabras.in";
        String archivo = ruta + nombre;
        ArrayList<String> palabras = arch.leer_archivo(archivo);
        String nombreSopa = "Sopa.in";
        String archivoSopa = ruta + nombreSopa;
        ArrayList<String> listaSopa = arch.leer_archivo(archivoSopa);
        ArrayList<String[]> sopa = arch.separar_letras(listaSopa);
        ArrayList<Estado> estadosValidos = bus.recorrer_palabras(sopa, palabras);
        arch.escribirArchivo(estadosValidos, palabras, ruta);
        System.out.println("Revisar ruta donde se encontraban las palabras por un archivo llamado Solucion.out");

    }

}