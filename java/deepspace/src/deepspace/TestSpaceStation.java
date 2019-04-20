/*
Test de prueba de la práctica 3, 
En particular se pruebará los métodos implementados en la clase SpaceStation
 */
package deepspace;

public class TestSpaceStation{
    public static void main( String[] args){
	//_____ creación spaceStation _______

	//elementos auxiliares creación de una estaciín espacial

	SuppliesPackage paquete = new SuppliesPackage(10.0f, 110.3f, 2f ); 
	SpaceStation ss = new SpaceStation( "Mi-ss", paquete);

	//--- fire() -
	float fire = ss.fire();
	System.out.println("El fuego es " + fire); 
    }
}
