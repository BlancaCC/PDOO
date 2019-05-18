package deepspace;

/**
   @brief Armas que se pueden dispones en una estación espacial 
 */
class Weapon {

    // atributos de instancia
    private String name;
    private WeaponType type;
    private int uses;

    // constructores por parámetros y por copia

    Weapon( String name, WeaponType type, int uses) {
	this.name = name;
	this.type = type;
	this.uses = uses; 
    } //constructor por parámetros

    Weapon( Weapon w ){
	this.name = w.name;
	this.type = w.type;
	this.uses = w.uses; 
    } //constructor por copia

    Weapon(String a, WeaponType weaponType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    ///consultores
    public WeaponType getType(){
	return type; 
    }
    public int getUses(){
	return uses;
    }
    
    public float power(){
	return type.getPower(); 
    } //consultor power

    public float useIt(){
	float use_power = 1.0f; //valor por defecto en caso de no quedar usos
	if( uses > 0){
	    uses -= 1;
	    use_power = type.getPower();
	} //comprobación si quedan oportunidades de usar el arma
	
	return use_power; 
    } //useI


    /** 
	@return @brief Representación en cadena de la instancia
     */
    public String toString(){

    String representation = "name: " + name + "\n" +
	"weapon type: " + type+ "\n" +
	"uses: " +  uses + "\n"; 

    return representation; 
    }

    /**
       @brief El objeto que devuelve permite conectar el modelo de la interfaz de usuario con el modelo manteniendo cierto aislamiento entre ambos. 
       @return Construye objeto ToUI a partir de la propia instancia
     */
    WeaponToUI getUIversion(){ return new WeaponToUI(this); }
    
} //weapon 
