
/**
 *
 * @author blanca
 */

package atributos_metodos;


class OsoAmoroso
{
    private String nombre;
    private int nvAmor;
    //int numeroAbrazos;
    static int numeroAbrazos = 3;
    

    public OsoAmoroso (String n, int nvAmor)
    {
	nombre = n;
	nvAmor = this.nvAmor; 
	this.nvAmor = nvAmor; 
	
    }

    void abraza()
    {
	System.out.println("Ayyyyyyyyyyyy");
	System.out.println("Ven a darle un abracillo a " + nombre);
	System.out.println("*abrazo nivel " + Integer.toString( nvAmor) + "*");
	numeroAbrazos -= -1; 
    }
}

public class Test1
{
    public static void main(String[] args)
    {
	OsoAmoroso osillo = new OsoAmoroso("Teddy", 999);
	
	// ¿Dará algún error? ¿qué tipo de error? ¿si no qué mostrará en pantalla?
	osillo.abraza();
	System.out.println( osillo.numeroAbrazos);
	System.out.println( OsoAmoroso.numeroAbrazos);
	
    }
}
