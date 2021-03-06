
/**
 * Write a description of class Contador here.
 * 
 * @author (Luis Fernando Posada Cano, Juan Pablo Giraldo Ramirez) 
 * @version (1)
 */
public class Contador
{
    private int cuenta;
    private final String id;

    /**
     * Se inicializan las variables en el constructor de manera que no posean valores nulos.
     */
    public Contador(String id) {
	this.id = id;
        cuenta = 0;
    }
    /**
     * El método incrementar incrementa el contador en una unidad.
     */
    public void incrementar() {
	cuenta++;
    }
    /**
     * El método incrementos nos muestra en que valor se encuentra la cuenta actualmente.
     * @return el numero actual de la cuenta
     */
    public int incrementos() {
	return cuenta;
    }
    /**
     * toString se encargará de convertir el contador en un tipo cadena
     * para su posterior visualización
     * se debe de mostrar el estado del contador y su id
     *
     * @return una cadena que contiene el id del contador y su cuenta
     */
    public String toString() {
	return super.toString() + cuenta;
    }
}

