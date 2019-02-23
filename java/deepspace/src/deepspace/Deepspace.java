/*
  @author Daniel Krell Calvo, Blanca Cano Camarero 
  @file Deepspace.java 
  Práctica 1 
  
 */
//COMENTO LO DE PAQUETE PARA IR PROBANDO,
//package deepspace;
//PREGUNTAR AL PROFESOR CÓMO SE HARÍA BIEN LA ESTRUCTURA

/// Representa los dos tipos de personajes del juego
enum GameCharacter { ENEMYSTARSHIP, SPACESTATION}

///~~~~~~~~~~~~~~~~ Weapon Type ~~~~~~~~~~~

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

// ~~~~~~~~~~~~~~~ CLASES ~~~~~~~~~~~~~

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
   
    
} //class SuppliesPackage


/**
 * @brief Clase para probar cada una de las clases creada 
 */
//Pongo esto así para probarlo, PREGUNTAR AL PROFESOR
public class Deepspace {
//public class TestP1 {

    public static void main(String[] args) {
	
	//__________  Datos enumerados ____________
	// combarResultul
	//CombatResult cr = ENEMYWINS;

	// GameCharacter
	GameCharacter gm = GameCharacter.ENEMYSTARSHIP; 
	gm =  GameCharacter.SPACESTATION;

	//Weapon type
	System.out.println( "Probamos el tipo Weapon Type"); 
	WeaponType wt = WeaponType.LASER;
	System.out.println( "El valor de "+  wt +  " es " +  wt.getPower() );
         wt = WeaponType.MISSILE;
	 System.out.println( "El valor de "+  wt +  " es " +  wt.getPower() );
	 wt = WeaponType.PLASMA;
	 System.out.println( "El valor de "+  wt +  " es " +  wt.getPower() );

	
    // _________ Clase SuppliesPackage __________
    
    //constructor por parámetros
    SuppliesPackage sp = new SuppliesPackage ( 1.1f, 2.2f, 9.3f);
    //constructor por copia
    SuppliesPackage sp2 = new SuppliesPackage( sp);
    // consultores

    System.out.println( "Probamos consultores de SuppliesPackage");
    System.out.println (" ammoPowe: " + sp.getAmmoPower()
			+ "\nfuelUnits: " + sp.getFuelUnits()
			+ "\nshieldPower: " + sp.getShieldPower() ); 


    
    } //main 

} // class TestP1 

