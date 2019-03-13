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
	
    
    
} //weapon 
