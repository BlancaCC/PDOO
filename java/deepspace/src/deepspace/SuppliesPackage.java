package deepspace;

/**
 * @brief Representa un paquete de suministros para una estación 
 * espacial
 */
class SuppliesPackage{

    private float ammoPower; 
    private float fuelUnits; 
    private float shieldPower; 

    //constructor por parámetros
    SuppliesPackage( float ammoPower, float fuelUnits,  float shieldPower
		     ){
	this.ammoPower = ammoPower;
	this.fuelUnits = fuelUnits; 
	this.shieldPower = shieldPower; 
	    } //cosntructor por parámetros


    //cosntructor por copia 
    SuppliesPackage( SuppliesPackage s){
	this.ammoPower = s.ammoPower;
	this.fuelUnits = s.fuelUnits; 
	this.shieldPower = s.shieldPower;
    }// constructor por copia

    //consultores atributos públicos
    public float getAmmoPower() { return ammoPower;  }
    public float getFuelUnits() { return fuelUnits; }
    public float getShieldPower() { return shieldPower; }

    //representación de la clase

    public String toString(){

    String representation = "ammoPower: " + Float.toString( ammoPower) + "\n" +
	"fuelUnits: " +  fuelUnits + "\n" +
	"shieldPower: " + shieldPower + "\n" ; 

	    
	return representation; 
    }
    
    
} //class SuppliesPackage

