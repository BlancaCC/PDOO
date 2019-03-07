package deepspace;


enum WeaponType { 
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

} //enum WeaponType
