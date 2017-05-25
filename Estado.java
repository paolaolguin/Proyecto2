import java.util.ArrayList;
import java.util.Arrays;
class Estado{
    public int generacion;
    public ArrayList<int[]> camino_recorrido;


    public Estado(int generacion, ArrayList<int[]> camino_recorrido) {
        this.generacion = generacion;
        this.camino_recorrido = camino_recorrido;
    }
    public Estado(Estado e){
        this.generacion = e.generacion;
        this.camino_recorrido = e.camino_recorrido;
    }

    public Boolean norepetido(){
        for (int i = 0; i< camino_recorrido.size(); i++){
            for (int j = i+1; j < camino_recorrido.size(); j++){
                if( Arrays.equals(camino_recorrido.get(i),camino_recorrido.get(j)) ) {
                    return false;

                }
            }

        }
        return true;
    }
}
