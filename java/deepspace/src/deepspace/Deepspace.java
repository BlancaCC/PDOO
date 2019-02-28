package deepspace;

import java.util.Random;

/*
  @author Daniel Krell Calvo, Blanca Cano Camarero 
  @file Deepspace.java 
  Práctica 1 
  
 */
//COMENTO LO DE PAQUETE PARA IR PROBANDO,
//package deepspace;
//PREGUNTAR AL PROFESOR CÓMO SE HARÍA BIEN LA ESTRUCTURA

// Representa los resultados posibles de un combate entre una estación espacial y una nave enemiga
enum CombatResult {ENEMYWINS, NOCOMBAT, STATIONESCAPES, STATIONWINS}

/// Representa los dos tipos de personajes del juego
enum GameCharacter { ENEMYSTARSHIP, SPACESTATION}

// Representa el resultado de un disparo recibido por una nave enemiga o una estación espacial.
enum ShotResult {DONOTRESIST, RESIST}

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
 * @brief representa el botín que se obtiene al vencer a una nave enemiga.
 */
class Loot {
    
    private int nSupplies;
    private int nWeapons;
    private int nShields;
    private int nHangars;
    private int nMedals;
    
    Loot(int Supplies, int Weapons, int Shields, int Hangars, int Medals) {
        nSupplies = Supplies;
        nWeapons = Weapons;
        nShields = Shields;
        nHangars = Hangars;
        nMedals = Medals;
    }
    
    // consultores 
    public int getNSupplies() { return nSupplies; }
    public int getNWeapons() { return nWeapons; }
    public int getNShields() { return nShields; }
    public int getNHangars() { return nHangars; }
    public int getNMedals() { return nMedals; }
}

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
 * @brief Representa a los potenciadores de escudo que pueden tener las estaciones espaciales.
 */
class ShieldBooster {
    
    private String name;
    private float boost;
    private int uses;
    
    ShieldBooster(String name, float boost, int uses) {
        this.name = name;
        this.boost = boost;
        this.uses = uses;
    }
    
    ShieldBooster(ShieldBooster otro) {
        name = otro.name;
        boost = otro.boost;
        uses = otro.uses;
    }
    
    public float getBoost() { return boost; }
    public int getUses() { return uses; }
    
    public float useIt() {
        if(uses > 0f) {
            uses--;
            return boost;
        }
        return 1.0f;
    }
}


class Dice {
    
    private final float NHANGARSPROB;
    private final float NSHIELDSPROB;
    private final float NWEAPONSPROB;
    private final float FIRSTSHOTPROB;
    
    private Random generator;

    
    Dice() {
        NHANGARSPROB = 0.25f;
        NSHIELDSPROB = 0.25f;
        NWEAPONSPROB = 0.33f;
        FIRSTSHOTPROB = 0.5f;
        
        generator = new Random();
    }
    
    public int initWithNHangars() {
        float p = generator.nextFloat();
        if(p < NHANGARSPROB) {
            return 0;
        }
        return 1;
    }
    
    public int initWithNWeapons() {
        float p = generator.nextFloat();
        if(p < NWEAPONSPROB) {
            return 1;
        }
        if(p < 2*NWEAPONSPROB) {
            return 2;
        }
        return 3;
    }
    
    public int initWithNShields() {
        float p = generator.nextFloat();
        if(p<NSHIELDSPROB) {
            return 0;
        }
        return 1;
    }
    
    public int whoStarts(int nPlayers) {
        return generator.nextInt(nPlayers);
    }
    
    GameCharacter firstShot() {
        float p = generator.nextFloat();
        if(p<FIRSTSHOTPROB) {
            return  GameCharacter.SPACESTATION;
        }
        return GameCharacter.ENEMYSTARSHIP;
    }
    
    boolean spaceStationMoves(float speed) {
        float p = generator.nextFloat();
        if(p<speed) {
            return true;
        }
        return false;
    }
}
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

