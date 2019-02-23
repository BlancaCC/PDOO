import Deespace.*; 
/**
 * @brief Clase para probar cada una de las clases creada 
 */
public class TestP1 {

    public static void main(String[] args) {
    // _________ Clase SuppliesPackage __________
    
    //constructor por parámetros
    SuppliesPackage sp = new SuppliesPackage ( 1.1f, 2.2f, 9.3f);
    //constructor por copia
    SuppliesPackage sp2 = new SuppliesPackage( sp);
    // consultores

    System.out.println( "Probamos consultores de SuppliesPackage");
    System.out.println (" ammoPowe: " + sp.getAmmoPower()
			+ "\nfuelUnits" + sp.getFuelUnits()
			+ "\nshieldPower" + sp.getShieldPower() ); 


    
    } //main 

} // class TestP1 
