/**
 * La clase Fecha tiene la intención de representar el tipo abstracto fecha.
 * @author Luis Fernando Posada Cano, Juan Pablo Giraldo Ramirez
 * @version 1
 */

public class Fecha {

    //Definición de las variables

    private final int dia;
    private final int  mes;
    private final int anyo;


    //se inicializan las variables
    public Fecha(int dia, int mes, int anyo) {
        this.dia = dia;
        this.mes = mes;
        this.anyo =  anyo;
    }

    /**
     * Método para obtener el día.
     * @return el dia
     */
    public int dia() {
        return this.dia;
    }

    /**
     * Método para obtener el mes.
     * @return el mes
     */
    public int mes() {
        return this.mes;
    }

    /**
     * Método para obtener el anyo.
     * @return el año
     */
    public int anyo() {
        return this.anyo;
    }

    /**
    * @param otra representa la fecha con la cual se va a comparar.
    *
    * El método comparar se encarga de devolvernos respuesta a tres posibilidades.
    * 1: si la fecha es menor que la otra retorna -1.
    * 2: si la fecha es igual que la otra retorna 0.
    * 3: si la fecha es mayor que la otra retorna 1.
    *
    * @return -1 sí es menor; 0 sí es igual; 1 sí es mayor.
    *
    */

    public int comparar(Fecha otra) {
        if(this.anyo < otra.anyo)
            return -1;
        if (this.anyo > otra.anyo)
            return 1;

        if (this.mes < otra.mes)
            return -1;
        if (this.mes > otra.mes)
            return 1;

        if (this.dia < otra.dia)
            return -1;
        if (this.dia > otra.dia)
            return 1;

        return 0;
    }
    
     /**
    * toString se encargará de convertir el tipo abstracto fecha en un tipo cadena
    * para su posterior visualización
    *
    * @return una cadena que contiene la fecha
    */
    public String toString() {
        return super.toString() + dia + mes + anyo;  
    }
}
