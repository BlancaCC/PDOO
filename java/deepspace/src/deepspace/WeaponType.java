package deepspace;


public enum WeaponType { 
    LASER(2.0f), MISSILE(3.0f), PLASMA(4.0f); // f para pasar de double a float

    private float power; 

    //constructor 
    WeaponType ( float power){
	this.power = power; 
    }

    // Consultor
    float getPower(){
	return power; 
    }
    
    public String toString(){
        if(power==2.0){
            return "LASER";
        }
        if(power == 3.0){
            return "MISSILE";
        }
        if(power == 4.0) {
            return "PLASMA";
        }
        return "Error";
    }

} //enum WeaponType
